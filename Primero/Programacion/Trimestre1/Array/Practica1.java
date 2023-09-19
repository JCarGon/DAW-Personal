//import java.util.Scanner;

public class Practica1 {
    public static void main(String[] args) {
        // int[] numeros1 = {0,1,2,3,4,5,6,7,8,9};
        // int[] numeros2 = {10,20,30,40,50,60,70,80,90};
        // int[] numeros3 = new int[numeros1.length+numeros2.length];

        /*Ejercicio 1: intercalar de 1 en 1 los números*/
        // int contador = 0;
        // for(int i=0; i<numeros1.length; i++){
        //     numeros3[contador] = numeros1[i];
        //     contador +=2;
        // }
        // contador = 1;
        // for(int i=0; i<numeros2.length; i++){
        //     numeros3[contador] = numeros2[i];
        //     contador += 2;
        // }
        // for(int i=0; i<numeros3.length; i++){
        //     System.out.print(numeros3[i]+", ");
        // }

        /*Ejercicio 2: guardar el array1 y después el array2*/
        // for(int i=0; i<numeros1.length; i++){
        //     numeros3[i] = numeros1[i];
        // }
        
        // for(int j=0; j<numeros2.length; j++){
        //     numeros3[numeros1.length+j] = numeros2[j];
        // }
        
        // for(int i=0; i<numeros3.length; i++){
        //     System.out.print(numeros3[i]+", ");
        // }

        /*Ejercicio 3: intercalar en bloques de 3*/
        // final int n = 3;
        // for(int i=0; i<numeros1.length; i+=n){
        //     numeros3[i*2] = numeros1[i];
        //     numeros3[i*2+1] = numeros1[i+1];
        //     numeros3[i*2+2] = numeros1[i+2];
        //     numeros3[i*2+3] = numeros2[i];
        //     numeros3[i*2+4] = numeros2[i+1];
        //     numeros3[i*2+5] = numeros2[i+2];
        // }
        // for(int i=0; i<numeros3.length; i++){
        //     System.out.print(numeros3[i]+", ");
        // }

        /*Ejercicio 4: mostrar el primer número, después el último, el segundo, el penúltimo, etc.*/
        // for(int i=0; i<numeros1.length/2; i++){
        //     System.out.print(numeros1[i]+", ");
        //     System.out.print(numeros1[(numeros1.length-1)-i]+", ");
        // }

        /*Mostrar el valor máximo, el mínimo y las posiciones que ocupa en el array*/
        // Scanner entrada = new Scanner(System.in);
        // int[] numeros = new int[10];
        // int valorMaximo = Integer.MIN_VALUE;
        // int posicionVmax = 0;
        // int valorMinimo = Integer.MAX_VALUE;
        // int posicionVmin = 0;


        // for(int i=0; i<numeros.length; i++){
        //     System.out.print("Introduce un valor para la posición "+i+": ");
        //     numeros[i] = entrada.nextInt();

        //     if(numeros[i]>valorMaximo){
        //         valorMaximo = numeros[i];
        //         posicionVmax = i;
        //     }
        //     if(numeros[i]<=valorMinimo){
        //         valorMinimo = numeros[i];
        //         posicionVmin = i;
        //     }
        // }
        // entrada.close();
        // System.out.println("El valor máximo es "+valorMaximo+" y ocupa la posición "+posicionVmax+
        // ". El valor mínimo es "+valorMinimo+" y ocupa la posición "+posicionVmin+".");

        /*Generar 20 números aleatorios enteros entre 0 y 99 y almacenarlos en un array. El programa debe crear un nuevo array con los números primos que haya entre
        esos 20 números. Finalmente deberá mostrar los dos arrays.*/
        int[] numeros1 = new int[20];
        int[] numerosPrimos = new int[20];
        boolean numeroPrimo;

        for(int i=0; i<numeros1.length; i++){
            numeros1[i] = (int) (Math.random() * 99 + 0);
        }
        for(int i=0;i<numeros1[i]; i++){
            numeroPrimo = true;             
            for(int j=2; j<numeros1[i]; j++){
                if(numeros1[i]%j==0){
                    numeroPrimo = false;
                    break;
                }
            }
            if(numeroPrimo == true){
                numerosPrimos[i] = numeros1[i];
            }
        }
        System.out.print("Array de números: ");
        for(int i=0; i<numeros1.length; i++){
            System.out.print(numeros1[i]+", ");
        }
        System.out.println();
        System.out.print("Array de números primos: ");
        for(int i=0; i<numeros1.length; i++){
            if(numerosPrimos[i]!=0){
                System.out.print(numerosPrimos[i]+", ");
            }
        }
    }
}