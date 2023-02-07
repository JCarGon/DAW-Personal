package clases;

public class Persona {
    private String nombre;
    private String apellidos;

    public Persona(String nombre, String apellidos){
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }

    public String getApellidos(){
        return this.apellidos;
    }

    @Override
    public String toString(){
        return this.nombre+" "+this.apellidos;
    }
}