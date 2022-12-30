import java.util.Scanner;

public class Practica5 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int[] numeros = {1,2,3,4,5,6,7,8,9,10};
        int valorFinal = 0;
        int valorPrimero;

        do{
            System.out.print("Introduce un número para la primera posición: ");
            valorPrimero = entrada.nextInt();
            valorFinal = numeros[numeros.length-1];
            System.out.println("El valor que se pierde es: "+valorFinal);
            for(int i=numeros.length-1; i>0; i--){
                numeros[i] = numeros[i-1];
            }
            numeros[0] = valorPrimero;
            System.out.print("El array queda: ");
            for(int i=0; i<numeros.length; i++){
                System.out.print(numeros[i]+", ");
            }
            System.out.println(); //salto de línea
        }while(valorPrimero != 0);
        System.out.println("Has introducido un 0. El programa termina.");
        entrada.close();
    }
}