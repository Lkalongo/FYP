package com.example.lorraine.fyp;

import android.content.Intent;
import android.os.Bundle;
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

import java.util.ArrayList;
import java.util.Arrays;

public class watching extends AppCompatActivity
{
    private static final String TAG = watching.class.getSimpleName();
   // private Button watchlist, finished,watching, settings;
    private EditText nFilmInput;
    private TextView nYearText, nTypeText;

   ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watching);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nFilmInput = (EditText) findViewById(R.id.filmInput);
        nYearText = (TextView) findViewById(R.id.yearText);
        nTypeText = (TextView) findViewById(R.id.typeText) ;

        //implement listview here
        /*ListView lv = (ListView)findViewById(R.id.emptyListViewFilm); //needs to be empty
        ArrayList<String> arrayFilm = new ArrayList<>();

        //comment from here
        arrayFilm.addAll(Arrays.asList(getResources () .getStringArray(R.array.array_film)));

        adapter = new ArrayAdapter<>
                (
                        watching.this,
                        android.R.layout.simple_list_item_1,
                        arrayFilm
                );
        lv.setAdapter(adapter);*/
        //to here to clear list
        //edit

       /* watchlist = (Button) findViewById(R.id.watchlist);
        watchlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openwatchlist();
            }
        });

        finished = (Button) findViewById(R.id.finished);
        finished.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openfinished();
            }
        });

        watching = (Button) findViewById(R.id.watching);
        watching.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openwatching();
            }
        });

        settings = (Button) findViewById(R.id.settings);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opensettings();
            }
        });*/

    }

   /* public void openwatchlist() {
        Intent intent = new Intent(this, watchlist.class);
        startActivity(intent);
    }

    public void openfinished() {
        Intent intent = new Intent(this, finished.class);
        startActivity(intent);
    }

    public void openwatching() {
        Intent intent = new Intent(this, watching.class);
        startActivity(intent);
    }

    public void opensettings() {
        Intent intent = new Intent(this, settings.class);
        startActivity(intent);
    }*/

    //the actual original search bar
   /*@Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        //menuSearch - is in res-menu. This is the search item
        inflater.inflate(R.menu.menu_search, menu);
        MenuItem item = menu.findItem(R.id.menuSearch);
        SearchView searchView = (SearchView) item.getActionView();

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
    }*/

   public void searchFilms (View view)
   {
       String queryString = nFilmInput.getText().toString();
       Log.i(TAG, "searchFilms:" +queryString);
       new fetchData(nYearText, nTypeText).execute(queryString);
   }
}

