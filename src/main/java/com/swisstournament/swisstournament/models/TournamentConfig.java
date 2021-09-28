package com.swisstournament.swisstournament.models;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

//        const NONE = 0;
//        const OMWP = 1;
//        const MEDIAN_BUCHHOLZ = 2;
//        const GWP = 3;
//        const OGWP = 4;
//        const CUSTOM_A = 5;
//        const CUSTOM_B = 6;

import java.sql.Timestamp;

@Entity(name="TournamentConfig")
@Table(name="TournamentConfig")
public class TournamentConfig {

    public TournamentConfig(Long id, @NotBlank String tournament_name, @NotBlank String competition_type, @NotEmpty Timestamp tournament_date, String venue, @NotNull boolean player_registration_on, @NotNull boolean player_results_on, @NotEmpty double win_points, @NotEmpty double loss_points, @NotEmpty double draw_points, @NotEmpty int first_tiebreaker, @NotEmpty int second_tiebreaker, @NotEmpty int third_tiebreaker, @NotEmpty int fourth_tiebreaker, @NotEmpty int fifth_tiebreaker, String custom_a_name, String custom_b_name, boolean custom_a_lower_is_better, boolean custom_b_lower_is_better) {
        this.id = id;
        this.tournament_name = tournament_name;
        this.competition_type = competition_type;
        this.tournament_date = tournament_date;
        this.venue = venue;
        this.player_registration_on = player_registration_on;
        this.player_results_on = player_results_on;
        this.win_points = win_points;
        this.loss_points = loss_points;
        this.draw_points = draw_points;
        this.first_tiebreaker = first_tiebreaker;
        this.second_tiebreaker = second_tiebreaker;
        this.third_tiebreaker = third_tiebreaker;
        this.fourth_tiebreaker = fourth_tiebreaker;
        this.fifth_tiebreaker = fifth_tiebreaker;
        this.custom_a_name = custom_a_name;
        this.custom_b_name = custom_b_name;
        this.custom_a_lower_is_better = custom_a_lower_is_better;
        this.custom_b_lower_is_better = custom_b_lower_is_better;
    }

    public TournamentConfig() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique=true, nullable = false)
    private Long id;

    @Column(name="tournament_name")
    @NotBlank
    private String tournament_name;

    @Column(name="competition_type")
    @NotBlank
    private String competition_type;

    @Column(name="tournament_date")
    @NotEmpty
    private Timestamp tournament_date;

    @Column(name="venue")
    private String venue;

    @Column(name="player_registration_on")
    @NotNull
    private boolean player_registration_on;

    @Column(name="player_results_on")
    @NotNull
    private boolean player_results_on;

    @Column(name="win_points")
    @NotEmpty
    private double win_points;

    @Column(name="loss_points")
    @NotEmpty
    private double loss_points;

    @Column(name="draw_points")
    @NotEmpty
    private double draw_points;

    @Column(name="first_tiebreaker")
    @NotEmpty
    private int first_tiebreaker;

    @Column(name="second_tiebreaker")
    @NotEmpty
    private int second_tiebreaker;

    @Column(name="third_tiebreaker")
    @NotEmpty
    private int third_tiebreaker;

    @Column(name="fourth_tiebreaker")
    @NotEmpty
    private int fourth_tiebreaker;

    @Column(name="fifth_tiebreaker")
    @NotEmpty
    private int fifth_tiebreaker;

    @Column(name="custom_a_name")
    private String custom_a_name;

    @Column(name="custom_b_name")
    private String custom_b_name;

    @Column(name="custom_a_lower_is_better")
    private boolean custom_a_lower_is_better;

    @Column(name="custom_b_lower_is_better")
    private boolean custom_b_lower_is_better;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean isPlayer_registration_on() {
        return player_registration_on;
    }

    public void setPlayer_registration_on(boolean player_registration_on) {
        this.player_registration_on = player_registration_on;
    }

    public boolean isPlayer_results_on() {
        return player_results_on;
    }

    public void setPlayer_results_on(boolean player_results_on) {
        this.player_results_on = player_results_on;
    }

    public double getWin_points() {
        return win_points;
    }

    public void setWin_points(double win_points) {
        this.win_points = win_points;
    }

    public double getLoss_points() {
        return loss_points;
    }

    public void setLoss_points(double loss_points) {
        this.loss_points = loss_points;
    }

    public double getDraw_points() {
        return draw_points;
    }

    public void setDraw_points(double draw_points) {
        this.draw_points = draw_points;
    }

    public int getFirst_tiebreaker() {
        return first_tiebreaker;
    }

    public void setFirst_tiebreaker(int first_tiebreaker) {
        this.first_tiebreaker = first_tiebreaker;
    }

    public int getSecond_tiebreaker() {
        return second_tiebreaker;
    }

    public void setSecond_tiebreaker(int second_tiebreaker) {
        this.second_tiebreaker = second_tiebreaker;
    }

    public int getThird_tiebreaker() {
        return third_tiebreaker;
    }

    public void setThird_tiebreaker(int third_tiebreaker) {
        this.third_tiebreaker = third_tiebreaker;
    }

    public int getFourth_tiebreaker() {
        return fourth_tiebreaker;
    }

    public void setFourth_tiebreaker(int fourth_tiebreaker) {
        this.fourth_tiebreaker = fourth_tiebreaker;
    }

    public int getFifth_tiebreaker() {
        return fifth_tiebreaker;
    }

    public void setFifth_tiebreaker(int fifth_tiebreaker) {
        this.fifth_tiebreaker = fifth_tiebreaker;
    }

    public String getCustom_a_name() {
        return custom_a_name;
    }

    public void setCustom_a_name(String custom_a_name) {
        this.custom_a_name = custom_a_name;
    }

    public String getCustom_b_name() {
        return custom_b_name;
    }

    public void setCustom_b_name(String custom_b_name) {
        this.custom_b_name = custom_b_name;
    }

    public boolean isCustom_a_lower_is_better() {
        return custom_a_lower_is_better;
    }

    public void setCustom_a_lower_is_better(boolean custom_a_lower_is_better) {
        this.custom_a_lower_is_better = custom_a_lower_is_better;
    }

    public boolean isCustom_b_lower_is_better() {
        return custom_b_lower_is_better;
    }

    public void setCustom_b_lower_is_better(boolean custom_b_lower_is_better) {
        this.custom_b_lower_is_better = custom_b_lower_is_better;
    }
}