package com.ryle_tech.materialdesign.Activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.android.volley.Cache;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.ryle_tech.materialdesign.App;
import com.ryle_tech.materialdesign.R;
import com.ryle_tech.materialdesign.data.Series;
import com.ryle_tech.materialdesign.adapter.SeriesAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class SeriesActivity extends AppCompatActivity {

    RecyclerView recyclerViewseries;
    ProgressDialog pDialog;
    String url = "http://192.168.56.1/Event/series.php";

    ArrayList<Series> seriesArrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        assignView();
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading....");
        pDialog.show();

        getDatabasePath();



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void getDatabasePath() {

        Cache cache = App.getInstance().getRequestQueue().getCache();
        Cache.Entry entry = cache.get(url);
        if (entry != null) {
            // fetch the data from cache
            try {
                String data = new String(entry.data, "UTF-8");
                try {
                    pDialog.hide();
                    parseJsonData(new JSONArray(data));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } else {
//        load the seasons and episodes
            JsonArrayRequest req = new JsonArrayRequest(url,
                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            Log.d(App.TAG, response.toString());

                            pDialog.hide();

                            parseJsonData(response);
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    VolleyLog.d(App.TAG, "Error: " + error.getMessage());
                    pDialog.hide();
                }
            });

// Adding request to request queue
            App.getInstance().addToRequestQueue(req, App.TAG);
        }

    }

    private void parseJsonData(JSONArray jsonArray) {

        for(int i = 0; i< jsonArray.length(); i++) {
        Series series = new Series();
            try {
                JSONObject jsonData = jsonArray.getJSONObject(i);

                series.setSeriesName(jsonData.getString("series_name"));
               series.setSeriesDescription(jsonData.getString("series_desc"));
            } catch (JSONException e) {
                e.printStackTrace();
            }

            System.out.println(series.toString());

            seriesArrayList.add(series);
        }
        Log.i(App.TAG, "parseJsonData: Series size = "+seriesArrayList.size());

//        pass the data to the adapter
        recyclerViewseries.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        recyclerViewseries.setItemAnimator(new DefaultItemAnimator());
        recyclerViewseries.setAdapter(new SeriesAdapter(this, seriesArrayList));

    }

    private void assignView() {

        recyclerViewseries = (RecyclerView)findViewById(R.id.recyclerview);

    }

}
