import java.util.Scanner;
public class ejercicio3a {
    public static void main(String[] args) {
        /*3.1 Imprimir del 1 al N en vertical*/
        Scanner entrada = new Scanner(System.in);
        int numero;

        System.out.print("Introduce hasta qué número quieres mostrar por pantalla: ");
        numero = entrada.nextInt();
        entrada.close();

        for(int i=1; i<=numero; i++){
            System.out.println(i);
        }
    }
}