package com.example.lorraine.fyp;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class FetchFilm extends AsyncTask<String, Void, String>
{
    private EditText nFilmInput;
    private TextView nTitleText;
    private TextView nYearText;

    private static final String LOG_TAG = FetchFilm.class.getSimpleName();

    public FetchFilm(TextView yearText, TextView titleText, EditText filmInput)
    {
        this.nFilmInput = filmInput;
        this.nTitleText = titleText;
        this.nYearText = yearText;
    }


    @Override
    protected String doInBackground(String ...params)
    {
        //search string
        String queryString = params[0];

        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String filmJSONString = null;

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

            InputStream inputStream = urlConnection.getInputStream();
            StringBuilder builder = new StringBuilder();
            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while((line = reader.readLine())!=null)
            {
                builder.append(line + "\n");
            }
            if(builder.length() == 0)
            {
                return null;
            }
            filmJSONString = builder.toString();
            Log.i(LOG_TAG, "here11");
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
        return filmJSONString;
    }

    //@params

    @Override
    protected void onPostExecute(String s)
    {
        super.onPostExecute(s);
        //searchActivity.data.setText(this.data);
        try
        {
            s = s.substring(s.indexOf("["));

           JSONObject object = new JSONObject(s);
           JSONArray jsonA = object.getJSONArray("Film");
           Log.i(LOG_TAG, "here2" + s);

            //gets indiviual films
            for (int i = 0; i < jsonA.length(); i++)
            {
                JSONObject data = jsonA.getJSONObject(i);
               // Log.i(LOG_TAG, "here22" + data);
               // Log.i(LOG_TAG, "here3" + jsonA);

                Sti

                /*Film films = new Film();
                //get json object values from json array
                films.setTitle(data.getString("Title"));
                films.setYear(data.getString("Year"));
                films.setType(data.getString("Type"));
                films.setPoster(data.getString("Poster"));*/



            }
            /*while(j<itemsArray.length() || (year == null && title == null))
            {
                JSONObject film = itemsArray.getJSONObject(i);
                JSONObject filmType = film.getJSONObject("filmType");

                try
                {
                    title = filmType.getString("title");
                    year = filmType.getString("year");
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                //to move onto next item
                i++;
            }
            if(title !=null && year !=null)
            {
                nTitleText.setText(title);
                nYearText.setText(year);
                nFilmInput.setText("");
            }
            else
            {
                nTitleText.setText(R.string.no_results);
                nYearText.setText("");
            }
            */
        }
        catch (Exception e)
        {
           // nTitleText.setText(R.string.no_results);
           // nYearText.setText("");
            e.printStackTrace();
        }

        //super.onPostExecute(s);

    }
}