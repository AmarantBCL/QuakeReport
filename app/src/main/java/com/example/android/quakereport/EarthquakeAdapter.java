package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {
    private static final String LOCATION_SEPARATOR = " of ";
    private static final String DECIMAL_FORMAT = "0.0";

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
        TextView offsetView = itemView.findViewById(R.id.tv_offset);
        TextView locationView = itemView.findViewById(R.id.tv_location);
        TextView dateView = itemView.findViewById(R.id.tv_date);
        TextView timeView = itemView.findViewById(R.id.tv_time);
        Earthquake earthquake = earthquakes.get(position);
        String originalLocation = earthquake.getLocation();
        String offset;
        String location;
        if (originalLocation.contains(LOCATION_SEPARATOR)) {
            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
            offset = parts[0] + LOCATION_SEPARATOR;
            location = parts[1];
        } else {
            offset = getContext().getString(R.string.near_the);
            location = originalLocation;
        }
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();
        int magnitudeColor = getMagnitudeColor(earthquake.getMagnitude());
        magnitudeCircle.setColor(magnitudeColor);
        magnitudeView.setText(formatMagnitude(earthquake.getMagnitude()));
        offsetView.setText(offset);
        locationView.setText(location);
        dateView.setText(DateTimeUtils.formatDate(earthquake.getDate()));
        timeView.setText(DateTimeUtils.formatTime(earthquake.getDate()));
        return itemView;
    }

    private String formatMagnitude(double magnitude) {
        DecimalFormat formatter = new DecimalFormat(DECIMAL_FORMAT, new DecimalFormatSymbols(Locale.ENGLISH));
        return formatter.format(magnitude);
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = ContextCompat.getColor(getContext(), R.color.magnitude1);
                break;
            case 2:
                magnitudeColorResourceId = ContextCompat.getColor(getContext(), R.color.magnitude2);
                break;
            case 3:
                magnitudeColorResourceId = ContextCompat.getColor(getContext(), R.color.magnitude3);
                break;
            case 4:
                magnitudeColorResourceId = ContextCompat.getColor(getContext(), R.color.magnitude4);
                break;
            case 5:
                magnitudeColorResourceId = ContextCompat.getColor(getContext(), R.color.magnitude5);
                break;
            case 6:
                magnitudeColorResourceId = ContextCompat.getColor(getContext(), R.color.magnitude6);
                break;
            case 7:
                magnitudeColorResourceId = ContextCompat.getColor(getContext(), R.color.magnitude7);
                break;
            case 8:
                magnitudeColorResourceId = ContextCompat.getColor(getContext(), R.color.magnitude8);
                break;
            case 9:
                magnitudeColorResourceId = ContextCompat.getColor(getContext(), R.color.magnitude9);
                break;
            default:
                magnitudeColorResourceId = ContextCompat.getColor(getContext(), R.color.magnitude10plus);
                break;

        }
        return magnitudeColorResourceId;
    }
}
