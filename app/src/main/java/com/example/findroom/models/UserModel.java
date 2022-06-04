package com.example.findroom.models;

import java.util.List;

public class UserModel {
    private String sdt;
    private String username;
    private String password;
    private String fullName;
    private List<Integer> myRoomId;
    private List<Integer> savedRoomId;
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Integer> getMyRoomId() {
        return myRoomId;
    }

    public void setMyRoomId(List<Integer> myRoomId) {
        this.myRoomId = myRoomId;
    }

    public List<Integer> getSavedRoomId() {
        return savedRoomId;
    }

    public void setSavedRoomId(List<Integer> savedRoomId) {
        this.savedRoomId = savedRoomId;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "username='" + username + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
