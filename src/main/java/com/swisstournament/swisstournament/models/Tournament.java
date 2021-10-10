package com.swisstournament.swisstournament.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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

@Entity(name="tournament")
@Table(name="tournament")
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique=true, nullable = false)
    private Long id;

    @Column(name="owner_user_id")
    private String owner_user_id;

    @Column(name="tournament_name")
    private String tournament_name;

    @Column(name="competition_type")
    private String competition_type;

    @Column(name="tournament_date")
    private Timestamp tournament_date;

    @Column(name="venue")
    private String venue;

    @Column(name="player_registration_on")
    private boolean is_player_registration_on;

    @Column(name="player_results_on")
    private boolean is_player_results_on;

    @Column(name="player_limit")
    private double player_limit;

    @Column(name="win_points")
    private double win_points;

    @Column(name="loss_points")
    private double loss_points;

    @Column(name="draw_points")
    private double draw_points;

    @Column(name="first_tiebreaker")
    private int first_tiebreaker;

    @Column(name="second_tiebreaker")
    private int second_tiebreaker;

    @Column(name="third_tiebreaker")
    private int third_tiebreaker;

    @Column(name="fourth_tiebreaker")
    private int fourth_tiebreaker;

    @Column(name="fifth_tiebreaker")
    private int fifth_tiebreaker;

    @Column(name="custom_a_name")
    private String custom_a_name;

    @Column(name="custom_b_name")
    private String custom_b_name;

    @Column(name="is_lower_better_for_custom_a")
    private boolean is_lower_better_for_custom_a;

    @Column(name="is_lower_better_for_custom_b")
    private boolean is_lower_better_for_custom_b;

    @Column(name="is_use_first_last")
    private boolean is_use_first_last;

    @Column(name="created_date")
    private Timestamp created_date;

    public Long getId() {
        return id;
    }

    public String getOwner_user_id() {
        return owner_user_id;
    }

    public String getTournament_name() {
        return tournament_name;
    }

    public String getCompetition_type() {
        return competition_type;
    }

    public Timestamp getTournament_date() {
        return tournament_date;
    }

    public String getVenue() {
        return venue;
    }

    public boolean isIs_player_registration_on() {
        return is_player_registration_on;
    }

    public boolean isIs_player_results_on() {
        return is_player_results_on;
    }

    public double getPlayer_limit() {
        return player_limit;
    }

    public double getWin_points() {
        return win_points;
    }

    public double getLoss_points() {
        return loss_points;
    }

    public double getDraw_points() {
        return draw_points;
    }

    public int getFirst_tiebreaker() {
        return first_tiebreaker;
    }

    public int getSecond_tiebreaker() {
        return second_tiebreaker;
    }

    public int getThird_tiebreaker() {
        return third_tiebreaker;
    }

    public int getFourth_tiebreaker() {
        return fourth_tiebreaker;
    }

    public int getFifth_tiebreaker() {
        return fifth_tiebreaker;
    }

    public String getCustom_a_name() {
        return custom_a_name;
    }

    public String getCustom_b_name() {
        return custom_b_name;
    }

    public boolean isIs_lower_better_for_custom_a() {
        return is_lower_better_for_custom_a;
    }

    public boolean isIs_lower_better_for_custom_b() {
        return is_lower_better_for_custom_b;
    }

    public boolean isIs_use_first_last() {
        return is_use_first_last;
    }

    public Timestamp getCreated_date() {
        return created_date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOwner_user_id(String owner_user_id) {
        this.owner_user_id = owner_user_id;
    }

    public void setTournament_name(String tournament_name) {
        this.tournament_name = tournament_name;
    }

    public void setCompetition_type(String competition_type) {
        this.competition_type = competition_type;
    }

    public void setTournament_date(Timestamp tournament_date) {
        this.tournament_date = tournament_date;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public void setIs_player_registration_on(boolean is_player_registration_on) {
        this.is_player_registration_on = is_player_registration_on;
    }

    public void setIs_player_results_on(boolean is_player_results_on) {
        this.is_player_results_on = is_player_results_on;
    }

    public void setPlayer_limit(double player_limit) {
        this.player_limit = player_limit;
    }

    public void setWin_points(double win_points) {
        this.win_points = win_points;
    }

    public void setLoss_points(double loss_points) {
        this.loss_points = loss_points;
    }

    public void setDraw_points(double draw_points) {
        this.draw_points = draw_points;
    }

    public void setFirst_tiebreaker(int first_tiebreaker) {
        this.first_tiebreaker = first_tiebreaker;
    }

    public void setSecond_tiebreaker(int second_tiebreaker) {
        this.second_tiebreaker = second_tiebreaker;
    }

    public void setThird_tiebreaker(int third_tiebreaker) {
        this.third_tiebreaker = third_tiebreaker;
    }

    public void setFourth_tiebreaker(int fourth_tiebreaker) {
        this.fourth_tiebreaker = fourth_tiebreaker;
    }

    public void setFifth_tiebreaker(int fifth_tiebreaker) {
        this.fifth_tiebreaker = fifth_tiebreaker;
    }

    public void setCustom_a_name(String custom_a_name) {
        this.custom_a_name = custom_a_name;
    }

    public void setCustom_b_name(String custom_b_name) {
        this.custom_b_name = custom_b_name;
    }

    public void setIs_lower_better_for_custom_a(boolean is_lower_better_for_custom_a) {
        this.is_lower_better_for_custom_a = is_lower_better_for_custom_a;
    }

    public void setIs_lower_better_for_custom_b(boolean is_lower_better_for_custom_b) {
        this.is_lower_better_for_custom_b = is_lower_better_for_custom_b;
    }

    public void setIs_use_first_last(boolean is_use_first_last) {
        this.is_use_first_last = is_use_first_last;
    }

    public void setCreated_date(Timestamp created_date) {
        this.created_date = created_date;
    }

    public Tournament(Long id, String owner_user_id, String tournament_name, String competition_type, Timestamp tournament_date, String venue, boolean is_player_registration_on, boolean is_player_results_on, double player_limit, double win_points, double loss_points, double draw_points, int first_tiebreaker, int second_tiebreaker, int third_tiebreaker, int fourth_tiebreaker, int fifth_tiebreaker, String custom_a_name, String custom_b_name, boolean is_lower_better_for_custom_a, boolean is_lower_better_for_custom_b, boolean is_use_first_last, Timestamp created_date) {
        this.id = id;
        this.owner_user_id = owner_user_id;
        this.tournament_name = tournament_name;
        this.competition_type = competition_type;
        this.tournament_date = tournament_date;
        this.venue = venue;
        this.is_player_registration_on = is_player_registration_on;
        this.is_player_results_on = is_player_results_on;
        this.player_limit = player_limit;
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
        this.is_lower_better_for_custom_a = is_lower_better_for_custom_a;
        this.is_lower_better_for_custom_b = is_lower_better_for_custom_b;
        this.is_use_first_last = is_use_first_last;
        this.created_date = created_date;
    }

    public Tournament() {
    }
}
