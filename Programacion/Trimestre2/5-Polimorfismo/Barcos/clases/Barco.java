package clases;
import java.util.List;

public class Barco {
    private String nombre;
    private String tipo;
    private int capacidadPasajeros;
    private List<Tripulante> tripulantes;
    private Gps gps;

    public Barco(String nombre, String tipo, int capacidadPasajeros, List<Tripulante> tripulantes, Gps gps){
        this.nombre = nombre;
        this.tipo = tipo;
        this.capacidadPasajeros = capacidadPasajeros;
        this.tripulantes = tripulantes;
        this.gps = gps;
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
    
    public Gps getGps() {
        return gps;
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
    public void setGps(Gps gps) {
        this.gps = gps;
    }
    
    @Override
    public String toString(){
        return "Datos del barco: "+
        "\nNombre: "+this.nombre+
        "\nTipo de barco: "+this.tipo+
        "\nCapacidad de pasajeros: "+this.capacidadPasajeros+
        "\n"+gps.toString();
    }
}