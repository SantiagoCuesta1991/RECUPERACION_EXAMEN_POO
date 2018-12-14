package com.santiagocuesta.modelo;

import java.util.ArrayList;

public class Serie extends Grabacion {
	private int id;
	private int sessionQuantity;
	private ArrayList<Capitulo> chapters;
	public Serie(String title, String genre, String creator, int duration, int sessionQuantity) {
            super(title, genre, creator, duration); 
            this.sessionQuantity = sessionQuantity;
	} 
	public int getId() {
		return id;
	} 
	public int getSessionQuantity() {
		return sessionQuantity;
	} 
	public void setSessionQuantity(int sessionQuantity) {
		this.sessionQuantity = sessionQuantity;
	} 
	public ArrayList<Capitulo> getChapters() {
		return chapters;
	} 
	public void setChapters(ArrayList<Capitulo> chapters) {
		this.chapters = chapters;
	} 
	@Override
	public String toString() { 
            return  "\n :: SERIE ::" + 
                    "\n Title: " + getTitle() +
                    "\n Genero: " + getGenre() + 
                    "\n Year: " + getYear() + 
                    "\n Creator: " + getCreator() +
                    "\n Duration: " + getDuration();
	}
	public static ArrayList<Serie> makeSeriesList() {
            ArrayList<Serie> series = new ArrayList();
            for (int i = 1; i <= 5; i++) {
                Serie serie = new Serie("Serie "+i, "genero "+i, "creador "+i, 1200, 5);
                serie.setChapters(Capitulo.makeChaptersList(serie));
                series.add(serie);
            }
        return series;
	}
}
