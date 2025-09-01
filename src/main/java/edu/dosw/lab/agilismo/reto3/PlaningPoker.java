package edu.dosw.lab.agilismo.reto3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class PlaningPoker {
    int numeroDeTareas;
    int numeroDeIntegrantes;
    HashMap<String, Integer> respuestas;
    Scanner scanner;

    public PlaningPoker(int numeroDeIntegrantes, int numeroDeTareas){
        respuestas = new HashMap<String, Integer>();
        this.numeroDeTareas = numeroDeTareas;
        this.numeroDeIntegrantes = numeroDeIntegrantes;
        this.scanner = new Scanner(System.in);
        for (int i = 0; i < numeroDeIntegrantes; i++){
            preliminarVotacion(numeroDeIntegrantes);
        }
        System.out.println(respuestas);

    }
    private void preliminarVotacion(int numeroDeIntegrantes){
        int respuestaFinal = 0;
        ArrayList<Integer> listaDePuntajes = new ArrayList<>();

        System.out.println("Ingrese nombre de la tarea: ");
        String tarea = scanner.nextLine();
        boolean respuesta = false;
        while (!respuesta){
            listaDePuntajes = votacion(numeroDeIntegrantes);
            respuesta = verificarPuntaje(listaDePuntajes);
            if (!respuesta) {
                System.out.println("No están de acuerdo, se repite votación");
            }
        }
        if(!listaDePuntajes.isEmpty()){
            respuestaFinal = listaDePuntajes.get(0);
        }

        this.respuestas.put(tarea, respuestaFinal);

    }

    private ArrayList<Integer> votacion(int numeroDeIntegrantes){
        ArrayList<Integer> listaDePuntajes = new ArrayList<>();
        for (int i = 1; i <= numeroDeIntegrantes; i++){
            System.out.println("Integrante " + i + ", ingrese puntaje 1, 2, 3, 5, 8, 13: ");
            int puntaje = scanner.nextInt();
            scanner.nextLine();
            listaDePuntajes.add(puntaje);


        }
        return listaDePuntajes;
    }
    private boolean verificarPuntaje(ArrayList<Integer> listaDePuntajes){
        return listaDePuntajes.stream().distinct().count() <= 1;
    }


}
