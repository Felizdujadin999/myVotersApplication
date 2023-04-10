package org.semicolon.africa.votersApplication.controllers;

import org.semicolon.africa.votersApplication.dtos.requests.CastVoteRequest;
import org.semicolon.africa.votersApplication.dtos.requests.VotersRegisterRequest;
import org.semicolon.africa.votersApplication.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("voter/register")
    public ResponseEntity<?> register(@RequestBody VotersRegisterRequest request){
        try {return new ResponseEntity<>(userService.register(request), HttpStatus.CREATED);}
        catch (IllegalArgumentException e){return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);}
    }

    @PostMapping("vote")
    public ResponseEntity<?> castVote(@RequestBody CastVoteRequest request){
        try {
            return new ResponseEntity<>(userService.castVote(request), HttpStatus.ACCEPTED);
        }catch (IllegalArgumentException e){return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);}
    }

    @GetMapping("findVoter/{id}")
    public ResponseEntity<?> findUserById(@PathVariable String id){
        try {
            return new ResponseEntity<>(userService.findUser(id), HttpStatus.FOUND);
        }catch (IllegalArgumentException e){return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);}
    }
}