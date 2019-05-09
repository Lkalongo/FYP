package com.example.lorraine.fyp;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
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

public class finished extends AppCompatActivity
{
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finished);

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
                        Toast.makeText(finished.this, "Watchlist", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(finished.this, watchlist.class);
                        startActivity(intent);
                        break;
                    case R.id.action_watching:
                        Toast.makeText(finished.this, "Watching", Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(finished.this, watching.class);
                        startActivity(intent1);
                        break;
                    case R.id.action_finished:
                        Toast.makeText(finished.this, "Finished", Toast.LENGTH_SHORT).show();
                        Intent intent2 = new Intent(finished.this, finished.class);
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



    /*
    * Section for the search bar functionality
    * inc. listener
    * */

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
