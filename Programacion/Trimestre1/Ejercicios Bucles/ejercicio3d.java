public class ejercicio3d {
    public static void main(String[] args) {
        /*Imprimir '*' tantas veces como indica el valor de la posición actual*/
        for(int i=1; i<=5; i++){//bucle for para que recorra las posiciones del 1 al 5 (por ejemplo)
            for(int j=1; j<=i; j++){//bucle for para que imprima tantas veces el '*' como valor tiene el número actual -> n=1 -- *, n=2 -- **
                System.out.print("*"+" ");
            }
            System.out.println();//salto de línea para separar una fila de otra
        }
    }
}