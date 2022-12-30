public class Pr3 {
    public static void main(String[] args) {
        /*Comparar si las dos matrices son simétricas*/
        int[][] arrA = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] arrB = {{1,4,7},{2,5,8},{3,6,9}};
        boolean simetrica = true;

        for(int i=0; i<arrA.length && simetrica; i++){
            for(int j=0; j<arrA[i].length; j++){
                if(arrA[i][j] != arrB[j][i]){
                    simetrica = false;
                    //break;
                }
            }
        }
        if(simetrica == true){
            System.out.print("Las matrices son simétricas.");
        }
        else{
            System.out.println("Las matrices NO son simétricas.");
        }
    }
}