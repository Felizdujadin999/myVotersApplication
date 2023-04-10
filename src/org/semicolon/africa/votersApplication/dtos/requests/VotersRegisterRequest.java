package org.semicolon.africa.votersApplication.dtos.requests;

import lombok.Data;

@Data
public class VotersRegisterRequest {
    private String lastName;
    private String firstName;
    private String password;
    private String username;
    private String id;
    private String dateOfBirth;
    private int age;

}
