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
        for(int i=0; i<listaClientes.size(); i++){
            System.out.println((i+1)+". "+listaClientes.get(i).toString());
        }
    }

    public void listar(){
        for(int i=0; i<listaLibros.size(); i++){
            System.out.println((i+1)+". "+listaLibros.get(i).toString());
        }
    }

    public void listar(int numero){
        switch(numero){
            case 1: //titulo
                System.out.print("Introduce un título para buscar: ");
                String titulo = entrada.nextLine();
                for(int i=0; i< listaLibros.size(); i++){
                    if(listaLibros.get(i).getNombre().toUpperCase().contains(titulo.toUpperCase())){
                        System.out.println((i+1)+". "+listaLibros.get(i).toString());
                    }
                }
                break;
            case 2: //autor
                System.out.print("Introduce un autor para buscar: ");
                String autor = entrada.nextLine();
                for(int i=0; i< listaLibros.size(); i++){
                    if(listaLibros.get(i).getAutor().toUpperCase().contains(autor.toUpperCase())){
                        System.out.println((i+1)+". "+listaLibros.get(i).toString());
                    }
                }
                break;
            case 3: //categoria
                System.out.print("Introduce una categoría para buscar: ");
                String categoria = entrada.nextLine();
                for(int i=0; i< listaLibros.size(); i++){
                    if(listaLibros.get(i).getCategoria().toUpperCase().contains(categoria.toUpperCase())){
                        System.out.println((i+1)+". "+listaLibros.get(i).toString());
                    }
                }
                break;
            default:
                System.out.println("Has introducido una opción no válida.");
                break;
        }
    }

    public void addLibro(){
        System.out.print("Introduce el nombre del libro: ");
        String nombreLibro = entrada.nextLine();
        for (Libro l : listaLibros) {
            if(l.getNombre().toUpperCase().equals(nombreLibro.toUpperCase())){
                //si el libro existe -> sumar uno a la cantidad
                System.out.println("Ese libro ya existe, por lo que se sumará uno al stock.");
                l.setCantidad(l.getCantidad()+1);
            }else{
                //si el libro no existe, añado el libro
                System.out.print("Introduce el nombre del autor: ");
                String autorLibro = entrada.nextLine();
                System.out.print("Introduce la categoría: ");
                String categoriaLibro = entrada.nextLine();
                System.out.print("Introduce un precio: ");
                double precioLibro = entrada.nextDouble();
                System.out.print("Introduce una cantidad de stock para el libro: ");
                int stock = entrada.nextInt();
                //creamos el libro y lo añadimos
                Libro libronuevo = new Libro(nombreLibro, autorLibro, categoriaLibro, precioLibro, stock);
                this.listaLibros.add(libronuevo);
                break; //para que no salte el error: Exception in thread "main" java.util.ConcurrentModificationException
            }
        }
    }

    public void addCliente(){
        System.out.print("Introduce el nombre del cliente: ");
        String nombreCliente = entrada.next();
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
                break; //para que no salte el error: Exception in thread "main" java.util.ConcurrentModificationException
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
            }else{
                System.out.println("No puedes comprar este libro. No nos queda stock.");
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