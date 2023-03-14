package clases;

public abstract class Articulo {
    private String nombre;
    private String codigo;
    private double precio;

    public Articulo(String nombre, String codigo, double precio){
        this.nombre = nombre;
        this.codigo = codigo;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public double getPrecio() {
        return precio;
    }
    
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public abstract void usar();

    @Override
    public String toString(){
        return this.nombre+", "+this.codigo+", "+this.precio+"\n";
    }
}