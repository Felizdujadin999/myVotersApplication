package org.semicolon.africa.votersApplication.data.repositories;

import org.semicolon.africa.votersApplication.data.models.Party;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PartyRepository extends MongoRepository<Party, String> {
    default Party findByPartyName(String partyName){
        for (var party: findAll()){
            if (party.getPartyName().equalsIgnoreCase(partyName)) return party;
        }
        return null;
    }

}