import java.util.Scanner;

public class Ej4 {
    /* Factorial de un número N con recursividad; !5 = 5*4*3*2*1*/
    public static int factorial(int n){
        if(n == 1){
            return 1;
        }
        else{
            return n*factorial(n-1);
        }
    }
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Introduce un número para hacer su factorial: ");
        int n = entrada.nextInt();
        System.out.println("El factorial de "+n+" es: "+factorial(n));
        entrada.close();
    }
}