import java.util.Scanner;
public class Practica4 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        /*1. Rotar un array lleno de extensión 10*/
        int[] numeros = {1,2,3,4,5,6,7,8,9,10};
        int valorFinal = 0;

        // valorFinal = numeros[numeros.length-1];
        // for(int i=numeros.length-1; i>0; i--){
        //     numeros[i] = numeros[i-1];
        // }
        // numeros[0] = valorFinal;
        // for(int i=0; i<numeros.length; i++){
        //     System.out.print(numeros[i]+", ");
        // }

        /*rotar N veces (bucle)*/
        System.out.print("¿Cuántas vueltas quiere dar el usuario?: ");
        int numeroVueltas = entrada.nextInt();
        int contadorVueltas = 1;

        while(contadorVueltas<=numeroVueltas){
            valorFinal = numeros[numeros.length-1];
            for(int i=numeros.length-1; i>0; i--){
                numeros[i] = numeros[i-1];
            }
            numeros[0] = valorFinal;
            System.out.print("Vuelta "+contadorVueltas+": ");
            for(int i=0; i<numeros.length; i++){
                System.out.print(numeros[i]+", ");
            }
            System.out.println();
            contadorVueltas++;
        }
        entrada.close();
    }
}