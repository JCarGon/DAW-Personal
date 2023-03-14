package clases;

public class Dulce extends Comida{
    private double grasas;

    public Dulce(String nombre, String codigo, double precio, double grasas){
        super(nombre, codigo, precio);
        this.grasas = grasas;
    }

    public double getGrasas() {
        return grasas;
    }

    public void setGrasas(double grasas) {
        this.grasas = grasas;
    }

    public void usar(){
        if(isCaducado()){
            System.out.println("No se puede consumir, está caducado.");
        }else{
            System.out.println("Me tomo el "+this.getNombre()+" y engordo "+this.grasas+" gramos.");
        }
    }

    @Override
    public String toString(){
        return super.toString()+". Esto engorda: "+this.grasas+" gramos."; 
    }
}