package com.santiagocuesta.modelo;

import java.util.ArrayList;
import java.util.Date;

public class Revista extends Publicacion {
    private int id;
    public Revista(String title, Date edititionDate, String editorial) {
        super(title, edititionDate, editorial); 
    }
    public int getId() {
        return id;
    }
    @Override
    public String toString() { 
            String detailMagazine = "\n  REVISTA  " + 
                                "\n Title: " + getTitle() +
                                "\n Editorial: " + getEditorial() + 
                                "\n Edition Date: " + getEdititionDate() +
                                "\n Authors: ";
        for (int i = 0; i < getAuthors().length; i++) {
                detailMagazine += "\t" + getAuthors()[i] + " ";
        }
    return  detailMagazine;
    }
    public static ArrayList<Revista> makeMagazineList() {
        ArrayList<Revista> magazines = new ArrayList();
        String[] authors = new String[3];
        for (int i = 0; i < 3; i++) {
                authors[i] = "author "+i;
        }
        for (int i = 1; i <= 5; i++) {
            magazines.add(new Revista("Magazine " + i, new Date(), "Editorial " + i));
        }
    return magazines;
    }
}
