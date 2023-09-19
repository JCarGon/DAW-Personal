package clases;

public class Vehiculo {
    private String marca;
    private int numRuedas;
    private int velocidadMaxima;

    public Vehiculo(String marca, int numRuedas, int velocidadMaxima){
        this.marca = marca;
        this.numRuedas = numRuedas;
        this.velocidadMaxima = velocidadMaxima;
    }

    public String getInfo(){
        return "Marca: "+this.marca+
        "\nNúmero de ruedas: "+this.numRuedas+
        "\nVelocidad Máxima: "+this.velocidadMaxima;
    }

    @Override
    public String toString(){
        return "[Vehiculo]: "+getInfo();
    }
}