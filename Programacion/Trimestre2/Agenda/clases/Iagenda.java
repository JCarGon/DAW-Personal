package clases;

public interface Iagenda {
    public boolean addContacto(Contacto c);
    public boolean eliminarContacto(String nombre);
    public boolean existeContacto(String nombre);
    public String listarContactos();
    public int buscarContacto(String nombre);
}