package com.swisstournament.swisstournament.models;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

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
    private String tournamentName;

    @Column(name="competitionType")
    private String competitionType;

    @Column(name="tournamentDate")
    private OffsetDateTime tournamentDate;

    @Column(name="venue")
    private String venue;

    @Column(name="playerRegistrationOn")
    private boolean playerRegistrationOn;

    @Column(name="playerResultsOn")
    private boolean playerResultsOn;

    @Column(name="winPoints")
    private double winPoints;

    @Column(name="lossPoints")
    private double lossPoints;

    @Column(name="drawPoints")
    private double drawPoints;

    @Column(name="firstTiebreaker")
    private int firstTiebreaker;

    @Column(name="secondTiebreaker")
    private int secondTiebreaker;

    @Column(name="firstTiebreaker")
    private int thirdTiebreaker;

    @Column(name="firstTiebreaker")
    private int fourthTiebreaker;

    @Column(name="firstTiebreaker")
    private int fifthTiebreaker;

    @Column(name="CustomAName")
    private String customAName;

    @Column(name="CustomBName")
    private String customBName;

    @Column(name="CustomALowerIsBetter")
    private boolean customALowerIsBetter;

    @Column(name="CustomBLowerIsBetter")
    private boolean customBLowerIsBetter;
}