import java.util.Scanner;
public class PareNone {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String decision = " "; //recoge la entrada sobre si quieren seguir jugando o no
        String respuestaUsuario1 = " ";
        String respuestaUsuario2 = " ";
        int numeroUsuario1 = 0;
        int numeroUsuario2 = 0;
        int contadorUsuario1 = 0;
        int contadorUsuario2 = 0;
        int sumaNumeros = 0;

        System.out.println("Vamos a jugar a pares o nones. Al comienzo de cada ronda, un jugador elegirá si quiere pares o nones. "
        +"Cada jugador sacará un número dentro de los posibles con los dedos de las manos, es decir entre 0 y 10 (ambos comprendidos). "
        +"A continuación, sumaremos el número que ha sacado cada usuario y si es par ganará el usuario que escogió 'pares', y si el "
        +"resultado es impar ganará el jugador que haya elegido 'nones'.");
        do{
            /* Para generar un número random entre valores: ((MAX-MIN)+1)+MIN.
            Con esto lo que voy a hacer es generar aleatoriamente quién empieza: si sale 1, empezará jugando el usuario 1; si sale 2, comenzará el usuario 2.*/
            int numAleatorio = (int) Math.floor(Math.random() * ((2 - 1) + 1)) + 1;
            
            if(numAleatorio == 1){ //si el número generado fue 1, se le pregunta al usuario 1 qué opción quiere
                do{
                    System.out.print("Usuario 1. ¿Pares o nones? (p/n): ");
                    respuestaUsuario1 = entrada.next();
                    if(!respuestaUsuario1.toUpperCase().equals("P") && !respuestaUsuario1.toUpperCase().equals("N")){ //si respuesta es diferente de "P" o "N" -> no válido
                        System.out.println("Ha introducido una respuesta no válida.\n");
                    }
                }while(!respuestaUsuario1.toUpperCase().equals("P") && !respuestaUsuario1.toUpperCase().equals("N")); //repite esto mientras la respuesta sea diferente de "P" o "N"

                do{
                    System.out.print("Usuario 1, introduzca un número del 0 al 10: "); //pregunta número al usuario 1
                    numeroUsuario1 = entrada.nextInt();
                    if(numeroUsuario1<0 || numeroUsuario1>10){ //si el número es menor de 0 o mayor de 10 -> no válido
                        System.out.println("Ha introducido un número no válido.\n");
                    }
                }while(numeroUsuario1<0 || numeroUsuario1>10); //repite pregunta mientras el número sea menor de 0 o mayor de 10
                do{
                    System.out.print("Usuario 2, introduzca un número del 0 al 10: "); //pregunta número al usuario 2
                    numeroUsuario2 = entrada.nextInt();
                    if(numeroUsuario2<0 || numeroUsuario2>10){ //si el número es menor de 0 o mayor de 10 -> no válido
                        System.out.println("Ha introducido un número no válido.\n");
                    }
                }while(numeroUsuario2<0 || numeroUsuario2>10); //repite pregunta mientras el número sea menor de 0 o mayor de 10
                
                //sumamos los números que ha introducido cada uno para saber el total
                sumaNumeros = numeroUsuario1+numeroUsuario2;
                
                //Resultados
                if(respuestaUsuario1.toUpperCase().equals("P") && (sumaNumeros%2==0)){
                    contadorUsuario1++;
                    System.out.println("Ha ganado el usuario 1.\n");
                }
                else if(respuestaUsuario1.toUpperCase().equals("N") && (sumaNumeros%2!=0)){
                    contadorUsuario1++;
                    System.out.println("Ha ganado el usuario 1.\n");
                }
                else{
                    contadorUsuario2++;
                    System.out.println("Ha ganado el usuario 2.\n");
                }
            }
            else{ //en caso contrario, empezará el usuario 2
                do{
                    System.out.print("Usuario 2. ¿Pares o nones? (p/n): ");
                    respuestaUsuario2 = entrada.next();
                    if(!respuestaUsuario2.toUpperCase().equals("P") && !respuestaUsuario2.toUpperCase().equals("N")){
                        System.out.println("Ha introducido una respuesta no válida.\n");
                    }
                }while(!respuestaUsuario2.toUpperCase().equals("P") && !respuestaUsuario2.toUpperCase().equals("N"));

                do{
                    System.out.print("Usuario 1, introduzca un número del 0 al 10: "); //pregunta número al usuario 1
                    numeroUsuario1 = entrada.nextInt();
                    if(numeroUsuario1<0 || numeroUsuario1>10){ //si el número es menor de 0 o mayor de 10 -> no válido
                        System.out.println("Ha introducido un número no válido.\n");
                    }
                }while(numeroUsuario1<0 || numeroUsuario1>10); //repite pregunta mientras el número sea menor de 0 o mayor de 10
                do{
                    System.out.print("Usuario 2, introduzca un número del 0 al 10: "); //pregunta número al usuario 2
                    numeroUsuario2 = entrada.nextInt();
                    if(numeroUsuario2<0 || numeroUsuario2>10){ //si el número es menor de 0 o mayor de 10 -> no válido
                        System.out.println("Ha introducido un número no válido.\n");
                    }
                }while(numeroUsuario2<0 || numeroUsuario2>10); //repite pregunta mientras el número sea menor de 0 o mayor de 10
                
                //sumamos los números que ha introducido cada uno para saber el total
                sumaNumeros = numeroUsuario1+numeroUsuario2;
                
                //Resultados
                if(respuestaUsuario2.toUpperCase().equals("P") && (sumaNumeros%2==0)){
                    contadorUsuario2++;
                    System.out.println("Ha ganado el usuario 2.\n");
                }
                else if(respuestaUsuario2.toUpperCase().equals("N") && (sumaNumeros%2!=0)){
                    contadorUsuario2++;
                    System.out.println("Ha ganado el usuario 2.\n");
                }
                else{
                    contadorUsuario1++;
                    System.out.println("Ha ganado el usuario 1.\n");
                }
            }

            do{
                System.out.print("¿Queréis jugar de nuevo? (s/n):");
                decision = entrada.next();
                if(!decision.toUpperCase().equals("S") && !decision.toUpperCase().equals("N")){
                    System.out.println("Ha introducido una respuesta no válida.\n"); //si decisión es diferente de "S" o "N" -> respuesta no válida
                }
            }while(!decision.toUpperCase().equals("S") && !decision.toUpperCase().equals("N")); //repite esto mientras la respuesta sea diferente de "S" o "N"

            /*Restablecer valores de variables para que no quede nada acumulado si se juega de nuevo*/
            respuestaUsuario1 = " ";
            respuestaUsuario2 = " ";
            numeroUsuario1 = 0;
            numeroUsuario2 = 0;
            sumaNumeros = 0;

            if(decision.toUpperCase().equals("N")){ //si la decision es "N", salir del juego
                System.out.println("Recuento final: El usuario 1 ha ganado "+contadorUsuario1+" veces y el usuario 2 ha ganado "+contadorUsuario2+" veces, por lo que...");
                if(contadorUsuario1>contadorUsuario2){
                    System.out.println("\tGANA USUARIO 1.");
                }
                else if(contadorUsuario2>contadorUsuario1){
                    System.out.println("\tGANA USUARIO 2.");

                }
                else{
                    System.out.println("\tTENEMOS UN EMPATE.");
                }
                System.out.println("Saliendo del programa. Gracias por jugar :).\n\n");
            }
        }while(decision.toUpperCase().equals("S"));
        entrada.close();
    }
}