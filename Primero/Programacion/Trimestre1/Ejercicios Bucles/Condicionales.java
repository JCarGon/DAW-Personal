import java.util.Scanner;

public class Condicionales {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String respuesta;

        System.out.print("¿Sabes de qué hablamos? si/no: ");
        respuesta=entrada.nextLine();
        if(respuesta.toUpperCase().equals("SI")){
            System.out.print("El programa termina.");
        }
        else{//no sé de qué hablamos
            while(!respuesta.toUpperCase().equals("SI")){
                System.out.print("¿Te quieres informar? si/no: ");
                respuesta = entrada.nextLine();
            }
            System.out.print("¿Lo has entendido? si/no: ");
            respuesta = entrada.nextLine();
            if(respuesta.toUpperCase().equals("SI")){
                System.out.print("El programa termina.");
            }
            else{
                while(!respuesta.toUpperCase().equals("SI")){
                System.out.print("¿Lo has entendido? si/no: ");
                respuesta = entrada.nextLine();
                }
                System.out.print("El programa termina.");
            }
        }
        entrada.close();
    }
}