public abstract class Contenido {
    private int id;
    private String nombre;
    private double duracion;
    private int edadMinima;
    private double numeroHorasReproducidas;

    public Contenido(int id, String nombre, double duracion, int edadMinima, double numeroHorasReproducidas){
        this.id = id;
        this.nombre = nombre;
        this.duracion = duracion;
        this.edadMinima = edadMinima;
        this.numeroHorasReproducidas = numeroHorasReproducidas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public int getEdadMinima() {
        return edadMinima;
    }

    public void setEdadMinima(int edadMinima) {
        this.edadMinima = edadMinima;
    }

    public double getNumeroHorasReproducidas() {
        return numeroHorasReproducidas;
    }

    public void setNumeroHorasReproducidas(double numeroHorasReproducidas) {
        this.numeroHorasReproducidas = numeroHorasReproducidas;
    }
    
    @Override
    public String toString(){
        return this.nombre+", id "+this.id+", duración "+this.duracion+", edad mínima "+this.edadMinima+" años, horas reproducidas "+this.numeroHorasReproducidas;
    }
}