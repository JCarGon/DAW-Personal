package clases;
import java.util.ArrayList;
import java.util.Scanner;

public class MaquinaExpendedora {
    private static Scanner entrada = new Scanner(System.in);
    private ArrayList<Articulo> articulos;
    private String menu = "\tMenú de la máquina expendedora"+
    "\n1. Ver artículos"+
    "\n2. Comprar artículo"+
    "\n3. Introducir artículo"+
    "\n4. Poner al día"+
    "\n5. Caducar consumibles"+
    "\n0. Salir";
    private String menuArticulo = "\tMenú de artículo"+
    "\n1. Juguete"+
    "\n2. Tabaco"+
    "\n3. Salado"+
    "\n4. Dulce"+
    "\n5. Bebida";

    public MaquinaExpendedora(){
        this.articulos = new ArrayList<>();
    }

    public void load(){ //carga la lista de articulos
        for(int i=0; i<Articulos.DATOS_ARTICULOS.length; i++){
            this.articulos.add(Articulos.DATOS_ARTICULOS[i]);
        }
        System.out.println("Lista de artículos cargada.");
    }

    public void verArticulos(){
        System.out.println(this.articulos.toString());
    }

    public void actualizarArticulos(){ //comprobar si el alimento está caducado y eliminar
        for(int i=0; i<this.articulos.size(); i++){
            Articulo articulo = articulos.get(i);
            if(articulo.getClass().getSimpleName().equals("Dulce")){
                Dulce d = (Dulce) articulo;
                if(d.isCaducado()){ //si el dulce está caducado
                    this.articulos.remove(d);
                    i--;
                }
            }else if(articulo.getClass().getSimpleName().equals("Salado")){
                Salado s = (Salado) articulo;
                if(s.isCaducado()){ //si el salado está caducado
                    this.articulos.remove(s);
                    i--;
                }
            }else if(articulo.getClass().getSimpleName().equals("Bebida")){
                Bebida b = (Bebida) articulo;
                if(b.isCaducado()){ //si la bebida está caducada
                    this.articulos.remove(b);
                    i--;
                }
            }
        }
    }

    public void comprobarArticulos(){ //caducar cada artículo
        for(int i=0; i<this.articulos.size(); i++){
            Articulo articulo = articulos.get(i);
            if(articulo.getClass().getSimpleName().equals("Dulce")){
                 Dulce d = (Dulce) articulo;
                 d.caducar();
            }else if(articulo.getClass().getSimpleName().equals("Salado")){
                Salado s = (Salado) articulo;
                s.caducar();
            }else if(articulo.getClass().getSimpleName().equals("Bebida")){
                Bebida b = (Bebida) articulo;
                b.caducar();
            }
        }
    }

