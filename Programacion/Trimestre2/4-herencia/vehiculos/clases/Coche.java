package clases;

public class Coche extends Motorizado {
    
    public Coche(String marca, int velocidadMaxima, int consumo, int capacidadMaxima){
        super(marca, 4, velocidadMaxima, consumo, capacidadMaxima);
    }

    public Coche(String marca){
        super(marca, 4, 220, 6, 70);
    }

    @Override
    public String toString(){
        return "[Coche]: "+super.getInfo();
    }
}