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

import java.time.OffsetDateTime;

@Entity(name="TournamentConfig")
@Table(name="TournamentConfig")
public class TournamentConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique=true, nullable = false)
    private Long id;

    @Column(name="tournamentName")
    @NotBlank
    private String tournamentName;

    @Column(name="competitionType")
    @NotBlank
    private String competitionType;

    @Column(name="tournamentDate")
    @NotEmpty
    private OffsetDateTime tournamentDate;

    @Column(name="venue")
    private String venue;

    @Column(name="playerRegistrationOn")
    @NotNull
    private boolean playerRegistrationOn;

    @Column(name="playerResultsOn")
    @NotNull
    private boolean playerResultsOn;

    @Column(name="winPoints")
    @NotEmpty
    private double winPoints;

    @Column(name="lossPoints")
    @NotEmpty
    private double lossPoints;

    @Column(name="drawPoints")
    @NotEmpty
    private double drawPoints;

    @Column(name="firstTiebreaker")
    @NotEmpty
    private int firstTiebreaker;

    @Column(name="secondTiebreaker")
    @NotEmpty
    private int secondTiebreaker;

    @Column(name="thirdTiebreaker")
    @NotEmpty
    private int thirdTiebreaker;

    @Column(name="fourthTiebreaker")
    @NotEmpty
    private int fourthTiebreaker;

    @Column(name="fifthTiebreaker")
    @NotEmpty
    private int fifthTiebreaker;

    @Column(name="customAName")
    private String customAName;

    @Column(name="customBName")
    private String customBName;

    @Column(name="customALowerIsBetter")
    private boolean customALowerIsBetter;

    @Column(name="customBLowerIsBetter")
    private boolean customBLowerIsBetter;
}