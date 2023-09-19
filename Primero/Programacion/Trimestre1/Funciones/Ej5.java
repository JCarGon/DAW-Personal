import java.util.Arrays;

public class Ej5 {
    /* Función que devuelva el doble de un número N */
    public static int doble(int n){
        return 2*n;
    }

    /* Función que devuelva la potencia(X) de un número N */
    public static int potencia(int base, int exponente){
        return (int) Math.pow(base, exponente);
    }
    
    /* Función que reciba un array y un N
     * se guarda N en posición 0
     * se rotan los números del array
     * se devuelve el número que sale
     * indicar posición donde guardar nuevo N */

    public static int guardarNenArray(int[] arr, int n, int posicion){
        int numeroPerdido = arr[arr.length-1];
        for(int i=arr.length-1; i>posicion; i--){
            arr[i] = arr[i-1];
        }
        arr[posicion] = n;
        return numeroPerdido;
    }
    public static void main(String[] args) {
        int[]arr = {1, 2, 3, 4, 5, 6};
        int numeroPerdido = guardarNenArray(arr, 55, 2); //guardamos en la variable el return de la función, que es el número que se pierde
        System.out.println("El número que se pierde es: "+numeroPerdido+"."); //lo muestro por pantalla
        System.out.println(Arrays.toString(arr)); //muestro por pantalla el array que se me queda
    }
}