public class ejercicio3e {
    public static void main(String[] args) {
        /*Imprimir '*' en orden inverso tantas veces como indica el valor de la posición actual*/
        /* Bucle for para que recorra las posiciones del 5 al 1 (por ejemplo) -> solo hay que invertir el orden del ejercicio anterior */
        for(int i=5; i>=1; i--){
            for(int j=1; j<=i; j++){//bucle for para que imprima tantas veces el '*' como valor tiene el número actual -> n=1 -- *, n=2 -- **
                System.out.print("*"+" ");
            }
            System.out.println();//salto de línea para separar una fila de otra
        }
    }
}