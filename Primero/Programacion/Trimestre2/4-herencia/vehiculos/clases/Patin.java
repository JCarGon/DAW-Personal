package clases;

public class Patin extends Nomotorizado {
    private String tipo;

    public Patin(String marca, int numRuedas, int velocidadMaxima, String tipo){
        super(marca, numRuedas, velocidadMaxima);
        this.tipo = tipo;
    }

    @Override
    public String toString(){
        return "[Patines]: "+super.getInfo()+
        "\nTipo de patín: "+this.tipo;
    }
}