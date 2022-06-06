package com.example.android.quakereport;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import java.util.List;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {
    private LayoutInflater inflater;
    private int layout;
    private List<Earthquake> earthquakes;

    public EarthquakeAdapter(Context context, int layout, List<Earthquake> earthquakes) {
        super(context, layout, earthquakes);
        this.earthquakes = earthquakes;
        this.layout = layout;
        this.inflater = LayoutInflater.from(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null) {
            itemView = inflater.inflate(layout, parent, false);
        }
        TextView magnitudeView = itemView.findViewById(R.id.tv_magnitude);
        TextView locationView = itemView.findViewById(R.id.tv_location);
        TextView dateView = itemView.findViewById(R.id.tv_date);
        Earthquake earthquake = earthquakes.get(position);
        magnitudeView.setText(earthquake.getMagnitude() + "");
        locationView.setText(earthquake.getLocation());
        dateView.setText(DateUtils.format(earthquake.getDate()));
        return itemView;
    }
}
