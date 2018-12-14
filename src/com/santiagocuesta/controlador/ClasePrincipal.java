package com.santiagocuesta.controlador;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.santiagocuesta.modelo.Libro;
import com.santiagocuesta.modelo.Capitulo;
import com.santiagocuesta.modelo.Revista;
import com.santiagocuesta.modelo.Pelicula;
import com.santiagocuesta.modelo.Serie;
import com.anncode.makereport.Report;
import java.util.Scanner;

public class ClasePrincipal {

    public static void main(String[] args) {		
        menuPrincipal();
    }

    public static void menuPrincipal() {
        int bandera = 0;
        int opcion;
        do {

            System.out.println("BIENVENIDOS MIS CINES SAN LUIS SHOPPING\n\n"+
                    "Seleccione una opción del menú"+
                    "[1]. Peliculas  \n"+
                    "[2]. Series   \n"+
                    "[3]. Libros \n"+
                    "[4]. Revistas \n"+
                    "[5]. Reporte \n"+
                    "[6]. Reporte Diario \n"+
                    "[0]. Salir");

            opcion = ValidarMenu.validarRespuesta(0, 6);

            switch (opcion) {
                case 0:    bandera = 0;             break;
                case 1:    mostrarPeliculas();            break;
                case 2:    mostarSeries();            break;
                case 3:    showBooks();             break;
                case 4:    mostarRevistas();         break;
                case 5:    makeReport();     
                           bandera = 1;             break;
                case 6:    reporte(new Date());
                            bandera = 1;            break;

                default:
                    System.out.println("\nOpción incorrecta....\n");
                    bandera = 1;                    break;
            }
        }while(bandera != 0);
    }
	
    static ArrayList<Pelicula> listPeliculas = Pelicula.makeMoviesList();
    public static void mostrarPeliculas() {
	int bandera = 1, max =100000;
	int opcion;	
        do { 
            System.out.println("\n MOSTRAR PELICULAS \n"); 

            for (int i = 0; i < listPeliculas.size(); i++) { //1. Movie 1
                    System.out.println(i+1 + ". " + listPeliculas.get(i).getTitle() + " Visto: " + listPeliculas.get(i).isViewed());
            }

            System.out.println("\n[0]. Regresar al Menu\n");

            opcion = ValidarMenu.validarRespuesta(0, listPeliculas.size());

            if(opcion == 0) {
                bandera = 0;
                menuPrincipal();
                break;
            }
            if (opcion > 0) {
                    Pelicula movieSelected = listPeliculas.get(opcion-1);
                    movieSelected.setViewed(true);
                    Date dateI = movieSelected.startToSee(new Date());
                    
                    for (int i = 0; i < max; i++) {
                        System.out.print(".");
                    }
                    movieSelected.stopToSee(dateI, new Date());
                    System.out.println("\nViste: " + movieSelected +
                                        "\nPor: " + movieSelected.getTimeViewed() + 
                                        " milisegundos");
            }
        }while(bandera !=0);
    }
    static ArrayList<Serie> listaSeries = Serie.makeSeriesList();
    public static void mostarSeries() {
	int bandera = 1;
	int opcion;
        do {
            System.out.println("\n MOSTRAR SERIES \n"); 
            for (int i = 0; i < listaSeries.size(); i++) { //1. Serie 1
                System.out.println(i+1 + ". " + listaSeries.get(i).getTitle() + " Visto: " + listaSeries.get(i).isViewed());
            }
            System.out.println("\n[0]. Regresar al Menu\n");

            opcion = ValidarMenu.validarRespuesta(0, listaSeries.size());
            if(opcion == 0) {
                    bandera = 0;
                    menuPrincipal();
            }
            if(opcion > 0) {
                mostarCapitulos(listaSeries.get(opcion-1).getChapters());
            }
        }while(bandera !=0);
    }	
    public static void mostarCapitulos(ArrayList<Capitulo> chaptersOfSerieSelected) {
        int bandera = 1, repuesta, max=100000;
        do {
            System.out.println("\n MOSTRAR CAPITULOS \n");
            for (int i = 0; i < chaptersOfSerieSelected.size(); i++) {  
                System.out.println(i+1 + ". " + chaptersOfSerieSelected.get(i).getTitle() + " Visto: " + chaptersOfSerieSelected.get(i).isViewed());
            }

            System.out.println("\n[0]. Regresar al Menu\n"); 

            repuesta = ValidarMenu.validarRespuesta(0, chaptersOfSerieSelected.size());

            if(repuesta == 0) {
                bandera = 0;
            }

            if(repuesta > 0) {
                Capitulo chapterSelected = chaptersOfSerieSelected.get(repuesta-1);
                chapterSelected.setViewed(true);
                Date dateI = chapterSelected.startToSee(new Date());

                for (int i = 0; i < max; i++) {
                        System.out.println(".");
                }
                chapterSelected.stopToSee(dateI, new Date()); 
                System.out.println("\nViste: " + chapterSelected +
                                    "Por: " + chapterSelected.getTimeViewed() + " milisegundos");
            }
        }while(bandera !=0);
    }

