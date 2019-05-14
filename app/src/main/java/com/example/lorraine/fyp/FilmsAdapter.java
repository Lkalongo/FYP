package com.example.lorraine.fyp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import com.example.lorraine.fyp.Film;

import java.util.ArrayList;
import java.util.List;


public class FilmsAdapter extends ArrayAdapter<Film>
{
   /* private EditText filmInput;
    private TextView title;
    private TextView year;
    private TextView type;
    private TextView poster;*/
    List<Film> filmList;
    Film current;
    int currentPos = 0;
    private LayoutInflater inflater;

    public FilmsAdapter(Context context, int resource ,List<Film> filmList)
    {
        super(context, resource, filmList);
        //this.context = context;
        //inflater = LayoutInflater.from(context);
      //  super(fetchFilm, R.layout.content_main, filmList);
        this.filmList = filmList;
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.content_main, null);
        }
        Film film = filmList.get(position);
        if (film != null) {
            //Text View references
            TextView title = (TextView) v.findViewById(R.id.title);
            TextView year = (TextView) v.findViewById(R.id.year);
            TextView type = (TextView) v.findViewById(R.id.type);
            TextView poster = (TextView) v.findViewById(R.id.poster);


            //Updating the text views
            title.setText(("Title" + film.getTitle()));
            year.setText(("Year" + film.getYear()));
            type.setText(("Type" + film.getType()));
            poster.setText(("Poster" + film.getPoster()));

        }

        return v;
    }

}

