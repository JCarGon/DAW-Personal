package clases;

import java.util.ArrayList;
import java.util.Scanner;

public class Juego {
    ArrayList<Jugador> jugadores;
    ArrayList<Objeto> saco;

    public Juego(){
        this.jugadores = new ArrayList<Jugador>();
        initJugadores();
        mostrarJugadores();
        System.out.println("Que comience la partida.");
        while(jugadores.size()>1){
            Start();
            mostrarJugadores();
        }
        System.out.println("Ganador del juego:\n"+jugadores.get(0).cogerDatos());
    }

    public void Start(){
        System.out.println("Que comience la ronda.");
        for (Jugador j : jugadores) {
            jugarTurno(j);
        }
        jugadores.removeIf(jugador -> jugador.getVidas() == 0); //remueve los jugadores que tengan 0 vidas
    }

    public void jugarTurno(Jugador jugador){
        jugador.UsarObjetoAleatorio();
        // if(jugador.getVidas() == 0){
        //     jugadores.remove(jugador); //FALLO
        // }
    }

    public void initJugadores(){
        Scanner entrada = new Scanner(System.in);
        System.out.print("Introduzca el número de jugadores: ");
        int numjugadores = entrada.nextInt();
        for(int i=0; i<numjugadores; i++){
            System.out.print("Introduce el nombre del jugador: ");
            String nombre = entrada.next();
            this.jugadores.add(new Jugador(nombre));
        }
        entrada.close();
    }

    public void mostrarJugadores(){
        for (int i=0; i<jugadores.size(); i++) {
            if(jugadores.get(i).getVidas() > 0){
                System.out.println(i+1 +") "+ jugadores.get(i).cogerDatos());
            }
        }
    }
}