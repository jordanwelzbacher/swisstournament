package com.jwelzbacher.swisstournament.models;

import javax.persistence.*;
import java.util.List;

@Entity(name="round")
@Table(name="round")
public class Round {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique = true, nullable = false)
    private Long id;

    @Column
    private Long tournamentId;

    @Column
    private int roundNumber;

    @Column
    private Integer topCut;

    @OneToMany
    @JoinColumn(name="pairing")
    private List<Pairing> pairings;

    public Round(Long id, Long tournamentId, int roundNumber, int topCut, List<Pairing> pairings) {
        this.id = id;
        this.tournamentId = tournamentId;
        this.roundNumber = roundNumber;
        this.topCut = topCut;
        this.pairings = pairings;
    }

    public Round() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(Long tournamentId) {
        this.tournamentId = tournamentId;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public Integer getTopCut() {
        return topCut;
    }

    public void setTopCut(Integer topCut) {
        this.topCut = topCut;
    }

    public List<Pairing> getPairings() {
        return pairings;
    }

    public void setPairings(List<Pairing> pairings) {
        this.pairings = pairings;
    }

}
