package clases;

public class Persona {
    public String nombre;
    public String dni;
    public int edad;

    //constructor
    public Persona(String nombre, String dni, int edad){
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
    }

    //set
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setDNI(String dni){
        this.dni = dni;
    }
    public void setEdad(int edad){
        this.edad = edad;
    }

    //get
    public String getNombre(){
        return nombre;
    }
    public String getDNI(){
        return dni;
    }
    public int getEdad(){
        return edad;
    }

    public void mostrarDatos(){
        System.out.println("El nombre de la persona es "+nombre+", su DNI es "+dni+" y su edad es "+edad+".");
    }
}