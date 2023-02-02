package clases;

public class Moto extends Motorizado {
    
    public Moto(String marca, int velocidadMaxima, int consumo, int capacidadMaxima){
        super(marca, 2, velocidadMaxima, consumo, capacidadMaxima);
    }

    public Moto(String marca){
        super(marca, 2, 120, 3, 15);
    }

    @Override
    public String toString(){
        return "[Moto]: "+super.getInfo();
    }
}