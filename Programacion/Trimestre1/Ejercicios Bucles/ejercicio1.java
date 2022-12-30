import java.util.Scanner;
public class ejercicio1 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int numeroInicio, numeroFin;
        int resultado = 1;

        System.out.print("Escribe un número 'N': ");
        numeroInicio = entrada.nextInt();
        System.out.print("Escribe un número 'M': ");
        numeroFin = entrada.nextInt();
        entrada.close();

        /*Si el númeroInicio es menor que el numeroFin, entramos en este if*/
        if(numeroInicio<numeroFin){
            while(numeroInicio<=numeroFin){ //mientras numeroInicio<=numeroFin
                for(int i=numeroInicio;i>1;i--){//Bucle que coge el númeroInicio para trabajar con su valor y hacer su factorial
                    resultado = resultado * i;
                }
                System.out.println("El factorial del número "+numeroInicio+" es: "+resultado);
                numeroInicio++;//aumentamos en 1 el numeroInicio para hacer el factorial del siguiente
                resultado = 1;//reseteamos el resultado a 1 para el cálculo del siguiente factorial
            }
        }
        else{//caso contrario, es decir, que numeroFin<numeroInicio
            while(numeroFin<=numeroInicio){
                for(int i=numeroFin;i>1;i--){
                    resultado = resultado * i;
                }
                System.out.println("El factorial del número "+numeroFin+" es: "+resultado);
                numeroFin++;
                resultado = 1;
            }
        }
    }
}