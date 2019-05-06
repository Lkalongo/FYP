
package com.example.lorraine.fyp;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

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

public class FetchFilm extends AsyncTask<String, Void, String>
{
    String data = "";
    ArrayList<String> filmArrayList = new ArrayList<String>();

    private static final String LOG_TAG = FetchFilm.class.getSimpleName();

    @Override
    protected String doInBackground(String ...params)
    {
        //search string
        String queryString = params[0];


        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;

        //contains JSON response as string
       String filmJSONString = "";

        try
        {
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

            //for converting inputstream to string
            InputStream inputStream = urlConnection.getInputStream();
            StringBuilder builder = new StringBuilder();
            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line = "";
            while((line = reader.readLine())!=null)
            {
                builder.append(line + "\n");
                data = data + line;
            }
            if(builder.length() == 0)
            {
                return null;
            }
            filmJSONString = builder.toString();
            //getFilmDataFromJSON(filmJSONString);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if(urlConnection !=null)
            {
                urlConnection.disconnect();
            }
            if(reader !=null)
            {
                try
                {
                    reader.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        Log.i(LOG_TAG, "doInBackground: filmJSONString: " + filmJSONString);
        return filmJSONString;
    }

    protected void onPostExecute(String s)
            //(Void aVoid)
    {
        super.onPostExecute(s);
        //super.onPostExecute(aVoid);
        watching.data.setText(this.data);

        // Factory method to convert an array of JSON objects into a list of objects
        // Film.fromJson(jsonArray);
    }

    public static ArrayList<Film> fromJson(JSONArray jsonObjects)
    {
        ArrayList<Film> films = new ArrayList<Film>();
        for (int i = 0; i < jsonObjects.length(); i++)
        {
            try
            {
                films.add(new Film(jsonObjects.getJSONObject(i)));
                }
                catch (JSONException e)
                {
                    e.printStackTrace();
                }
            }
            return films;
        }
}