import java.util.Arrays;

public class FuncionesLetras {
        /* Función que convierta String a char[] */
        public static char[] PalabraToChar(String palabra){
            char[] letras = new char[palabra.length()];
            for(int i=0; i<palabra.length(); i++){
                letras[i] = palabra.charAt(i);
            }
            return letras;
        }
    
        /* Función que cuente cuántas veces está un char en un String */
        public static int VecesCharEnString(String palabra, char letra){
            int numeroVeces = 0;
            for(int i=0; i<palabra.length(); i++){
                if(palabra.charAt(i) == letra){
                    numeroVeces++;
                }
            }
            System.out.print("Número de veces que está el caracter "+letra+" en la palabra "+palabra+": ");
            return numeroVeces;
        }
    
        /* Función que le pase un array de char y cuente cuantas veces están las letras en un String (total) -> hola, {h, j, a} -- devuelve 2 en total (1 h, 1 a) */
        public static int VecesCharEnString(String palabra, char[] letras){
            int numeroVeces = 0;
            for(int i=0; i<palabra.length(); i++){
                for(int j=0; j<letras.length; j++){
                    if(palabra.charAt(i) == letras[j]){
                        numeroVeces++;
                    }
                }
            }
            System.out.print("Número de veces que los caracteres "+Arrays.toString(letras)+" están en la palabra "+palabra+": ");
            return numeroVeces;
        }
        /* Función que le pase un array de char y cuente cuántas veces está cada letra en un String -> hola, {h, j, a} -- devuelve 1 h, 1 a */
    
        public static void main(String[] args) {
            String palabra = "agua";
            char[] letras = PalabraToChar(palabra);
            System.out.println(Arrays.toString(letras)+"\n");
            
            String palabra1 = "patata";
            System.out.println(VecesCharEnString(palabra1, 'a')+"\n");
            
            char[] letras2 = {'n', 'i'};
            String palabra2 = "bendicion";
            System.out.println(VecesCharEnString(palabra2, letras2)+"\n");
        }
}