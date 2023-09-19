public class ejercicio3c {
    public static void main(String[] args) {
        /*Imprimir el número de fila tantas veces como su valor indica*/
        for(int i=1; i<=5; i++){//bucle for para que recorra los números del 1 al 5 (por ejemplo)
            for(int j=1; j<=i; j++){//bucle for para que imprima tantas veces el número actual como valor tiene
                System.out.print(i+" ");
            }
            System.out.println();//salto de línea para separar una fila de otra
        }
    }
}