    public void insertarArticulo(){
        int opcion2 = -1;
        do{
            System.out.println(menuArticulo);
            System.out.print("Introduce una opción: ");
            opcion2 = entrada.nextInt();
            switch(opcion2){
                case 1: //juguete
                    System.out.print("Introduce un nombre para el juguete: ");
                    String nombreJuguete = entrada.nextLine();
                    System.out.print("Introduce un código para el juguete: ");
                    String codigoJuguete = entrada.nextLine();
                    System.out.print("Introduce un precio para el juguete: ");
                    double precioJuguete = entrada.nextDouble();
                    Juguete juguete = new Juguete(nombreJuguete, codigoJuguete, precioJuguete);
                    this.articulos.add(juguete);
                    System.out.println("Juguete creado.\n");
                    break;
                case 2: //tabaco
                    System.out.print("Introduce un nombre para el tabaco: ");
                    String nombreTabaco = entrada.nextLine();
                    System.out.print("Introduce un código para el tabaco: ");
                    String codigoTabaco = entrada.nextLine();
                    System.out.print("Introduce un precio para el tabaco: ");
                    double precioTabaco = entrada.nextDouble();
                    Tabaco tabaco = new Tabaco(nombreTabaco, codigoTabaco, precioTabaco);
                    this.articulos.add(tabaco);
                    System.out.println("Tabaco creado.\n");
                    break;
                case 3: //salado
                    System.out.print("Introduce un nombre para el salado: ");
                    String nombreSalado = entrada.nextLine();
                    System.out.print("Introduce un código para el salado: ");
                    String codigoSalado = entrada.nextLine();
                    System.out.print("Introduce un precio para el salado: ");
                    double precioSalado = entrada.nextDouble();
                    System.out.print("Introduce la cantidad de nutrientes del salado: ");
                    double nutrientesSalado = entrada.nextDouble();
                    Salado salado = new Salado(nombreSalado, codigoSalado, precioSalado, nutrientesSalado);
                    this.articulos.add(salado);
                    System.out.println("Salado creado.\n");
                    break;
                case 4: //dulce
                    System.out.print("Introduce un nombre para el dulce: ");
                    String nombreDulce = entrada.nextLine();
                    System.out.print("Introduce un código para el dulce: ");
                    String codigoDulce = entrada.nextLine();
                    System.out.print("Introduce un precio para el dulce: ");
                    double precioDulce = entrada.nextDouble();
                    System.out.print("Introduce la cantidad de grasas del dulce: ");
                    double grasasDulce = entrada.nextDouble();
                    Dulce dulce = new Dulce(nombreDulce, codigoDulce, precioDulce, grasasDulce);
                    this.articulos.add(dulce);
                    System.out.println("Dulce creado.\n");
                    break;
                case 5: //bebida
                    System.out.print("Introduce un nombre para la bebida: ");
                    String nombreBebida = entrada.nextLine();
                    System.out.print("Introduce un código para la bebida: ");
                    String codigoBebida = entrada.nextLine();
                    System.out.print("Introduce un precio para la bebida: ");
                    double precioBebida = entrada.nextDouble();
                    Bebida bebida = new Bebida(nombreBebida, codigoBebida, precioBebida);
                    this.articulos.add(bebida);
                    System.out.println("Bebida creada.\n");
                    break;
                default:
                System.out.println("Opción incorrecta. Prueba de nuevo.\n");
            }
        }while((opcion2<1) && (opcion2>5));
    }

    public void comprarArticulo(){
        int opcion = -1;
        do{
            for (int i=0; i<this.articulos.size(); i++) {
                System.out.println((i+1)+": "+articulos.get(i));
            }
            System.out.print("Selecciona el artículo: ");
            opcion = entrada.nextInt();
        }while((opcion<0) && (opcion > this.articulos.size()-1));
        System.out.print("Introduce el dinero en la máquina para comprar un artículo: ");
        double cantidad = entrada.nextDouble();
        if(articulos.get(opcion).getPrecio()>cantidad){
            System.out.println("No tienes dinero suficiente para comprar este artículo.\n");
        }else{
            this.articulos.remove(articulos.get(opcion));
            articulos.get(opcion).usar();
        }
    }

    public void start(){
        load();
        boolean start = true;
        while(start){
            int opcion1 = -1;
            do{
                System.out.println(menu);
                System.out.print("Elige una opción: ");
                opcion1 = entrada.nextInt();
                switch(opcion1){
                    case 0:
                        start = false;
                        System.out.println("Gracias por usar nuestros servicios. Hasta la próxima :).");
                        break;
                    case 1:
                        //ver artículos
                        verArticulos();
                        break;
                    case 2:
                        //comprar artículo
                        comprarArticulo();
                        break;
                    case 3:
                        //introducir artículo
                        insertarArticulo();
                        break;
                    case 4:
                        //poner al día
                        actualizarArticulos();
                        break;
                    case 5:
                        //caducar consumibles
                        comprobarArticulos();
                        break;
                    default:
                        System.out.println("Opción incorrecta. Prueba de nuevo.\n");
                }
            }while((opcion1<0) && (opcion1>5));
        }
    }
}