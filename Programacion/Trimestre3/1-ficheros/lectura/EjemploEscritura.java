package lectura;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EjemploEscritura {
    public static void main(String[] args) {
        /* Crear un programa que pida al usuario que introduzca frases y guarda todas ellas en un fichero de texto.
        Deberá terminar cuando el usuario introduzca "fin". */
        Scanner entrada = new Scanner(System.in);
        String texto ="";
        try {
            FileWriter fichero = new FileWriter("nuevo.txt");
            while(!texto.equals("fin")){
                System.out.print("Inserta una frase o palabra para agregar al archivo: ");
                texto = entrada.nextLine();
                fichero.write(texto + "\n");
            }
            fichero.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        entrada.close();
    }
}