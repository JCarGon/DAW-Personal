import java.util.Scanner;

public class MediaNumeros {
    public static void main(String[] args) {
        //Calcular la media de los números introducidos; el programa para cuando se introduce un 0.
        Scanner entrada = new Scanner(System.in);
        int numero;
        int sumaNumeros = 0;
        int contadorNumeros = 0;
        double media;

        System.out.print("Introduzca un número: ");
        numero = entrada.nextInt();

        while(numero!=0){
            sumaNumeros += numero;
            contadorNumeros++;
            System.out.print("Introduzca otro número: ");
            numero = entrada.nextInt();
        }
        entrada.close();
        media = (double) sumaNumeros/contadorNumeros;
        System.out.println("El programa ha parado porque ha introducido un 0. La media de los números introducidos es: "+media+".");
    }
}