    static ArrayList<Libro> listaLibros= Libro.makeBookList();
    public static void showBooks() {
        int bandera = 1;
        int respuesta,max=100000; 

        do {
            System.out.println("\n MOSTRAR LIBROS \n");
            for (int i = 0; i < listaLibros.size(); i++) {  
                System.out.println(i+1 + ". " + listaLibros.get(i).getTitle() + " Leído: " + listaLibros.get(i).isReaded());
            }

            System.out.println("\n[0]. Regresar al Menu\n");
            respuesta = ValidarMenu.validarRespuesta(0, listaLibros.size());

            if(respuesta == 0) {
                bandera = 0;
                menuPrincipal();
            }

                if(respuesta > 0) {
                    Libro bookSelected = listaLibros.get(respuesta-1);
                    bookSelected.setReaded(true);
                    Date dateI = bookSelected.startToSee(new Date());
                    for (int i = 0; i < max; i++) {
                            System.out.println(".");
                    }
                    bookSelected.stopToSee(dateI, new Date());
                    System.out.println();
                    System.out.println("Leíste: " + bookSelected+
                                       "Por: " + bookSelected.getTimeReaded() + " milisegundos");
                }
        }while(bandera !=0);
    }
	
    public static void mostarRevistas() {
    ArrayList<Revista> listaRevistas = Revista.makeMagazineList();
        int bandera = 0,respuesta;
        do {
            System.out.println("\n MOSTRAR REVISTAS \n");
            for (int i = 0; i < listaRevistas.size(); i++) {
                System.out.println(i+1 + ". " + listaRevistas.get(i).getTitle());
            }
            System.out.println("\n[0]. Regresar al Menu\n");
            respuesta = ValidarMenu.validarRespuesta(0, 0);
            if(respuesta == 0) {
                bandera = 0;
                menuPrincipal();
            }
        }while(bandera !=0);
    }
	
    public static void makeReport() {
        Report report = new Report();
        report.setNameFile("reporte");
        report.setExtension("txt");
        report.setTitle(":: VISTOS ::");
        String contentReport = "";
		
        for (Pelicula movie : listPeliculas) {
            if (movie.getIsViewed()) {
                contentReport += movie.toString() + "\n";
            }
        }
        for (Serie serie : listaSeries) {
            ArrayList<Capitulo> chapters = serie.getChapters();
            for (Capitulo chapter : chapters) {
                if (chapter.getIsViewed()) {
                    contentReport += chapter.toString() + "\n";
                }
            }	
        }
        for (Libro book : listaLibros) {
            if (book.getIsReaded()) {
                contentReport += book.toString() + "\n";
            }
        }

        report.setContent(contentReport);
        report.makeReport();
        System.out.println("Reporte Generado");
	}
	
    public static void reporte(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-h-m-s-S");
        String dateString = df.format(date);
        Report report = new Report();

        report.setNameFile("reporte" + dateString);
        report.setExtension("txt");
        report.setTitle("  REPORTE   ");
        
        SimpleDateFormat dfNameDays = new SimpleDateFormat("E, W MMM Y");
        dateString = dfNameDays.format(date);
        String contentReport = "Date: " + dateString + "\n\n\n";
		
        for (Pelicula movie : listPeliculas) {
            if (movie.getIsViewed()) {
                contentReport += movie.toString() + "\n";
            }
        }
        for (Serie serie : listaSeries) {
            ArrayList<Capitulo> chapters = serie.getChapters();
            for (Capitulo chapter : chapters) {
                if (chapter.getIsViewed()) {
                    contentReport += chapter.toString() + "\n";
                }
            }
        }		
        for (Libro book : listaLibros) {
            if (book.getIsReaded()) {
                contentReport += book.toString() + "\n";
            }
        }
        report.setContent(contentReport);
        report.makeReport();
        System.out.println("Reporte Generado"); 
	}	
}