package com.jwelzbacher.swisstournament.models;

import javax.persistence.*;

@Entity(name="pairing")
@Table(name="pairing")
public class Pairing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column
    private Long playerAId;

    @Column
    private Long playerBId;

    @Column
    private Long roundId;

    @Column
    private int matchResultPlayerA;

    @Column
    private int matchResultPlayerB;

    @Column
    private int gameWinsPlayerA;

    @Column
    private int gameWinsPlayerB;

    @Column
    private int gameDrawsPlayerA;

    @Column
    private int gameDrawsPlayerB;

    @Column
    private int gameLossesPlayerA;

    @Column
    private int gameLossesPlayerB;

    @Column
    private int customAPlayerA;

    @Column
    private int customAPlayerB;

    @Column
    private int customBPlayerA;

    @Column
    private int customBPlayerB;

    public Pairing(Long id, Long playerAId, Long playerBId, Long roundId, int matchResultPlayerA, int matchResultPlayerB, int gameWinsPlayerA, int gameWinsPlayerB, int gameDrawsPlayerA, int gameDrawsPlayerB, int gameLossesPlayerA, int gameLossesPlayerB, int customAPlayerA, int customAPlayerB, int customBPlayerA, int customBPlayerB) {
        this.id = id;
        this.playerAId = playerAId;
        this.playerBId = playerBId;
        this.roundId = roundId;
        this.matchResultPlayerA = matchResultPlayerA;
        this.matchResultPlayerB = matchResultPlayerB;
        this.gameWinsPlayerA = gameWinsPlayerA;
        this.gameWinsPlayerB = gameWinsPlayerB;
        this.gameDrawsPlayerA = gameDrawsPlayerA;
        this.gameDrawsPlayerB = gameDrawsPlayerB;
        this.gameLossesPlayerA = gameLossesPlayerA;
        this.gameLossesPlayerB = gameLossesPlayerB;
        this.customAPlayerA = customAPlayerA;
        this.customAPlayerB = customAPlayerB;
        this.customBPlayerA = customBPlayerA;
        this.customBPlayerB = customBPlayerB;
    }

    public Pairing() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPlayerAId() {
        return playerAId;
    }

    public void setPlayerAId(Long playerAId) {
        this.playerAId = playerAId;
    }

    public Long getPlayerBId() {
        return playerBId;
    }

    public void setPlayerBId(Long playerBId) {
        this.playerBId = playerBId;
    }

    public Long getRoundId() {
        return roundId;
    }

    public void setRoundId(Long roundId) {
        this.roundId = roundId;
    }

    public int getMatchResultPlayerA() {
        return matchResultPlayerA;
    }

    public void setMatchResultPlayerA(int matchResultPlayerA) {
        this.matchResultPlayerA = matchResultPlayerA;
    }

    public int getMatchResultPlayerB() {
        return matchResultPlayerB;
    }

    public void setMatchResultPlayerB(int matchResultPlayerB) {
        this.matchResultPlayerB = matchResultPlayerB;
    }

    public int getGameWinsPlayerA() {
        return gameWinsPlayerA;
    }

    public void setGameWinsPlayerA(int gameWinsPlayerA) {
        this.gameWinsPlayerA = gameWinsPlayerA;
    }

    public int getGameWinsPlayerB() {
        return gameWinsPlayerB;
    }

    public void setGameWinsPlayerB(int gameWinsPlayerB) {
        this.gameWinsPlayerB = gameWinsPlayerB;
    }

    public int getGameDrawsPlayerA() {
        return gameDrawsPlayerA;
    }

    public void setGameDrawsPlayerA(int gameDrawsPlayerA) {
        this.gameDrawsPlayerA = gameDrawsPlayerA;
    }

    public int getGameDrawsPlayerB() {
        return gameDrawsPlayerB;
    }

    public void setGameDrawsPlayerB(int gameDrawsPlayerB) {
        this.gameDrawsPlayerB = gameDrawsPlayerB;
    }

    public int getGameLossesPlayerA() {
        return gameLossesPlayerA;
    }

    public void setGameLossesPlayerA(int gameLossesPlayerA) {
        this.gameLossesPlayerA = gameLossesPlayerA;
    }

    public int getGameLossesPlayerB() {
        return gameLossesPlayerB;
    }

    public void setGameLossesPlayerB(int gameLossesPlayerB) {
        this.gameLossesPlayerB = gameLossesPlayerB;
    }

    public int getCustomAPlayerA() {
        return customAPlayerA;
    }

    public void setCustomAPlayerA(int customAPlayerA) {
        this.customAPlayerA = customAPlayerA;
    }

    public int getCustomAPlayerB() {
        return customAPlayerB;
    }

    public void setCustomAPlayerB(int customAPlayerB) {
        this.customAPlayerB = customAPlayerB;
    }

    public int getCustomBPlayerA() {
        return customBPlayerA;
    }

    public void setCustomBPlayerA(int customBPlayerA) {
        this.customBPlayerA = customBPlayerA;
    }

    public int getCustomBPlayerB() {
        return customBPlayerB;
    }

    public void setCustomBPlayerB(int customBPlayerB) {
        this.customBPlayerB = customBPlayerB;
    }
}
