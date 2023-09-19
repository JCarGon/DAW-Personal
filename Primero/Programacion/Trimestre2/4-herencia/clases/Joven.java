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

    public void saludar2(){
        //super.saludar(); -> elige el método saludar de la clase padre
        this.saludar(); //elige el método saludar() con el overrida (esta clase)
    }

    @Override
    public String toString(){
        return super.toString()+
        "\nPelo "+this.pelo;
    }
}