package com.jwelzbacher.swisstournament.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.lang.Nullable;

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
    private int countPlayers;
    @Column
    private int countRounds;
    @Column
    private int gamesPerMatch;
    @Column
    private int firstTiebreaker;
    @Column
    private int secondTiebreaker;
    @Column
    private int thirdTiebreaker;
    @Column
    private int fourthTiebreaker;
    @Column
    private int fifthTiebreaker;
    @Column
    private String firstCustomTiebreakerName;
    @Column
    private String secondCustomTiebreakerName;
    @Column
    private Boolean lowerBetterForFirstCustom;
    @Column
    private Boolean lowerBetterForSecondCustom;


    public TournamentAtAGlance(Long id, String ownerUsername, String tournamentName, String competitionType, Timestamp tournamentDate, String venue, boolean isPlayerRegistrationOn, double playerLimit, boolean isRegistrationOpen, boolean isCompleted, int countPlayers, int countRounds, int gamesPerMatch, int firstTiebreaker, int secondTiebreaker, int thirdTiebreaker, int fourthTiebreaker, int fifthTiebreaker, String firstCustomTiebreakerName, String secondCustomTiebreakerName, Boolean lowerBetterForFirstCustom, Boolean lowerBetterForSecondCustom) {
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
        this.countPlayers = countPlayers;
        this.countRounds = countRounds;
        this.gamesPerMatch = gamesPerMatch;
        this.firstTiebreaker = firstTiebreaker;
        this.secondTiebreaker = secondTiebreaker;
        this.thirdTiebreaker = thirdTiebreaker;
        this.fourthTiebreaker = fourthTiebreaker;
        this.fifthTiebreaker = fifthTiebreaker;
        this.firstCustomTiebreakerName = firstCustomTiebreakerName;
        this.secondCustomTiebreakerName = secondCustomTiebreakerName;
        this.lowerBetterForFirstCustom = lowerBetterForFirstCustom;
        this.lowerBetterForSecondCustom = lowerBetterForSecondCustom;
    }

    public TournamentAtAGlance() {
    }

    public int getGamesPerMatch() {
        return gamesPerMatch;
    }

    public void setGamesPerMatch(int gamesPerMatch) {
        this.gamesPerMatch = gamesPerMatch;
    }

    public int getFirstTiebreaker() {
        return firstTiebreaker;
    }

    public void setFirstTiebreaker(int firstTiebreaker) {
        this.firstTiebreaker = firstTiebreaker;
    }

    public int getSecondTiebreaker() {
        return secondTiebreaker;
    }

    public void setSecondTiebreaker(int secondTiebreaker) {
        this.secondTiebreaker = secondTiebreaker;
    }

    public int getThirdTiebreaker() {
        return thirdTiebreaker;
    }

    public void setThirdTiebreaker(int thirdTiebreaker) {
        this.thirdTiebreaker = thirdTiebreaker;
    }

    public int getFourthTiebreaker() {
        return fourthTiebreaker;
    }

    public void setFourthTiebreaker(int fourthTiebreaker) {
        this.fourthTiebreaker = fourthTiebreaker;
    }

    public int getFifthTiebreaker() {
        return fifthTiebreaker;
    }

    public void setFifthTiebreaker(int fifthTiebreaker) {
        this.fifthTiebreaker = fifthTiebreaker;
    }

    public String getFirstCustomTiebreakerName() {
        return firstCustomTiebreakerName;
    }

    public void setFirstCustomTiebreakerName(String firstCustomTiebreakerName) {
        this.firstCustomTiebreakerName = firstCustomTiebreakerName;
    }

    public String getSecondCustomTiebreakerName() {
        return secondCustomTiebreakerName;
    }

    public void setSecondCustomTiebreakerName(String secondCustomTiebreakerName) {
        this.secondCustomTiebreakerName = secondCustomTiebreakerName;
    }

    public Boolean getLowerBetterForFirstCustom() {
        return lowerBetterForFirstCustom;
    }

    public void setLowerBetterForFirstCustom(Boolean lowerBetterForFirstCustom) {
        this.lowerBetterForFirstCustom = lowerBetterForFirstCustom;
    }

    public Boolean getLowerBetterForSecondCustom() {
        return lowerBetterForSecondCustom;
    }

    public void setLowerBetterForSecondCustom(Boolean lowerBetterForSecondCustom) {
        this.lowerBetterForSecondCustom = lowerBetterForSecondCustom;
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
