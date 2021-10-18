package com.jwelzbacher.swisstournament.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name="tournamentAtAGlance")
@Table(name="tournament")
public class TournamentAtAGlance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String owner_username;
    @Column
    private String tournament_name;
    @Column
    private String competition_type;
    @Column
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm a z")
    private Timestamp tournament_date;
    @Column
    private String venue;
    @Column
    private boolean is_player_registration_on;
    @Column
    private double player_limit;
    @Column
    private boolean is_registration_open;
    @Column
    private boolean is_completed;
    @Column
    private boolean in_tourney;
    @Column
    private int count_players;
    @Column
    private int count_rounds;

    public TournamentAtAGlance(Long id, String owner_username, String tournament_name, String competition_type, Timestamp tournament_date, String venue, boolean is_player_registration_on, double player_limit, boolean is_registration_open, boolean is_completed, boolean in_tourney, int count_players, int count_rounds) {
        this.id = id;
        this.owner_username = owner_username;
        this.tournament_name = tournament_name;
        this.competition_type = competition_type;
        this.tournament_date = tournament_date;
        this.venue = venue;
        this.is_player_registration_on = is_player_registration_on;
        this.player_limit = player_limit;
        this.is_registration_open = is_registration_open;
        this.is_completed = is_completed;
        this.in_tourney = in_tourney;
        this.count_players = count_players;
        this.count_rounds = count_rounds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwner_username() {
        return owner_username;
    }

    public void setOwner_username(String owner_username) {
        this.owner_username = owner_username;
    }

    public String getTournament_name() {
        return tournament_name;
    }

    public void setTournament_name(String tournament_name) {
        this.tournament_name = tournament_name;
    }

    public String getCompetition_type() {
        return competition_type;
    }

    public void setCompetition_type(String competition_type) {
        this.competition_type = competition_type;
    }

    public Timestamp getTournament_date() {
        return tournament_date;
    }

    public void setTournament_date(Timestamp tournament_date) {
        this.tournament_date = tournament_date;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public boolean isIs_player_registration_on() {
        return is_player_registration_on;
    }

    public void setIs_player_registration_on(boolean is_player_registration_on) {
        this.is_player_registration_on = is_player_registration_on;
    }

    public double getPlayer_limit() {
        return player_limit;
    }

    public void setPlayer_limit(double player_limit) {
        this.player_limit = player_limit;
    }

    public boolean isIs_registration_open() {
        return is_registration_open;
    }

    public void setIs_registration_open(boolean is_registration_open) {
        this.is_registration_open = is_registration_open;
    }

    public boolean isIs_completed() {
        return is_completed;
    }

    public void setIs_completed(boolean is_completed) {
        this.is_completed = is_completed;
    }

    public int getCount_players() {
        return count_players;
    }

    public void setCount_players(int count_players) {
        this.count_players = count_players;
    }

    public int getCount_rounds() {
        return count_rounds;
    }

    public void setCount_rounds(int count_rounds) {
        this.count_rounds = count_rounds;
    }

    public boolean isIn_tourney() {
        return in_tourney;
    }

    public void setIn_tourney(boolean in_tourney) {
        this.in_tourney = in_tourney;
    }

    public TournamentAtAGlance() {
    }
}
