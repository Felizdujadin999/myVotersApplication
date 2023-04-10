package org.semicolon.africa.votersApplication.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class User {
    private String lastName;
    private String firstName;
    @Id
    private String id;
    private int age;
    private String username;
    private String password;
    private String state;
    private String nationality;
    private String dateOfBirth;
    private String gender;
    private LocalDateTime date;
}