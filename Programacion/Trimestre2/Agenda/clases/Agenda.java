package clases;
import java.util.List;

public class Agenda implements Iagenda{
    List<Contacto> contactos;

    public Agenda(List<Contacto> contactos) {
        this.contactos = contactos;
    }

    public boolean addContacto(Contacto c){
        boolean addContacto = false;
        if(existeContacto(c.getNombre())){
            System.out.println("Este contacto ya existe. No puedo añadirlo");
            return addContacto;
        }else{
            contactos.add(c);
            System.out.println("Contacto añadido.");
            addContacto = true;
            return addContacto;
        }
    }

    public boolean eliminarContacto(String nombre){
        boolean eliminarContacto = false;
        if(existeContacto(nombre)){
            for (Contacto c : contactos) {
                String nombreActual = c.getNombre();
                if(nombreActual.equals(nombre)){
                    contactos.remove(c);
                    eliminarContacto = true;
                    System.out.println("Se ha eliminado el contacto.");
                    break;
                }
            }
        }else{
            System.out.println("El contacto no se puede eliminar porque no existe.");
        }
        return eliminarContacto;
    }

    public boolean existeContacto(String nombre){
        boolean nombreRepetido = false;
        for (Contacto c : contactos) {
            String nombreActual = c.getNombre();
            if(nombreActual.equals(nombre)){
                nombreRepetido = true;
                break;
            }
        }
        return nombreRepetido;
    }

    public String listarContactos(){
        String acumular= "";
        for (Contacto c : contactos) {
            acumular += c.toString();
            acumular += "\n";
        }
        return acumular;
    }

    public int buscarContacto(String nombre){
        int posicion = 0;
        if(existeContacto(nombre)){
            for(int i=0; i<contactos.size(); i++){
                String nombreActual = contactos.get(i).getNombre();
                if(nombreActual.equals(nombre)){
                    System.out.println("Contacto encontrado en la posición: "+i);
                    posicion = i;
                    return posicion;
                }
            }
        }else{
            System.out.println("El contacto no existe.");
        }
        return posicion;
    }
}