package org.semicolon.africa.votersApplication.dtos.requests;

import lombok.Data;

@Data
public class VoterLoginRequest {
    private String fullName;
    private String username;
    private String password;

}
