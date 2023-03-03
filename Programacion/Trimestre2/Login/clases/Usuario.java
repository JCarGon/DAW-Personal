package clases;
import java.util.Scanner;

public class Usuario {
    Scanner entrada = new Scanner(System.in);

    String nombre;
    String pass;
    public Usuario(String nombre, String pass) {
        this.nombre = nombre;
        this.pass = pass;
    }
    public String getNombre() {
        return nombre;
    }
    public String getPass() {
        return pass;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }

    public String publicarComentario(){
        System.out.print("Introduce un comentario: ");
        String comentario = entrada.nextLine();
        return comentario;
    }

    @Override
    public String toString(){
        return "Soy un usuario normal y corriente.";
    }
}