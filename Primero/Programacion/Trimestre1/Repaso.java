//import java.util.Arrays;
//import java.util.Scanner;

public class Repaso {
    public static void main(String[] args) {
        // int[] fila = new int[100];
        // double[] columna = new double[100];

        // char[][] matriz = new char[8][10];
        // for(int i=0; i<matriz.length; i++){
        //     for(int j=0; j<matriz[i].length; j++){
        //         matriz[i][j] = 'a';
        //     }
        // }
        
        /* Guardar en un array los 10 primeros números primos */
        // Scanner entrada = new Scanner(System.in);
        // int[] primos = new int[10];
        // int contadorPrimos = 0;
        // boolean primo = true;
        // int numero = 1;
        // while(contadorPrimos<10){
        //     for(int i=2; i<numero; i++){
        //         if(numero%i == 0){
        //             primo = false;
        //         }
        //     }
        //     if(primo == true){
        //         primos[contadorPrimos] = numero;
        //         contadorPrimos++;
        //     }
        //     primo = true;
        //     numero++;
        // }
        // for(int i=0; i<primos.length; i++){
        //     System.out.print(primos[i]+", ");
        // }

        /* Declarar matriz llamada pares e inicializar con 3 filas y 4 columnas cada una, todas con números pares */
        // int[][] pares = new int[3][4];
        // for(int i=0; i<pares.length; i++){
        //     for(int j=0; j<pares[i].length; j++){
        //         pares[i][j] = 2;
        //     }
        // }
        // for(int i=0; i<pares.length; i++){
        //     for(int j=0; j<pares[i].length; j++){
        //         System.out.print(pares[i][j]+" ");
        //     }
        //     System.out.println();
        // }

        /* Declarar e inicializar dos variables tipo cadena de texto. mDeclara e inicializa una variable lógica que indique si las dos cadenas anteriores son iguales */
        // String cadena1 = "hola que tal";
        // String cadena2 = "hola que tal";
        // boolean iguales = false;

        // if(cadena1.contains(cadena2)){
        //     iguales = true;
        // }
        // if(iguales == true){
        //     System.out.println("Las dos cadenas de texto son iguales.");
        // }else{
        //     System.out.println("Las cadenas de texto son diferentes.");
        // }

        /* 8. Crea una nueva cadena de texto como resultado de pasar a mayúsculas alguna de las dos anteriores. */
        // String cadena1 = "hola que tal";
        // String cadena2 = "";

        // cadena2 = cadena1.toUpperCase();
        // System.out.println(cadena2);

        /* 9. Crea una nueva cadena de texto como resultado de eliminar los espacios en blanco de la anterior */
        // String cadena1 = "hola que tal";
        // String cadena2 = "";

        // cadena2 = cadena1.replace(" ", ""); //reemplaza lo primero (espacio en blanco), por lo segundo (sin espacio)
        // System.out.println(cadena2);

        /* 10. Declara e inicializa una variable lógica que indique si dos de las cadenas anteriores tienen el mismo tamaño. */
        // String cadena1 = "hola que tal";
        // String cadena2 = "hola que haces";
        
        // int tamano1 = cadena1.length();
        // int tamano2 = cadena2.length();

        // boolean a = tamano1 == tamano2; //guardar la condición en una variable booleana para casos en los que la condición sea larga

        // if(a){
        //     System.out.println("Las cadenas de texto son iguales.");
        // }else{
        //     System.out.println("Las cadenas de texto no son iguales.");
        // }

        /* 11. Crea una nueva cadena de texto como concatenación de todas las anteriores. */
        // String cadena1 = "hola que tal";
        // String cadena2 = "hola que haces";
        // String cadena3 = cadena1+cadena2;
        
        // System.out.println(cadena3);

        /* 12. Declara e inicializa una variable lógica que indique si alguna de las cadenas anteriores el carácter 'c' */
        // String cadena1 = "hola que tal estas";
        // boolean a = cadena1.contains("c");
        // if(a){
        //     System.out.println("La cadena de texto: '"+cadena1+"' tiene al menos una vez la letra 'c'.");
        // }else{
        //     System.out.println("La cadena de texto: '"+cadena1+"' no contiene la letra 'c'.");
        // }

        /* 13. Crea una nueva cadena de texto como resultado de sustituir el carácter 's' por el carácter '$' en alguna de las cadenas anteriores. */
        // String cadena1 = "en esta frase voy a poner muchas letras s para sustituir";
        // String cadena2 = cadena1.replace("s", "$");
        // System.out.println("La primera cadena de texto es: "+cadena1+".\nLa segunda cadena de texto es: "+cadena2+".");

        /* 14. Crea un array de enteros llamados impares y añade en él los primeros 10 números impares. */
        // int[] impares = new int[10];

        // int contadorImpar = 0;
        // boolean impar = true;
        // int numero = 1;
        // while(contadorImpar<10){
        //     for(int i=2; i<=numero; i++){
        //         if(numero%2 == 0){
        //             impar = false;
        //         }
        //     }
        //     if(impar == true){
        //         impares[contadorImpar] = numero;
        //         contadorImpar++;
        //     }
        //     impar = true;
        //     numero++;
        // }
        // for(int i=0; i<impares.length; i++){
        //     System.out.print(impares[i]+", ");
        // }

        /* 15. Declara e inicializa una variable lógica que indique si el array anterior contiene el elemento 0 */
        // int[] primos = {1,3,5,7,9,11,13,15,17,19};
        // boolean estaCero = false;

        // for(int i=0; i<primos.length; i++){
        //     estaCero = primos[i]==0;
        //     if(estaCero){
        //         System.out.println("El número 0 se encuentra en el array.");
        //         break;
        //     }
        // }
        // if(!estaCero){
        //     System.out.println("El número 0 no está en el array.");
        // }

        /* 16. Declara e inicializa una variable entera con el valor del 6º elemento del array anterior. */
        int[] primos = {1,3,5,7,9,11,13,15,17,19};
        int numeroSeis = primos[5];
        System.out.println(numeroSeis);
    }
}