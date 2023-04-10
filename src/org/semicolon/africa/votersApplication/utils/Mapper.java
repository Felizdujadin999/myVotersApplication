package org.semicolon.africa.votersApplication.utils;

import org.semicolon.africa.votersApplication.data.models.Party;
import org.semicolon.africa.votersApplication.data.models.User;
import org.semicolon.africa.votersApplication.dtos.requests.*;
import org.semicolon.africa.votersApplication.dtos.responses.FindVoterResponse;
import org.semicolon.africa.votersApplication.dtos.responses.FindPartyResponse;
import org.semicolon.africa.votersApplication.dtos.responses.UserRegisterResponse;

public class Mapper {

    public static User map(VotersRegisterRequest request){
        User user = new User();
        user.setLastName(request.getLastName());
        user.setFirstName(request.getFirstName());
        user.setPassword(request.getPassword());
        user.setId(request.getId());
        user.setUsername(request.getUsername());
        user.setAge(request.getAge());
        return user;
    }

    public static Party map(PartyRegisterRequest request){
        Party party = new Party();
        party.setPartyName(request.getPartyName());
        party.setCandidateName(request.getPartyCandidate());
        return party;
    }
    public static void map(Party foundParty, FindPartyResponse response){
        response.setPartyName(foundParty.getPartyName());
        response.setCandidateName(foundParty.getCandidateName());
        response.setNumberOfVotes(foundParty.getNumberOfVotes());
        response.setDateRegistered(foundParty.getDateTime().toString());
    }

    public static void map(User user, VoterLoginRequest request){
        request.setFullName(user.getLastName()+ " "+user.getFirstName());
        request.setUsername(user.getUsername());
        request.setPassword(user.getPassword());
    }

    public static void map(User user, FindVoterResponse response){
        response.setFullName(user.getLastName()+" "+user.getFirstName());
        response.setAge(user.getAge());
        response.setUsername(user.getUsername());
        response.setVoterId(user.getId());
    }

    public static UserRegisterResponse map(User user) {
        UserRegisterResponse response = new UserRegisterResponse();
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        response.setAge(user.getAge());
        response.setUsername(user.getUsername());
        response.setPassword(user.getPassword());
        return response;
    }
}