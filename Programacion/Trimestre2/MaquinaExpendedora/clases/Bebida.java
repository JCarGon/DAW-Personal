package clases;

public class Bebida extends Articulo implements Ialimento{
    private boolean caducado;
    private double nutrientes;
    private double grasas;

    public Bebida(String nombre, String codigo, double precio){
        super(nombre, codigo, precio);
        this.caducado = false;
        this.nutrientes = 0;
        this.grasas = 0;
    }

    public double getNutrientes() {
        return nutrientes;
    }

    public void setNutrientes(double nutrientes) {
        this.nutrientes = nutrientes;
    }

    public double getGrasas() {
        return grasas;
    }

    public void setGrasas(double grasas) {
        this.grasas = grasas;
    }

    public boolean isCaducado() {
        return caducado;
    }

    public void setCaducado(boolean caducado) {
        this.caducado = true;
    }

    public void caducar(){ // 25% de caducar
        if(Math.random() < 0.25){
            setCaducado(this.caducado);
        }
    }

    public void usar(){
        if(isCaducado()){
            System.out.println("No se puede consumir, está caducado.");
        }else{
            System.out.println("Me tomo el "+this.getNombre()+", me nutro de "+this.nutrientes+" gramos y engordo "+this.grasas+"gramos.");
        }
    }

    @Override
    public String toString(){
        return super.toString()+", caducado: "+this.caducado+", nutrienes: "+this.nutrientes+", grasas: "+this.grasas; 
    }
}