package clases;

public class Pocion extends Objeto{

    public Pocion(){
        super("pocion");
    }

    public void Usar(Jugador jugador){
        jugador.setVidas(jugador.getVidas()+1);
    }
}