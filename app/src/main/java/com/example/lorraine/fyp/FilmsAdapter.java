
package com.example.lorraine.fyp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class FilmsAdapter extends ArrayAdapter<Film>
{
    public FilmsAdapter(Context context, ArrayList<Film> films)
    {
        super (context, 0, films);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        Film film = getItem(position);
        if(convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_film, parent, false);
        }
        TextView fName = (TextView) convertView.findViewById(R.id.fName);
        TextView fType = (TextView) convertView.findViewById(R.id.fType);
        TextView fYear = (TextView) convertView.findViewById(R.id.fYear);
        TextView fPoster = (TextView) convertView.findViewById(R.id.fPoster);

        fName.setText(film.name);
        fType.setText(film.type);
        fYear.setText(film.year);
        fPoster.setText(film.poster);

        return convertView;

    }




    /*public FilmAdapter(@NonNull Context context, ArrayList<Film> filmArrayList)
    {
        super(context,0, filmArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        Film film = getItem(position);


        if(convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_items, parent, false);
        }

        //context = convertView.getContext();

        TextView  nameTextView = convertView.findViewById(R.id.fName);
        TextView  yearTextView = convertView.findViewById(R.id.fYear);
        TextView  typeTextView = convertView.findViewById(R.id.fType);
        TextView  posterTextView = convertView.findViewById(R.id.fPoster);

        nameTextView.setText(film.getName());
        yearTextView.setText(film.getYear());
        typeTextView.setText(film.getType());
        posterTextView.setText(film.getPoster());

        return convertView;
    }
*/

}
