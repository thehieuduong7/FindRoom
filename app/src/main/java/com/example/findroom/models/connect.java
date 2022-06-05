package com.example.findroom.models;

import android.text.method.SingleLineTransformationMethod;

import java.util.ArrayList;

public class connect {
    private String sdt;
    private ArrayList<String>  idR;

    public connect(String sdt, ArrayList<String> idR) {
        this.sdt = sdt;
        this.idR = idR;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public ArrayList<String> getIdR() {
        return idR;
    }

    public void setIdR(ArrayList<String> idR) {
        this.idR = idR;
    }
}
