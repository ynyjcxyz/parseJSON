package com.example.android.quakereport;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;


public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {
    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> earthquake) {
        super(context, 0, earthquake);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_detail, parent, false);
        }
        Earthquake currentEarthquake = getItem(position);

        TextView magView = (TextView) listItemView.findViewById(R.id.mag);
        magView.setText(currentEarthquake.getMagnitude());

        TextView cityView = (TextView) listItemView.findViewById(R.id.city);
        cityView.setText(currentEarthquake.getCity());

        TextView timeView = (TextView) listItemView.findViewById(R.id.date);
        timeView.setText(currentEarthquake.getSimpleDate());

        return listItemView;
    }

}
