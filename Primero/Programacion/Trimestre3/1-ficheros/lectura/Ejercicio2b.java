package lectura;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ejercicio2b {
    public static void main(String[] args) {
    /* Programa que imprima las 3 primeras y 3 últimas líneas */
        File fichero = new File("C:\\Users\\jesus\\Documents\\GitHub\\DAW-Personal\\Programacion\\Trimestre3\\1-ficheros\\fichero.txt");
        Scanner entrada = new Scanner(System.in);
        System.out.print("¿Cuántas líneas quiere imprimir? (ej: 2 primeras y 2 últimas): ");
        int imprimir = entrada.nextInt();
        int cont = 0;
        int numeroLineas = 0;
        try {
            Scanner lector = new Scanner(fichero);
            while(lector.hasNextLine()){ //contador de líneas del fichero
                lector.nextLine();
                numeroLineas += 1;
            }
            lector = new Scanner(fichero);
            while(lector.hasNextLine()){
                cont += 1;
                String linea = lector.nextLine();
                if((cont >= 1 && cont <= imprimir) || (cont >= (numeroLineas-(imprimir-1)) && cont <= numeroLineas)){
                /* 1er contador: desde la línea 1 hasta la línea del número introducido
                 * 2do contador: desde número total de líneas - (líneas que quiero mostrar-1) hasta la última línea
                */
                    System.out.println(cont +"\t"+ linea);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        entrada.close();
    }
}