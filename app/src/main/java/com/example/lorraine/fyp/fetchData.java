
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
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import static android.net.wifi.WifiConfiguration.Status.strings;

public class fetchData extends AsyncTask<String, Void, String> //HERE
{

    private static final String LOG_TAG = fetchData.class.getSimpleName();

    //JSON file - used to hold the data from JSON
    String data = "";
    String dataParsed = "";
    String singleParsed = "";

    //background thread
    @Override
    protected String doInBackground(String ...params)
    {
        String queryString = params[0];

        HttpURLConnection urlConnection = null;
        String filmJSONString = null;
        BufferedReader bufferedReader = null;

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


           //HttpURLConnection httpURLConnection = (HttpURLConnection) builtUri.openConnection();
            //InputStream inputStream = httpURLConnection.getInputStream();
            URL requestURL = new URL(builtUri.toString());

            urlConnection = (HttpURLConnection) requestURL.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            InputStream inputStream = urlConnection.getInputStream();
            StringBuilder builder = new StringBuilder();
            //read data from input stream
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            //Another option - pick which one is better
            //StringBuffer buffer = new StringBuffer();

            String line;
            while((line = bufferedReader.readLine())!=null)
            {
                builder.append(line + "\n");
            }
            if(builder.length() == 0)
            {
                return null;
            }
            filmJSONString = builder.toString();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
       /* finally
        {
            if(urlConnection !=null)
            {
                urlConnection.disconnect();
            }
            if(bufferedReader !=null)
            {
                try
                {
                    BufferedReader.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }*/
        Log.i(LOG_TAG, "doInBackground: filmJSONString: " + filmJSONString);
        return null;
       // return filmJSONString;

           /* //read line and assign to line
            String line = "";
            while ((line = bufferedReader.readLine()) !=null)
            {
                builder.append(line + "\n");
                //whole JSON file in dataj
                data = data + line;
            }
        }
        //take note of
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;

       // return NetworkUtils.getFilmInfo(strings[0]); //HERE*/
    }

    //UI thread
    @Override
    protected void onPostExecute(String filmJSONString)
    {
        super.onPostExecute(filmJSONString);
        /*try {
            //for parsing and formatting data
            JSONObject jsonObject = new JSONObject(s);
            JSONArray itemsArray = jsonObject.getJSONArray("items");

            for (int i = 0; i < itemsArray.length(); i++)
            {
                JSONObject film = itemsArray.getJSONObject(i);
                String title = null;
                String year = null;

                //needed??
                JSONObject filmInfo = film.getJSONObject("filmInfo");

                try
                {
                    title = filmInfo.getString("title");
                    year = filmInfo.getString("year");

                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }

                //if both a title and year exist update the TextViews and return
                if (title != null && year != null)
                {
                    nTitleText.setText(title);
                    nYearText.setText(year);
                }
            }*/
            searchActivity.data.setText(this.data);
           /* nTitleText.setText("No Results Found");
            nYearText.setText("");
        }
        catch(Exception e)
        {
                nTitleText.setText("No Results Found");
                nYearText.setText("");
                e.printStackTrace();

        }*/
    }


/*
 public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }
*/

}
