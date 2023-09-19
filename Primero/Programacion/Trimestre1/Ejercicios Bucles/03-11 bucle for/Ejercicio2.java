import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        /*Pedir 10 números y al final imprimir el mayor*/
        Scanner entrada = new Scanner(System.in);
        int numero;
        int numeromayor = 0;
        int contador = 0;

        System.out.println("Introduce números y al final te diré el mayor de todos.");
        do{
            System.out.print("Introduce un número: ");
            numero = entrada.nextInt();
            if(numero>numeromayor){
                numeromayor = numero;
            }
            contador++;
        }while(contador<11);
        entrada.close();
        System.out.print("El número mayor de todos los introducidos es: "+numeromayor);
    }    
}