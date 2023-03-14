package clases;

public class Juguete extends Articulo{

    public Juguete(String nombre, String codigo, double precio){
        super(nombre, codigo, precio);
    }

    public void usar(){
        System.out.println("Juego con mi "+this.getNombre()+".");
    }
}