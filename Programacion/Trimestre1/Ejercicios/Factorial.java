import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int numero;
        int resultado = 1;

        System.out.print("Escribe un número para entregar su factorial: ");
        numero = entrada.nextInt();
        entrada.close();

        for(int i=numero;i>1;i--){
            resultado= resultado *i;
        }
        System.out.println(resultado);
    }
}