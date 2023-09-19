package clases;

public abstract class Comida extends Articulo implements Ialimento{
    private boolean caducado;

    public Comida(String nombre, String codigo, double precio){
        super(nombre, codigo, precio);
        this.caducado = false;
    }

    public boolean isCaducado() {
        return caducado;
    }

    public void setCaducado(boolean caducado) {
        this.caducado = true;
    }

    public void caducar(){ // 50% de caducar
        if(Math.random() > 0.5){
            setCaducado(this.caducado);
        }
    }

    public abstract void usar();

    @Override
    public String toString(){
        return super.toString()+", caducado: "+this.caducado; 
    }
}