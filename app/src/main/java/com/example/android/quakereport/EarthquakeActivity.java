/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<ArrayList<Earthquake>> {
    public static final String LOG_TAG = EarthquakeActivity.class.getSimpleName();
    private EarthquakeAdapter mAdapter;
    private static final String USGS_REQUEST_URL = "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&eventtype=earthquake&orderby=time&minmag=6&limit=10";
    private static final int EARTHQUAKE_LOADER_ID = 1;
    private TextView mEmptyStateTextView;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        mAdapter = new EarthquakeAdapter(this, new ArrayList<Earthquake>());
/**        EarthquakeAsyncTask asyncTask = new EarthquakeAsyncTask();
 asyncTask.execute(USGS_REQUEST_URL);*/
        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        mEmptyStateTextView = findViewById(R.id.empty_view);
        earthquakeListView.setEmptyView(mEmptyStateTextView);

        earthquakeListView.setAdapter(mAdapter);

        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Earthquake currentEarthquake = mAdapter.getItem(position);
                Uri earthquakeUri = Uri.parse(currentEarthquake.getUrl());
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, earthquakeUri);
                startActivity(websiteIntent);
            }
        });

        ConnectivityManager cm =
                (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            getSupportLoaderManager().initLoader(EARTHQUAKE_LOADER_ID, null, this).forceLoad();
            Log.i(LOG_TAG, "This is initLoader()");
        } else {
            ProgressBar prgBar = (ProgressBar) findViewById(R.id.loading_bar);
            prgBar.setVisibility(View.GONE);
            mEmptyStateTextView.setText("No Internet Connection...");
            mEmptyStateTextView.setBackgroundResource(R.drawable.no_internet);
        }
    }

    @NonNull
    @Override
    public Loader<ArrayList<Earthquake>> onCreateLoader(int i, @Nullable Bundle bundle) {
        Log.i(LOG_TAG, "This is onCreateLoader() callback");
        return new EarthquakeLoader(EarthquakeActivity.this, USGS_REQUEST_URL);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onLoadFinished(@NonNull Loader<ArrayList<Earthquake>> loader, ArrayList<Earthquake> earthquakes) {
        ProgressBar prgBar = (ProgressBar) findViewById(R.id.loading_bar);
        prgBar.setVisibility(View.GONE);
        Log.i(LOG_TAG, "This is onLoadFinished() callback");
        mEmptyStateTextView.setText("No Data can be found...");
        mEmptyStateTextView.setBackgroundResource(R.drawable.repeat_bg);
        mAdapter.clear();
        if (earthquakes != null && !earthquakes.isEmpty()) {
            mAdapter.addAll(earthquakes);
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<ArrayList<Earthquake>> loader) {
        Log.i(LOG_TAG, "This is onLoaderReset() callback");
        mAdapter.clear();
        //mAdapter.addAll(new ArrayList<Earthquake>());
    }

/**    private class EarthquakeAsyncTask extends AsyncTask<String, Void, ArrayList<Earthquake>> {
@Override protected ArrayList<Earthquake> doInBackground(String... urls) {
if (urls.length < 1 || urls[0] == null) {
return null;
}
return QueryUtils.fetchEarthquakeData(urls[0]);
}

@Override protected void onPostExecute(ArrayList<Earthquake> data) {
mAdapter.clear();
if (data != null && !data.isEmpty()) {
mAdapter.addAll(data);
}
}
}*/
}