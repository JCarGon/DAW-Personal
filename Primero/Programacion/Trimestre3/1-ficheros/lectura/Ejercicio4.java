package lectura;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ejercicio4{
    public static void main(String[] args) {
        File fichero = new File("C:\\Users\\jesus\\Documents\\GitHub\\DAW-Personal\\Programacion\\Trimestre3\\1-ficheros\\Matriz.txt");
        try {
            Scanner lector = new Scanner(fichero);
            while(lector.hasNextLine()){ //responde sí-no a si tiene siguiente línea
                //guardamos en un aray de string la primera línea del documento, que son los dos valores (fila y columna)
                String[] linea = lector.nextLine().split(" ");
                //la posición 0 la guardamos en un int filas
                int filas = Integer.parseInt(linea[0]);
                //la posición 1 del array la guardamos en un int columnas
                int columnas = Integer.parseInt(linea[1]);
                //asignamos dichos valores a la matriz
                int[][] matriz = new int[filas][columnas];
                //recorremos la matriz para insertar cada valor en la posición que le corresponde
                for(int i=0; i<filas; i++){
                    //guardamos la primera fila en un array de valores
                    String[] valores = lector.nextLine().split(" ");
                    for(int j=0; j<columnas; j++){
                        //asignamos cada posición del array valores a su posición correspondiente de la matriz
                        matriz[i][j] = Integer.parseInt(valores[j]);
                    }
                }
                //representar la matriz por consola
                for(int i=0; i< filas; i++){
                    for(int j=0; j<columnas; j++){
                        System.out.print(matriz[i][j]+"-");
                    }
                    System.out.println();
                }
            }
            lector.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        /* PARA HACERLO CON BUFFEREDREADER
        int i = 0;
        while((linea=bf.readLine()) != null){
            String[] valores = linea.split(" ");
            for(int j=0; j<columnas; j++){
                matriz[i][j] = Integer.ParseInt(valores[j]);
            }
            i++;
        }
        */
    }
}