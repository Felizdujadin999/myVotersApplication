package org.semicolon.africa.votersApplication.dtos.responses;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class UserRegisterResponse {
    private String lastName;
    private String firstName;
    private int age;
    private String username;
    private String password;
}
