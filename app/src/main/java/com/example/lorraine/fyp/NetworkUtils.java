package com.example.lorraine.fyp;//package com.example.lorraine.fyp;

import android.net.Uri;
import android.nfc.Tag;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class NetworkUtils
{
    private static final String TAG = "com.example.lorraine.fyp.NetworkUtils";
    private final static String OMDB_URL = "http://www.omdbapi.com/ ";
           // "?apikey=[yourkey]&";
    private final static String API_KEY = "822594fa";
    private final static String PARAM_API_KEY = "?apikey=[yourkey]&";
    private static URL buildUrlForFilm()
    {
        Uri buiitUri = Uri.parse(OMDB_URL).buildUpon()
            .appendQueryParameter(PARAM_API_KEY, API_KEY)
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
        Log.i(TAG, "buildUrlForFilm: url:"+url);
        return url
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
    }
}
