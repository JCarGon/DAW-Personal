package clases;

//Clase hija de Persona
public class Anciano extends Persona{
    
    public Anciano(String dni, String nombre, String apellido, int edad){
        super(dni, nombre, apellido, edad);
    }

    @Override
    public void saludar(){
        System.out.println("Hola soy un viejo.");
    }

    public void saludar2(){
        //super.saludar(); -> elige el método saludar de la clase padre
        this.saludar(); //elige el método saludar() con el overrid (esta clase)
    }

    @Override
    public String toString(){
        return super.toString();
    }
}