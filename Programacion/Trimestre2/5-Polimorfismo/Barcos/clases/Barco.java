package clases;
import java.util.List;

public class Barco {
    private String nombre;
    private String tipo;
    private int capacidadPasajeros;
    private List<Tripulante> tripulantes;

    public Barco(String nombre, String tipo, int capacidadPasajeros, List<Tripulante> tripulantes){
        this.nombre = nombre;
        this.tipo = tipo;
        this.capacidadPasajeros = capacidadPasajeros;
        this.tripulantes = tripulantes;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    public List<Tripulante> getTripulantes() {
        return tripulantes;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setCapacidadPasajeros(int capacidadPasajeros) {
        this.capacidadPasajeros = capacidadPasajeros;
    }

    public void setTripulantes(List<Tripulante> tripulantes) {
        this.tripulantes = tripulantes;
    }
    
    @Override
    public String toString(){
        return this.nombre+" "+this.tipo+" "+this.capacidadPasajeros;
    }
}