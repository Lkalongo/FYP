/*

package com.example.lorraine.fyp;

import android.os.AsyncTask;
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
    private EditText nFilmInput;
    private TextView nYearText;
    private TextView nTitleText;



    public fetchData(TextView nYearText, TextView nTitleText, EditText nFilmInput)
    {
        this.nYearText = nYearText;
        this.nTitleText = nTitleText;
        this.nFilmInput = nFilmInput;
    }

    //JSON file - used to hold the data from JSON
    */
/*String data = "";
    String dataParsed = "";
    String singleParsed = "";
    String filmTitle = "avengers";*//*


    //background thread
    @Override
    protected String doInBackground(String... params)
    {
        */
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
        return null;*//*

        return NetworkUtils.getFilmInfo(strings[0]); //HERE
    }

    //UI thread
    @Override
    protected void onPostExecute(String s)
    {
        super.onPostExecute(s);
        try {
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
            }
            //searchActivity.data.setText(this.data);
            nTitleText.setText("No Results Found");
            nYearText.setText("");
        }
        catch(Exception e)
        {
                nTitleText.setText("No Results Found");
                nYearText.setText("");
                e.printStackTrace();

        }
    }


   */
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
    }*//*

    }
*/
