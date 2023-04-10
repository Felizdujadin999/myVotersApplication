package org.semicolon.africa.votersApplication.services;

import org.semicolon.africa.votersApplication.data.models.Party;
import org.semicolon.africa.votersApplication.data.repositories.PartyRepository;
import org.semicolon.africa.votersApplication.dtos.requests.PartyRegisterRequest;
import org.semicolon.africa.votersApplication.dtos.responses.FindPartyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.semicolon.africa.votersApplication.utils.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PartyServiceImpl implements PartyService{
    @Autowired
    private PartyRepository partyRepository;
//    static List<Party> parties = new ArrayList<>();

    @Override
    public Party registerParty(PartyRegisterRequest request) {
        if (partyExist(request.getPartyName())) throw new IllegalArgumentException(request.getPartyName()+ " already exists");
        return partyRepository.save(Mapper.map(request));
    }

    private boolean partyExist(String partyName){
        Party party = partyRepository.findByPartyName(partyName);
        if (party!=null) return true;
        return false;
    }

    @Override
    public FindPartyResponse findPoliticalParty(String partyName) {
        Party foundParty = partyRepository.findByPartyName(partyName);
        if (foundParty!=null){
            FindPartyResponse response = new FindPartyResponse();
            Mapper.map(foundParty, response);
            return response;
        }
        throw new NullPointerException("Party not found.");
    }

    @Override
    public Long voteParty(String partyName) {
        Party votedParty = partyRepository.findByPartyName(partyName);
        long votes = votedParty.getNumberOfVotes() + 1;
        votedParty.setNumberOfVotes(votes);
        partyRepository.save(votedParty);
        return votes;
    }

    @Override
    public String showPartyNews(String partyName) {
        return null;
//        FindPartyResponse partyResponse = new FindPartyResponse();
//        Party foundParty = partyRepository.findByPartyName(partyName);
//        if (foundParty == null) throw new NoSuchElementException("Party doesn't exist");
//        Mapper.map(foundParty, partyResponse);
//        return String.format("""
//                ========================
//                %s NEWS BOARD.
//                VOTE COUNT ->> %s
//                CANDIDATE ->> %S
//                ========================
//                """, partyResponse.getPartyName(), partyResponse.getVote(), partyResponse.getCandidateName().getUserName());
    }

    //    @Override
    public List<Party> findAllParties() {
        return partyRepository.findAll();
    }
}
