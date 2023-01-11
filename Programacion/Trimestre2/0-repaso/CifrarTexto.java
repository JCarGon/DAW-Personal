public class CifrarTexto {
    /* Implementa una función que sirva para cifrar un texto con el conocido método de César. El criptosistema consiste en el desplazamiento de
    3 caracteres en la posición del carácter a cifrar, es decir, la A se sustituye por la D, la B por la E,... la X por la A, la Y por la B y la Z por la C.
    Por simplicidad, supondremos que el texto a crigrar solo contiene caracteres alfabéticos. Implementar la siguiente función:
    */

    public static String cifrarTexto(String texto){
        String textoCifrado = "";
        int aux;
        for(int i=0; i<texto.length(); i++){
            aux = texto.charAt(i);
            if(texto.charAt(i) == ' '){
                textoCifrado += " ";
            }else if(aux >= 120){
                aux -=23;
                textoCifrado += (char) aux;
            }else{
                aux += 3;
                textoCifrado += (char) aux;
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