package org.semicolon.africa.votersApplication;

import org.semicolon.africa.votersApplication.controllers.PartyController;
import org.semicolon.africa.votersApplication.controllers.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class Main {
    @Autowired
    private UserController userController;
    private PartyController partyController;
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}