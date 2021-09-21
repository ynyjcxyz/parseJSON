package com.example.android.quakereport;

public class Earthquake {
    String magnitude;
    String city;
    String simpleDate;

    public Earthquake(String inputMagnitude, String inputCity, String inputSimpleDate) {
        magnitude = inputMagnitude;
        city = inputCity;
        simpleDate = inputSimpleDate;
    }

    public String getMagnitude() {
        return this.magnitude;
    }

    public String getCity() { return this.city; }

    public String getSimpleDate() {
        return this.simpleDate;
    }
}
