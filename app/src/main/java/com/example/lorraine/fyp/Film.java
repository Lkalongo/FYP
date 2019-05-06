package com.example.lorraine.fyp;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

//data modelling class
public class Film
{
    public String name;
    public String year;
    public String type;
    public String poster;

    public Film(JSONObject object)
    {
        try
        {
           this.name = object.getString("name");
           this.year = object.getString("year");
           this.type = object.getString("type");
           this.poster = object.getString("poster");
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
    }

   /*  //first option
   public String name;
   public String year;
   public String type;
   public String poster;

    public Film(String name, String type, String year, String poster)

    {
        this.name = name;
        this.poster = poster;
        this.year = year;
        this.type = type;
    }*/


   /* public void setPoster(String poster) {
        this.poster = poster;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName ()
    {
        return name;
    }

    public String getYear()
    {
        return year;
    }

    public String getType()
    {
        return type;
    }

    public String getPoster() {
        return poster;}
*/
}
