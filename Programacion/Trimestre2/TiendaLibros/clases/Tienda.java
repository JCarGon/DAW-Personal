package clases;
import java.util.ArrayList;
import java.util.Scanner;

public class Tienda {
    Scanner entrada = new Scanner(System.in);
    private String nombre;
    private ArrayList<Libro> listaLibros;
    private ArrayList<Cliente> listaClientes;

    public Tienda(String nombre, ArrayList<Libro> libros, ArrayList<Cliente> clientes){
        this.nombre = nombre;
        this.listaLibros = libros;
        this.listaClientes = clientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Libro> getListaLibros() {
        return listaLibros;
    }

    public void setListaLibros(ArrayList<Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public void verClientes(){
        for (Cliente c : listaClientes) {
            System.out.println(c.toString());
        }
    }

    public void listar(){
        for (Libro l : listaLibros) {
            System.out.println(l.toString());
        }
    }

    public void listar(int numero){
        switch(numero){
            case 1: //titulo
                System.out.print("Introduce un título para buscar: ");
                String titulo = entrada.nextLine();
                for (Libro l : listaLibros) {
                    if(l.getNombre().toUpperCase().contains(titulo.toUpperCase())){
                        System.out.println(l.toString());
                    }
                }
                break;
            case 2: //autor
                System.out.print("Introduce un autor para buscar: ");
                String autor = entrada.nextLine();
                for (Libro l : listaLibros) {
                    if(l.getAutor().toUpperCase().contains(autor.toUpperCase())){
                        System.out.println(l.toString());
                    }
                }
                break;
            case 3: //categoria
                System.out.print("Introduce una categoría para buscar: ");
                String categoria = entrada.nextLine();
                for (Libro l : listaLibros) {
                    if(l.getCategoria().toUpperCase().contains(categoria.toUpperCase())){
                        System.out.println(l.toString());
                    }
                }
                break;
            default:
                System.out.println("Has introducido una opción no válida.");
                break;
        }
    }

    public void addLibro(){
        System.out.print("Introduce el nombro del libro: ");
        String nombre = entrada.nextLine();
        for (Libro l : listaLibros) {
            if(l.getNombre().toUpperCase().equals(nombre.toUpperCase())){
                //si el libro existe -> sumar uno a la cantidad
                l.setCantidad(l.getCantidad()+1);
            }else{
                //si el libro no existe, añado el libro
                System.out.print("Introduce el nombre del autor: ");
                String autor = entrada.nextLine();
                System.out.print("Introduce la categoría: ");
                String categoria = entrada.nextLine();
                System.out.print("Introduce un precio: ");
                double precio = entrada.nextDouble();
                System.out.print("Introduce una cantidad de stock para el libro");
                int stock = entrada.nextInt();
                //creamos el libro y lo añadimos
                Libro libronuevo = new Libro(nombre, autor, categoria, precio, stock);
                this.listaLibros.add(libronuevo);
            }
        }
    }

    public void addCliente(){
        System.out.print("Introduce el nombre del cliente: ");
        String nombreCliente = entrada.nextLine();
        for (Cliente c : listaClientes) {
            if(c.getNombre().toUpperCase().equals(nombreCliente.toUpperCase())){
                //si el cliente ya existe
                System.out.print("Este cliente ya existe, no puedes crearlo.");
            }else{
                //si el cliente no existe, sigo preguntando datos y lo creo
                System.out.print("Introduce una cantidad de dinero: ");
                double dinero = entrada.nextDouble();
                Cliente clientenuevo = new Cliente(nombreCliente, dinero);
                this.listaClientes.add(clientenuevo);
            }
        }
    }

    public void venderLibro(Libro libro, Cliente cliente){
        //si cliente tiene suficiente para pagar el libro
        if(cliente.getDinero()>libro.getPrecio()){
            //comprobar si hay stock de ese libro en la colección de la tienda
            if(libro.getCantidad()>0){
                //restar uno al stock de la tienda
                libro.setCantidad(libro.getCantidad()-1);
                //restar dinero al usuario
                cliente.setDinero(cliente.getDinero()-libro.getPrecio());
                //añadir a la colección
                cliente.addLibro(libro);
                System.out.println("Comprado!");
            }
        }
    }

    @Override
    public String toString(){
        return "Nombre de la tienda: "+this.nombre+
        ", nombre de la lista de libros: "+this.listaLibros+
        ", nombre de la lista de clientes: "+this.listaClientes;
    }
}