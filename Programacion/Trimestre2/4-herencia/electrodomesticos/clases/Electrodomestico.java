package clases;

public class Electrodomestico {
    private String tipo;
    private String marca;
    private double potencia;

    public Electrodomestico(String tipo, String marca, double potencia){
        this.tipo = tipo;
        this.marca = marca;
        this.potencia = potencia;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public String getTipo(){
        return this.tipo;
    }

    public void setMarca(String marca){
        this.marca = marca;
    }

    public String getMarca(){
        return this.marca;
    }

    public void setPotencia(double potencia){
        this.potencia = potencia;
    }

    public double getPotencia(){
        return this.potencia;
    }

    public double getConsumo(int horas){
        double consumo = this.potencia*horas;
        return consumo;
    }

    public double getCosteConsumo(int horas, double costeHora){
        double costeConsumo = getConsumo(horas)*costeHora;
        return costeConsumo;
    }

    @Override
    public String toString(){
        return "Tipo: "+this.tipo+
        "\nMarca: "+this.marca+
        "\nPotencia: "+this.potencia+" kW";
    }
}