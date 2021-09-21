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

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

/*        ArrayList<Earthquake> items = new ArrayList<>();
        items.add(new Earthquake("7.2","San Francisco","Feb 2,2016"));
        items.add(new Earthquake("6.1","London","July 20,2015"));
        items.add(new Earthquake("3.9","Tokyo","Nov 10,2014"));
        items.add(new Earthquake("5.4","Mexico","May 3,2014"));
        items.add(new Earthquake("2.8","Moscow","Jan 31,2013"));
        items.add(new Earthquake("4.9","Rio de Janeiro","Aug 19,2012"));
        items.add(new Earthquake("1.6","Paris","Oct 30,2011"));*/

        EarthquakeAdapter itemsAdapter = new EarthquakeAdapter(this, QueryUtils.extractEarthquakes());
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

/*        ArrayList<String> earthquakes = new ArrayList<>();
        earthquakes.add("San Francisco");
        earthquakes.add("London");
        earthquakes.add("Tokyo");
        earthquakes.add("Mexico City");
        earthquakes.add("Moscow");
        earthquakes.add("Rio de Janeiro");
        earthquakes.add("Paris");

        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, earthquakes);

        earthquakeListView.setAdapter(adapter);*/
    }
}
