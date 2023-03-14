package clases;

public class Tabaco extends Articulo{
    private int unidades;
    
    public Tabaco(String nombre, String codigo, double precio){
        super(nombre, codigo, precio);
        this.unidades = 10;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public void usar(){
        if(getUnidades()>0){
            setUnidades(getUnidades()-1);
            System.out.println("me acabo de fumar un cigarrillo, quedan "+getUnidades()+" unidad/es.");
        }else{
            System.out.println("No quedan cigarrillos.");
        }
    }
}