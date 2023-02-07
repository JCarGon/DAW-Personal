package clases;

public class Pajaro extends Animal{
    public Pajaro(String nombre){
        super(nombre);
    }

    @Override
    public void saludar(){
        System.out.println("Hola soy un pajarillo pio pio.");
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