package com.example.lorraine.fyp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class watchlist extends AppCompatActivity
{

    private Button watchlist;
    private Button finished;
    private Button watching;
    private Button settings;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watchlist);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //bottom navigation - go in a its own class
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                switch (item.getItemId())
                {
                    case R.id.action_watchlist:
                        Toast.makeText(watchlist.this, "Watchlist", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(watchlist.this, watchlist.class);
                        startActivity(intent);
                        break;
                    case R.id.action_watching:
                        Toast.makeText(watchlist.this, "Watching", Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(watchlist.this, watching.class);
                        startActivity(intent1);
                        break;
                    case R.id.action_finished:
                        Toast.makeText(watchlist.this, "Finished", Toast.LENGTH_SHORT).show();
                        Intent intent2 = new Intent(watchlist.this, finished.class);
                        startActivity(intent2);
                        break;
                }
                return false;
            }
        });

    }


}
