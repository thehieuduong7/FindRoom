package com.example.findroom.models;

import java.util.List;

public class UserModel {
    private String sdt;
    private String password;
    private String fullName;
    private List<String> myRoomId;
    private List<String> savedRoomId;

    public String getSdt() {
        return sdt;
    }

    public UserModel() {
    }

    public UserModel(String sdt, String password, String fullName) {
        this.sdt = sdt;
        this.password = password;
        this.fullName = fullName;
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

    public List<String> getMyRoomId() {
        return myRoomId;
    }

    public void setMyRoomId(List<String> myRoomId) {
        this.myRoomId = myRoomId;
    }

    public List<String> getSavedRoomId() {
        return savedRoomId;
    }

    public void setSavedRoomId(List<String> savedRoomId) {
        this.savedRoomId = savedRoomId;
    }

    @Override
    public String toString() {
        return "UserModel{" +

                ", fullName='" + fullName + '\'' +
                '}';
    }
}
