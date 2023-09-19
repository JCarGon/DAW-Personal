package clases;

public class Carta {
    public int valor;
    public String palo;

    public Carta(int valor, String palo){
        this.valor = valor;
        this.palo = palo;
    }

    public Carta(){
        this(7, "picas");//para que pase por el constructor de arriba y cree el objeto por defecto con esos valores
    }

    @Override
    public String toString(){
        return "["+this.valor+", "+this.palo+"]";
    }
}