package com.jwelzbacher.swisstournament.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

//        const NONE = 0;
//        const OMWP = 1;
//        const MEDIAN_BUCHHOLZ = 2;
//        const GWP = 3;
//        const OGWP = 4;
//        const CUSTOM_A = 5;
//        const CUSTOM_B = 6;

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

    @Column(name="custom_a_name")
    private String customAName;

    @Column(name="custom_b_name")
    private String customBName;

    @Column(name="is_lower_better_for_custom_a")
    private boolean isLowerBetterForCustomA;

    @Column(name="is_lower_better_for_custom_b")
    private boolean isLowerBetterForCustomB;

    @Column
    private boolean isUseFirstLast;

    @Column
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss a z")
    private Timestamp createdDate;

    @Column
    private boolean isRegistrationOpen;

    @Column
    private boolean isCompleted;

    public Tournament(Long id, Long ownerUserId, String tournamentName, String competitionType, Timestamp tournamentDate, String venue, boolean isPlayerRegistrationOn, boolean isPlayerResultsOn, double playerLimit, double winPoints, double lossPoints, double drawPoints, int gamesPerMatch, int firstTiebreaker, int secondTiebreaker, int thirdTiebreaker, int fourthTiebreaker, int fifthTiebreaker, String customAName, String customBName, boolean isLowerBetterForCustomA, boolean isLowerBetterForCustomB, boolean isUseFirstLast, Timestamp createdDate, boolean isRegistrationOpen, boolean isCompleted) {
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
        this.customAName = customAName;
        this.customBName = customBName;
        this.isLowerBetterForCustomA = isLowerBetterForCustomA;
        this.isLowerBetterForCustomB = isLowerBetterForCustomB;
        this.isUseFirstLast = isUseFirstLast;
        this.createdDate = createdDate;
        this.isRegistrationOpen = isRegistrationOpen;
        this.isCompleted = isCompleted;
    }

    public Tournament() {
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

    public String getCustomAName() {
        return customAName;
    }

    public void setCustomAName(String customAName) {
        this.customAName = customAName;
    }

    public String getCustomBName() {
        return customBName;
    }

    public void setCustomBName(String customBName) {
        this.customBName = customBName;
    }

    public boolean isLowerBetterForCustomA() {
        return isLowerBetterForCustomA;
    }

    public void setLowerBetterForCustomA(boolean lowerBetterForCustomA) {
        isLowerBetterForCustomA = lowerBetterForCustomA;
    }

    public boolean isLowerBetterForCustomB() {
        return isLowerBetterForCustomB;
    }

    public void setLowerBetterForCustomB(boolean lowerBetterForCustomB) {
        isLowerBetterForCustomB = lowerBetterForCustomB;
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

    public int getGamesPerMatch() {
        return gamesPerMatch;
    }

    public void setGamesPerMatch(int gamesPerMatch) {
        this.gamesPerMatch = gamesPerMatch;
    }
}
