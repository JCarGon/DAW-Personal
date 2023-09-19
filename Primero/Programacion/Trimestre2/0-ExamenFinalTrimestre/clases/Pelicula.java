public class Pelicula extends Contenido{
    private String tipoPelicula;

    public Pelicula(int id, String nombre, double duracion, int edadMinima, double numeroHorasReproducidas, String tipoPelicula){
        super(id, nombre, duracion, edadMinima, numeroHorasReproducidas);
        this.tipoPelicula = tipoPelicula;
    }

    public String getTipoPelicula() {
        return tipoPelicula;
    }

    public void setTipoPelicula(String tipoPelicula) {
        this.tipoPelicula = tipoPelicula;
    }
    
    @Override
    public String toString(){
        return "Película: "+super.toString()+", tipo de película "+this.tipoPelicula;
    }
}