import java.util.Scanner;

public class Intro1 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int[] listaNumeros = new int[5];

        System.out.println("Vamos a guardar valores en cada una de las posiciones del array.");
        for(int i=0; i<listaNumeros.length; i++){
            System.out.print("Introduzca un valor para la posición "+i+": ");
            listaNumeros[i] = entrada.nextInt();
        }
        System.out.println("Mostrando por pantalla los valores del array.");
        for(int i=listaNumeros.length-1; i>=0; i--){ //empieza en lenght-1 porque lenght vale 5 y la última posición del array es 4
            System.out.println("Valor de la posición "+i+": "+listaNumeros[i]);
        }
        entrada.close();
    }
}