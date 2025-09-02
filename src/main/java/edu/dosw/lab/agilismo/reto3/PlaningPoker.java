package edu.dosw.lab.agilismo.reto3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;


public class PlaningPoker {
    int numeroDeTareas;
    int numeroDeIntegrantes;
    HashMap<String, Integer> respuestas;
    Scanner scanner;
    private static final Set<Integer> VALORES_VALIDOS = Set.of(1, 2, 3, 5, 8, 13);

    public PlaningPoker(int numeroDeIntegrantes, int numeroDeTareas){
        respuestas = new HashMap<String, Integer>();
        this.numeroDeTareas = numeroDeTareas;
        this.numeroDeIntegrantes = numeroDeIntegrantes;
        this.scanner = new Scanner(System.in);
    }
    public void iniciar() {
        for (int i = 0; i < numeroDeTareas; i++) {
            preliminarVotacion(numeroDeIntegrantes);
        }
        System.out.println("\n===== Resumen de Estimaciones =====");
        respuestas.forEach((tarea, puntaje) ->
                System.out.println("Historia: " + tarea + " → Puntaje final: " + puntaje));
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
                System.out.println("Votos divergentes – Discutan y vuelvan a votar");
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
            boolean comprobacionPuntaje = isVotoCorrecto(puntaje);
            while (!comprobacionPuntaje){
                System.out.println("Puntaje incorrecto");
                System.out.println("Integrante " + i + ", ingrese puntaje 1, 2, 3, 5, 8, 13: ");
                puntaje = scanner.nextInt();
                scanner.nextLine();
                comprobacionPuntaje = isVotoCorrecto(puntaje);
            }
            listaDePuntajes.add(puntaje);
        }
        return listaDePuntajes;
    }

    public boolean verificarPuntaje(ArrayList<Integer> listaDePuntajes){
        return listaDePuntajes.stream().distinct().count() <= 1;
    }

    public boolean isVotoCorrecto(int puntaje){
        return VALORES_VALIDOS.contains(puntaje);
    }

}
