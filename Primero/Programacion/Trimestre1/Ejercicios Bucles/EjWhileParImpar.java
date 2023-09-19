import java.util.Scanner;

public class EjWhileParImpar {
    //Indicar si es par o impar; el programa se para cuando se introduce un 0
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int numero;
        
        System.out.print("Introduce un número: ");
        numero = entrada.nextInt();

        while(numero!=0){
            if(numero%2 == 0){
                System.out.println("El número es par");
            }
            else if(numero%2 != 0){
                System.out.println("El número es impar");
            }
            System.out.print("Introduce un número: ");
            numero = entrada.nextInt();
        }
        entrada.close();
        System.out.println("Ha introducido un 0. El programa para.");
    }
}