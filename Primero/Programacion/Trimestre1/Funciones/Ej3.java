import java.util.Scanner;

public class Ej3 {

    /* Función que obtenga la suma de los números de hasta N. Se debe pasar como parámetro el número N */
    public static int sumaN(int n){
        int resultado = 0;
        for(int i=1; i<=n; i++){
            resultado += i;
        }
        return resultado;
    }
    /* RECURSIVIDAD:
     * Para cuando el número llega al último (que es el introducido) si empieza por el principio
     * cuando el número llega a 1, si empieza por el final (número introducido) 
     * Es conveniente utilizar la recursividad cuando no sé cuándo voy a salir */
    public static int suma(int n){
        if(n == 1){
            return 1; //Caso base: cuando "n" llega aquí, para
        }
        else{
            return n+suma(n-1); //llamar a la función dentro de la operación de la misma función
        }
    }
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Introduce un número para hacer la suma desde el 1 hasta ese número: ");
        int numero = entrada.nextInt();
        System.out.println("La suma del 1 al "+numero+" es: "+suma(numero));
        entrada.close();
    }
}