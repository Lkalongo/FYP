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

import java.util.ArrayList;


public class FilmsAdapter extends ArrayAdapter<Film>
{
    private ArrayList<Film> filmList;
    private LayoutInflater vi;
    private int Resource;
    private ViewHolder holder;
    View view;
    //ArrayList<Film> cp=0
    int gen=0;
    private static String LOG_TAG = FilmsAdapter.class.getSimpleName();

    FilmsAdapter(Context context,int resource, ArrayList<Film> objects)
    {
        super(context, resource, objects);
        vi = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Resource = resource;
        this.filmList = objects;
        Log.i(LOG_TAG,"film list and objects" + filmList);
    }

    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent)
    {
        View f = convertView;
        //Film film = getItem(position);

        if (f == null) {
            holder = new ViewHolder();
            f = vi.inflate(Resource, null);
            Log.i(LOG_TAG, "here95" + f);
            // convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_watching, parent, false);

            holder.filmInput = (EditText) convertView.findViewById(R.id.filmInput);
            holder.titleT = (TextView) convertView.findViewById(R.id.title);
            holder.yearT = (TextView) convertView.findViewById(R.id.year);
            holder.posterT = (TextView) convertView.findViewById(R.id.poster);
            f.setTag(holder);

        }
        else
            {
            holder = (ViewHolder) view.getTag();
        }

        holder.filmInput.setText(filmList.get(position).getFilmInput());
        holder.titleT.setText(filmList.get(position).getTitle());
        holder.yearT.setText(filmList.get(position).getYear());
        holder.posterT.setText(filmList.get(position).getPoster());

        return f;
        //Log.i(LOG_TAG, "film adapter" + f);
    }


    private static class ViewHolder
    {
        EditText filmInput;
        TextView titleT;
        TextView yearT;
        TextView posterT;
    }
}

