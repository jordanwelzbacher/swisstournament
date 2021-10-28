package com.jwelzbacher.swisstournament.DTOs;

import java.util.Comparator;
import java.util.Random;

public class PlayerScore implements Comparable {

    private Long id;

    private Long userId;

    private String name;

    private int rank;

    private Double matchPoints;

    private int wins;

    private int losses;

    private int draws;

    private Double firstTiebreaker;

    private Double secondTiebreaker;

    private Double thirdTiebreaker;

    private Double fourthTiebreaker;

    private Double fifthTiebreaker;

    public PlayerScore() {
    }

    public PlayerScore(Long id, Long userId, String name, int rank, Double matchPoints, int wins, int losses, int draws, Double firstTiebreaker, Double secondTiebreaker, Double thirdTiebreaker, Double fourthTiebreaker, Double fifthTiebreaker) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.rank = rank;
        this.matchPoints = matchPoints;
        this.wins = wins;
        this.losses = losses;
        this.draws = draws;
        this.firstTiebreaker = firstTiebreaker;
        this.secondTiebreaker = secondTiebreaker;
        this.thirdTiebreaker = thirdTiebreaker;
        this.fourthTiebreaker = fourthTiebreaker;
        this.fifthTiebreaker = fifthTiebreaker;
    }

    @Override
    public int compareTo(Object o) {
        PlayerScore playerScore = (PlayerScore) o;
        if (! this.matchPoints.equals(playerScore.matchPoints)) {
            return this.matchPoints - playerScore.matchPoints > 0 ? 1 : -1;
        }
        else if (! this.firstTiebreaker.equals(playerScore.firstTiebreaker)) {
            return this.firstTiebreaker - playerScore.firstTiebreaker > 0 ? 1 : -1;
        }
        else if (! this.secondTiebreaker.equals(playerScore.secondTiebreaker)) {
            return this.secondTiebreaker - playerScore.secondTiebreaker > 0 ? 1 : -1;
        }
        else if (! this.thirdTiebreaker.equals(playerScore.thirdTiebreaker)) {
            return this.thirdTiebreaker - playerScore.thirdTiebreaker > 0 ? 1 : -1;
        }
        else if (! this.fourthTiebreaker.equals(playerScore.fourthTiebreaker)) {
            return this.fourthTiebreaker - playerScore.fourthTiebreaker > 0 ? 1 : -1;
        }
        else if (! this.fifthTiebreaker.equals(playerScore.fifthTiebreaker)) {
            return this.fifthTiebreaker - playerScore.fifthTiebreaker > 0 ? 1 : -1;
        }
        else {
            return 0;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public Double getMatchPoints() {
        return matchPoints;
    }

    public void setMatchPoints(Double matchPoints) {
        this.matchPoints = matchPoints;
    }

    public Double getFirstTiebreaker() {
        return firstTiebreaker;
    }

    public void setFirstTiebreaker(Double firstTiebreaker) {
        this.firstTiebreaker = firstTiebreaker;
    }

    public Double getSecondTiebreaker() {
        return secondTiebreaker;
    }

    public void setSecondTiebreaker(Double secondTiebreaker) {
        this.secondTiebreaker = secondTiebreaker;
    }

    public Double getThirdTiebreaker() {
        return thirdTiebreaker;
    }

    public void setThirdTiebreaker(Double thirdTiebreaker) {
        this.thirdTiebreaker = thirdTiebreaker;
    }

    public Double getFourthTiebreaker() {
        return fourthTiebreaker;
    }

    public void setFourthTiebreaker(Double fourthTiebreaker) {
        this.fourthTiebreaker = fourthTiebreaker;
    }

    public Double getFifthTiebreaker() {
        return fifthTiebreaker;
    }

    public void setFifthTiebreaker(Double fifthTiebreaker) {
        this.fifthTiebreaker = fifthTiebreaker;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}

