package com.example.lorraine.fyp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;

public class watching extends AppCompatActivity
{
   // public static TextView data;
    private static final String TAG = watching.class.getSimpleName();
    private EditText filmInput;
    private TextView yearT, titleT, posterT;
   // public ListView filmJSONString;

    private List<Film> filmList;
    private ListView flm;
   // ArrayList<Film> filmList;
   // FilmsAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watching);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        flm = (ListView) findViewById(R.id.list_film);

      // filmJSONString = (ListView) findViewById(R.id.list_film);


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
                    case R.id.action_fetch_film:
                        Toast.makeText(watching.this, "Finished", Toast.LENGTH_SHORT).show();
                        Intent intent3 = new Intent(watching.this, FetchFilm.class);
                        startActivity(intent3);
                        break;
                }
                return false;
            }
        });

        /*adapter = new FilmsAdapter(filmList, getApplicationContext());
        adapter = new FilmsAdapter<String>(this, android.R.id.simple_list_item_1, )
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, filmList);
        listView.setAdapter(adapter);*/

    }

    public void searchFilms (View view)
    {
        String queryString = filmInput.getText().toString();
        //returns the string of the film searched for
        Log.i(TAG, "searchFilms:" +queryString);
        if(queryString.length() !=0)
        {
            //new FetchFilm(yearT, titleT, filmInput).execute(queryString);
        }
        else
        {
            Toast.makeText(this, "Please enter a search term.", Toast.LENGTH_SHORT).show();
        }
    }



}

