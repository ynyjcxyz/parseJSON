package com.example.android.quakereport;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
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

        TextView magView = listItemView.findViewById(R.id.magnitude);
        String formattedMagnitude = formatMagnitude(currentEarthquake.getMagnitude());
        magView.setText(formattedMagnitude);

/*        TextView cityView = (TextView) listItemView.findViewById(R.id.location1);
        cityView.setText(currentEarthquake.getLocation());*/
        String locationOriginal = currentEarthquake.getLocation();
        if(locationOriginal.contains("of")){
            String[] strings= locationOriginal.split("of", 2);
            String location1 = strings[0] + "of";
            String location2 = strings[1];
            TextView locationView1 = listItemView.findViewById(R.id.location1);
            locationView1.setText(location1);
            TextView locationView2 = listItemView.findViewById(R.id.location2);
            locationView2.setText(location2);
        }else {
            String location1 = "near the";
            TextView locationView1 = listItemView.findViewById(R.id.location1);
            locationView1.setText(location1);
            TextView locationView2 = listItemView.findViewById(R.id.location2);
            locationView2.setText(locationOriginal);
        }

        Date dateObject = new Date(currentEarthquake.getTimeInMilliseconds());

        TextView dateView  = listItemView.findViewById(R.id.date);
        String formattedDate = formatDate(dateObject);
        dateView.setText(formattedDate);
        //dateView.setText(String.valueOf(currentEarthquake.getDate()));

        TextView timeView = listItemView.findViewById(R.id.time);
        String formattedTime = formatTime(dateObject);
        timeView.setText(formattedTime);

        return listItemView;
    }

    private String formatMagnitude(double magnitude){
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }

    private String formatDate(Date dateObject) {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    private String formatTime(Date dateObject) {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }
}
