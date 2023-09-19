import java.util.Scanner;

public class Calculardni {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int dni;
        int resto;
        int i;
        /*Creamos un array en el que guardamos las letras del abecedario por posiciones*/
        char[] letras = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};

        System.out.print("Escribe tu número de DNI completo sin letra para calcularla: ");
        dni = entrada.nextInt();
        entrada.close();

        /*Calculamos el resto de la división entre el número de DNI y 23*/
        resto=dni%23;

        /*Con un bucle for recorremos el array buscando la coincidencia de la posición con el resto*/
        for(i=0;i<=letras.length;i++){
            if(i==resto){
                System.out.println("La letra del DNI es: " +letras[i]);
            }
        }
    }
}