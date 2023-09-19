package lectura;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        /*Crea un programa que muestre el contenido de un fichero de texto, cuyo nombre deberá introducir el usuario. Debe avisar si el fichero no existe.*/
        Scanner entrada = new Scanner(System.in);
        System.out.print("Inserte un nombre para buscar si existe algún fichero con ese nombre: ");
        String nombreFichero = entrada.nextLine();
        String ruta = "C:\\Users\\jesus\\Documents\\GitHub\\DAW-Personal\\Programacion\\Trimestre3\\1-ficheros\\";
        ruta += nombreFichero;
        File fichero = new File(ruta);
        int cont = 0;
        if(fichero.exists()){
            try {
                Scanner lector = new Scanner(fichero);
                while(lector.hasNextLine()){
                    cont += 1;
                    String linea = lector.nextLine();
                    System.out.println(cont +"\t"+ linea);
                }
                lector.close();
            } catch (FileNotFoundException e) {
                System.out.println(e);
            }
        }else{
            System.out.println("El fichero no existe.");
        }
        entrada.close();
    }
}