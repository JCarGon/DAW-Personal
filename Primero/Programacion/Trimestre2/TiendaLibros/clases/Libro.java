package clases;

public class Libro {
    private String nombre;
    private String autor;
    private String categoria;
    private double precio;
    private int cantidad;

    public Libro(String nombre, String autor, String categoria, double precio, int cantidad){
        this.nombre = nombre;
        this. autor = autor;
        this.categoria = categoria;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Libro comprar(int unidades){
        if(this.cantidad-unidades>0){
            //si hay suficiente cantidad de libro se puede comprar
            return this;
        }else{
            return null;
        }
    }

    @Override
    public String toString(){
        return this.nombre+" - "+this.autor+" - "+this.categoria+" - "+this.precio+" - "+this.cantidad;
    }
}