import java.util.Scanner;

public class ExamenHundirFlota {
    public static Scanner input = new Scanner(System.in);
    public static int x;
    public static int y;
    public static int contadorBarcosUsuario = 0;
    public static int contadorBarcosMaquina = 0;
    public static String[][] tablero = new String[10][10];

    public static void crearMapaOceano(){
        for(int i=0; i<tablero.length; i++){
            for(int j=0; j<tablero[i].length; j++){
                tablero[i][j] = " "; //rellenar el contenido de cada posición con un espacio en blanco
            }
        }
    }

    public static void imprimirMapaOceano(){
        System.out.println();
        System.out.println("   0 1 2 3 4 5 6 7 8 9"); //primera línea impresa
        for(int i=0; i<tablero.length; i++){
            System.out.print(i+"| ");
            for(int j=0; j<tablero[i].length; j++){
                System.out.print(tablero[i][j]+" "); //imprimir el contenido de cada posición
            }
            System.out.println("|"+i);
        }
        System.out.println("   0 1 2 3 4 5 6 7 8 9"); //última línea impresa
    }

    public static void despliegueBarcosJugador(){
        System.out.println("Desplegando los barcos del jugador (recuerda que debes desplegar 5):");
        while(contadorBarcosUsuario <5){
            do{
                System.out.println("Barco "+(contadorBarcosUsuario+1)+".");
                do{ //para que pida coordenada x mientras el número no esté entre 0 y 9
                    System.out.print("Indica posición x: ");
                    x = input.nextInt();
                    if(x < 0 || x >= tablero.length){
                        System.out.println("Coordenada x no válida. Introduce otra.");
                    }
                }while(x < 0 || x >= tablero.length);

                do{ //para que pida coordenada y mientras el número no esté entre 0 y 9
                    System.out.print("Indica posición y: ");
                    y = input.nextInt();
                    if(y < 0 || y >= tablero.length){
                        System.out.println("Coordenada y no válida. Introduce otra.");
                    }
                }while(y < 0 || y >= tablero.length);

                if(tablero[x][y].equals("J")){ //si la coordenada ya contiene un barco del jugador no se puede utilizar
                    System.out.println("\nEsa posición ya la tienes ocupada. Inserta otra.\n");
                }
            }while(tablero[x][y].equals("J"));
            tablero[x][y] = "J";
            contadorBarcosUsuario++;
        }
        imprimirMapaOceano();
    }

    public static void despliegueBarcosOrdernador(){
        System.out.println("\nEl ordenador está colocando sus barcos. También desplegará 5.");
        while(contadorBarcosMaquina<5){
                int x = (int)(Math.random() * 10);
                int y = (int)(Math.random() * 10);
                if((x >= 0 && x < tablero.length) && (y >= 0 && y < tablero.length) && (!tablero[x][y].equals("J")) && (!tablero[x][y].equals("O"))){
                    tablero[x][y] = "O";
                    System.out.println("Barco "+contadorBarcosMaquina+" desplegado.");
                    contadorBarcosMaquina++;
                }
            };
        // Se imprime el mapa actualizado
        imprimirMapaOceano();
    }

    public static void turnoJugador(){
        System.out.println("\n¡Es tu turno!");
        System.out.println("Selecciona una coordenada para efectuar un disparo. Recuerda que puedes darle al tuyo.");

        do{ //para que pida coordenada x mientras el número no esté entre 0 y 9
            System.out.print("Indica posición x: ");
            x = input.nextInt();
            if(x < 0 || x >= tablero.length){
                System.out.println("Coordenada x no válida. Introduce otra.");
            }
        }while(x < 0 || x >= tablero.length);

        do{ //para que pida coordenada y mientras el número no esté entre 0 y 9
            System.out.print("Indica posición y: ");
            y = input.nextInt();
            if(y < 0 || y >= tablero.length){
                System.out.println("Coordenada y no válida. Introduce otra.");
            }
        }while(y < 0 || y >= tablero.length);

        if(tablero[x][y].equals("J")){ //si la coordenada tiene un barco del jugador, barcos usuario -1
            System.out.println("Has derribado uno de tus barcos. Ya me jodería ser tan torpe...");
            tablero[x][y] = "X";
            contadorBarcosUsuario--;
        }else if(tablero[x][y].equals("O")){ //si la coordenada tiene un barco del ordenador, barcos ordenador -1
            System.out.println("¡Has derribado un barco del ordenador!");
            tablero[x][y] = "!";
            contadorBarcosMaquina--;
        }else{ //si la coordenada no contiene ningún barco, disparo al agua
            System.out.println("Has disparado al agua.");
            tablero[x][y] = "-";
        }
    }

    public static void turnoOrdenador(){
        System.out.println("\n¡Turno del ordenador!");
        x = (int)(Math.random() * 10);
        y = (int)(Math.random() * 10);
        if((x >= 0 && x < tablero.length) && (y >= 0 && y < tablero.length)){
            if(tablero[x][y].equals("J")){ //si la coordenada tiene un barco del jugador, barcos usuario -1
                System.out.println("El ordenador ha derribado uno de tus barcos...");
                tablero[x][y] = "X";
                contadorBarcosUsuario--;
            }else if(tablero[x][y].equals("O")){ //si la coordenada tiene un barco del ordenador, barcos ordenador -1
                System.out.println("La máquina ha derribado uno de sus propios barcos. Menudo retraso...");
                tablero[x][y] = "!";
                contadorBarcosMaquina--;
            }else if(tablero[x][y].equals("X")){
                System.out.println("El ordenador ha disparado a uno de tus barcos ya hundido.");
            }else if(tablero[x][y].equals("!")){
                System.out.println("El ordenador ha disparado a uno de sus barcos ya hundido.");
            }else{ //si la coordenada no contiene ningún barco, disparo al agua
                System.out.println("La máquina ha disparado al agua.");
                tablero[x][y] = "-";
            }
        }
    }
    
    public static void combate(){
        turnoJugador();
        
        turnoOrdenador();

        imprimirMapaOceano();

        System.out.println();
        System.out.println("Barcos del jugador: " + contadorBarcosUsuario +" | Barcos del ordenador: " + contadorBarcosMaquina);
        System.out.println();
    }

    public static void gameOver(){
        if(contadorBarcosMaquina == 0){
            System.out.println("¡Enhorabuena! Has ganado la batalla :)");
        }
        else if(contadorBarcosUsuario == 0)
            System.out.println("Has perdido la batalla.");
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("##### HUNDIR LA FLOTA #####");
        System.out.println("El océano está vacío\n");

        //Fase 1 – Crear el mapa del océano
        crearMapaOceano();

        //Fase 2 – Desplegar los barcos del jugador
        despliegueBarcosJugador();

        // //Fase 3 - Desplegar los barcos del orcenador
        despliegueBarcosOrdernador();

        // //Fase 4 Combate
        do{
            combate();
        }while(contadorBarcosUsuario > 0 && contadorBarcosMaquina > 0);

        //Fase 5 - Game over
        gameOver();
        input.close();
    }
}