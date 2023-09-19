import java.util.Scanner;

public class Juego {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int respuestaInicial;

        do{
            System.out.print("Piedra, papel y tijeras. Elige 1 si quieres jugar contra la máquina, o 2 si quieres jugar contra otra persona: ");
            respuestaInicial = entrada.nextInt();
            System.out.println();
        }while(respuestaInicial !=1 && respuestaInicial != 2);

        if(respuestaInicial == 1){ //Usuario VS máquina
            int opcionUsuario = 0;
            int contadorUsuario = 0;
            int contadorMaquina = 0;
            do {
                System.out.print("Vamos a jugar a piedra, papel y tijeras. Piedra será el número 1, papel será el número 2 y "
                +"tijeras será el número 3. Piedra gana a tijeras y pierde con papel; papel gana a piedra y pierde contra tijeras; "
                +" tijeras gana a papel y pierde contra piedra; en caso de empate será ronda no válida. Iré contando quién gana cada partida."
                +"\nElige piedra (1), papel (2) o tijeras (3); cuando quiera salir del juego pulse 4: ");
                opcionUsuario = entrada.nextInt();
                /* Salto de línea para separar con el resultado */
                System.out.println("");
    
                /* Para generar un número random entre valores es: ((MAX-MIN)+1)+MIN */
                int opcionMaquina = (int) Math.floor(Math.random() * ((3 - 1) + 1)) + 1;
    
                /* El usuario escoge opción 1: piedra */
                if (opcionUsuario == 1) {
                    /* La máquina escoge opción 1: piedra. Empate */
                    if (opcionMaquina == 1) {
                        System.out.println( "La máquina eligió opción 1 (piedra). Empate. Los dos sacaron piedra. Se repite la ronda.\n");
                    }
                    /* La máquina escoge opción 2: papel. Gana máquina */
                    else if (opcionMaquina == 2) {
                        System.out.println("La máquina eligió opción 2 (papel). Máquina gana. Eligió papel, que gana a piedra.\n");
                        contadorMaquina++;
                    }
                    /* La máquina escoge opción 3: tijeras. Gana usuario */
                    else {
                        System.out.println("La máquina eligió opción 3 (tijeras). Gana el usuario. Eligió piedra, que gana a tijeras.\n");
                        contadorUsuario++;
                    }
                }
    
                /* El usuario escoge opción 2: papel */
                else if (opcionUsuario == 2) {
                    /* La máquina escoge opción 1: piedra. Gana usuario */
                    if (opcionMaquina == 1) {
                        System.out.println("La máquina eligió opción 1 (piedra). Gana el usuario. Eligió papel, que gana a piedra.\n");
                        contadorUsuario++;
                    }
                    /* La máquina escoge opción 2: papel. Empate */
                    else if (opcionMaquina == 2) {
                        System.out.println("La máquina eligió opción 2 (papel). Empate. Los dos sacaron papel. Se repite la ronda.\n");
                    }
                    /* La máquina escoge opción 3: tijeras. Gana máquina */
                    else {
                        System.out.println("La máquina eligió opción 3 (tijeras). Máquina gana. Eligió tijeras, que gana a papel.\n");
                        contadorMaquina++;
                    }
                }
    
                /* El usuario escoge opción 3: tijeras */
                else if (opcionUsuario == 3) {
                    /* La máquina escoge opción 1: piedra. Gana máquina */
                    if (opcionMaquina == 1) {
                        System.out.println("La máquina eligió opción 1 (piedra). Máquina gana. Eligió piedra, que gana a tijeras.\n");
                        contadorMaquina++;
                    }
                    /* La máquina escoge opción 2: papel. Gana usuario */
                    else if (opcionMaquina == 2) {
                        System.out.println("La máquina eligió opción 2 (papel). Gana el usuario. Eligió tijeras que gana a papel.\n");
                        contadorUsuario++;
                    } else {
                        System.out.println("La máquina eligió opción 3 (tijeras). Empate. Los dos sacaron tijeras. Se repite la ronda.\n");
                    }
                }
    
                /* Opción 4: salir del juego. Recuento de puntos y ganador */
                else if (opcionUsuario ==4){
                    System.out.println("Saliendo de la aplicación. "
                    +"Resultado final: Victorias del usuario: " + contadorUsuario + "; victorias de la máquina: "+ contadorMaquina);
                    /* Gana el usuario */
                    if (contadorUsuario > contadorMaquina) {
                        System.out.println("Ha ganado el usuario.\n");
                    }
                    /* Gana la máquina */
                    else if (contadorUsuario < contadorMaquina) {
                        System.out.println("Ha ganado la máquina.\n");
                    }
                    /* Empate */
                    else {
                        System.out.println("Hay un empate.\n");
                    }
                }
                /* Opción usuario < 1 || opcion usuario > 4: opción no válida, repetir */
                else {
                    System.out.println("Error, no ha seleccionado una opción válida. Vuelva a seleccionar una.\n");
                }
            } while (opcionUsuario != 4);
        }
        else{ //Usuario 1 VS Usuario 2
            int opcionUsuario1 = 0;
            int opcionUsuario2 = 0;
            int contadorUsuario1 = 0;
            int contadorUsuario2 = 0;
            do {
                System.out.print("Vamos a jugar a piedra, papel y tijeras. Piedra será el número 1, papel será el número 2 y "
                +"tijeras será el número 3. Piedra gana a tijeras y pierde con papel; papel gana a piedra y pierde contra tijeras; "
                +" tijeras gana a papel y pierde contra piedra; en caso de empate será ronda no válida. Iré contando quién gana cada partida."
                +"\nUsuario 1. Elige piedra (1), papel (2) o tijeras (3); cuando quiera salir del juego pulse 4: ");
                opcionUsuario1 = entrada.nextInt();
                System.out.print("\nUsuario 2. Elige piedra (1), papel (2) o tijeras (3); cuando quiera salir del juego pulse 4: ");
                opcionUsuario2 = entrada.nextInt();
                /* Salto de línea para separar con el resultado */
                System.out.println("");
    
                /* El usuario 1 escoge opción 1: piedra */
                if (opcionUsuario1 == 1) {
                    /* El usuario 2 escoge opción 1: piedra. Empate */
                    if (opcionUsuario2 == 1) {
                        System.out.println( "Empate.\n");
                    }
                    /* El usuario 2 escoge opción 2: papel. Gana usuario 2 */
                    else if (opcionUsuario2 == 2) {
                        System.out.println("Gana el usuario 2. Papel gana a piedra.\n");
                        contadorUsuario2++;
                    }
                    /* El usuario 2 escoge opción 3: tijeras. Gana usuario 1 */
                    else {
                        System.out.println("Gana el usuario 1. Piedra gana a tijeras.\n");
                        contadorUsuario1++;
                    }
                }
    
                /* El usuario 1 escoge opción 2: papel */
                else if (opcionUsuario1 == 2) {
                    /* El usuario 2 escoge opción 1: piedra. Gana usuario 1 */
                    if (opcionUsuario2 == 1) {
                        System.out.println("Gana el usuario 1. Papel gana a piedra.\n");
                        contadorUsuario1++;
                    }
                    /* El usuario 2 escoge opción 2: papel. Empate */
                    else if (opcionUsuario2 == 2) {
                        System.out.println("Empate.\n");
                    }
                    /* El usuario 2 escoge opción 3: tijeras. Gana el usuario 2 */
                    else {
                        System.out.println("Gana el usuario 2. Tijeras gana a papel.\n");
                        contadorUsuario2++;
                    }
                }
    
                /* El usuario 1 escoge opción 3: tijeras */
                else if (opcionUsuario1 == 3) {
                    /* El usuario 2 escoge opción 1: piedra. Gana el usuario 2 */
                    if (opcionUsuario2 == 1) {
                        System.out.println("Gana el usuario 2. Piedra gana a tijeras.\n");
                        contadorUsuario2++;
                    }
                    /* El usuario 2 escoge opción 2: papel. Gana usuario 1 */
                    else if (opcionUsuario2 == 2) {
                        System.out.println("Gana el usuario 1. Tijeras gana a papel.\n");
                        contadorUsuario1++;
                    } else {
                        System.out.println("Empate.\n");
                    }
                }
    
                /* Opción 4: salir del juego. Recuento de puntos y ganador */
                else if (opcionUsuario1 ==4 || opcionUsuario2 == 4){
                    System.out.println("Saliendo de la aplicación. "
                    +"Resultado final: Victorias del usuario 1: " + contadorUsuario1 + "; victorias del usuario 2: "+ contadorUsuario2);
                    /* Gana el usuario 1 */
                    if (contadorUsuario1 > contadorUsuario2) {
                        System.out.println("Ha ganado el usuario 1.\n");
                    }
                    /* Gana el usuario 2 */
                    else if (contadorUsuario1 < contadorUsuario2) {
                        System.out.println("Ha ganado el usuario 2.\n");
                    }
                    /* Empate */
                    else {
                        System.out.println("Hay un empate.\n");
                    }
                    break;
                }
                /* Opción usuario 1 < 1 || opcion usuario 1 > 4: opción no válida, repetir */
                else {
                    System.out.println("Error, no ha seleccionado una opción válida. Vuelva a seleccionar una.\n");
                }
            } while (opcionUsuario1 != 4 || opcionUsuario2 != 4);
        }
        entrada.close();
    }
}