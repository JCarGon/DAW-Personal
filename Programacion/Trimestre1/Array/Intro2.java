import java.util.Scanner;

public class Intro2 {
    public static void main(String[] args) {
        /*Hacer media de positivos, de negativos y contador de 0*/
        Scanner entrada = new Scanner(System.in);
        int[] numeros = new int[10];
        int contadorCero = 0;
        int sumaPositivo = 0;
        int contadorPositivo = 0;
        double mediaPositivo = 0;
        int sumaNegativo = 0;
        int contadorNegativo = 0;
        double mediaNegativo = 0;

        for(int i=0; i<numeros.length; i++){
            System.out.print("Introduce un valor para la posición "+i+": ");
            numeros[i] = entrada.nextInt();

            if(numeros[i] == 0){
                contadorCero++;
            }
            else if(numeros[i]>0){
                contadorPositivo++;
                sumaPositivo += numeros[i];
            }
            else{
                contadorNegativo++;
                sumaNegativo += numeros[i];
            }
        }
        entrada.close();
        if(contadorPositivo>0){
            mediaPositivo = (double) sumaPositivo/contadorPositivo;
        }
        if(contadorNegativo>0){
            mediaNegativo = (double) sumaNegativo/contadorNegativo;
        }
        System.out.println("Has insertado "+contadorCero+" ceros.\n"
        +"La media de los números positivos es: "+mediaPositivo+".\n"
        +"La media de los números negativos es: "+Math.abs(mediaNegativo)+".\n");
    }
}