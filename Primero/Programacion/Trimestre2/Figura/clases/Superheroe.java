package clases;

public class Superheroe {
    String nombre;
    String descripcion;
    boolean llevaCapa;

    public Superheroe(String nombre){
        this.nombre = nombre;
        this.descripcion = "";
        this.llevaCapa = false;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion(){
        return this.descripcion;
    }

    public void setCapa(boolean llevaCapa){
        this.llevaCapa = llevaCapa;
    }

    public boolean getCapa(){
        return this.llevaCapa;
    }

    @Override
    public String toString(){
        return "Nombre del superhéroe: "+nombre+".\nDescripción: "+this.descripcion+".\nLleva capa: "+llevaCapa+".";
    }
}