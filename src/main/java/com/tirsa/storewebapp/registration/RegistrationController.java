package com.tirsa.storewebapp.registration;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tirsa.storewebapp.generics.GenericResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "storeapp/v1/registration")
@AllArgsConstructor
public class RegistrationController implements ErrorController{
    
    private RegistrationService registrationService;

    @CrossOrigin
    @PostMapping
    public ResponseEntity<Object> register(@RequestBody RegistrationRequest req )throws RuntimeException{
        return registrationService.register(req);
    }
}
