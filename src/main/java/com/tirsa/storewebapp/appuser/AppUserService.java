package com.tirsa.storewebapp.appuser;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService{

    private final static String USER_NOT_FOUND_ERR_MSG = "user with email %s not found";
    private final static String USER_ALREADY_TAKEN_ERR_MSG = "User Already Taken";
    private final AppUserRepository appUserRepository;

    private final BCryptPasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email)
            .orElseThrow(() -> 
                    new UsernameNotFoundException(String.format(USER_NOT_FOUND_ERR_MSG, email))
                );
    }

    public String signUpUser(AppUser appUser)
    {
        boolean userAlreadyExists = appUserRepository.findByEmail(appUser.getEmail()).isPresent();
        if(userAlreadyExists)
            {
                //throw new IllegalStateException(USER_ALREADY_TAKEN_ERR_MSG);
                return USER_ALREADY_TAKEN_ERR_MSG;
            }
        String encoded = encoder.encode(appUser.getPassword());
        appUser.setPassword(encoded);

        appUserRepository.save(appUser);
        return "User registered";
    }
}
