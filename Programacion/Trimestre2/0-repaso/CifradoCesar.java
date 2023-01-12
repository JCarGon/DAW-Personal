public class CifradoCesar {

    public static String cifrarTexto(String texto, int N){
        String textoCifrado = "";
        String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int aux;
        for(int i=0; i<texto.length(); i++){
            for(int j=0; j<abc.length(); j++){
                if(texto.charAt(i) == abc.charAt(j)){
                    aux = i+N;
                    while(aux>=26){
                        aux -=26;
                    }
                    aux += j;
                    while(aux>=26){
                        aux -=26;
                    }
                    textoCifrado += abc.charAt(aux);
                }
            }
        }
        return textoCifrado;
    }

    public static String descifrarTexto(String texto, int N){
        String textoCifrado = "";
        String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int aux;
        for(int i=0; i<texto.length(); i++){
            for(int j=0; j<abc.length(); j++){
                if(texto.charAt(i) == abc.charAt(j)){
                    aux = j+(-i-N);
                    while(aux<0){
                        aux +=26;
                    }
                    textoCifrado += abc.charAt(aux);
                }
            }
        }
        return textoCifrado;
    }

    public static String rotor1(String texto){
        String rotor1 = "";
        String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String abcAux = "BDFHJLCPRTXVZNYEIWGAKMUSQO";
        for(int i=0; i<texto.length(); i++){
            for(int j=0; j<abc.length(); j++){
                if(texto.charAt(i) == abc.charAt(j)){
                    rotor1 += abcAux.charAt(j);
                }
            }
        }
        return rotor1;
    }

    public static String desrotor1(String texto){
        String rotor1 = "";
        String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String abcAux = "BDFHJLCPRTXVZNYEIWGAKMUSQO";
        for(int i=0; i<texto.length(); i++){
            for(int j=0; j<abcAux.length(); j++){
                if(texto.charAt(i) == abcAux.charAt(j)){
                    rotor1 += abc.charAt(j);
                }
            }
        }
        return rotor1;
    }

    public static String rotor2(String texto){
        String rotor2 = "";
        String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String abcAux = "AJDKSIRUXBLHWTMCQGZNPYFVOE";
        for(int i=0; i<texto.length(); i++){
            for(int j=0; j<abc.length(); j++){
                if(texto.charAt(i) == abc.charAt(j)){
                    rotor2 += abcAux.charAt(j);
                }
            }
        }
        return rotor2;
    }

    public static String desrotor2(String texto){
        String rotor2 = "";
        String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String abcAux = "AJDKSIRUXBLHWTMCQGZNPYFVOE";
        for(int i=0; i<texto.length(); i++){
            for(int j=0; j<abcAux.length(); j++){
                if(texto.charAt(i) == abcAux.charAt(j)){
                    rotor2 += abc.charAt(j);
                }
            }
        }
        return rotor2;
    }

    public static String rotor3(String texto){
        String rotor3 = "";
        String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String abcAux = "EKMFLGDQVZNTOWYHXUSPAIBRCJ";
        for(int i=0; i<texto.length(); i++){
            for(int j=0; j<abc.length(); j++){
                if(texto.charAt(i) == abc.charAt(j)){
                    rotor3 += abcAux.charAt(j);
                }
            }
        }
        return rotor3;
    }

    public static String desrotor3(String texto){
        String rotor3 = "";
        String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String abcAux = "EKMFLGDQVZNTOWYHXUSPAIBRCJ";
        for(int i=0; i<texto.length(); i++){
            for(int j=0; j<abcAux.length(); j++){
                if(texto.charAt(i) == abcAux.charAt(j)){
                    rotor3 += abc.charAt(j);
                }
            }
        }
        return rotor3;
    }

    public static void main(String[] args) {
        String texto = cifrarTexto("EVERYBODYISWELCOMEHERE", 4);
        System.out.println("Cifrado: "+texto);
        texto = rotor1(texto);
        System.out.println("Rotor 1: "+texto);
        texto = rotor2(texto);
        System.out.println("Rotor 2: "+texto);
        texto = rotor3(texto);
        System.out.println("Rotor 3: "+texto);

        //String texto = desrotor3("XPCXAUPHYQALKJMGKRWPGYHFTKRFFFNOUTZCABUAEHQLGXREZ");
        texto = desrotor3(texto);
        System.out.println("Desrotor 3: "+texto);
        texto = desrotor2(texto);
        System.out.println("Desrotor 2: "+texto);
        texto = desrotor1(texto);
        System.out.println("Desrotor 1: "+texto);
        System.out.println("Descifrado: "+descifrarTexto(texto, 4));
    }
}