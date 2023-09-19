import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        /*Pedir 10 números y decir al final si había algún negativo*/
        Scanner entrada = new Scanner(System.in);
        int numero;
        boolean negativo = false;
        int contador = 0;

        System.out.println("Introduce números y al final te diré si hay al menos uno negativo.");
        do{
            System.out.print("Introduce un número: ");
            numero = entrada.nextInt();
            if(numero<0){
                negativo = true;
            }
            contador++;
        }while(contador<10);
        entrada.close();
        if(negativo == true){
            System.out.println("Has introducido al menos un número negativo.");
        }
        else{
            System.out.println("NO has introducido al menos un número negativo.");
        }
    }
}