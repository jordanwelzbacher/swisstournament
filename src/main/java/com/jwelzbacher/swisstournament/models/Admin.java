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
    private Long userId;

    @Column
    private String username;

    public Admin(Long id, Long userId, String username) {
        this.id = id;
        this.userId = userId;
        this.username = username;
    }

    public Admin() {
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
}
