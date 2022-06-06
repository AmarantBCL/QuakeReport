package com.example.android.quakereport;

import java.time.LocalDate;

public class Earthquake {
    private double magnitude;
    private String location;
    private LocalDate date;

    public double getMagnitude() {
        return magnitude;
    }

    public String getLocation() {
        return location;
    }

    public LocalDate getDate() {
        return date;
    }

    public Earthquake(double magnitude, String location, LocalDate date) {
        this.magnitude = magnitude;
        this.location = location;
        this.date = date;
    }
}
