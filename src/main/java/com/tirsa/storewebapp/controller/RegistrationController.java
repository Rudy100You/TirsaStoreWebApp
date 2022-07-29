package com.tirsa.storewebapp.controller;

import org.apache.catalina.connector.Response;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.tirsa.storewebapp.generics.GenericResponse;
import com.tirsa.storewebapp.registration.RegistrationRequest;
import com.tirsa.storewebapp.registration.RegistrationResponse;
import com.tirsa.storewebapp.registration.RegistrationSerivce;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "storeapp/v1/registration")
@AllArgsConstructor
public class RegistrationController implements ErrorController{
    
    private RegistrationSerivce registrationService;

    @CrossOrigin
    @PostMapping
    public ResponseEntity<GenericResponse> register(@RequestBody RegistrationRequest req){
        return registrationService.register(req);
    }
}
