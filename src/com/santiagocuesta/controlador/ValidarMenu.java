/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.santiagocuesta.controlador;

import java.util.Scanner;
public class ValidarMenu {
        public static int validarRespuesta(int minimo, int maximo) {
            Scanner sc = new Scanner(System.in);
            int respuesta;
            
            while(!sc.hasNextInt()) {
                    sc.next();
                    System.out.println("No ingresaste una opción válida \n"+
                                        "Intenta otra vez");
            }
            respuesta = sc.nextInt();
            while(respuesta < minimo || respuesta > maximo) { 
                    System.out.println("No ingresaste una opción válida \n"+
                                        "Intenta otra vez");

                    while(!sc.hasNextInt()) {
                            sc.next();
                            System.out.println("No ingresaste una opción válida \n"+
                                    "Intenta otra vez");
                    }
                respuesta = sc.nextInt();
            }
        return respuesta;
	}
}
