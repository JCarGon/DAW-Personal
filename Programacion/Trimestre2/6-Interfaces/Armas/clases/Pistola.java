package clases;

public abstract class Pistola extends Arma implements Distancia, Recargable{
    int balas;
    
    public abstract int getBalas();
    public abstract void setBalas(int balas);
}