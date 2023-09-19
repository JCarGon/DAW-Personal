package clases;

public class Equipo {
    public String nombre;
    public String temporada;
    public int partidosJugados;
    public int partidosGanados;
    public int partidosPerdidos;

    public Equipo(String nombre, String temporada){
        this.nombre = nombre;
        this.temporada = temporada;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setTemporada(String temporada){
        this.temporada = temporada;
    }

    public void setPartidosJugados(int partidosJugados){
        this.partidosJugados = partidosJugados;
    }

    public void setPartidosGanados(int partidosGanados){
        this.partidosGanados = partidosGanados;
    }

    public void setPartidosPerdidos(int partidosPerdidos){
        this.partidosPerdidos = partidosPerdidos;
    }

    public String getNombre(){
        return nombre;
    }

    public String getTemporada(){
        return temporada;
    }

    public int getPartidosJugados(){
        return partidosJugados;
    }

    public int getPartidosGanados(){
        return partidosGanados;
    }

    public int getPartidosPerdidos(){
        return partidosPerdidos;
    }

    @Override
    public String toString(){
        return "El equipo"+nombre+" está jugando la temporada "+temporada+".";
    }
}