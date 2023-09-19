package clases;

public class Arco extends Arma implements Recargable, Distancia{
    private int balas;

    public int getBalas(){
        return this.balas;
    }

    public void setBalas(int balas){
        this.balas = balas;
    }
}