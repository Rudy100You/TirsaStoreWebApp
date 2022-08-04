package com.tirsa.storewebapp.registration;

import lombok.*;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;

    public boolean isEmpty(){
        RegistrationRequest aux = new RegistrationRequest(null,null,null,null);
        return aux.equals(this)?true:false;
    }

}
