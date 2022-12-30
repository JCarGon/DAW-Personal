public class Pr2 {
    public static void main(String[] args) {
        /*Suma de matrices*/
        int[][] arrA = {{1,2,3},{4,4,4},{9,0,9}};
        int[][] arrB = {{3,2,1},{0,-3,7},{1,2,3}};
        int[][] arrC = new int[arrA.length][arrA[0].length];

        for(int i=0; i<arrA.length; i++){
            for(int j=0; j<arrA[i].length; j++){
                arrC[i][j] = arrA[i][j] + arrB[i][j];
                System.out.print(arrC[i][j]+" ");
            }
            System.out.println();
        }
    }
}