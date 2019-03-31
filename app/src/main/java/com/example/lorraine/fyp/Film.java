package com.example.lorraine.fyp;

//data modelling class
public class Film
{
    String time;
    String year;

    public void setTime(String time) {
        this.time = time;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setType(String type) {
        this.type = type;
    }

    String type;

    public String getTime ()
    {
        return time;
    }

    public String getYear()
    {
        return year;
    }

    public String getType()
    {
        return type;
    }

}
