package com.jwelzbacher.swisstournament.models;

import javax.persistence.*;

@Entity(name="admin")
@Table(name="tournament_admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique = true, nullable = false)
    private Long id;

    @Column
    private Long tournamentId;

    @Column
    private Long userId;

    public Admin(Long id, Long tournamentId, Long userId) {
        this.id = id;
        this.tournamentId = tournamentId;
        this.userId = userId;
    }

    public Admin() {
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
}
