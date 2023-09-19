import java.util.Scanner;

public class PositivosNegativos {
    public static void main(String[] args) {
        //Decir cuántos positivos y negativos se han introducido; el programa para con un 0
        Scanner entrada = new Scanner(System.in);
        int numero;
        int contadorPositivos = 0;
        int contadorNegativos = 0;

        System.out.print("Introduce un número: ");
        numero = entrada.nextInt();
        while(numero!=0){
            if(numero>0){
                System.out.println("El número introducido es positivo.");
                contadorPositivos++;
            }
            else{
                System.out.println("El número introducido es negativo.");
                contadorNegativos++;
            }
            System.out.print("Introduce un número: ");
            numero = entrada.nextInt();
        }
        System.out.println("Ha introducido un 0, el programa se cierra.\n"
        +"Ha introducido un total de "+contadorPositivos+" números positivos y "
        +contadorNegativos+" números negativos antes de introducir un 0.");
        entrada.close();
    }
}