package com.jwelzbacher.swisstournament.DTOs;

import javax.persistence.*;

@Entity(name="adminWithUsername")
@Table(name="tournament_admin")
public class AdminWithUsername {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique = true, nullable = false)
    private Long id;

    @Column
    private Long tournamentId;

    @Column
    private Long userId;

    @Column
    private String username;

    public AdminWithUsername(Long id, Long tournamentId, Long userId, String username) {
        this.id = id;
        this.tournamentId = tournamentId;
        this.userId = userId;
        this.username = username;
    }

    public AdminWithUsername() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(Long tournamentId) {
        this.tournamentId = tournamentId;
    }
}
