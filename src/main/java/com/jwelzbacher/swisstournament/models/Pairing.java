package com.jwelzbacher.swisstournament.models;

import javax.persistence.*;

@Entity(name="pairing")
@Table(name="pairing")
public class Pairing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column
    private Long firstPlayerId;

    @Column
    private Long secondPlayerId;

    @Column
    private Long roundId;

    @Column
    private String matchResultFirstPlayer;

    @Column
    private String matchResultSecondPlayer;

    @Column
    private Long gameWinsFirstPlayer;

    @Column
    private Long gameWinsSecondPlayer;

    @Column
    private Long gameDrawsFirstPlayer;

    @Column
    private Long gameDrawsSecondPlayer;

    @Column
    private Long gameLossesFirstPlayer;

    @Column
    private Long gameLossesSecondPlayer;

    @Column
    private Long firstCustomFirstPlayer;

    @Column
    private Long firstCustomSecondPlayer;

    @Column
    private Long secondCustomFirstPlayer;

    @Column
    private Long secondCustomSecondPlayer;

    public Pairing(Long id, Long firstPlayerId, Long secondPlayerId, Long roundId, String matchResultFirstPlayer, String matchResultSecondPlayer, Long gameWinsFirstPlayer, Long gameWinsSecondPlayer, Long gameDrawsFirstPlayer, Long gameDrawsSecondPlayer, Long gameLossesFirstPlayer, Long gameLossesSecondPlayer, Long firstCustomFirstPlayer, Long firstCustomSecondPlayer, Long secondCustomFirstPlayer, Long secondCustomSecondPlayer) {
        this.id = id;
        this.firstPlayerId = firstPlayerId;
        this.secondPlayerId = secondPlayerId;
        this.roundId = roundId;
        this.matchResultFirstPlayer = matchResultFirstPlayer;
        this.matchResultSecondPlayer = matchResultSecondPlayer;
        this.gameWinsFirstPlayer = gameWinsFirstPlayer;
        this.gameWinsSecondPlayer = gameWinsSecondPlayer;
        this.gameDrawsFirstPlayer = gameDrawsFirstPlayer;
        this.gameDrawsSecondPlayer = gameDrawsSecondPlayer;
        this.gameLossesFirstPlayer = gameLossesFirstPlayer;
        this.gameLossesSecondPlayer = gameLossesSecondPlayer;
        this.firstCustomFirstPlayer = firstCustomFirstPlayer;
        this.firstCustomSecondPlayer = firstCustomSecondPlayer;
        this.secondCustomFirstPlayer = secondCustomFirstPlayer;
        this.secondCustomSecondPlayer = secondCustomSecondPlayer;
    }

    public Pairing() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFirstPlayerId() {
        return firstPlayerId;
    }

    public void setFirstPlayerId(Long firstPlayerId) {
        this.firstPlayerId = firstPlayerId;
    }

    public Long getSecondPlayerId() {
        return secondPlayerId;
    }

    public void setSecondPlayerId(Long secondPlayerId) {
        this.secondPlayerId = secondPlayerId;
    }

    public Long getRoundId() {
        return roundId;
    }

    public void setRoundId(Long roundId) {
        this.roundId = roundId;
    }

    public String getMatchResultFirstPlayer() {
        return matchResultFirstPlayer;
    }

    public void setMatchResultFirstPlayer(String matchResultFirstPlayer) {
        this.matchResultFirstPlayer = matchResultFirstPlayer;
    }

    public String getMatchResultSecondPlayer() {
        return matchResultSecondPlayer;
    }

    public void setMatchResultSecondPlayer(String matchResultSecondPlayer) {
        this.matchResultSecondPlayer = matchResultSecondPlayer;
    }

    public Long getGameWinsFirstPlayer() {
        return gameWinsFirstPlayer;
    }

    public void setGameWinsFirstPlayer(Long gameWinsFirstPlayer) {
        this.gameWinsFirstPlayer = gameWinsFirstPlayer;
    }

    public Long getGameWinsSecondPlayer() {
        return gameWinsSecondPlayer;
    }

    public void setGameWinsSecondPlayer(Long gameWinsSecondPlayer) {
        this.gameWinsSecondPlayer = gameWinsSecondPlayer;
    }

    public Long getGameDrawsFirstPlayer() {
        return gameDrawsFirstPlayer;
    }

    public void setGameDrawsFirstPlayer(Long gameDrawsFirstPlayer) {
        this.gameDrawsFirstPlayer = gameDrawsFirstPlayer;
    }

    public Long getGameDrawsSecondPlayer() {
        return gameDrawsSecondPlayer;
    }

    public void setGameDrawsSecondPlayer(Long gameDrawsSecondPlayer) {
        this.gameDrawsSecondPlayer = gameDrawsSecondPlayer;
    }

    public Long getGameLossesFirstPlayer() {
        return gameLossesFirstPlayer;
    }

    public void setGameLossesFirstPlayer(Long gameLossesFirstPlayer) {
        this.gameLossesFirstPlayer = gameLossesFirstPlayer;
    }

    public Long getGameLossesSecondPlayer() {
        return gameLossesSecondPlayer;
    }

    public void setGameLossesSecondPlayer(Long gameLossesSecondPlayer) {
        this.gameLossesSecondPlayer = gameLossesSecondPlayer;
    }

    public Long getFirstCustomFirstPlayer() {
        return firstCustomFirstPlayer;
    }

    public void setFirstCustomFirstPlayer(Long firstCustomFirstPlayer) {
        this.firstCustomFirstPlayer = firstCustomFirstPlayer;
    }

    public Long getFirstCustomSecondPlayer() {
        return firstCustomSecondPlayer;
    }

    public void setFirstCustomSecondPlayer(Long firstCustomSecondPlayer) {
        this.firstCustomSecondPlayer = firstCustomSecondPlayer;
    }

    public Long getSecondCustomFirstPlayer() {
        return secondCustomFirstPlayer;
    }

    public void setSecondCustomFirstPlayer(Long secondCustomFirstPlayer) {
        this.secondCustomFirstPlayer = secondCustomFirstPlayer;
    }

    public Long getSecondCustomSecondPlayer() {
        return secondCustomSecondPlayer;
    }

    public void setSecondCustomSecondPlayer(Long secondCustomSecondPlayer) {
        this.secondCustomSecondPlayer = secondCustomSecondPlayer;
    }
}
