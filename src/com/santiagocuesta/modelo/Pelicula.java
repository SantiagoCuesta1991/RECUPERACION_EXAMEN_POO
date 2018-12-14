package com.santiagocuesta.modelo;

import java.util.ArrayList;
import java.util.Date;

public class Pelicula extends Grabacion implements Interface {
    private int id;
    private int timeViewed;
    public Pelicula(String title, String genre, String creator, int duration, short year) {
        super(title, genre, creator, duration);
        setYear(year);
    } 
    public int getId() {
        return id;
    } 
    public int getTimeViewed() {
        return timeViewed;
    }
    public void setTimeViewed(int timeViewed) {
        this.timeViewed = timeViewed;
    }
    @Override
    public String toString() { 
        return  "\n :: PELICULA ::" + 
                    "\n Title: " + getTitle() +
                    "\n Genero: " + getGenre() + 
                    "\n Year: " + getYear() + 
                    "\n Creator: " + getCreator() +
                    "\n Duration: " + getDuration();
    }
    @Override
    public Date startToSee(Date dateI) {
        return dateI;
    }
    @Override
    public void stopToSee(Date dateI, Date dateF) {
        if (dateF.getTime() > dateI.getTime()) {
                setTimeViewed((int)(dateF.getTime() - dateI.getTime()));
        }else {
                setTimeViewed(0);
        } 
    }

    public static ArrayList<Pelicula> makeMoviesList() {
        ArrayList<Pelicula> movies = new ArrayList();
        for (int i = 1; i <= 5; i++) {
            movies.add(new Pelicula("Movie " + i, "Genero " + i, "Creador " + i, 120+i, (short)(2017+i)));
        }
    return movies;
    }
}







