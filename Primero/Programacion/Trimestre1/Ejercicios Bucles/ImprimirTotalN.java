import java.util.Scanner;

public class ImprimirTotalN {
    public static void main(String[] args) {
        //Pedir N hasta que se introduzca 0; imprimir total de número que se han introducidos (número total)
        Scanner entrada = new Scanner(System.in);
        int numero;
        int contador = 0;

        System.out.print("Introduce un número: ");
        numero = entrada.nextInt();
        while(numero!=0){
            contador++;
            System.out.print("Introduce un número: ");
            numero = entrada.nextInt();
        }
        System.out.println("Ha introducido un 0, el programa se cierra. Ha introducido un total de "+contador+" números antes de introducir un 0.");
        entrada.close();
    }
}