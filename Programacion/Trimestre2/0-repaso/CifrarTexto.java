/* Implementa una función que sirva para cifrar un texto con el conocido método de César. El criptosistema consiste en el desplazamiento de
3 caracteres en la posición del carácter a cifrar, es decir, la A se sustituye por la D, la B por la E,... la X por la A, la Y por la B y la Z por la C.
Por simplicidad, supondremos que el texto a crigrar solo contiene caracteres alfabéticos. Implementar la siguiente función: */
public class CifrarTexto {

    public static String cifrarTexto(String texto){
        String textoCifrado = "";
        int aux;
        for(int i=0; i<texto.length(); i++){
            aux = texto.charAt(i); //guardo el carácter en un entero, de manera que se guarda su valor en código ASCII
            if(texto.charAt(i) == ' '){ //si el carácter es un espacio, introduzco un espacio
                textoCifrado += " ";
            }else if(aux >= 120){ //si el carácter es mayor o igual a 120, resto 23 para que vuelva a los valores de inicio (a, b, c)
                aux -=23;
                textoCifrado += (char) aux;
            }else{
                aux += 3; //al número en código ASCII le sumo 3 para que avance 3 posiciones
                textoCifrado += (char) aux; //la variable aux (entera) le hago cast a char para que transforme ese código ASCII en letra y la sume al texto
            }
        }
        return textoCifrado;
    }

    public static String descifrarTexto(String texto){
        String textoDescifrado = "";
        int aux;
        for(int i=0; i<texto.length(); i++){
            aux = texto.charAt(i);
            if(texto.charAt(i) == ' '){
                textoDescifrado += " ";
            }else if(aux <= 99){
                aux +=23;
                textoDescifrado += (char) aux;
            }else{
                aux -= 3;
                textoDescifrado += (char) aux;
            }
        }
        return textoDescifrado;
    }

    public static void main(String[] args) {
        System.out.println(cifrarTexto("jesus hola"));
        System.out.println(descifrarTexto(cifrarTexto("jesus hola")));
    }
}