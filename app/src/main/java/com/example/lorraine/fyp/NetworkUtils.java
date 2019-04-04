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
    private static final String TAG = "NetworkUtils";
    private final static String OMDB_BASE_URL = "http://www.omdbapi.com/?s=Avengers";

    private final static String API_KEY = "822594fa";
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
    }
}
