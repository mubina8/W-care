package com.example.wcare.Classes;

public class newUser {

    public String nameUser;
    public String phnUser;
    public String emailUser;
    public String userId;

    public newUser() {
    }

    public newUser(String nameUser, String phnUser, String emailUser , String userId) {
        this.nameUser = nameUser;
        this.phnUser = phnUser;
        this.emailUser = emailUser;
        this.userId = userId;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getPhnUser() {
        return phnUser;
    }

    public void setPhnUser(String phnUser) {
        this.phnUser = phnUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
