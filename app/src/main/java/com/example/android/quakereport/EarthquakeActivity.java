package com.example.android.quakereport;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EarthquakeActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earthquake);

        List<Earthquake> earthquakes = new ArrayList<>();
        earthquakes.add(new Earthquake(7.2, "San Francisco", LocalDate.of(2016, 2, 2)));
        earthquakes.add(new Earthquake(6.1, "London", LocalDate.of(2015, 7, 20)));
        earthquakes.add(new Earthquake(3.9, "Tokyo", LocalDate.of(2014, 11, 10)));
        earthquakes.add(new Earthquake(5.4, "Mexico City", LocalDate.of(2014, 5, 3)));
        earthquakes.add(new Earthquake(2.8, "Moscow", LocalDate.of(2013, 1, 31)));
        earthquakes.add(new Earthquake(4.9, "Rio de Janeiro", LocalDate.of(2012, 8, 19)));
        earthquakes.add(new Earthquake(1.6, "Paris", LocalDate.of(2011, 10, 30)));
        ListView earthquakeListView = (ListView) findViewById(R.id.list);
        EarthquakeAdapter adapter = new EarthquakeAdapter(
                this, R.layout.row_earthquake, earthquakes);
        earthquakeListView.setAdapter(adapter);
    }
}