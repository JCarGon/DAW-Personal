import java.util.Arrays;

public class Ej6 {
    /* PUSH: añadir un N a un array en última posición
     * pasar múltiples argumentos */
    public static void push(int[] arr, int n){
        int[] arrB = new int[arr.length+1];
        for(int i=0; i<arr.length; i++){
            arrB[i] = arr[i];
        }
        arrB[arrB.length-1] = n;
        System.out.println(Arrays.toString(arrB));
    }

    /* POP: función que elimine el último elemento y lo devuelva */
    public static int pop(int arr[]){
        int arrB[] = new int[arr.length-1];
        int numeroPerdido = arr[arr.length-1];
        for(int i=0; i<arrB.length; i++){
            arrB[i] = arr[i];
        }
        return numeroPerdido;
    }

    /* SHIFT: función que elimine el primer elemento y lo devuelva */
    public static int shift(int arr[]){
        int arrB[] = new int[arr.length-1];
        int numeroPerdido = arr[0];
        for(int i=0; i<arrB.length; i++){
            arrB[i] = arr[i+1];
        }
        return numeroPerdido;
    }
    /* UNSHIFT: Función que añada un número en el inicio */
    public static void unshift(int arr[], int n){
        int arrB[] = new int[arr.length+1];
        for(int i=0; i<arrB.length-1; i++){
            arrB[i+1] = arr[i];
        }
        arrB[0] = n;
        System.out.println("El nuevo array es: "+Arrays.toString(arrB));
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        push(arr, 55);

        int numeroPerdido1 = pop(arr);
        System.out.println("El número que se pierde es: "+numeroPerdido1+".");

        int numeroPerdido2 = shift(arr);
        System.out.println("El número que se pierde es: "+numeroPerdido2+".");
        
        unshift(arr, 55);
    }
}