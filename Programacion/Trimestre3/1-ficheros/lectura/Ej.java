package lectura;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ej {
    public static void main(String[] args) {
        try {
            //mete el contenido del fichero en un buffer (pila de información)
            BufferedReader bfA = new BufferedReader(new FileReader("C:\\Users\\jesus\\Documents\\GitHub\\DAW-Personal\\Programacion\\Trimestre3\\1-ficheros\\A.txt"));
            BufferedReader bfB = new BufferedReader(new FileReader("C:\\Users\\jesus\\Documents\\GitHub\\DAW-Personal\\Programacion\\Trimestre3\\1-ficheros\\B.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\jesus\\Documents\\GitHub\\DAW-Personal\\Programacion\\Trimestre3\\1-ficheros\\C.txt"));
            String linea = "";
            while(linea != null){
                linea = bfA.readLine();
                if(linea != null){
                    bw.write(linea + "\n");
                }
                linea = bfB.readLine();
                if(linea != null){
                    bw.write(linea + "\n");
                }
            }
            bfA.close();
            bfB.close();
            bw.close();
        } catch (IOException e) {
            System.out.println("Archivo no encontrado");
        }
    }
}