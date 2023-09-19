package clases;

public class Veneno extends Objeto{
    
    public Veneno(){
        super("veneno");
    }

    public void Usar(Jugador jugador){
        jugador.setVidas(jugador.getVidas()-1);
    }
}