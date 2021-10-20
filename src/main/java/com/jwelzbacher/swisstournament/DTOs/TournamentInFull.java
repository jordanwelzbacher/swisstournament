package com.jwelzbacher.swisstournament.DTOs;

import com.jwelzbacher.swisstournament.models.Admin;
import com.jwelzbacher.swisstournament.models.Player;
import com.jwelzbacher.swisstournament.models.Round;
import com.jwelzbacher.swisstournament.models.Tournament;

import java.util.List;


public class TournamentInFull {

    private Tournament tournament;
    private List<Player> players;
    private List<Admin> admins;
    private List<Round> rounds;

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
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
