public class CanalProfesor extends Contenido{
    private Profesor profesor;
    private boolean enDirecto;

    public CanalProfesor(int id, String nombre, double duracion, int edadMinima, double numeroHorasReproducidas, Profesor profesor){
        super(id, nombre, duracion, edadMinima, numeroHorasReproducidas);
        this.profesor = profesor;
        this.enDirecto = false;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public boolean isEnDirecto() {
        return enDirecto;
    }

    public void setEnDirecto(boolean enDirecto) {
        this.enDirecto = enDirecto;
    }
    
    @Override
    public String toString(){
        return "Canal del profesor: "+this.profesor.getNombre()+", "+super.toString()+", está en directo "+this.enDirecto;
    }
}