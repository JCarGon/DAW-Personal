package lectura;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ejercicio2a {
    public static void main(String[] args) {
    /* Programa que imprima la primera y última línea de un fichero. Igual con las 3 primeras y 3 últimas líneas */
        File fichero = new File("C:\\Users\\jesus\\Documents\\GitHub\\DAW-Personal\\Programacion\\Trimestre3\\1-ficheros\\fichero.txt");
        int cont = 0;
        try {
            Scanner lector = new Scanner(fichero);
            cont += 1; //si la tiene suma 1 al contador
            String linea = lector.nextLine();
            System.out.println(cont +"\t"+ linea); //primera línea

            while(lector.hasNextLine()){ //responde sí-no a si tiene siguiente línea
                cont += 1; //si la tiene suma 1 al contador
                linea = lector.nextLine();
            }
            System.out.println(cont +"\t"+ linea); //última línea
            lector.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
}