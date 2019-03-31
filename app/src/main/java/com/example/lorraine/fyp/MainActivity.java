package com.example.lorraine.fyp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.net.URL;

public class MainActivity extends AppCompatActivity
{
    private static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate (Bundle savedInstancesState)
    {
        super.onCreate(savedInstancesState);
        setContentView(R.layout.activity_main);

        URL omdbUrl = NetworkUtils.buildUrlForOmdb();
        Log.i(TAG, "onCreate: omdbUrl:" + film Url);
    }
}
