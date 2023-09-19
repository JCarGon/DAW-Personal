package clases;

public abstract class Persona {
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre(){
        return this.nombre;
    }

    public int getEdad(){
        return this.edad;
    }

    public abstract int correr();

    @Override
    public String toString(){
        return this.getClass().getName();
    }
}