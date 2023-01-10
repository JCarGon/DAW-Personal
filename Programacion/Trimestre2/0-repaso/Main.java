import java.util.Arrays;

public class Main{
    public static boolean superaCarrera(String[] array, String pista){
        boolean comprobacion = true;
        String palabra;
        String pistaFinal = "";
        char letra;
        for(int i=0; i<array.length; i++){
            palabra = array[i];
            letra = pista.charAt(i);
            if(palabra.equals("run")){
                if(letra == '|'){
                    pistaFinal += "x";
                    comprobacion = false;
                }else{
                    pistaFinal += "_";
                }
            }else if(palabra.equals("jump")){
                if(letra == '_'){
                    pistaFinal += "/";
                    comprobacion = false;
                }else{
                    pistaFinal += "|";
                }
            }
        }
        System.out.println(pistaFinal);
        return comprobacion;
    }
    /* Función que convierta String a char[] */
    public static char[] PalabraToChar(String palabra){
        char[] letras = new char[palabra.length()];
        for(int i=0; i<palabra.length(); i++){
            letras[i] = palabra.charAt(i);
        }
        return letras;
    }

    /* Función que cuente cuantas veces está un char en un String */
    public static int VecesCharEnString(String palabra, char letra){
        int numeroVeces = 0;
        for(int i=0; i<palabra.length(); i++){
            if(palabra.charAt(i) == letra){
                numeroVeces++;
            }
        }
        return numeroVeces;
    }

    /* Función que le pase un array de char y cuente cuantas veces están las letras en un String (total) -> hola, {h, j, a} -- devuelve 2 en total (1 h, 1 a) */

    /* Función que le pase un array de char y cuente cuántas veces está cada letra en un String -> hola, {h, j, a} -- devuelve 1 h, 1 a */


    public static void main(String[] args) {
        String[] carrera1 = {"run", "run", "run", "run", "run",};
        String pista1 = "|____";
        boolean resultado1 = superaCarrera(carrera1, pista1); // true
        System.out.println("El resultado de la prueba 1 es: " +resultado1);

        String[] carrera2 = {"run", "run", "jump", "run", "run",};
        String pista2 = "_____";
        boolean resultado2 = superaCarrera(carrera2, pista2); // false
        System.out.println("El resultado de la prueba 2 es: " +resultado2);

        String[] carrera3 = {"run", "jump", "run", "jump", "run",};
        String pista3 = "_|_|_";
        boolean resultado3 = superaCarrera(carrera3, pista3); // true
        System.out.println("El resultado de la prueba 3 es: " +resultado3);

        String palabra = "agua";
        char[] letras = PalabraToChar(palabra);
        System.out.println(Arrays.toString(letras));

        String palabra1 = "bendicion";
        System.out.println(VecesCharEnString(palabra1, 'i'));
    }
}