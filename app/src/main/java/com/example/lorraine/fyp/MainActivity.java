package com.example.lorraine.fyp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.net.URL;
import java.time.Year;
import java.util.ArrayList;
import java.util.Iterator;


public class MainActivity extends AppCompatActivity
{
    private static final String TAG = MainActivity.class.getSimpleName();
    private ArrayList<Film> filmArrayList = new ArrayList<>();
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView =findViewById(R.id.idListView);

        URL omdbUrl = NetworkUtils.buildUrlForOmdb();
        new FetchOmdbDetails().execute(omdbUrl);
        Log.i(TAG, "onCreate: omdbUrl:" + omdbUrl);
    }

    private class FetchOmdbDetails extends AsyncTask<URL, Void, String>
    {
        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(URL... urls)
        {
            URL omdbURL = urls[0];
            String omdbSearchResults = null;

            try
            {
                omdbSearchResults = NetworkUtils.getResponseFromHttpUrl(omdbURL);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

            Log.i(TAG, "doInBackground: omdbSearchResults: " + omdbSearchResults);
            return omdbSearchResults;
        }

        @Override
        protected void onPostExecute(String omdbSearchResults)
        {
            if(omdbSearchResults != null && !omdbSearchResults.equals(""))
            {
                filmArrayList = parseJSON(omdbSearchResults);

                //for the purpose of testing
               /* Iterator itr = filmArrayList.iterator();
                while(itr.hasNext())
                {
                    Film filmInIterator = (Film) itr.next();
                    Log.i(TAG, "onPostExecute: name:" + filmInIterator.getName()+
                                    "year:" + filmInIterator.getYear() +
                                    "type:" + filmInIterator.getName() +
                                    "poster:" + filmInIterator.getPoster());
                }*/

            }

            super.onPostExecute(omdbSearchResults);
        }
    }

    private ArrayList<Film> parseJSON(String omdbSearchResults)
    {
        if(filmArrayList !=null)
        {
            filmArrayList.clear();
        }
        if(omdbSearchResults !=null)
        {
           try
           {
               JSONObject rootObject = new JSONObject(omdbSearchResults);
               JSONArray results = rootObject.getJSONArray("FilmDetails");

               for(int i = 0; i<results.length(); i++)
               {
                   Film film = new Film();

                   JSONObject resultsObj = results.getJSONObject(i);

                   //For name of the film
                   String name = resultsObj.getString("name");
                   film.setName(name);

                   Log.i(TAG, "parseJSON: name: " + name);

                    //For year film was released
                   String year = resultsObj.getString("year");
                   film.setYear(year);

                   Log.i(TAG, "parseJSON: year: " + year);

                   //For type of film i.e. movie/short film
                   String type = resultsObj.getString("type");
                   film.setType(type);

                   Log.i(TAG, "parseJSON: type: " + type);

                   //For poster URL
                   String poster = resultsObj.getString("poster");
                   film.setPoster(poster);

                  /* Log.i(TAG, "parseJSON: name:" + name + " "+
                           "year: " + year + "" +
                           "type: " + type);*/

                   filmArrayList.add(film);

               }

               if(filmArrayList !=null)
               {
                   FilmAdapter filmAdapter = new FilmAdapter(this, filmArrayList);
                   listView.setAdapter(filmAdapter);
               }

               return filmArrayList;
           }
           catch (JSONException e)
           {
               e.printStackTrace();
           }
        }
        return null;
    }
}
