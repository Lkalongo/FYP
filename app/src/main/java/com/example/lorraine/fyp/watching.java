package com.example.lorraine.fyp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class watching extends AppCompatActivity
{
    private static final String LOG_TAG = watching.class.getSimpleName();
    private EditText filmInput;
    private TextView year, title, poster,type;
    private List<Film> filmList;
    private ListView lvFilms;

    FilmsAdapter adapterF;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watching);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        title = (TextView)findViewById(R.id.title);
        year = (TextView)findViewById(R.id.year);
        poster = (TextView)findViewById(R.id.poster);
        type = (TextView)findViewById(R.id.type);

      // filmJSONString = (ListView) findViewById(R.id.list_film);

        //calling film FetchFilm class and the adapter array
       /* adapterF = new FilmsAdapter(this ,0, filmList);
        lvFilms.setAdapter(adapterF);
       // lVFilms.setLayoutManger(new LayoutManager(watching.this));*/

        //bottom navigation - go in a its own class
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.action_mainactivity:
                        Toast.makeText(watching.this, "Search", Toast.LENGTH_SHORT).show();
                        Intent intent3 = new Intent(watching.this, MainActivity.class);
                        startActivity(intent3);
                        break;
                    case R.id.action_watchlist:
                        Toast.makeText(watching.this, "Watchlist", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(watching.this, watchlist.class);
                        startActivity(intent);
                        break;
                    case R.id.action_watching:
                        Toast.makeText(watching.this, "Watching", Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(watching.this, watching.class);
                        startActivity(intent1);
                        break;
                    case R.id.action_finished:
                        Toast.makeText(watching.this, "Finished", Toast.LENGTH_SHORT).show();
                        Intent intent2 = new Intent(watching.this, finished.class);
                        startActivity(intent2);
                        break;

                }
                return false;
            }
        });


    }

    public void searchFilms (View view)
    {
        Log.i(LOG_TAG, "button click sf");
        String queryString = filmInput.getText().toString();
        //returns the string of the film searched for
        Log.i(LOG_TAG, "searchFilms:" +queryString);
        if(queryString.length() !=0)
        {
           //new FetchFilm().execute(queryString);
            new FetchFilm(title, year,  poster).execute(queryString);


            lvFilms = (ListView)findViewById(R.id.list_film);
            adapterF = new FilmsAdapter(this ,android.R.layout.simple_list_item_1, filmList);
            lvFilms.setAdapter(adapterF);

        }
        else
        {
            Toast.makeText(this, "Please enter a search term.", Toast.LENGTH_SHORT).show();
        }
    }



}

