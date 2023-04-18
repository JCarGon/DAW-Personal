package lectura;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio5{
    public static void main(String[] args) {
/* Programa que codifique/decodifique un texto en ASCII y guarde en el fichero el texto codificado en numérico. Mostrará por consola el contenido en texto. */
        
        //Encode
        Scanner entrada = new Scanner(System.in);
        System.out.print("Escriba la frase secreta: ");
        String texto = entrada.nextLine();

        try {
            FileWriter fw = new FileWriter("secret.txt");
            for(int i=0; i<texto.length(); i++){
                fw.write((int)texto.charAt(i)+" ");
            }
            fw.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        //Decode
        File file = new File("secret.txt");
        Scanner fr;
        try{
            fr = new Scanner(file);
            String decodeText = "";
            while(fr.hasNextInt()){
                decodeText += (char) fr.nextInt();
            }
            System.out.println(decodeText);
        }catch(FileNotFoundException ex){
            System.out.println(ex);
        }
        entrada.close();
    }
}