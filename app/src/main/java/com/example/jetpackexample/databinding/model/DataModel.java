package com.example.jetpackexample.databinding.model;

public class DataModel {
    private String androidName;
    private int androidVersion;

    public DataModel(String androidName, int androidVersion) {
        this.androidName = androidName;
        this.androidVersion = androidVersion;
    }

    public String getAndroidName() {
        return androidName;
    }

    public int getAndroidVersion() {
        return androidVersion;
    }
}