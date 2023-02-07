package clases;

public class Informatico extends Persona{
    public Informatico(String nombre, int edad){
        super(nombre, edad);
    }

    @Override
    public int correr(){
        return 2;
    }

    @Override
    public String toString(){
        return super.toString();
    }
}