package org.semicolon.africa.votersApplication.dtos.requests;

import lombok.Data;

@Data
public class CastVoteRequest {
    private String partyName;
    private String userId;

}
