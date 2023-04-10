package org.semicolon.africa.votersApplication.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@Document
public class Party {
    private String partyName;
    private String candidateName;
    @Id
    private String partyId;
    private long numberOfVotes;
    LocalDateTime dateTime = LocalDateTime.now();
}