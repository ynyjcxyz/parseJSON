package com.example.android.quakereport;

public class Earthquake {
    private final double mMagnitude;
    private final String mLocation;
    private final long mTimeInMilliseconds;

    public Earthquake(double magnitude, String location, long timeInMilliseconds) {
        mMagnitude = magnitude;
        mLocation = location;
        mTimeInMilliseconds = timeInMilliseconds;
    }

    public double getMagnitude() {
        return this.mMagnitude;
    }

    public String getLocation() {
        return this.mLocation;
    }

    public long getTimeInMilliseconds() { return this.mTimeInMilliseconds; }
}