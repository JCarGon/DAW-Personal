package clases;

public abstract class Objeto {
    private String nombre;
    
    public Objeto(String nombre){
        this.nombre = nombre;
    }

    public void Usar(Jugador jugador){};
}