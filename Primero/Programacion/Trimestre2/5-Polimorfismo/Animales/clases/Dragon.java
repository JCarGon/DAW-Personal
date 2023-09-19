package clases;

public class Dragon extends Animal implements Volador{
    public Dragon(String nombre){
        super(nombre);
    }

    @Override
    public void saludar(){
        System.out.println("Hola soy un dragón GRRRAW.");
    }

    @Override
    public void gritar(){
        System.out.println(this.getClass().getName()+": AAAAAAAAAAAH");
    }

    public void volar(){
        System.out.println("Estoy volando");
    }

    @Override
    public String toString(){
        return super.toString();
    }
}