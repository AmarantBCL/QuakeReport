package com.example.android.quakereport;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.net.HttpURLConnection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EarthquakeActivity extends AppCompatActivity {
    private static final String EARTHQUAKES_HOST_URL = "https://earthquake.usgs.gov/";
    private static final String EARTHQUAKES_RESOURCE_PATH = "fdsnws/event/1/query?";
    private static final String EARTHQUAKES_QUERY = "format=geojson&eventtype=earthquake&orderby=time&minmag=6&limit=10";

    private EarthquakeAdapter adapter;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earthquake);

        ListView earthquakeListView = (ListView) findViewById(R.id.list);
        adapter = new EarthquakeAdapter(
                this, R.layout.row_earthquake, new ArrayList<>());
        earthquakeListView.setAdapter(adapter);
        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Earthquake earthquake = adapter.getItem(position);
                Uri webpage = Uri.parse(earthquake.getUrl());
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(intent);
            }
        });

        String url = EARTHQUAKES_HOST_URL + EARTHQUAKES_RESOURCE_PATH + EARTHQUAKES_QUERY;
        EarthquakeTask task = new EarthquakeTask();
        task.execute(url);
    }

    private class EarthquakeTask extends AsyncTask<String, Void, List<Earthquake>> {
        @Override
        protected List<Earthquake> doInBackground(String... strings) {
            if (strings.length == 0) {
                return null;
            }
            return QueryUtils.fetchEarthquakeData(strings[0]);
        }

        @Override
        protected void onPostExecute(List<Earthquake> result) {
            adapter.clear();
            if (result != null && !result.isEmpty()) {
                adapter.addAll(result);
            }
        }
    }
}