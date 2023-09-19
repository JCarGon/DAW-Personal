package clases;

public class Vehiculo implements Ivehiculo{
    public void conducir(){
        System.out.println("Estoy conduciendo.");
    }

    public int repostar(int cantidad){
        return cantidad;
    }

    public int numeroRuedas(int numRuedas){
        return numRuedas;
    };
}