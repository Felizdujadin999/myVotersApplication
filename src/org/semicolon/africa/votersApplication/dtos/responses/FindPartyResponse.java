package org.semicolon.africa.votersApplication.dtos.responses;

import lombok.Data;

@Data
public class FindPartyResponse {
    private String partyName;
    private String candidateName;
    private long numberOfVotes;
    private String dateRegistered;

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public long getNumberOfVotes() {
        return numberOfVotes;
    }

    public void setNumberOfVotes(long numberOfVotes) {
        this.numberOfVotes = numberOfVotes;
    }

    public String getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(String dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    @Override
    public String toString() {
        return "FindPartyResponse{" +
                "partyName='" + partyName + '\'' +
                ", candidateName='" + candidateName + '\'' +
                ", numberOfVotes=" + numberOfVotes +
                ", dateRegistered='" + dateRegistered + '\'' +
                '}';
    }
}
