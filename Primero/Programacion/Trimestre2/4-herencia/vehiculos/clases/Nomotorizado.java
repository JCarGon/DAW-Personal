package clases;

public class Nomotorizado extends Vehiculo{
    
    public Nomotorizado(String marca, int numRuedas, int velocidadMaxima){
        super(marca, numRuedas, velocidadMaxima);
    }

    public void avanzar(int km){
        System.out.println("He avanzado "+km+" kms.");
    }

    @Override
    public String toString(){
        return "[No motorizado]: "+super.getInfo();
    }
}