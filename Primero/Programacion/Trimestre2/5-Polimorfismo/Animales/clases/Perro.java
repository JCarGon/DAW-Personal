package clases;

public class Perro extends Animal{
    public Perro(String nombre){
        super(nombre);
    }

    @Override
    public void saludar(){
        System.out.println("Hola soy un perrete guau guau.");
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