public class SumaFyC {
    public static void main(String[] args) {
        int[][] matrizA = new int[10][10];
        int sumaFila = 0;
        int sumaColum = 0;

        /*Rellenar la matriz con números randoms entre 0 y 9*/
        for(int i=0; i<matrizA.length; i++){
            for(int j=0; j<matrizA[i].length; j++){
                matrizA[i][j]= (int) (Math.random()*10);
            }
        }

        /*Mostrar la matriz*/
        System.out.println("La matriz generada es: ");
        for(int i=0; i<matrizA.length; i++){
            for(int j=0; j<matrizA[i].length; j++){
                System.out.print(matrizA[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();//salto de línea para separar la matriz de los resultados de la suma

        /*Sumar filas y columnas*/
        for(int i=0; i<matrizA.length; i++){
            for(int j=0; j<matrizA[i].length; j++){
                sumaFila += matrizA[i][j]; //suma iterativa de los números de la fila
            }
            System.out.println("La suma de la fila "+(i+1)+" es: "+sumaFila+".");
            sumaFila = 0;

            for(int j=0; j<matrizA[i].length; j++){
                sumaColum += matrizA[j][i]; //suma iterativa de los números de la columna
            }
            System.out.println("La suma de la columna "+(i+1)+" es: "+sumaColum+".");
            sumaColum = 0;
        }
    }
}