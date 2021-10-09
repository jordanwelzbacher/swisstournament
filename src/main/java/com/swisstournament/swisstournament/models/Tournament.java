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
}
