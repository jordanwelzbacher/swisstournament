package com.jwelzbacher.swisstournament.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="st_user")
@Table(name="st_user")
public class User {

    @Id
    @Column(name="username", unique = true, nullable = false)
    private String username;

    @Column(name="full_name")
    private String fullName;

    @Column(name="email_address", unique = true, nullable = false)
    private String emailAddress;

    @Column(name="password")
    private String password;

    @Column(name="is_verified")
    private boolean isVerified;

    public User(String username, String fullName, String emailAddress, String password, Boolean isVerified) {
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
}
