import java.util.Scanner;
public class Calendario {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String respuesta = " "; //recoger la respuesta del usuario para saber en qué día quiere empezar el mes
        int n = 0; //variable para transformar esa elección del día en un número

        do{
            System.out.print("Elige en qué día quieres que empiece el mes (L-M-X-J-V-S-D): ");
            respuesta = entrada.next(); //recogemos la respuesta
        }while(!respuesta.toUpperCase().equals("L") && !respuesta.toUpperCase().equals("M") && 
        !respuesta.toUpperCase().equals("X") && !respuesta.toUpperCase().equals("J") && 
        !respuesta.toUpperCase().equals("V") && !respuesta.toUpperCase().equals("S") && 
        !respuesta.toUpperCase().equals("D"));
        /* Mientrasla respuesta no sea uno de los 7 días válidos, me seguirá preguntando */

        if(respuesta.toUpperCase().equals("L")){ //si escogió lunes "L", n = 0
            n = 0;
        }
        else if(respuesta.toUpperCase().equals("M")){
            n = 1;
        }
        else if(respuesta.toUpperCase().equals("X")){
            n = 2;
        }
        else if(respuesta.toUpperCase().equals("J")){
            n = 3;
        }
        else if(respuesta.toUpperCase().equals("V")){
            n = 4;
        }
        else if(respuesta.toUpperCase().equals("S")){
            n = 5;
        }
        else{
            n = 6;
        }
        entrada.close();

        System.out.println("Calendario de un mes: "
        +"\nL  M  X  J  V  S  D");
        for(int i=(1-n); i<=30; i++){ //bucle que pinte los números del 1 al 30
            if(i<1){ //si el número es menor de 1, que pinte 3 espacios: 1 del número y 2 de separación
                System.out.print("   ");
            }
            else{
                System.out.print(i);
                if(i<10){ //si el índice actual es menor de 10,que pinte doble espacio entre número y número
                    System.out.print("  ");
                }
                else{ //si el número es igual o mayo de 10, que pinte solo un espacio entre números
                    System.out.print(" ");
                }
                if(i==(7-n)){ //si el número es 7, después de pintarlo meto un salto de línea; lo mismo para los demás casos
                    System.out.println();
                }
                else if(i==(14-n)){
                    System.out.println();
                }
                else if(i==(21-n)){
                    System.out.println();
                }
                else if(i==(28-n)){
                    System.out.println();
                }
                else if(i==(35-n)){
                    System.out.println();
                }
/* Restar "n" al contador inicial y a los condicionales es para que el día 1 se mueva de posición y en lugar de empezar siempre 
en lunes, empieza según el día que el usuario indique. De esta forma ponemos una especie de "barrera" en lo que sería la posición
del día "Domingo", para que cuando llegue a esa posición, pinte el número y dé un salto de línea.
En realidad, 7, 14, 28 y 35 son múltiplos de 7 (que son los días que tiene la semana), a los que le restamos "n", que es el día
en el que quiero empezar a imprimir el 1. De esta manera movemos el día 1 y cuándo pega los saltos de línea, para que no sean
estáticos en los múltiplos de 7.*/
            }
        }
    }
}