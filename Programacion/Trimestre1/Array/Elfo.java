import java.io.FileNotFoundException;
import java.io.IOException;
import Utilidades.*;

/* Encontrar al elfo que lleva más calorías y decir cuántas lleva (sumatorio de las calorías que lleva cada elfo de manera individual y compararlo con el siguiente:
    *si es mayor que el siguiente -> me quedo con el valor actual;
    *si es menor que el siguiente -> lo sustituyo por el valor siguiente) */

/* PARTE 2: encontrar al 2o y 3er elfo con más calorías y sumar las 3 cantidades mayores para saber cuántas llevan en total */
public class Elfo{
    public static void main(String[] args) throws FileNotFoundException, IOException{
        String[] numeros = Utils.LeerFichero("C:\\Users\\jesus\\Desktop\\day1.txt"); //se pone la barra doble '\\' para que coja la ruta
        int acumulacionElfo1 = 0;
        int acumulacionElfo2 = 0;
        int acumulacionElfo3 = 0;
        int caloriasTotalElfo1 = 0;
        int caloriasTotalElfo2 = 0;
        int caloriasTotalElfo3 = 0;
        int caloriasTotal = 0;

        for(int i=0; i<numeros.length; i++){ //elfo con más calorías
            if(!numeros[i].equals("")){
                /* PARA USAR numeros.compareTo(""):
                    0 = son iguales;
                    < 0 el primero es mayor que el segundo;
                    > 0 el segundo es mayor que el primero
                */
                acumulacionElfo1 += Integer.parseInt(numeros[i]);
            }else{
                if(acumulacionElfo1 > caloriasTotalElfo1){
                    caloriasTotalElfo1 = acumulacionElfo1;
                }
                acumulacionElfo1 = 0;
            }
        }

        for(int i=0; i<numeros.length; i++){ //buscar el segundo con más calorías
            if(!numeros[i].equals("")){
                acumulacionElfo2 += Integer.parseInt(numeros[i]);
            }else{
                if((acumulacionElfo2 > caloriasTotalElfo2) && (acumulacionElfo2 < caloriasTotalElfo1)){
                    caloriasTotalElfo2 = acumulacionElfo2;
                }
                acumulacionElfo2 = 0;
            }
        }

        for(int i=0; i<numeros.length; i++){ //buscar el tercero con más calorías
            if(!numeros[i].equals("")){
                acumulacionElfo3 += Integer.parseInt(numeros[i]);
            }else{
                if((acumulacionElfo3 > caloriasTotalElfo3) && (acumulacionElfo3 < caloriasTotalElfo2)){
                    caloriasTotalElfo3 = acumulacionElfo3;
                }
                acumulacionElfo3 = 0;
            }
        }
        
        caloriasTotal = caloriasTotalElfo1+caloriasTotalElfo2+caloriasTotalElfo3;
        System.out.println("El elfo que lleva más calorías lleva un total de: "+caloriasTotalElfo1);
        System.out.println("El segundo elfo que lleva más calorías lleva un total de: "+caloriasTotalElfo2);
        System.out.println("El tercer elfo que lleva más calorías lleva un total de: "+caloriasTotalElfo3);
        System.out.println("La suma de las calorías de los 3 elfos es: "+caloriasTotal);
    }
}