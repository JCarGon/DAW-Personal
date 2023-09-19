package clases;

import java.util.ArrayList;

public class Equipo {
    String nombre;
    ArrayList<Mascota> mascotas;

    public Equipo(String nombre, ArrayList<Mascota> mascotas){
        this.nombre = nombre;
        this.mascotas = mascotas;
    }

    public int mascotasSize(){
        return this.mascotas.size();
    }

    public boolean addMascota(Mascota mascota){
        if(mascotas.size() > 3){
            return mascotas.add(mascota);
        }
        return false;
    }

    public boolean removeMascota(Mascota mascota){
        if(mascotas.size() > 0){
            return mascotas.remove(mascota);
        }
        return false;
    }

    public Mascota getNextMascota(){
        return mascotas.get(0);
    }

    public String getNombre(){
        return nombre;
    }

    public void printMascotas(){
        System.out.println(this.nombre+": "+this.mascotas);
    }
}