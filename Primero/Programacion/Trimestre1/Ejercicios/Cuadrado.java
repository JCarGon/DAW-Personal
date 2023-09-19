/* Hacer un programa que dibuje un cuadrado de n elementos de lado utilizando "*" */
import java.util.Scanner;

public class Cuadrado {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String asterisco = "* ";//la base de lo que va a imprimir
        String asteriscoFinal = ""; //lo que va a imprimir finalmente
        int nAsterisco = 0;//Contador para los asteriscos que comienza en 0, que son los asteriscos que contiene la variable asteriscoFinal
        int n;//variable donde vamos a guardar el número que introduce el usuario para los lados
        System.out.print("Cuánto quiere que valga el lado N: ");
        n = entrada.nextInt();
        entrada.close();

        while(nAsterisco<n){//mientras que nAsterisco (0) sea menor que n (número introducido por el usuario)
            asteriscoFinal += asterisco;//Dentro de asteriscoFinal (que está vacío) va a ir sumando cada vez que entre "* ", añadiendo un asterisco a los que ya hubiera
            nAsterisco++;//sumamos 1 a la variable nAsterisco cada vez que entremos
        }

        nAsterisco = 0;//restablecemos a 0 la variable para volver a usarla en un nuevo bucle while

        System.out.println("Lado del cuadrado: "+n);
        while(nAsterisco<n){//mientras que nAsterisco (0) sea menor que n (número introducido por el usuario)
            System.out.println(asteriscoFinal);//que pinte por pantalla asteriscoFinal, que será una línea de "n" asteriscos cada vez que entre
            nAsterisco++;//sumamos 1 a la variable nAsterisco cada vez que entremos
        }
    }
}