package com.tirsa.storewebapp.generics;

import javax.mail.Message;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class GenericResponse {
    private String status;
    private String Message;
}
