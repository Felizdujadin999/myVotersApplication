package org.semicolon.africa.votersApplication.controllers;

import org.semicolon.africa.votersApplication.dtos.requests.PartyRegisterRequest;
import org.semicolon.africa.votersApplication.services.PartyService;
import org.semicolon.africa.votersApplication.services.PartyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PartyController {
    @Autowired
    private PartyService partyService;

    @PostMapping("party/register")
    public ResponseEntity<?> registerParty(@RequestBody PartyRegisterRequest request){
        try {
            return new ResponseEntity<>(partyService.registerParty(request), HttpStatus.CREATED);
        }catch (IllegalArgumentException e){return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);}
    }

    @GetMapping("party/{partyName}")
    public ResponseEntity<?> findPoliticalParty(@PathVariable String partyName){
        try {
            return new ResponseEntity<>(partyService.findPoliticalParty(partyName), HttpStatus.FOUND);
        }catch (IllegalArgumentException e){return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);}
    }
}