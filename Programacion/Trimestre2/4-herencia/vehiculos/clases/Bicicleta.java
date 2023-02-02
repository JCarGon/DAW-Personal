package clases;

public class Bicicleta extends Nomotorizado {
    
    public Bicicleta(String marca, int velocidadMaxima){
        super(marca, 2, velocidadMaxima);
    }

    @Override
    public String toString(){
        return "[Bicicleta]: "+super.getInfo();
    }
}