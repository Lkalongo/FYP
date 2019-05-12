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
    private static final String KEY_TITLE = "Title: ";
    private static final String KEY_YEAR = "Year: ";
    private static final String KEY_TYPE = "Type: ";
    private static final String KEY_POSTER = "Poster: ";
    private List<Film> dataSet;

    public FilmsAdapter(List<Film> dataSet, Context mContext)
    {
        super(mContext, R.layout.content_watching, dataSet);
        this.dataSet = dataSet;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.content_watching, null);
        }
        Film film = dataSet.get(position);
        if (film != null) {
            //Text View references
            TextView title = (TextView) v.findViewById(R.id.title);
            TextView year = (TextView) v.findViewById(R.id.year);
            TextView type = (TextView) v.findViewById(R.id.type);
            TextView poster = (TextView) v.findViewById(R.id.poster);


            //Updating the text views
            title.setText((KEY_TITLE + film.getTitle()));
            year.setText((KEY_YEAR + film.getYear()));
            type.setText((KEY_TYPE + film.getType()));
            poster.setText((KEY_POSTER + film.getPoster()));

        }

        return v;
    }
}

