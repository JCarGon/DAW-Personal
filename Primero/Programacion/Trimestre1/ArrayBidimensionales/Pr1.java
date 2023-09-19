public class Pr1 {
    public static void main(String[] args) {
        /*Representación de array bidimensional
        int[][] arrB = new int[y][x];*/
        int[][] arrB = {{1,2,3,4},{1,2,3,4},{1,2,3,4}};

        for(int i=0; i<arrB.length; i++){
            for(int j=0; j<arrB[i].length; j++){
                System.out.print(i);
                System.out.print(arrB[i][j]+" ");
            }
            System.out.println();
        }
    }
}