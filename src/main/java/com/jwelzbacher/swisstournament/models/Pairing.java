package com.jwelzbacher.swisstournament.models;

import javax.persistence.*;

@Entity(name="pairing")
@Table(name="pairing")
public class Pairing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(name="player_a_id")
    private Long playerAId;

    @Column(name="player_b_id")
    private Long playerBId;

    @Column(name="round_id")
    private Long roundId;

    @Column(name="match_result_player_a")
    private String matchResultPlayerA;

    @Column(name="match_result_player_b")
    private String matchResultPlayerB;

    @Column(name="game_wins_player_a")
    private Long gameWinsPlayerA;

    @Column(name="game_wins_player_b")
    private Long gameWinsPlayerB;

    @Column(name="game_draws_player_a")
    private Long gameDrawsPlayerA;

    @Column(name="game_draws_player_b")
    private Long gameDrawsPlayerB;

    @Column(name="game_losses_player_a")
    private Long gameLossesPlayerA;

    @Column(name="game_losses_player_b")
    private Long gameLossesPlayerB;

    @Column(name="custom_a_player_a")
    private Long customAPlayerA;

    @Column(name="custom_a_player_b")
    private Long customAPlayerB;

    @Column(name="custom_b_player_a")
    private Long customBPlayerA;

    @Column(name="custom_b_player_b")
    private Long customBPlayerB;

    public Pairing(Long id, Long playerAId, Long playerBId, Long roundId, String matchResultPlayerA, String matchResultPlayerB, Long gameWinsPlayerA, Long gameWinsPlayerB, Long gameDrawsPlayerA, Long gameDrawsPlayerB, Long gameLossesPlayerA, Long gameLossesPlayerB, Long customAPlayerA, Long customAPlayerB, Long customBPlayerA, Long customBPlayerB) {
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

    public String getMatchResultPlayerA() {
        return matchResultPlayerA;
    }

    public void setMatchResultPlayerA(String matchResultPlayerA) {
        this.matchResultPlayerA = matchResultPlayerA;
    }

    public String getMatchResultPlayerB() {
        return matchResultPlayerB;
    }

    public void setMatchResultPlayerB(String matchResultPlayerB) {
        this.matchResultPlayerB = matchResultPlayerB;
    }

    public Long getGameWinsPlayerA() {
        return gameWinsPlayerA;
    }

    public void setGameWinsPlayerA(Long gameWinsPlayerA) {
        this.gameWinsPlayerA = gameWinsPlayerA;
    }

    public Long getGameWinsPlayerB() {
        return gameWinsPlayerB;
    }

    public void setGameWinsPlayerB(Long gameWinsPlayerB) {
        this.gameWinsPlayerB = gameWinsPlayerB;
    }

    public Long getGameDrawsPlayerA() {
        return gameDrawsPlayerA;
    }

    public void setGameDrawsPlayerA(Long gameDrawsPlayerA) {
        this.gameDrawsPlayerA = gameDrawsPlayerA;
    }

    public Long getGameDrawsPlayerB() {
        return gameDrawsPlayerB;
    }

    public void setGameDrawsPlayerB(Long gameDrawsPlayerB) {
        this.gameDrawsPlayerB = gameDrawsPlayerB;
    }

    public Long getGameLossesPlayerA() {
        return gameLossesPlayerA;
    }

    public void setGameLossesPlayerA(Long gameLossesPlayerA) {
        this.gameLossesPlayerA = gameLossesPlayerA;
    }

    public Long getGameLossesPlayerB() {
        return gameLossesPlayerB;
    }

    public void setGameLossesPlayerB(Long gameLossesPlayerB) {
        this.gameLossesPlayerB = gameLossesPlayerB;
    }

    public Long getCustomAPlayerA() {
        return customAPlayerA;
    }

    public void setCustomAPlayerA(Long customAPlayerA) {
        this.customAPlayerA = customAPlayerA;
    }

    public Long getCustomAPlayerB() {
        return customAPlayerB;
    }

    public void setCustomAPlayerB(Long customAPlayerB) {
        this.customAPlayerB = customAPlayerB;
    }

    public Long getCustomBPlayerA() {
        return customBPlayerA;
    }

    public void setCustomBPlayerA(Long customBPlayerA) {
        this.customBPlayerA = customBPlayerA;
    }

    public Long getCustomBPlayerB() {
        return customBPlayerB;
    }

    public void setCustomBPlayerB(Long customBPlayerB) {
        this.customBPlayerB = customBPlayerB;
    }
}
