import java.util.Arrays;
import java.util.Scanner;
import Utilidades.*;

public class JuegoCalculadora {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int[] numerosCalculadora = new int[9];
        int[] arrayAux = new int[9];
        int sumatorio = 0;
        int numero = 0;
        boolean numeroEnArray;
        boolean ganador1 = false;
        boolean ganador2 = false;


        System.out.println("Bienvenido al juego de la calculadora. El juego consiste en que cada jugador debe insertar un número entre 1 y 9 "
        +"para sumarlo al que ya estuviera previamente. El jugador que llegue a sumar más de 31 o igual, pierde."
        +"\n*Condición 1: en cada turno un jugador solo podrá utilizar los números situados en la misma fila o columna que el dígito marcado por su oponente"
        +" en el turno anterior, sin repetir un número que ya haya sido usado anteriormente." //recorrer el array de los números introducidos y si está el número que se intenta meter, repetir
        +"\n*Condición 2: El número 0 no puede utilizarse nunca. "
        +"Por ejemplo, si durante una partida un jugador recibe la calculadora mostrándole el número 28 y el oponente acaba de introducir el 9,"
        +" el siguiente jugador solo tendrá disponible los números 3, 6, 7 y 8.");
        System.out.print("Empieza el juego.");
        System.out.println("Suma actual de la calculadora: "+sumatorio);

        /* El primer turno no hay que comprobar si el número está en el array porque comienza vacío */
        do{ //controlar que el número introducido está entre 1 y 9
            System.out.print("Turno del jugador 1. Inserte un número: "); //turno usuario 1
            numero = entrada.nextInt(); //número usuario 1
            if(numero<1 || numero > 9){
                System.out.print("Has introducido un número no válido: ");
            }
        }while(numero<1 || numero > 9);
        Utils.InsertarNumeroEnArray(numerosCalculadora, numero); //inserto el número en el array de los números introducidos
        sumatorio += numero; //lo sumo al total que hay en el juego
        System.out.println("La cantidad de la calculadora es: "+sumatorio+".\n"); //mostrar por pantalla el resultado actual de la calculadora
        
        /* MIENTRAS EL SUMATORIO SEA MENOR DE 31, SE SIGUE JUGANDO */
        while(sumatorio<31){

            /* CONTROL DEL TURNO DEL USUARIO 2 */
            System.out.print("Turno del jugador 2. Inserte un número de los posibles ("+Arrays.toString(Utils.ObtenerNumerosRelacionados(numero))+"): "); //turno usuario 2
            arrayAux = Utils.ObtenerNumerosRelacionados(numero);
            
            do{ //haz esto mientras el número que introduce el usuario está en el array de números ya introducidos
                do{ //controlar que el núemro introducido está entre 1 y 9
                    do{
                        numero = entrada.nextInt(); //numero de usuario 2
                        if(numero<1 || numero > 9){
                            System.out.print("Has introducido un número no válido. Inserta otro: ");
                        }
                    }while(numero<1 || numero > 9);
                    if(!Utils.ComprobarNumeroExisteEnArray(arrayAux, numero)){
                        System.out.print("El número introducido no está entre las posibilidades. Inserta otro: ");
                    }
                }while(!Utils.ComprobarNumeroExisteEnArray(arrayAux, numero));
                numeroEnArray = Utils.ComprobarNumeroExisteEnArray(numerosCalculadora, numero); //compruebo si ese número está en el array de números ya introducidos
                if(!numeroEnArray){ //si el número no está en el array
                    Utils.InsertarNumeroEnArray(numerosCalculadora, numero); //lo inserto en dicho array
                    sumatorio += numero; //lo sumo al total que hay en el juego
                }else{ //caso contrario: el número ya está en el array
                    System.out.print("El número introducido ya está en el array. Inserte otro: ");
                }
            }while(numeroEnArray);
            System.out.println("La cantidad de la calculadora es: "+sumatorio+".\n"); //mostrar por pantalla el resultado actual de la calculadora
            /* PONER FUERA DEL DO-WHILE PARA QUE SALGA DEL PROGRAMA CUANDO TENGA QUE HACERLO */
            if(sumatorio>=31){
                ganador1 = true;
                break;
            }
    
            /* CONTROL DEL TURNO DEL USUARIO 1 */
            System.out.print("Turno del jugador 1. Inserte un número de los posibles ("+Arrays.toString(Utils.ObtenerNumerosRelacionados(numero))+"): "); //turno usuario 1
            arrayAux = Utils.ObtenerNumerosRelacionados(numero);

            do{ //haz esto mientras el número que introduce el usuario está en el array de números ya introducidos
                do{ //controlar que el núemro introducido está entre 1 y 9
                    do{ //controlar que el núemro introducido está entre 1 y 9
                        numero = entrada.nextInt(); //numero de usuario 1
                        if(numero<1 || numero > 9){
                            System.out.print("Has introducido un número no válido. Inserta otro: ");
                        }
                    }while(numero<1 || numero > 9);
                    if(!Utils.ComprobarNumeroExisteEnArray(arrayAux, numero)){
                        System.out.print("El número introducido no está entre las posibilidades. Inserta otro: ");
                    }
                }while(!Utils.ComprobarNumeroExisteEnArray(arrayAux, numero));
                numeroEnArray = Utils.ComprobarNumeroExisteEnArray(numerosCalculadora, numero); //compruebo si ese número está en el array de números ya introducidos
                if(!numeroEnArray){ //si el número no está en el array
                    Utils.InsertarNumeroEnArray(numerosCalculadora, numero); //lo inserto en dicho array
                    sumatorio += numero; //lo sumo al total que hay en el juego
                }else{ //caso contrario: el número ya está en el array
                    System.out.print("El número introducido ya está en el array. Inserte otro: ");
                }
            }while(numeroEnArray);
            System.out.println("La cantidad de la calculadora es: "+sumatorio+".\n"); //mostrar por pantalla el resultado actual de la calculadora
            /* PONER FUERA DEL DO-WHILE PARA QUE SALGA DEL PROGRAMA CUANDO TENGA QUE HACERLO */
            if(sumatorio>=31){
                ganador2 = true;
                break;
            }
        }
        if(ganador1){
            System.out.println("Ha ganado el usuario 1 porque el usuario 2 ha llegado o superado el número 31.");
        }
        if(ganador2){
            System.out.println("Ha ganado el usuario 2 porque el usuario 1 ha llegado o superado el número 31.");
        }
        entrada.close();
    }
}