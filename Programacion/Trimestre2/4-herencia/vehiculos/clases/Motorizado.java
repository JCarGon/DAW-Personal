package clases;

public class Motorizado extends Vehiculo{
    private int consumo; // L/100Km
    private int capacidadMaxima; // capacidad máxima del depósito - solo get
    private double deposito; // L - get y set -> 1L/Km
    private boolean arrancado;

    public Motorizado(String marca, int numRuedas, int velocidadMaxima, int consumo, int capacidadMaxima, double deposito){
        super(marca, numRuedas, velocidadMaxima);
        this.consumo = consumo;
        this.capacidadMaxima = capacidadMaxima;
        this.deposito = deposito;
        this.arrancado = false;
    }

    public Motorizado(String marca, int numRuedas, int velocidadMaxima, int consumo, int capacidadMaxima){
        super(marca, numRuedas, velocidadMaxima);
        this.consumo = consumo;
        this.capacidadMaxima = capacidadMaxima;
        this.deposito = capacidadMaxima;
    }

    public Motorizado(String marca, int numRuedas){
        super(marca, numRuedas, 180);
        this.consumo = 6;
        this.capacidadMaxima = 50;
        this.deposito = 50;
    }

    public void arrancar(){
        if(arrancado){ //si el coche está arrancado
            System.out.println("El coche ya está arrancado.");
        }else{
            this.arrancado = true;
        }
    }

    public void parar(){
        if(arrancado){ //si el coche está arrancado
            this.arrancado = false;
        }else{
            System.out.println("El coche ya está parado.");
        }
    }

    public void avanzar(int km){
        this.deposito -= (consumo*km)/100;
        System.out.println("He avanzado "+km+" kms.");
    }

    public String getInfo(){
        return super.getInfo()+"\nConsumo: "+this.consumo+
        "\nCapacidad del depósito: "+this.deposito+
        "\nCapacidad máxima del depósito: "+this.capacidadMaxima+
        "\nArrancado: "+this.arrancado;
    }

    @Override
    public String toString(){
        return "[Motorizado]: "+super.getInfo()+getInfo();
        
    }
}