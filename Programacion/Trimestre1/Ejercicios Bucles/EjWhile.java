import java.util.Scanner;

public class EjWhile {
    public static void main(String[] args) {
        //Programa que pida un N hasta introducir en negativo
        Scanner entrada = new Scanner(System.in);
        int numero;

        // System.out.print("Introduce un número: ");
        // numero = entrada.nextInt();
        // while(numero>=0){
        //     System.out.print("Introduce un número: ");
        //     numero = entrada.nextInt();
        // }
        // System.out.println("Ha introducido un número negativo. El programa se cierra.");
        // entrada.close();

        /*Indicar si es positivo o negativo; el programa para cuando se introduce un 0*/
        System.out.print("Introduce un número: ");
        numero = entrada.nextInt();
        if(numero>0){
            System.out.println("El número es positivo");
        }
        else if(numero<0){
            System.out.println("El número es negativo");
        }
        while(numero!=0){
            System.out.print("Introduce un número: ");
            numero = entrada.nextInt();
            if(numero>0){
                System.out.println("El número es positivo");
            }
            else if(numero<0){
                System.out.println("El número es negativo");
            }
            else{
                System.out.println("Ha introducido un 0. El programa para.");
            }
        }
        entrada.close();
    }
}