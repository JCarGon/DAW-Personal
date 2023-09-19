import java.util.ArrayList;
import java.util.Scanner;
import clases.*;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        Libro libro1 = new Libro("ESDLA", "Pepito", "Fantasia", 15, 1);
        Libro libro2 = new Libro("La historia interminable", "Pepito", "Fantasia", 12, 2);
        Libro libro3 = new Libro("Un camino inesperado", "Juan", "Fantasia", 5, 5);
        Libro libro4 = new Libro("El elfo oscuro", "Juan", "Fantasia", 20, 6);
        Libro libro5 = new Libro("El Hobbit", "Maria", "Fantasia", 18, 0);
        Libro libro6 = new Libro("Mozart", "Maria", "Historia", 10, 4);
        Libro libro7 = new Libro("Don Juan", "Maria", "Teatro", 14, 10);

        Cliente clienteGabri = new Cliente("Gabri", 1000.0);
        Cliente clienteAntonio = new Cliente("Antonio", 50.0);
        Cliente clienteArturo = new Cliente("Arturo", 23.0);

        //Crear la lista de libros de la tienda
        ArrayList<Libro> listaLibros = new ArrayList<>();
        listaLibros.add(libro1);
        listaLibros.add(libro2);
        listaLibros.add(libro3);
        listaLibros.add(libro4);
        listaLibros.add(libro5);
        listaLibros.add(libro6);
        listaLibros.add(libro7);
        //Crear la lista de clientes de la tienda
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        listaClientes.add(clienteGabri);
        listaClientes.add(clienteAntonio);
        listaClientes.add(clienteArturo);
        //Crear tienda
        Tienda tienda = new Tienda("Erase una vez", listaLibros, listaClientes);

        String menu = "### Bienvenido a "+tienda.getNombre()+" ###"+
        "\n1. Ver libros"
        +"\n2. Ver clientes"
        +"\n3. Buscar libro"
        +"\n4. Vender libro"
        +"\n5. registrar libro"
        +"\n6. Registrar cliente"
        +"\n0. Salir"
        +"\nIntroduzca una opción: ";
        
        int opcion = -1;
        do{
            System.out.print(menu);
            opcion = entrada.nextInt();
            System.out.println();
            switch(opcion){
                case 0:
                System.out.println("Saliendo de la tienda virtual. Gracias por visitarnos.");
                    break;
                case 1:
                    tienda.listar();
                    System.out.println("-----------------------------------");
                    break;
                case 2:
                    tienda.verClientes();
                    System.out.println("-----------------------------------");
                    break;
                case 3:
                    char letra = ' ';
                    do{
                        System.out.print("¿Quiere ver todos los libros?: ");
                        letra = entrada.next().charAt(0);
                        System.out.println();
                        if(letra != 's' && letra != 'n'){
                            System.out.println("Opción no válida, inserte otra.");
                            System.out.println("-----------------------------------");
                        }
                    }while(letra != 's' && letra != 'n');
                    if(letra == 's'){
                        tienda.listar();
                        System.out.println("-----------------------------------");
                    }else{
                        int busqueda = 0;
                        do{
                            System.out.print("--- Elija la opción de búsqueda ---"
                            +"\n1. Nombre"
                            +"\n2. Autor"
                            +"\n3. Categoria"
                            +"\nIntroduzca una opción: ");
                            busqueda = entrada.nextInt();
                            tienda.listar(busqueda);
                            System.out.println("-----------------------------------");
                            if(busqueda != 1 && busqueda != 2 && busqueda != 3){
                                System.out.println("Opción no válida, inserte otra.");
                                System.out.println("-----------------------------------");
                            }
                        }while(busqueda != 1 && busqueda != 2 && busqueda != 3);
                    }
                    break;
                case 4:
                    //vender libro
                    int comprador = -1;
                    tienda.verClientes();
                    do{
                        System.out.print("Elija un comprador: ");
                        comprador = (entrada.nextInt()-1);
                        System.out.println();
                    }while(comprador < 0 && comprador > listaClientes.size());
                    tienda.listar();
                    int numlibro = -1;
                    do{
                        System.out.print("Elija un libro: ");
                        numlibro = (entrada.nextInt()-1);
                        System.out.println();
                    }while(numlibro < 0 && numlibro > listaLibros.size());
                    tienda.venderLibro(listaLibros.get(numlibro), listaClientes.get(comprador));
                    System.out.println("-----------------------------------");
                    break;
                case 5:
                    //registrar libro
                    tienda.addLibro();
                    System.out.println("-----------------------------------");
                    break;
                case 6:
                    //registrar cliente
                    tienda.addCliente();
                    System.out.println("-----------------------------------");
                    break;
                default:
                    System.out.println("No ha introducido una opción correcta.");
                    System.out.println("-----------------------------------");
            }
        }while(opcion > 0 && opcion < 7);
        entrada.close();
    }
}