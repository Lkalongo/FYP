package com.example.lorraine.fyp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class watchlist extends AppCompatActivity
{
    ArrayAdapter<String> adapter;


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
                    case R.id.action_mainactivity:
                        Toast.makeText(watchlist.this, "Search", Toast.LENGTH_SHORT).show();
                        Intent intent3 = new Intent(watchlist.this, MainActivity.class);
                        startActivity(intent3);
                        break;
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


        ListView lv = (ListView) findViewById(R.id.listViewFilm);
        ArrayList<String> arrayFilm = new ArrayList<>();
        arrayFilm.addAll(Arrays.asList(getResources().getStringArray(R.array.array_film)));
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayFilm);
        lv.setAdapter(adapter);
        //lv.setOnItemClickListener(new ArrayView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        MenuItem item = menu.findItem(R.id.menuSearch);
        SearchView searchView = (SearchView)item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener()
        {

            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }

        });

        return super.onCreateOptionsMenu(menu);
    }
}
