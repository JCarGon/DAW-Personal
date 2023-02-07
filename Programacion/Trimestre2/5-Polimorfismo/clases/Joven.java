package clases;

//Clase hija de Persona
public class Joven extends Persona{
    String pelo;

    public Joven(String dni, String nombre, String apellido, int edad){
        super(dni, nombre, apellido, edad);
        this.pelo = "corto";
    }

    public Joven(String dni, String nombre, String apellido, int edad, String pelo){
        super(dni, nombre, apellido, edad);
        this.pelo = pelo;
    }

    @Override
    public void saludar(){
        System.out.println("Hola soy joven jajaja.");
    }

    public void saltar(){
        System.out.println("Salto.");
    }

    @Override
    public String toString(){
        return super.toString()+
        "\nPelo "+this.pelo;
    }
}