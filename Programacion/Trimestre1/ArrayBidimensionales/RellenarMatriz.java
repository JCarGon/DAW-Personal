public class RellenarMatriz {
    public static void main(String[] args) {
        int[][] matrizA = new int[7][7];

        for(int i=0; i<matrizA.length; i++){
            for(int j=0; j<matrizA[i].length; j++){
                if(i==j){
                    matrizA[i][j] = 1;
                }
                else{
                    matrizA[i][j] = 0;
                }
            }
        }
        System.out.println("La matriz resultante sería: ");
        for(int i=0; i<matrizA.length; i++){
            for(int j=0; j<matrizA[i].length; j++){
                System.out.print(matrizA[i][j]+" ");
            }
            System.out.println();
        }
    }
}