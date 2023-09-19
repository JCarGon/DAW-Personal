package clases;

public class Camion extends Motorizado {
    
    public Camion(String marca, int numRuedas, int velocidadMaxima, int consumo, int capacidadMaxima){
        super(marca, numRuedas, velocidadMaxima, consumo, capacidadMaxima);
    }

    public Camion(String marca){
        super(marca, 8, 150, 12, 200);
    }

    @Override
    public String toString(){
        return "[Camión]: "+super.getInfo();
    }
}