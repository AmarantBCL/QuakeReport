package com.example.android.quakereport;

import java.time.LocalDate;

public class Earthquake {
    private double magnitude;
    private String location;
    private long date;
    private String url;

    public double getMagnitude() {
        return magnitude;
    }

    public String getLocation() {
        return location;
    }

    public long getDate() {
        return date;
    }

    public String getUrl() {
        return url;
    }

    public Earthquake(double magnitude, String location, long date, String url) {
        this.magnitude = magnitude;
        this.location = location;
        this.date = date;
        this.url = url;
    }
}
