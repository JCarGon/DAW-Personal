public class Serie extends Contenido{
    private String tipoSerie;
    private int numeroCapitulos;
    private int numeroTemporadas;

    public Serie(int id, String nombre, double duracion, int edadMinima, double numeroHorasReproducidas, String tipoSerie, int numeroCapitulos, int numeroTemporadas){
        super(id, nombre, duracion, edadMinima, numeroHorasReproducidas);
        this.tipoSerie = tipoSerie;
        this.numeroCapitulos = numeroCapitulos;
        this.numeroTemporadas = numeroTemporadas;
    }

    public String getTipoSerie() {
        return tipoSerie;
    }

    public void setTipoSerie(String tipoSerie) {
        this.tipoSerie = tipoSerie;
    }

    public int getNumeroCapitulos() {
        return numeroCapitulos;
    }

    public void setNumeroCapitulos(int numeroCapitulos) {
        this.numeroCapitulos = numeroCapitulos;
    }

    public int getNumeroTemporadas() {
        return numeroTemporadas;
    }

    public void setNumeroTemporadas(int numeroTemporadas) {
        this.numeroTemporadas = numeroTemporadas;
    }
    
    @Override
    public String toString(){
        return "Serie: "+super.toString()+", tipo de serie "+this.tipoSerie+", número de capítulos "+this.numeroCapitulos+", número de temporadas "+this.numeroTemporadas;
    }
}