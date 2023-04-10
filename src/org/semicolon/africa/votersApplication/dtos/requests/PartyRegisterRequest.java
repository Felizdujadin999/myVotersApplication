package org.semicolon.africa.votersApplication.dtos.requests;

import lombok.Data;

@Data
public class PartyRegisterRequest {
    private String partyName;
    private String partyCandidate;

}
