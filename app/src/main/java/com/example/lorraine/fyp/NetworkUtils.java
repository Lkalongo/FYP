/*
package com.example.lorraine.fyp;

import android.net.Uri;
import android.nfc.Tag;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import static android.content.ContentValues.TAG;

public class NetworkUtils
{
    private static final String LOG_TAG = NetworkUtils.class.getSimpleName();
    //Base URL for API
    private final static String OMDB_BASE_URL = "http://www.omdbapi.com/?s=";
    private final static String QUERY_PARAM = "q";
    private final static String API_KEY = "822594fa";
    private final static String PARAM_API_KEY = "apikey=";
   // String queryString = null;



    public static String getFilmInfo (String queryString)
    {
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String filmJSONString = null;
        //String queryString = null;
       // return filmJSONString;


        try
        {
           */
/* Uri builtUri = Uri.parse(OMDB_BASE_URL).buildUpon()
                    // .appendQueryParameter(PARAM_API_KEY)
                    .appendQueryParameter(queryString, PARAM_API_KEY)

                    .build();*//*


            Uri builtUri = Uri.parse(OMDB_BASE_URL).buildUpon()
                    .appendQueryParameter(QUERY_PARAM, queryString)
                    .appendQueryParameter(API_KEY, PARAM_API_KEY)
                    .build();

           // Log.i(LOG_TAG, "build Uri" +builtUri);
            Log.i(LOG_TAG,"Build uri" + queryString);

            URL requestURL = new URL(builtUri.toString());

            urlConnection = (HttpURLConnection) requestURL.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            //used to read response using inputStream and a StringBuffer then convert to a String
            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();
            if(inputStream == null)
            {
                return null;
            }
            reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while((line = reader.readLine()) !=null)
            {
                buffer.append(line + "\n");
            }
            if(buffer.length() == 0)
            {
                //stream empty so do not parse
                return null;
            }
            filmJSONString = buffer.toString();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return null;
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
            //Log.i(LOG_TAG, filmJSONString); //HERE
            return filmJSONString;
        }



    }


   */
/* private final static String API_KEY = "822594fa";
    private final static String PARAM_API_KEY = "apikey" ;

    public static URL buildUrlForOmdb()
    {
        Uri builtUri = Uri.parse(OMDB_BASE_URL).buildUpon()
            .appendQueryParameter(PARAM_API_KEY, API_KEY)
                //.appendQueryParameter(scanner string here)
                .build();

        URL url = null;
        try
        {
            url = new URL(builtUri.toString());

        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        Log.i(TAG, "buildUrlForOmdb: url:"+ url);
        return url;
    }

    public static String getResponseFromHttpUrl(URL url) throws IOException
    {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try
        {
            InputStream in =  urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if(hasInput)
            {
                return scanner.next();
            }
            else
            {
                return null;
            }

        }
        finally
        {
            urlConnection.disconnect();
        }
    }*//*

}
*/
