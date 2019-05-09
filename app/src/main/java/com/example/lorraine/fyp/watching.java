package com.example.lorraine.fyp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class watching extends AppCompatActivity
{
   // public static TextView data;
    private static final String TAG = watching.class.getSimpleName();
    private EditText nFilmInput;
    private TextView nYearText, nTitleText;

    //ArrayList<Film> filmArrayList = new ArrayList<>();

    //  ListView listView = findViewById(R.id.wListView);
    //listView.setAdapter(adapter);

    ArrayAdapter<String> adapter;
    //new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);

    //ListView listView = (ListView) findViewById(R.id.wListView);
    //  listView.setAdapter(adapter);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watching);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nFilmInput = (EditText) findViewById(R.id.filmInput);
        nYearText = (TextView) findViewById(R.id.yearText);
        nTitleText = (TextView) findViewById(R.id.titleText) ;


        //ListView adapter - 3/5
        ArrayList<Film> arrayOfFilms = new ArrayList<Film>();
        FilmsAdapter fAdapter = new FilmsAdapter(this, arrayOfFilms);
        ArrayAdapter<String>
        //ListView listView = findViewById(R.id.wListView);
        //listView.setAdapter(adapter);

        //data = (TextView)findViewById(R.id.oldListView);


        //bottom navigation - go in a its own class
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
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
        String queryString = nFilmInput.getText().toString();
        Log.i(TAG, "searchFilms:" +queryString);
        if(queryString.length() !=0)
        {
            new FetchFilm(nYearText, nTitleText, nFilmInput).execute(queryString);
        }
        else
        {
            Toast.makeText(this, "Please enter a search term.", Toast.LENGTH_SHORT).show();
        }
    }
}

