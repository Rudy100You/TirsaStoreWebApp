package com.tirsa.storewebapp.registration;

import com.tirsa.storewebapp.generics.apiexceptions.ApiBadRequestException;
import com.tirsa.storewebapp.generics.apiexceptions.ApiForbiddenException;
import com.tirsa.storewebapp.generics.apiexceptions.ApiInternalServerErrorException;
import com.tirsa.storewebapp.generics.apiexceptions.ApiUnprocessableEntityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tirsa.storewebapp.appuser.AppUser;
import com.tirsa.storewebapp.appuser.AppUserRole;
import com.tirsa.storewebapp.appuser.AppUserService;
import com.tirsa.storewebapp.generics.GenericResponse;

import lombok.AllArgsConstructor;

import java.util.Arrays;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final AppUserService appUserService;
    private final EmailValidator emailValidator;
    
    public ResponseEntity<Object> register(RegistrationRequest req){
        try {
            //validate fields
            if (req.isEmpty())
                throw new ApiBadRequestException("Bad Request");

            if (!emailValidator.test(req.getEmail()))
                throw new ApiUnprocessableEntityException("Invalid email");

            GenericResponse res;
            res = new GenericResponse("200", appUserService.signUpUser(
                    new AppUser(
                            req.getFirstName(),
                            req.getLastName(),
                            req.getEmail(),
                            req.getPassword(),
                            AppUserRole.USER
                    )
            ));
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
        catch (Exception e){
            //Verify if exception is generic
            Class<? extends Exception>[] exceptionClasses = new Class[] { ApiBadRequestException.class,  ApiUnprocessableEntityException.class, ApiForbiddenException.class};
            if(! Arrays.asList(exceptionClasses).contains(e.getClass()))
                throw new ApiInternalServerErrorException("Unknown exception");
            throw e;
        }
    }
}
