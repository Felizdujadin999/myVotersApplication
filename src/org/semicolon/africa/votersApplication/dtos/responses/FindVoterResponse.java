package org.semicolon.africa.votersApplication.dtos.responses;

import lombok.Data;

@Data
public class FindVoterResponse {
    private String fullName;
    private String username;
    private int age;
    private String voterId;

}
