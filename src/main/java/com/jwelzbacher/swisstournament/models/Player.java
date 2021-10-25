package com.jwelzbacher.swisstournament.models;

import javax.persistence.*;


@Entity(name="player")
@Table(name="player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column
    private Long tournamentId;

    @Column
    private Long userId;

    @Column
    private String displayName;

    @Column
    private boolean isDropped;

    @Column
    private boolean isConfirmed;

    public Player(Long id, Long tournamentId, Long userId, String displayName, boolean isDropped, boolean isConfirmed) {
        this.id = id;
        this.tournamentId = tournamentId;
        this.userId = userId;
        this.displayName = displayName;
        this.isDropped = isDropped;
        this.isConfirmed = isConfirmed;
    }

    public Player() {
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public boolean isDropped() {
        return isDropped;
    }

    public void setDropped(boolean dropped) {
        isDropped = dropped;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(boolean confirmed) {
        isConfirmed = confirmed;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
