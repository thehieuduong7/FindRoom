package com.example.findroom.models;

import android.media.Image;

import java.util.List;

public class RoomModel {
    private int id;
    private String name;
    private String type;
    private float price;
    private String status;
    private float area;
    private float deposit; // tien coc
    private String location;            //-> show
    private String note;
    private List<Image> images;

    public RoomModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public float getDeposit() {
        return deposit;
    }

    public void setDeposit(float deposit) {
        this.deposit = deposit;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
    @Override
    public String toString() {
        return "RoomModel{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", area=" + area +
                ", deposit=" + deposit +
                ", location='" + location + '\'' +
                ", note='" + note + '\'' +
                ", images=" + images +
                '}';
    }
}
