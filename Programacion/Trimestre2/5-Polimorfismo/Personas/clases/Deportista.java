package clases;

public class Deportista extends Persona{
    public Deportista(String nombre, int edad){
        super(nombre, edad);
    }

    @Override
    public int correr(){
        return 7;
    }

    @Override
    public String toString(){
        return super.toString();
    }
}