import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        //pedir números al usuario con scanner, cuando le dé a intro, paro de recoger números (1 20 5 44 28 intro->)
        /* De esta manera pedimos tantos números como quiera insertar el usuario; después los introducimos en un String[] */

        /* Saber cuántos "1", "2", "3" hay */
        Scanner entrada = new Scanner(System.in);
        System.out.print("Inserta números con espacios entre ellos: ");
        String numeros = entrada.nextLine();
        entrada.close();
        String[] numerosSplit = numeros.split(" ");
        Integer[] numerosInt = new Integer[numerosSplit.length];

        HashMap<Integer, Integer> mapa1 = new HashMap<Integer, Integer>();

        for(int i=0; i<numerosSplit.length; i++){
            numerosInt[i] = Integer.parseInt(numerosSplit[i]);
        }
        for(int i=0; i<numerosInt.length; i++){
            if(mapa1.containsKey(numerosInt[i])){ //si el mapa contiene el número de la posición actual del array
                //al mapa le damos en la clave número actual del array, el valor que tuviera + 1
                mapa1.replace(numerosInt[i], mapa1.get(numerosInt[i]) + 1);
            }
            //la primera vez que se encuentre este número, entra aquí para añadirlo 1 vez
            else{
                mapa1.put(numerosInt[i], 1);
            }
        }
        //entrySet devuelve el conjunto clave=valor que contenga el mapa
        System.out.println(mapa1);
    }
}