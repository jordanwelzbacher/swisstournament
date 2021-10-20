package com.jwelzbacher.swisstournament.models;

import javax.persistence.*;

@Entity(name="st_user")
@Table(name="st_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column
    private String fullName;

    @Column(unique = true, nullable = false)
    private String emailAddress;

    @Column
    private String password;

    @Column
    private boolean isVerified;

    public User(Long id, String username, String fullName, String emailAddress, String password, Boolean isVerified) {
        this.id = id;
        this.username = username;
        this.fullName = fullName;
        this.emailAddress = emailAddress;
        this.password = password;
        this.isVerified = isVerified;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String pword) {
        this.password = pword;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
