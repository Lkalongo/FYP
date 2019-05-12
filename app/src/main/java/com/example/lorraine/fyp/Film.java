package com.example.lorraine.fyp;

//data modelling class
public class Film
{
    String title;
    String year;
    String type;
    String poster;
    String filmInput;

    public String getFilmInput() {
        return filmInput;
    }

    public void setFilmInput(String filmInput) {
        this.filmInput = filmInput;
    }




    public void setPoster(String poster) {
        this.poster = poster;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle ()
    {
        return title;
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