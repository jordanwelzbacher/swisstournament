package com.jwelzbacher.swisstournament.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name="tournamentAtAGlance")
@Table(name="tournament")
public class TournamentAtAGlance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String ownerUsername;
    @Column
    private String tournamentName;
    @Column
    private String competitionType;
    @Column
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm a z")
    private Timestamp tournamentDate;
    @Column
    private String venue;
    @Column
    private boolean isPlayerRegistrationOn;
    @Column
    private double playerLimit;
    @Column
    private boolean isRegistrationOpen;
    @Column
    private boolean isCompleted;
    @Column
    private Boolean inTourney;
    @Column
    private int countPlayers;
    @Column
    private int countRounds;

    public TournamentAtAGlance(Long id, String ownerUsername, String tournamentName, String competitionType, Timestamp tournamentDate, String venue, boolean isPlayerRegistrationOn, double playerLimit, boolean isRegistrationOpen, boolean isCompleted, boolean inTourney, int countPlayers, int countRounds) {
        this.id = id;
        this.ownerUsername = ownerUsername;
        this.tournamentName = tournamentName;
        this.competitionType = competitionType;
        this.tournamentDate = tournamentDate;
        this.venue = venue;
        this.isPlayerRegistrationOn = isPlayerRegistrationOn;
        this.playerLimit = playerLimit;
        this.isRegistrationOpen = isRegistrationOpen;
        this.isCompleted = isCompleted;
        this.inTourney = inTourney;
        this.countPlayers = countPlayers;
        this.countRounds = countRounds;
    }

    public TournamentAtAGlance() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwnerUsername() {
        return ownerUsername;
    }

    public void setOwnerUsername(String ownerUsername) {
        this.ownerUsername = ownerUsername;
    }

    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public String getCompetitionType() {
        return competitionType;
    }

    public void setCompetitionType(String competitionType) {
        this.competitionType = competitionType;
    }

    public Timestamp getTournamentDate() {
        return tournamentDate;
    }

    public void setTournamentDate(Timestamp tournamentDate) {
        this.tournamentDate = tournamentDate;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public boolean isPlayerRegistrationOn() {
        return isPlayerRegistrationOn;
    }

    public void setPlayerRegistrationOn(boolean playerRegistrationOn) {
        isPlayerRegistrationOn = playerRegistrationOn;
    }

    public double getPlayerLimit() {
        return playerLimit;
    }

    public void setPlayerLimit(double playerLimit) {
        this.playerLimit = playerLimit;
    }

    public boolean isRegistrationOpen() {
        return isRegistrationOpen;
    }

    public void setRegistrationOpen(boolean registrationOpen) {
        isRegistrationOpen = registrationOpen;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public Boolean isInTourney() {
        return inTourney;
    }

    public void setInTourney(Boolean inTourney) {
        this.inTourney = inTourney;
    }

    public int getCountPlayers() {
        return countPlayers;
    }

    public void setCountPlayers(int countPlayers) {
        this.countPlayers = countPlayers;
    }

    public int getCountRounds() {
        return countRounds;
    }

    public void setCountRounds(int countRounds) {
        this.countRounds = countRounds;
    }
}
