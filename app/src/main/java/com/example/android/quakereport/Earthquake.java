package com.example.android.quakereport;

public class Earthquake {
    private final double mMagnitude;
    private final String mLocation;
    private final long mTimeInMilliseconds;
    private final String mUrl;

    public Earthquake(double magnitude, String location, long timeInMilliseconds, String url) {
        this.mMagnitude = magnitude;
        this.mLocation = location;
        this.mTimeInMilliseconds = timeInMilliseconds;
        this.mUrl = url;
    }

    public double getMagnitude() {
        return this.mMagnitude;
    }

    public String getLocation() {
        return this.mLocation;
    }

    public long getTimeInMilliseconds() {
        return this.mTimeInMilliseconds;
    }

    public String getUrl() {
        return this.mUrl;
    }
}