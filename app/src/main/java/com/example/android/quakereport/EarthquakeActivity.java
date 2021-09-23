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

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {
    ArrayList<Earthquake> earthquakes = QueryUtils.extractEarthquakes();

    private static Uri getUri(int mPosition){
        return Uri.parse(QueryUtils.extractEarthquakes().get(mPosition).getUrl());
    }

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

        EarthquakeAdapter itemsAdapter = new EarthquakeAdapter(this, earthquakes);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            switch (position) {
                case 0: Intent intent0 = new Intent(Intent.ACTION_VIEW, getUri(0));
                    startActivity(intent0);
                    break;
                case 1: Intent intent1 = new Intent(Intent.ACTION_VIEW, getUri(1));
                    startActivity(intent1);
                    break;
                case 2: Intent intent2 = new Intent(Intent.ACTION_VIEW, getUri(2));
                    startActivity(intent2);
                    break;
                case 3: Intent intent3 = new Intent(Intent.ACTION_VIEW, getUri(3));
                    startActivity(intent3);
                    break;
                case 4: Intent intent4 = new Intent(Intent.ACTION_VIEW, getUri(4));
                    startActivity(intent4);
                    break;
                case 5: Intent intent5 = new Intent(Intent.ACTION_VIEW, getUri(5));
                    startActivity(intent5);
                    break;
                case 6: Intent intent6 = new Intent(Intent.ACTION_VIEW, getUri(6));
                    startActivity(intent6);
                    break;
                case 7: Intent intent7 = new Intent(Intent.ACTION_VIEW, getUri(7));
                    startActivity(intent7);
                    break;
                case 8: Intent intent8 = new Intent(Intent.ACTION_VIEW, getUri(8));
                    startActivity(intent8);
                    break;
                case 9: Intent intent9 = new Intent(Intent.ACTION_VIEW, getUri(9));
                    startActivity(intent9);
                    break;
            }
        });
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