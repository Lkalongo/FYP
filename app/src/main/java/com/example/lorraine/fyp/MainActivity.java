package com.example.lorraine.fyp;


import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity
{
    private static final String KEY_TITLE = "Title: ";
    private static final String KEY_YEAR = "Year: ";
    private static final String KEY_TYPE = "Type: ";
    private static final String KEY_POSTER = "Poster: ";
    private static final String KEY_DATA = "data ";
    private FilmsAdapter adapterF;
    private ListView lVFilms;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //exectuting - keep regardless
       // new FetchFilm().execute();


        //bottom navigation - go in a its own class
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_watchlist:
                        Toast.makeText(MainActivity.this, "Watchlist", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, watchlist.class);
                        startActivity(intent);
                        break;
                    case R.id.action_watching:
                        Toast.makeText(MainActivity.this, "Watching", Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(MainActivity.this, watching.class);
                        startActivity(intent1);
                        break;
                    case R.id.action_finished:
                        Toast.makeText(MainActivity.this, "Finished", Toast.LENGTH_SHORT).show();
                        Intent intent2 = new Intent(MainActivity.this, finished.class);
                        startActivity(intent2);
                        break;
                    case R.id.action_mainactivity:
                        Toast.makeText(MainActivity.this, "Finished", Toast.LENGTH_SHORT).show();
                        Intent intent3 = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(intent3);
                        break;
                }
                return false;
            }
        });
    }

   /* private class FetchFilm extends AsyncTask<String, String, String> //String, Void, String
    {
        private final String LOG_TAG = com.example.lorraine.fyp.FetchFilm.class.getSimpleName();
        //String filmJSONString = null;

        ProgressDialog pdLoading = new ProgressDialog(MainActivity.this);

        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();

            //this method will be running on UI thread
            pdLoading.setMessage("\tLoading...");
            pdLoading.setCancelable(false);
            pdLoading.show();
        }



        @Override
        protected String doInBackground(String... params)
        {
            final String LOG_TAG = com.example.lorraine.fyp.FetchFilm.class.getSimpleName();
            //search string
            String queryString = params[0];

            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;
            String filmJSONString = null;

            try {
                final String OMDB_BASE_URL = "http://www.omdbapi.com/?";
                final String QUERY_PARAM = "s";
                final String API_KEY = "822594fa";
                final String PARAM_API_KEY = "apikey";

                //building uri
                Uri builtUri = Uri.parse(OMDB_BASE_URL).buildUpon()
                        .appendQueryParameter(QUERY_PARAM, queryString)
                        .appendQueryParameter(PARAM_API_KEY, API_KEY)
                        .build();

                Log.i(LOG_TAG, "build uri: " + builtUri);

                URL requestURL = new URL(builtUri.toString());

                urlConnection = (HttpURLConnection) requestURL.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                InputStream inputStream = urlConnection.getInputStream();
                StringBuilder builder = new StringBuilder();
                reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while ((line = reader.readLine()) != null) {
                    builder.append(line + "\n");
                }
                if (builder.length() == 0) {
                    return null;
                }
                filmJSONString = builder.toString();
                Log.i(LOG_TAG, "here11");


                //return the list
                //return filmJSONString;

            }
            catch (IOException e)
            {
                e.printStackTrace();

            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return filmJSONString;
        }

        //@params

        @Override
        protected void onPostExecute(String s)
        {
            //super.onPostExecute(s);

            // watching.filmJSONString.setText(this.filmJSONString);
            // ListView listView = (ListView)findViewById(R.id.filmList);
            List<Film> filmList = new ArrayList<>();
            try
            {
                //filmJSONString = filmJSONString.substring(filmJSONString.indexOf("["));
                s = s.substring(s.indexOf("["));

                JSONArray jsonA = new JSONArray(s);
                //List filmList = new ArrayList<>();
                // List<Film> filmList = new ArrayList<>();
                Log.i(LOG_TAG, "here2" + s);

                //gets indiviual films
                for (int i = 0; i < jsonA.length(); i++)
                {
                    JSONObject data = jsonA.getJSONObject(i);
                    Film flmDetails = new Film();

                    Log.i(LOG_TAG, "here22" + data);
                    Log.i(LOG_TAG, "here3" + jsonA);

                    flmDetails.setTitle(data.getString(KEY_TITLE));
                    flmDetails.setYear(data.getString(KEY_YEAR));
                    flmDetails.setType(data.getString(KEY_TYPE));
                    flmDetails.setPoster(data.getString(KEY_POSTER));
                    filmList.add(flmDetails);
                }
                //lvFilms = (ListView)findViewById(R.id.list_film);
                adapterF = new FilmsAdapter(filmList, MainActivity.this);
               // lvFilms.setAdapter(adapterF);
                //for recylcer view and showing items in vertical or horizontal scrolling list
                //lVFilms.setLayoutManger(new LinearLayoutManager(MainActivity.this));
            }
            catch (JSONException e)
            {
                e.printStackTrace();
            }

        }
    }*/
}

