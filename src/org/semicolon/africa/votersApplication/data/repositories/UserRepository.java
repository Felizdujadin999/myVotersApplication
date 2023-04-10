package org.semicolon.africa.votersApplication.data.repositories;

import org.semicolon.africa.votersApplication.data.models.User;
import org.semicolon.africa.votersApplication.dtos.requests.VoterLoginRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findUserById(String id);
//    default void findUser(VoterLoginRequest request){
//    }
}
