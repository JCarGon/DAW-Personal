package clases;
import java.util.ArrayList;
import java.util.Collections;

public class Baraja{
    final int numCartasPorPalo = 13;
    final String[] palos = {"picas", "corazones", "tréboles", "diamantes"};
    ArrayList<Carta> cartas;

    public Baraja(){
        this.resetear();
    }
    
    public Baraja(ArrayList<Carta> cartas){
        this.cartas = cartas;
    }

    public ArrayList<Carta> getCartas(){
        return this.cartas;
    }

    public boolean cartaEsValida(Carta carta){
        if((carta.getValor() <= 0) || (carta.getValor() >= numCartasPorPalo)){
            return false;
        }
        for(int i=0; i<palos.length; i++){
            if(carta.getPalo().equals(palos[i])){
                return true;
            }
        }
        return false;
    }
    
    public void meterCarta(Carta carta){
        if(this.cartas.size() >= numCartasPorPalo*palos.length){
            System.out.println("Error. No se puede introducir la carta porque la baraja está completa.");
        }else{
            this.cartas.add(carta);
        }
    }

    public void resetear(){
        this.cartas = new ArrayList<Carta>();

        for(int i=0; i<palos.length;i++){
            for(int j=0; j<numCartasPorPalo; j++){
                this.cartas.add(new Carta(j+1, palos[i])); //j = número del palo y palos[i] para que sean todas las cartas del mismo palo
            }
        }
    }

    public void barajar(){
        Collections.shuffle(this.cartas);
    }

    @Override
    public String toString(){
        String listaCartas = "";
        for(Carta carta : this.cartas){ //por cada carta de Carta
            listaCartas += carta.getValor()+" de "+carta.getPalo()+"\n";
        }
        return listaCartas;
    }
}