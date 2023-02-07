package clases;

public class Bulldog extends Perro{
    public Bulldog(String nombre){
        super(nombre);
    }

    @Override
    public void saludar(){
        System.out.println("Hola soy un bulldog GUAU GUAU.");
    }

    @Override
    public void gritar(){
        System.out.println(this.getClass().getName()+": AAAAAAAAAAAH");
    }

    @Override
    public String toString(){
        return super.toString();
    }
}