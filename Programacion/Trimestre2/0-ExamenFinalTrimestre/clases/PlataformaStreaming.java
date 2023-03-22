import java.util.ArrayList;

public class PlataformaStreaming implements IplataformaStreaming{
    private int id;
    private String nombre;
    private double precioSuscripcion;
    private ArrayList<Contenido> contenidos;
    private boolean contieneAnuncios;

    public PlataformaStreaming(int id, String nombre, double precioSuscripcion, ArrayList<Contenido> contenidos){
        this.id = id;
        this.nombre = nombre;
        this.precioSuscripcion = precioSuscripcion;
        this.contenidos = contenidos;
        this.contieneAnuncios = false;
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

    public double getPrecioSuscripcion() {
        return precioSuscripcion;
    }

    public void setPrecioSuscripcion(double precioSuscripcion) {
        this.precioSuscripcion = precioSuscripcion;
    }

    public ArrayList<Contenido> getContenidos() {
        return contenidos;
    }

    public void setContenidos(ArrayList<Contenido> contenidos) {
        this.contenidos = contenidos;
    }

    public boolean isContieneAnuncios() {
        return contieneAnuncios;
    }

    public void setContieneAnuncios(boolean contieneAnuncios) {
        this.contieneAnuncios = contieneAnuncios;
    }
    
    public boolean addContenido(Contenido c){
        return this.contenidos.add(c);
    }

    public boolean eliminarContenido(Contenido c){
        return this.contenidos.remove(c);
    }

    public ArrayList<Contenido> obtenerTopDiez(){ //ordenar por número de horas hasta máximo 10
        // CAMBIAR MÉTODO
        return this.contenidos;
    }

    public int obtenerCalidadImagen(){
        if(this.precioSuscripcion < 3){ //si el precio de la suscripción es menor de 3 la calidad es 720
            return 720;
        }else if(this.precioSuscripcion >= 3.99 && this.precioSuscripcion < 9.99){ //si el precio de la suscripción está entre 3.99 y 9.98, la calidad es 1080
            return 1080;
        }else{ //si el precio es 9.99, la calidad es 4096
            return 4096;
        }
    }

    public int obtenerNumeroMaximoPantallas(){
        if(this.precioSuscripcion < 3){ //si el precio de la suscripción es menor de 3 solo puede verlo en una pantalla
            return 1;
        }else if(this.precioSuscripcion >= 3.99 && this.precioSuscripcion < 9.99){ //si el precio de la suscripción está entre 3.99 y 9.98, puede verlo en dos pantallas
            return 2;
        }else{ //si el precio es 9.99, tiene pantallas infinitas (100)
            return 100;
        }
    }

    public String reproducirAnuncioAleatoriamente(){
        String[] anuncios = {"anuncio de comida", "anuncio de fútbol", "anuncio de bebida", "anuncio de loción de pelo", "anuncio de juego de PS5", "anuncio de juego de Xbox", "anuncio de juego de Switch", "anuncio de ordenadores"};
        int opcion = (int)Math.random()*anuncios.length;
        return anuncios[opcion];
    }

    public String listarContenidos(){
        String salidaContenido = "";
        for (Contenido c : contenidos) {
            salidaContenido += c + "\n";
        }
        return salidaContenido;
    }

    @Override
    public String toString(){
        return "Plataforma de Streaming "+this.nombre+", "+this.id+", "+this.precioSuscripcion+", "+this.contenidos.toString();
    }
}