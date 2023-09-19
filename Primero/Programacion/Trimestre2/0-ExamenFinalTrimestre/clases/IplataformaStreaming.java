import java.util.ArrayList;

public interface IplataformaStreaming {
    public boolean addContenido(Contenido c);
    public boolean eliminarContenido(Contenido c);
    public ArrayList<Contenido> obtenerTopDiez();
    public int obtenerCalidadImagen();
    public int obtenerNumeroMaximoPantallas();
    public String reproducirAnuncioAleatoriamente();
    public String listarContenidos();
}