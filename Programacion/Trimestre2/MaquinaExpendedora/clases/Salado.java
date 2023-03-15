package clases;

public class Salado extends Comida{
    private double nutrientes;

    public Salado(String nombre, String codigo, double precio, double nutrientes){
        super(nombre, codigo, precio);
        this.nutrientes = nutrientes;
    }

    public double getNutrientes() {
        return nutrientes;
    }

    public void setNutrientes(double nutrientes) {
        this.nutrientes = nutrientes;
    }

    public void usar(){
        if(isCaducado()){
            System.out.println("No se puede consumir, está caducado.");
        }else{
            System.out.println("Me tomo el "+this.getNombre()+" y me nutro "+this.nutrientes+" gramos.");

        }
    }

    @Override
    public String toString(){
        return "\n"+super.getNombre()+", "+super.getCodigo()+", "+super.getPrecio()+". Esto nutre: "+this.nutrientes+" gramos, caducado: "+super.isCaducado();
    }
}