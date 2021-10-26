package com.jwelzbacher.swisstournament.DTOs;

import java.util.Map;

public class PlayerScore {

    private Long id;

    private Long userId;

    private String name;

    private int wins;

    private int losses;

    private int draws;

    private Double matchPoints;

    private Map<Integer, Double> tiebreakers;

    public PlayerScore() {
    }

    public PlayerScore(Long id, Long userId, String name, int wins, int losses, int draws, Double matchPoints, Map<Integer, Double> tiebreakers) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.wins = wins;
        this.losses = losses;
        this.draws = draws;
        this.matchPoints = matchPoints;
        this.tiebreakers = tiebreakers;
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

    public Map<Integer, Double> getTiebreakers() {
        return tiebreakers;
    }

    public void setTiebreakers(Map<Integer, Double> tiebreakers) {
        this.tiebreakers = tiebreakers;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}