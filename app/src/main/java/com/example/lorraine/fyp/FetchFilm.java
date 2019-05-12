package com.example.lorraine.fyp;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
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

import com.example.lorraine.fyp.FilmsAdapter;
import com.example.lorraine.fyp.Film;

public class FetchFilm extends AsyncTask<String, Void, String>
{
    private static final String KEY_TITLE = "Title: ";
    private static final String KEY_YEAR = "Year: ";
    private static final String KEY_TYPE = "Type: ";
    private static final String KEY_POSTER = "Poster: ";
    private static final String KEY_DATA = "data ";
    private FilmsAdapter adapter;
   // private ListView listView;
   // ArrayList<Film> filmList;
   // FilmsAdapter adapter;

    private static final String LOG_TAG = FetchFilm.class.getSimpleName();
    String filmJSONString = null;



    @Override
    protected String doInBackground(String... params)
        {
        //search string
        String queryString = params[0];

        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        // String filmJSONString = null;

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
        super.onPostExecute(s);

        // watching.filmJSONString.setText(this.filmJSONString);
      // ListView listView = (ListView)findViewById(R.id.list_film);

        try
        {
            filmJSONString = filmJSONString.substring(filmJSONString.indexOf("["));


            JSONArray jsonA = new JSONArray(filmJSONString);
            //List filmList = new ArrayList<>();
            List<Film> filmList = new ArrayList<>();
            Log.i(LOG_TAG, "here2" + filmJSONString);

            //gets indiviual films
            for (int i = 0; i < jsonA.length(); i++)
            {
                Film flmDetails = new Film();
                JSONObject data = jsonA.getJSONObject(i);
                Log.i(LOG_TAG, "here22" + data);
                Log.i(LOG_TAG, "here3" + jsonA);

                flmDetails.setTitle(data.getString(KEY_TITLE));
                flmDetails.setYear(data.getString(KEY_YEAR));
                flmDetails.setType(data.getString(KEY_TYPE));
                flmDetails.setPoster(data.getString(KEY_POSTER));
                filmList.add(flmDetails);
            }
            //adapter = new FilmsAdapter(filmList, getApplicationContext());
            //adapter = new FilmsAdapter<String>(this, android.R.id.simple_list_item_1, )
            //adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, filmList);
           // listView.setAdapter(adapter);
           // return ;
           // Log.i(LOG_TAG,"first: film details" + flmDetails);
            Log.i(LOG_TAG,"first: film list" + filmList);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }

    }
}
