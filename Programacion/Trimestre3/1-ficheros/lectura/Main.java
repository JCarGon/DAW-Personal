package lectura;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File fichero = new File("C:\\Users\\jesus\\Documents\\GitHub\\DAW-Personal\\Programacion\\Trimestre3\\1-ficheros\\fichero.txt");
        int cont = 0;
        try {
            Scanner lector = new Scanner(fichero);
            while(lector.hasNextLine()){ //responde sí-no a si tiene siguiente línea
                cont += 1; //si la tiene suma 1 al contador
                String linea = lector.nextLine(); //guarda esa línea en el string linea
                System.out.println(cont +"\t"+ linea); //saca por pantalla el contador actual y el contenido de la línea que ha leído
            }
            lector.close();
        } catch (FileNotFoundException e) {
            System.out.println(e); //si no encuentra la ruta del archivo, salta este error
        }
    }
}