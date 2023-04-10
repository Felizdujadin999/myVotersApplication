package org.semicolon.africa.votersApplication.services;

import org.semicolon.africa.votersApplication.data.models.User;
import org.semicolon.africa.votersApplication.dtos.requests.CastVoteRequest;
import org.semicolon.africa.votersApplication.dtos.requests.VoterLoginRequest;
import org.semicolon.africa.votersApplication.dtos.requests.VotersRegisterRequest;
import org.semicolon.africa.votersApplication.dtos.responses.FindVoterResponse;
import org.semicolon.africa.votersApplication.dtos.responses.UserRegisterResponse;
import org.semicolon.africa.votersApplication.dtos.responses.VoterLoginResponse;
import org.semicolon.africa.votersApplication.exceptions.UserExistsException;

public interface UserService {
    UserRegisterResponse register(VotersRegisterRequest request);
    VoterLoginResponse login(VoterLoginRequest request);
    String castVote(CastVoteRequest request);
    void deleteAll();
    void delete(String id);
    void delete(User user);
    FindVoterResponse findUser(String id);
}
