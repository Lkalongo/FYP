package com.example.lorraine.fyp;

import android.content.Intent;
import android.os.Bundle;
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
import java.util.ArrayList;
import java.util.Arrays;

public class finished extends AppCompatActivity
{
    private Button watchlist;
    private Button finished;
    private Button watching;
    private Button settings;
    private Button searchA;
    private Button mainActivity;


    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finished);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView lv = (ListView)findViewById(R.id.listViewFilm);
        ArrayList<String> arrayFilm = new ArrayList<>();
        arrayFilm.addAll(Arrays.asList(getResources () .getStringArray(R.array.array_film)));

        adapter = new ArrayAdapter<>
                (
                        finished.this,
                        android.R.layout.simple_list_item_1,
                        arrayFilm
                );
        lv.setAdapter(adapter);

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

        searchA= (Button) findViewById(R.id.searchA);
        searchA.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                opensearchA();
            }
        });

        mainActivity= (Button) findViewById(R.id.mainActivity);
        mainActivity.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                openmainActivity();
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
    public void opensearchA()
    {
        Intent intent = new Intent(this, searchActivity.class);
        startActivity(intent);
    }

    public void openmainActivity()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    /*
    * Section for the search bar functionality
    * inc. listener
    * */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        MenuItem item = menu.findItem(R.id.menuSearch);
        SearchView searchView = (SearchView)item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

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
