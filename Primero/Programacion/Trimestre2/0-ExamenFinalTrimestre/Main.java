import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LocalDate fechaKnekro = LocalDate.of(1940, 5, 20);
        LocalDateTime horarioKnekro = LocalDateTime.of(2023, 3, 22, 18, 00, 00);
        Profesor knekro = new Profesor(1, "Knekro", fechaKnekro, horarioKnekro);
        Pelicula pelicula1 = new Pelicula(1, "El señor de los Anillos", 3.2, 16, 400, "Fantasía");
        Serie serie1 = new Serie(1, "The Mandalorian", 8, 12, 200, "Fantasía", 20, 3);
        Serie serieTLOU = new Serie(2, "The Last Of Us", 10, 18, 800, "Ficción", 9, 1);
        Serie serieAndor = new Serie(3, "Andor", 12, 16, 300, "Ficción", 8, 1);
        CanalProfesor canalProfe1 = new CanalProfesor(1, "KnekroGamer", 6, 18, 500, knekro);

        ArrayList<Contenido> listaPrueba = new ArrayList<>(Arrays.asList(canalProfe1, pelicula1, serie1, serieAndor, serieTLOU));

        ArrayList<Contenido> contenido1 = new ArrayList<>();
        contenido1.add(pelicula1);
        ArrayList<Contenido> contenido2 = new ArrayList<>();
        contenido2.add(serie1);
        ArrayList<Contenido> contenido3 = new ArrayList<>();
        contenido3.add(canalProfe1);
        contenido3.add(serie1);
        contenido3.add(pelicula1);
        ArrayList<Contenido> contenidoHBO = new ArrayList<>();
        contenidoHBO.add(serieTLOU);
        ArrayList<Contenido> contenidoDisney = new ArrayList<>();
        contenidoDisney.add(serieAndor);


        PlataformaStreaming adaflixBasic = new PlataformaStreaming(1, "ADAFLIX BASIC", 0, contenido1);
        PlataformaStreaming adaflixStandard = new PlataformaStreaming(1, "ADAFLIX STANDARD", 3.99, contenido2);
        PlataformaStreaming adaflixPremium = new PlataformaStreaming(1, "ADAFLIX PREMIUM", 9.99, contenido3);
        PlataformaStreaming HBOMax = new PlataformaStreaming(2, "HBO MAX", 40, contenidoHBO);
        PlataformaStreaming Disney = new PlataformaStreaming(3, "Disney+", 60, contenidoHBO);
        ArrayList<PlataformaStreaming> listaSubscripciones = new ArrayList<>();
        listaSubscripciones.add(adaflixBasic);
        listaSubscripciones.add(adaflixStandard);
        listaSubscripciones.add(adaflixPremium);
        listaSubscripciones.add(HBOMax);
        listaSubscripciones.add(Disney);

        LocalDate fechaU1 = LocalDate.of(1992, 12, 22);
        Usuario u1 = new Usuario(1, "Pepe", fechaU1, 20);
        u1.addContenidoFavorito(serieTLOU);

        LocalDate fechaU2 = LocalDate.of(2000, 4, 15);
        Usuario u2 = new Usuario(2, "Manolete", fechaU2, 5);

        Scanner entrada = new Scanner(System.in);
        int opcion = -1;

        do{
            System.out.print("Bienvenido a ADAFLIX: Gestión de plataformas streaming\n"+
            "1. Listar las distintas suscripciones que existen de una plataforma\n"+
            "2. Subscribirse a una plataforma\n"+
            "3. Darse de baja de una plataforma\n"+
            "4. Listar el contenido según el tipo (película, serie o canal profesorado)\n"+
            "5. Mostrar el TOP 10 de los contenidos\n"+
            "6. Salir\n"+
            "Introduce una opción: ");
            opcion = entrada.nextInt();
            System.out.println();
            switch(opcion){
                case 1: //listar las suscripciones existentes
                    for (PlataformaStreaming p : listaSubscripciones) {
                        System.out.println("Plataforma de Streaming: "+p.getNombre()+", ID: "+p.getId()+", precio: "+p.getPrecioSuscripcion()+" euros.");
                    }
                    System.out.println();
                    break;
                case 2: //suscribirse a una plataforma existente
                    for(int i=0; i<listaSubscripciones.size(); i++){
                        System.out.println((i+1)+": "+listaSubscripciones.get(i).toString());
                    }
                    System.out.print("Selecciona una opción: ");
                    int op = entrada.nextInt()-1;
                    u1.darAltaPLataforma(listaSubscripciones.get(op));
                    System.out.println();
                    break;
                case 3: //darse de baja de una plataforma
                    for(int i=0; i<listaSubscripciones.size(); i++){
                        System.out.println((i+1)+": "+listaSubscripciones.get(i).toString());
                    }
                    System.out.print("Selecciona una opción: ");
                    int opt = entrada.nextInt()-1;
                    u1.darBajaPlataforma(listaSubscripciones.get(opt));
                    System.out.println();
                    break;
                case 4: //Listar contenido según el tipo (peli, serie, canal del profesorado)
                    int o = -1;
                    do{
                        System.out.print("¿Qué quieres ver?\n"+
                        "1. Serie\n"+
                        "2. Película\n"+
                        "3. Canal del profesorado\n"+
                        "Selecciona una opción: ");
                        o = entrada.nextInt();
                        System.out.println();
                        switch(o){
                            case 1: //series
                                for (Contenido l : listaPrueba) {
                                    if(l.getClass().getSimpleName().equals("Serie")){
                                        System.out.println(l.toString());
                                    }
                                }
                                System.out.println();
                                break;
                            case 2: //pelis
                                for (Contenido l : listaPrueba) {
                                    if(l.getClass().getSimpleName().equals("Pelicula")){
                                        System.out.println(l.toString());
                                    }
                                }
                                System.out.println();
                                break;
                            case 3: //canal profesores
                                for (Contenido l : listaPrueba) {
                                    if(l.getClass().getSimpleName().equals("CanalProfesor")){
                                        System.out.println(l.toString());
                                    }
                                }
                                System.out.println();
                                break;
                            default:
                                System.out.println("Opción no válida.\n");
                                break;
                        }
                    }while(o<1 || o>3);
                    break;
                case 5: //top 10 de una lista
                    ArrayList<Contenido> top10 = adaflixPremium.obtenerTopDiez();
                    for (Contenido t : top10) {
                        System.out.println(t.toString());
                    }
                    System.out.println();
                    break;
                case 6:
                    System.out.println("Saliendo del programa. Hasta la próxima.\n");
                    System.out.println(u1.toString()); //esto es para tener feedback de los datos del usuario 1
                    System.out.println();
                    break;
                default:
                    System.out.println("Has introducido una opción no válida.\n");
                    break;
            }
        }while(opcion != 6);
        entrada.close();
    }
}