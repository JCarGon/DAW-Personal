import java.util.Scanner;
public class ejercicio2 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int numero;

        System.out.print("Introduzca un número para mostrar su tabla de multiplicar: ");
        numero = entrada.nextInt();
        entrada.close();

        for(int i=1; i<=10; i++){//empezar por 1 y terminar en 10, yendo de 1 en 1
            System.out.println(numero+"x"+i+" = "+(numero*i));
        }
    }
}