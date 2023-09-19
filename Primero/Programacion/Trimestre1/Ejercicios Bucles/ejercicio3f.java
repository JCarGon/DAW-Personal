public class ejercicio3f {
    public static void main(String[] args) {
        /*Realizar un triángulo equilátero
              * (línea 1)
            * * * (línea 3)
          * * * * * (línea 5)
        * * * * * * * (línea 7)
        */
        /* Bucle para que recorra las líneas; al tratar con números impares serán líneas 1-3-5-7 */
        for(int i=1; i<=7; i+=2){
            /* j = i para que coja el valor actual del índice que sigue las líneas y vaya pintando " " mientras sea < que 7
            (última línea donde no tiene que pintar); +=2 para que trate con números impares */
            for(int j=i; j<7; j+=2){
                System.out.print(" ");
            }
            /* bucle for para que imprima tantas veces el '*' como valor tiene el número actual -> n=1 *, n=3 *** */
            for(int k=i; k>0; k--){
                System.out.print("*");
            }
            System.out.println();//salto de línea para separar una fila de otra
        }
    }
}