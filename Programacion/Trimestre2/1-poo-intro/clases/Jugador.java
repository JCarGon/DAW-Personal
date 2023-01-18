package clases;

import java.time.LocalDate;

public class Jugador{
    public String nombre;
    public int dorsal;
    public String nombreEquipo;
    public int nTarjetasAmarillas;
    public int nTarjetasRojas;
    public String nacionalidad;
    public LocalDate fechaNacimiento;
    public String posicion;

    public Jugador(String nombre, LocalDate fechaNacimiento, String nacionalidad, String posicion, int dorsal, String nombreEquipo){
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.posicion = posicion;
        this.dorsal = dorsal;
        this.nombreEquipo = nombreEquipo;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setDorsal(int dorsal){
        this.dorsal = dorsal;
    }

    public void setnombreEquipo(String nombreEquipo){
        this.nombreEquipo = nombreEquipo;
    }

    public void setNTarjetasAmarillas(int nTarjetasAmarillas){
        this.nTarjetasAmarillas = nTarjetasAmarillas;
    }

    public void setNTarjetasRojas(int nTarjetasRojas){
        this.nTarjetasRojas = nTarjetasRojas;
    }

    public void setNacionalidad(String nacionalidad){
        this.nacionalidad = nacionalidad;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento){
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setPosicion(String posicion){
        this.posicion = posicion;
    }

    public String getNombre(){
        return nombre;
    }

    public int getDorsal(){
        return dorsal;
    }

    public String getnombreEquipo(){
        return nombreEquipo;
    }

    public int getNTarjetasAmarillas(){
        return nTarjetasAmarillas;
    }

    public int getNTarjetasRojas(){
        return nTarjetasRojas;
    }

    public String getNacionalidad(){
        return nacionalidad;
    }

    public LocalDate getFechaNacimiento(){
        return fechaNacimiento;
    }

    public String getPosicion(){
        return posicion;
    }

    @Override
    public String toString(){
        return "El jugador "+nombre+" juega en el equipo "+nombreEquipo+".";
    }
}