package org.semicolon.africa.votersApplication.services;

import org.semicolon.africa.votersApplication.data.models.Party;
import org.semicolon.africa.votersApplication.dtos.requests.PartyRegisterRequest;
import org.semicolon.africa.votersApplication.dtos.responses.FindPartyResponse;

import java.util.List;

public interface PartyService {
    Party registerParty(PartyRegisterRequest request);
    FindPartyResponse findPoliticalParty(String partyName);
    Long voteParty(String partyName);

    String showPartyNews(String partyName);
}
