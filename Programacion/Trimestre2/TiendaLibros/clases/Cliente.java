package clases;

import java.util.ArrayList;

public class Cliente{
    private String nombre;
    private ArrayList<Libro> coleccionLibros;
    private double dinero;

    public Cliente(String nombre, double dinero){
        this.nombre = nombre;
        this.coleccionLibros = new ArrayList<>();
        this.dinero = dinero;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Libro> getColeccionLibros() {
        return coleccionLibros;
    }

    public void setColeccionLibros(ArrayList<Libro> coleccionLibros) {
        this.coleccionLibros = coleccionLibros;
    }

    public double getDinero() {
        return dinero;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }

    public boolean pagarLibro(double numero){
        boolean comprobar = false;
        double cantidadFinal = this.dinero-numero;
        if(cantidadFinal<0){
            System.out.println("No puedes pagar el libro porque no tienes dinero suficiente.");
            return comprobar;
        }else{
            this.dinero = cantidadFinal;
            comprobar = true;
            return comprobar;
        }
    }

    public void addLibro(Libro libro){
        this.coleccionLibros.add(libro);
    }
    
    public int numeroLibros(){
        return this.coleccionLibros.size();
    }

    @Override
    public String toString(){
        return this.nombre+" - "+this.coleccionLibros.size()+" - "+this.dinero;
    }
}