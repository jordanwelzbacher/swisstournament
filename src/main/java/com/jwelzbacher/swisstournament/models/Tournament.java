package com.jwelzbacher.swisstournament.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.sql.Timestamp;

@Entity(name="tournament")
@Table(name="tournament")
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique=true, nullable = false)
    private Long id;

    @Column
    private Long ownerUserId;

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
    private boolean isPlayerResultsOn;

    @Column
    private double playerLimit;

    @Column
    private double winPoints;

    @Column
    private double lossPoints;

    @Column
    private double drawPoints;

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

    @Column
    private boolean isUseFirstLast;

    @Column
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss a z")
    private Timestamp createdDate;

    @Column
    private boolean isRegistrationOpen;

    @Column
    private boolean isCompleted;

    public Tournament() {
    }

    public Tournament(Long id, Long ownerUserId, String tournamentName, String competitionType, Timestamp tournamentDate, String venue, boolean isPlayerRegistrationOn, boolean isPlayerResultsOn, double playerLimit, double winPoints, double lossPoints, double drawPoints, int gamesPerMatch, int firstTiebreaker, int secondTiebreaker, int thirdTiebreaker, int fourthTiebreaker, int fifthTiebreaker, String firstCustomTiebreakerName, String secondCustomTiebreakerName, boolean lowerBetterForFirstCustom, boolean lowerBetterForSecondCustom, boolean isUseFirstLast, Timestamp createdDate, boolean isRegistrationOpen, boolean isCompleted) {
        this.id = id;
        this.ownerUserId = ownerUserId;
        this.tournamentName = tournamentName;
        this.competitionType = competitionType;
        this.tournamentDate = tournamentDate;
        this.venue = venue;
        this.isPlayerRegistrationOn = isPlayerRegistrationOn;
        this.isPlayerResultsOn = isPlayerResultsOn;
        this.playerLimit = playerLimit;
        this.winPoints = winPoints;
        this.lossPoints = lossPoints;
        this.drawPoints = drawPoints;
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
        this.isUseFirstLast = isUseFirstLast;
        this.createdDate = createdDate;
        this.isRegistrationOpen = isRegistrationOpen;
        this.isCompleted = isCompleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOwnerUserId() {
        return ownerUserId;
    }

    public void setOwnerUserId(Long ownerUserId) {
        this.ownerUserId = ownerUserId;
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

    public boolean isPlayerResultsOn() {
        return isPlayerResultsOn;
    }

    public void setPlayerResultsOn(boolean playerResultsOn) {
        isPlayerResultsOn = playerResultsOn;
    }

    public double getPlayerLimit() {
        return playerLimit;
    }

    public void setPlayerLimit(double playerLimit) {
        this.playerLimit = playerLimit;
    }

    public double getWinPoints() {
        return winPoints;
    }

    public void setWinPoints(double winPoints) {
        this.winPoints = winPoints;
    }

    public double getLossPoints() {
        return lossPoints;
    }

    public void setLossPoints(double lossPoints) {
        this.lossPoints = lossPoints;
    }

    public double getDrawPoints() {
        return drawPoints;
    }

    public void setDrawPoints(double drawPoints) {
        this.drawPoints = drawPoints;
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

    public Boolean isLowerBetterForFirstCustom() {
        return lowerBetterForFirstCustom;
    }

    public void setLowerBetterForFirstCustom(Boolean lowerBetterForFirstCustom) {
        this.lowerBetterForFirstCustom = lowerBetterForFirstCustom;
    }

    public Boolean isLowerBetterForSecondCustom() {
        return lowerBetterForSecondCustom;
    }

    public void setLowerBetterForSecondCustom(Boolean lowerBetterForSecondCustom) {
        this.lowerBetterForSecondCustom = lowerBetterForSecondCustom;
    }

    public boolean isUseFirstLast() {
        return isUseFirstLast;
    }

    public void setUseFirstLast(boolean useFirstLast) {
        isUseFirstLast = useFirstLast;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
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
}
