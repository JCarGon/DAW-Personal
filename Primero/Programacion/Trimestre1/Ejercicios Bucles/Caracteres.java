import java.util.Scanner;

public class Caracteres {
    public static void main(String[] args) {
        /*Algoritmo que pida caracteres e imprima 'VOCAL' si son vocales y 'NO VOCAL' en caso contrario. El programa termina cuando se introduce un espacio.*/        
        Scanner entrada = new Scanner(System.in);
        String caracterIntroducido; //Trabajamos con un String

        System.out.print("Introduzca un caracter para comprobar si es vocal o no: ");
        caracterIntroducido = entrada.nextLine();
        while(!caracterIntroducido.equals(" ")){ //que igualamos a espacio y con la '!' del principio lo negamos para expresar !=
            char caracter = caracterIntroducido.toUpperCase().charAt(0);//el String introducimos, lo convertimos en MAYUS, nos quedamos solo la primera letra y lo guardamos en un char
            if(caracter == 'A' || caracter == 'E' || caracter == 'I' || caracter == 'O' || caracter == 'U'){
                System.out.println("VOCAL.");
            }
            else{
                System.out.println("NO VOCAL.");
            }
            System.out.print("Introduzca otro caracter: ");
            caracterIntroducido = entrada.nextLine();
        }
        if(caracterIntroducido.equals(" ")){
            System.out.println("Ha introducido un espacio. Saliendo del programa.");
        }
        entrada.close();
    }
}