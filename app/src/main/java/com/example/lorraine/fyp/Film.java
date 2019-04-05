package com.example.lorraine.fyp;

//data modelling class
public class Film
{
    String name;
    String year;
    String type;
    String poster;


    public void setPoster(String poster) {
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

}
