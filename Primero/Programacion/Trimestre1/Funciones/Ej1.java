import java.util.Scanner;

public class Ej1 {
    
    /* Ejercicio 1: función que recibe dos números y que te diga cuál es el más grande de los dos */
    public static int numeroMayor(int a, int b){
        int resultado;
        if(a>b){
            resultado = a;
        }
        else{
            resultado = b;
        }
        return resultado;
    }

    /* Pasar de dóalres a euros 1 dólar = 0.97€*/
    public static double conversor(double a){
        double resultado;
        resultado = (a*0.97);
        return resultado;
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        // int numero1;
        // int numero2;
        
        // System.out.print("Introduce un valor para el número 1: ");
        // numero1 = entrada.nextInt();
        // System.out.print("Introduce un valor para el número 2: ");
        // numero2 = entrada.nextInt();
        
        // System.out.println("El números mayor es: "+numeroMayor(numero1, numero2));
        
        double numero3;
        System.out.print("Introduce la cantidad de dólares a convertir a euros: ");
        numero3 = entrada.nextDouble();
        System.out.println(numero3+" dólares son: "+conversor(numero3)+" euros.");

        entrada.close();
    }
}