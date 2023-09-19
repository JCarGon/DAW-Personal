import java.util.Scanner;

public class VocalNoVocal {
    /* Programa que pide caracteres e imprime 'VOCAL' si son vocales y 'NO VOCAL' en caso contrario. Para cuando se inserta un espacio. */
    public static Scanner entrada = new Scanner(System.in);

    public static char LeerCaracter(){
        char letra;
        System.out.print("Introduce una letra: ");
        letra = entrada.nextLine().charAt(0);
        return letra;
    }

    public static boolean VocaloNo(char letra){
        boolean bandera = true;
        if(letra != 'A' && letra != 'E' && letra != 'I' && letra != 'O' && letra != 'U' && letra != 'a' && letra != 'e' && letra != 'i' && letra != 'o' && letra != 'u'){
            bandera = false;
        }
        return bandera;
    }
    
    public static void main(String[] args) {
        char letra;
        do{
            letra = LeerCaracter();
            boolean comprobacion = VocaloNo(letra);
            if(comprobacion){
                System.out.println("VOCAL");
            }else{
                System.out.println("NO VOCAL");
            }
        }while(letra != ' ');
    }
}