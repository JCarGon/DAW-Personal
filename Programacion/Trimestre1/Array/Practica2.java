import java.util.Scanner;

public class Practica2 {
    public static void main(String[] args) {
        /*Leer 10 números por teclado. Deberá indicarnos si los números están ordenados de forma creciente, decreciente o si están desordenados.*/
        Scanner entrada = new Scanner(System.in);
        int[] numeros = new int[10];
        boolean creciente = true;
        boolean decreciente = true;

        for(int i=0; i<numeros.length; i++){
            System.out.print("Introduce el valor para la posición "+i+": ");
            numeros[i] = entrada.nextInt();
        }

        for(int i=0; i<numeros.length-1; i++){
            if(numeros[i]<numeros[i+1]){
                decreciente = false;
            }
            else if(numeros[i]>numeros[i+1]){
                creciente = false;
            }
        }

        if(creciente && !decreciente){
            System.out.println("El orden es creciente.");
        }
        else if(!creciente && decreciente){
            System.out.println("El orden es decreciente.");
        }
        else if(creciente && decreciente){
            System.out.println("Los números son iguales.");
        }
        else{
            System.out.println("Los números están desordenados.");
        }        
        entrada.close();
    }
}