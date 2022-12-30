import java.util.Scanner;

public class ejercicio3b {
    public static void main(String[] args) {
        /*Imprimir N veces el número de la fila: si N=4 ->
         * 1111
         * 2222
         * 3333
         * 4444
        */
        Scanner entrada = new Scanner(System.in);
        int n;

        System.out.print("Introduce el número de veces que se va a repetir el número en la fila: ");
        n = entrada.nextInt();
        entrada.close();

        for(int i=1; i<=5; i++){//bucle for para que recorra los números del 1 al 5 (por ejemplo)
            for(int j=1; j<=n; j++){//bucle for para que imprima n veces el número actual
                System.out.print(i+" ");
            }
            System.out.println();//salto de línea para separar una fila de otra
        }
    }
}