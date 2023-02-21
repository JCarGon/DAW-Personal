package clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Panel {
    Scanner entrada = new Scanner(System.in);
    List<Comentario> comentarios = new ArrayList<Comentario>();
    BBDD baseDatos;

    public Panel(List<Comentario> comentarios, BBDD baseDatos) {
        this.comentarios = comentarios;
        this.baseDatos = baseDatos;
        this.start();
    }

    public void start(){
        Usuario usuario;
        do{
            usuario = this.Login();
        }while(usuario == null);
        this.insertarComentario(usuario);
    }

    public Usuario Login(){
        Usuario usuario = new Usuario(null, null);
        System.out.print("\t -----\n\t|Login| \n\t ----- \nIntroduce el nombre de usuario: ");
        String user = entrada.nextLine();
        boolean bandera = false;
        for (Usuario u : baseDatos.users){
            if(user.equals(u.getNombre())){
                bandera = true;
                usuario.setNombre(user);
            }
        }
        if(!bandera){
            System.out.println("Error, ha introducido un usuario inexistente. Pruebe de nuevo");
            usuario = null;
            return usuario;
        }else{
            bandera = false;
            System.out.print("Introduzca la contraseña: ");
            String pass = entrada.nextLine();
            for (Usuario u : baseDatos.users){
                if(pass.equals(u.getPass())){
                    bandera = true;
                    usuario.setPass(pass);
                }
            }
            if(!bandera){
                System.out.println("Ha introducido una contraseña errónea.");
                usuario = null;
                return usuario;
            }else{
                System.out.println("Bienvenido al sistema.");
                return usuario;
            }
        }
    }

    public void MostrarAcciones(){
        
    }

    public void insertarComentario(Usuario user){
        String coment = user.publicarComentario();
        Comentario comentario = new Comentario(user.getNombre(), coment);
        this.comentarios.add(comentario);
    }
}