public class Bordes1 {
    public static void main(String[] args) {
        /*Pintar los bordes como 1 y el interior como 0 en una matriz 7x7*/
        int[][] tabla = new int[7][7]; //las coordenadas son [y][x]

        for(int i=0; i<tabla.length; i++){
            for(int j=0; j<tabla[i].length; j++){
                if(i==0 || i==tabla.length-1 || j==0 || j==tabla[i].length-1){
                    tabla[i][j] = 1;
                }
                else{
                    tabla[i][j] = 0;
                }
            }
        }
        for(int i=0; i<tabla.length; i++){
            for(int j=0; j<tabla[i].length; j++){
                System.out.print(tabla[i][j]+" ");
            }
            System.out.println();
        }
    }
}