package com.santiagocuesta.modelo;

import java.util.ArrayList;

public class Capitulo extends Pelicula {
    private int id;
    private int sessionNumber;
    private Serie serie;
    public Capitulo(String title, String genre, String creator, int duration, short year, int sessionNumber, Serie serie) {
            super(title, genre, creator, duration, year); 
            this.setSessionNumber(sessionNumber);
            this.setSerie(serie);
    }
    @Override
    public int getId() { 
            return this.id;
    } 
    public int getSessionNumber() {
            return sessionNumber;
    } 
    public void setSessionNumber(int sessionNumber) {
            this.sessionNumber = sessionNumber;
    } 
    public Serie getSerie() {
            return serie;
    } 
    public void setSerie(Serie serie) {
            this.serie = serie;
    } 
    @Override
    public String toString() { 
            return  "\n  CAPITULO " + 
                            "\n Title: " + getSerie().getTitle() +
                            "\n Title: " + getTitle() +
                            "\n Year: " + getYear() + 
                            "\n Creator: " + getCreator() +
                            "\n Duration: " + getDuration();
    }
    public static ArrayList<Capitulo> makeChaptersList(Serie serie) {
        ArrayList<Capitulo> chapters = new ArrayList();

        for (int i = 1; i <= 5; i++) {
            chapters.add(new Capitulo("Capituo "+i, "genero "+i, "creator" +i, 45, (short)(2017+i), i, serie));
        }
    return chapters;
    }
}
