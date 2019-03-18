package com.example.lorraine.fyp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class watching extends AppCompatActivity
{

    private Button watchlist;
    private Button finished;
    private Button watching;
    private Button settings;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watching);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        watchlist= (Button) findViewById(R.id.watchlist);
        watchlist.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                openwatchlist();
            }
        });

        finished= (Button) findViewById(R.id.finished);
        finished.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                openfinished();
            }
        });

        watching= (Button) findViewById(R.id.watching);
        watching.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                openwatching();
            }
        });

        settings= (Button) findViewById(R.id.settings);
        settings.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                opensettings();
            }
        });

    }

    public void openwatchlist()
    {
        Intent intent = new Intent(this, watchlist.class);
        startActivity(intent);
    }

    public void openfinished()
    {
        Intent intent = new Intent(this, finished.class);
        startActivity(intent);
    }

    public void openwatching()
    {
        Intent intent = new Intent(this, watching.class);
        startActivity(intent);
    }

    public void opensettings()
    {
        Intent intent = new Intent(this, settings.class);
        startActivity(intent);
    }
}

