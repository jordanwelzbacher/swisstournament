package com.jwelzbacher.swisstournament.DTOs;

import com.jwelzbacher.swisstournament.models.User;

public class AuthedUser {
    private String username;

    private String fullName;

    private String emailAddress;

    private boolean isVerified;

    public AuthedUser(User user) {
        this.username = user.getUsername();
        this.fullName = user.getFullName();
        this.emailAddress = user.getEmailAddress();
        this.isVerified = user.isVerified();
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

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

}
