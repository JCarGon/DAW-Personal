package clases;

public class Lavadora extends Electrodomestico{
    private double precio;
    private boolean aguaCaliente;

    public Lavadora(String marca, double potencia){
        super("Lavadora", marca, potencia);
        this.aguaCaliente = false;
    }

    public Lavadora(String marca, double potencia, double precio, boolean aguaCaliente){
        super("Lavadora", marca, potencia);
        this.precio = precio;
        this.aguaCaliente = aguaCaliente;
    }

    public void setPrecio(double precio){
        this.precio = precio;
    }

    public double getPrecio(){
        return this.precio;
    }

    public void setAguaCaliente(boolean aguaCaliente){
        this.aguaCaliente = aguaCaliente;
    }

    public boolean getAguaCaliente(){
        return this.aguaCaliente;
    }

    @Override
    public double getConsumo(int horas){
        double consumo;
        if(!this.aguaCaliente){
            consumo = super.getConsumo(horas);
        }else{
            consumo = super.getConsumo(horas) + (super.getPotencia()*0.2);
        }
        return consumo;
    }

    @Override
    public String toString(){
        return super.toString()+
        "\nPrecio:  "+this.precio+" euros"+
        "\nAgua Caliente: "+this.aguaCaliente;
    }
}