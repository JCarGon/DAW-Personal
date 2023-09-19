package clases;

public class Gato extends Animal{
    public Gato(String nombre){
        super(nombre);
    }

    @Override
    public void saludar(){
        System.out.println("Hola soy un gato miau miau.");
    }

    @Override
    public void gritar(){
        System.out.println(this.getClass().getName()+": AAAAAAAAAAAH");
    //this.getClass().getName() -> sirve para identificar la clase a la que pertenece
    }

    @Override
    public String toString(){
        return super.toString();
    }
}