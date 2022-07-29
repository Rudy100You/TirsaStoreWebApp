package com.tirsa.storewebapp.registration;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tirsa.storewebapp.appuser.AppUser;
import com.tirsa.storewebapp.appuser.AppUserRole;
import com.tirsa.storewebapp.appuser.AppUserService;
import com.tirsa.storewebapp.generics.GenericResponse;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RegistrationSerivce {

    private final AppUserService appUserService;
    private final EmailValidator emailValidator;
    
    public ResponseEntity<GenericResponse> register(RegistrationRequest req){

        GenericResponse res;
        try{
        boolean isValidEmail = emailValidator.test(req.getEmail());
        if(!isValidEmail){
            throw new IllegalStateException("Email is not valid");
        }

        res = new GenericResponse("200", appUserService.signUpUser(
            new AppUser(
                req.getFirstName(),
                req.getLastName(),
                req.getEmail(),
                req.getPassword(),
                AppUserRole.USER
            )
        ));
        return new ResponseEntity<GenericResponse>(res,HttpStatus.OK);
    }catch(Exception e)
    {
        return new ResponseEntity<GenericResponse>(new GenericResponse("500", e.getMessage()),HttpStatus.OK);
    }
    }
}
