package com.jwelzbacher.swisstournament.DTOs;

public class AuthedUser {
    private String username;

    private String fullName;

    private String emailAddress;

    private boolean isVerified;

    private String authToken;

    public AuthedUser(String username, String fullName, String emailAddress, boolean isVerified, String authToken) {
        this.username = username;
        this.fullName = fullName;
        this.emailAddress = emailAddress;
        this.isVerified = isVerified;
        this.authToken = authToken;
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

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
}
