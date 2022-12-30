public class Bidimensional {
    public static void main(String[] args) {
        String[] array1 = {"0","1","2","3","4"};
        String[] array2 = {"0","1","2","3","4"};

        /*Cómo hacer un eje de coordenadas
         -pedir coordenada X e Y
         -después del primer for, meter un if(x.equals(array1[i])) entro en el siguiente for
         -dentro del segundo for, meter un if(y.equals(array2[j])) entro dentro del for
        */
        for(int i=0; i<array1.length; i++){
            for(int j=0; j<array2.length; j++){
                System.out.print(array1[i]+","+array2[j]+" ");
            }
            System.out.println();
        }
    }
}