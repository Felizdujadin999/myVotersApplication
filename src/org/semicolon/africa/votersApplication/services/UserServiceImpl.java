package org.semicolon.africa.votersApplication.services;

import org.semicolon.africa.votersApplication.data.models.User;
import org.semicolon.africa.votersApplication.data.repositories.UserRepository;
import org.semicolon.africa.votersApplication.dtos.requests.CastVoteRequest;
import org.semicolon.africa.votersApplication.dtos.requests.VoterLoginRequest;
import org.semicolon.africa.votersApplication.dtos.requests.VotersRegisterRequest;
import org.semicolon.africa.votersApplication.dtos.responses.FindVoterResponse;
import org.semicolon.africa.votersApplication.dtos.responses.UserRegisterResponse;
import org.semicolon.africa.votersApplication.dtos.responses.VoterLoginResponse;
import org.semicolon.africa.votersApplication.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Objects;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PartyService partyService;
    User user = new User();
    @Override
    public UserRegisterResponse register(VotersRegisterRequest request){
        if (Objects.equals(request.getUsername(), user.getUsername())) throw new IllegalArgumentException("username already exists.");
        if (request.getAge() < 18) throw new IllegalArgumentException("You are not eligible to vote, you must be over 18+ to vote..");
        return Mapper.map(userRepository.save(Mapper.map(request)));
    }

  @Override
   public VoterLoginResponse login(VoterLoginRequest request) {
//        User foundUser = userRepository;
//        VoterLoginResponse reply = new VoterLoginResponse();
//        Mapper.map(foundUser,request);
//        return reply;
      return null;
      }

    @Override
    public String castVote(CastVoteRequest request) {
        FindVoterResponse voter = findUser(request.getUserId());
        if (voteExist(request.getUserId())) throw new IllegalArgumentException("Vote declined, you can't vote twice..");
        if (voter!=null) {partyService.voteParty(request.getPartyName());
        return "Your vote can't be reversed as you have voted successfully";}
        else throw new IllegalArgumentException("This voter is not registered, register and try again...");
    }

    public boolean voteExist(String id){
        return userRepository.findUserById(id) != null;
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

    @Override
    public void delete(String id) {
       userRepository.deleteById(id);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public FindVoterResponse findUser(String id) {
        User user = userRepository.findUserById(id);
        if (user == null) throw new NullPointerException("Voter not found.");
        FindVoterResponse response = new FindVoterResponse();
        Mapper.map(user, response);
        return response;
    }
}
