package clases;
import java.util.List;
import java.util.ArrayList;

public class BBDD {
    List<Usuario> users = new ArrayList<Usuario>();
    List<Comentario> comentarios = new ArrayList<Comentario>();

    public BBDD(List<Usuario> users, List<Comentario> comentarios) {
        this.users = users;
        this.comentarios = comentarios;
    }

    @Override
    public String toString(){
        return "Base de datos: "+this.getClass().getSimpleName();
    }
}