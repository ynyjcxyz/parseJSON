package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;
import java.util.ArrayList;

public class EarthquakeLoader extends AsyncTaskLoader<ArrayList<Earthquake>> {
    public static final String LOG_TAG = EarthquakeLoader.class.getSimpleName();
    private final String mUrl;

    public EarthquakeLoader(@NonNull Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
        Log.i(LOG_TAG,"This is onStartLoading() method");
    }

    @Nullable
    @Override
    public ArrayList<Earthquake> loadInBackground() {
        if (mUrl == null) {
            return null;
        } else {
            Log.i(LOG_TAG,"This is loadInBackground() method");
            return QueryUtils.fetchEarthquakeData(mUrl);
        }
    }
}