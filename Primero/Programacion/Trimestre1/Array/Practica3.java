import java.util.Scanner;

public class Practica3 {
    public static void main(String[] args) {
        /*Definir un array de extensión 10 y rellenamos con 8 valores. Insertar nuevo valor en posición 0 y desplazar el resto*/
        Scanner entrada = new Scanner(System.in);
        int[] numeros = new int[10];
        int posicion = 0;

        for(int i=0; i<8; i++){
            System.out.print("Introduce un número para la posición "+i+": ");
            numeros[i] = entrada.nextInt();
        }
        /*Cambiar valores: número siguiente coge el valor del número actual*/
        // for(int i=7; i>=0; i--){ //lo mismo que: (i=numeros.lenght-1; i>0; i--)
        //     numeros[i+1] = numeros[i]; //numeros[i] = numeros[i-1]
        // }
        // System.out.print("Introduce un número para la posición 0: ");
        // numeros[0] = entrada.nextInt();

        /*Preguntar en qué posición quiero introducir un número nuevo, introducirlo en esa posición y mover lo demás una posición adelante GENERALIZAR*/
        System.out.print("Introduce la posición en la que quieres introducir un valor nuevo: ");
        posicion = entrada.nextInt();
        for(int i=7; i>=posicion; i--){
            numeros[i+1] = numeros[i];
        }
        System.out.print("Introduce un número para el valor de la posición "+posicion+": ");
        numeros[posicion] = entrada.nextInt();
        for(int i=0; i<numeros.length; i++){
            System.out.print(numeros[i]+", ");
        }
        entrada.close();
    }
}