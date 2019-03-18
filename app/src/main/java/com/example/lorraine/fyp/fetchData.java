package com.example.lorraine.fyp;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class fetchData extends AsyncTask<Void, Void, Void>
{
    //JSON file - used to hold the data from JSON
    String data = "";
    String dataParsed = "";
    String singleParsed = "";
    //background thread
    @Override
    protected Void doInBackground(Void... voids)
    {
        try
        {
            //data is collected from this URL only - needs to be explanadble
            URL url = new URL("http://www.omdbapi.com/?s=avengers&apikey=822594fa");

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            //read data from input stream
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            //read line and assign to line
            String line ="";
            while(line != null)
            {
                line = bufferedReader.readLine();
                //whole JSON file in dataj
                data = data + line;
            }
        }
        //take note of
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }



    //UI thread
    @Override
    protected void onPostExecute(Void aVoid)
    {
        super.onPostExecute(aVoid);

        searchActivity.data.setText(this.data);
    }
}
