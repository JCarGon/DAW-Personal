import clases.*;
import java.util.List;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args) {
        Usuario user1 = new Usuario("user1", "1234");
        List<Usuario> listaUsuarios = new ArrayList<>();
        listaUsuarios.add(user1);

        List<Comentario> comentarios = new ArrayList<>();

        BBDD baseDatos = new BBDD(listaUsuarios, comentarios);

        Panel panel1 = new Panel(comentarios, baseDatos);

        panel1.start();
        System.out.println(comentarios.toString());
    }
}