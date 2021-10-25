package com.jwelzbacher.swisstournament.DTOs;

import com.jwelzbacher.swisstournament.models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TournamentInFull {

    private Tournament tournament;
    private List<PlayerScore> players = new ArrayList<>();
    private List<Admin> admins = new ArrayList<>();
    private List<Round> rounds = new ArrayList<>();
    private Map<Integer, List<Pairing>> pairings = new HashMap<>();

    public void addPairingsOfRound(Integer round, List<Pairing> pairings) {
        this.pairings.put(round, pairings);
    }

    public Map<Integer, List<Pairing>> getPairings() {
        return pairings;
    }

    public void setPairings(Map<Integer, List<Pairing>> pairings) {
        this.pairings = pairings;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public List<PlayerScore> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        for(Player player : players) {
            this.players.add(new PlayerScore(player));
        }
    }

    public List<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(List<Admin> admins) {
        this.admins = admins;
    }

    public List<Round> getRounds() {
        return rounds;
    }

    public void setRounds(List<Round> rounds) {
        this.rounds = rounds;
    }
}
