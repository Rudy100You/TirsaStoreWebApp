package com.tirsa.storewebapp.registration;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "storeapp/v1/registration")
@AllArgsConstructor
public class RegistrationController {
    
    private RegistrationSerivce registrationService ;

    @PostMapping
    public String register(@RequestBody RegistrationRequest req){
        return registrationService.register(req);
    }
}
