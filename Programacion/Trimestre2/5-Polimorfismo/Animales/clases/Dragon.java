package clases;

public class Dragon extends Animal{
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

    @Override
    public String toString(){
        return super.toString();
    }
}