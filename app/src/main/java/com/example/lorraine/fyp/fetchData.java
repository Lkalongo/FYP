
package com.example.lorraine.fyp;

import android.os.AsyncTask;
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

public class fetchData extends AsyncTask<String, Void, String>
{
    private TextView nYearText;
    private TextView nTypeText;

    public fetchData (TextView nYearText, TextView nTypeText)
    {
        this.nYearText = nYearText;
        this.nTypeText = nTypeText;
    }

    //JSON file - used to hold the data from JSON
    /*String data = "";
    String dataParsed = "";
    String singleParsed = "";
    String filmTitle = "avengers";*/

    //background thread
    @Override
    protected String doInBackground(String... strings)
    {
        /*try {
            //most likely will have to change to append and build URI - then parse
            URL url = new URL("http://www.omdbapi.com/?s="+ filmTitle +"&apikey=822594fa");
            //"http://www.omdbapi.com/apikey=822594fa"



            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            //read data from input stream
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            //Another option - pick which one is better
            //StringBuffer buffer = new StringBuffer();


            //read line and assign to line
            String line = "";
            while (line != null) {
                line = bufferedReader.readLine();
                //whole JSON file in dataj
                data = data + line;
            }
        }
        //take note of
        catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;*/
        return NetworkUtils.getFilmInfo(strings[0]);
    }

    //UI thread
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        //searchActivity.data.setText(this.data);
    }


   /* public static String getResponseFromHttpUrl(URL url) throws IOException {
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
    }*/
}
