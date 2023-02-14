package clases;

public class Pajaro extends Animal implements Volador{
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

    public void volar(){
        System.out.println("Estoy volando.");
    }

    @Override
    public String toString(){
        return super.toString();
    }
}