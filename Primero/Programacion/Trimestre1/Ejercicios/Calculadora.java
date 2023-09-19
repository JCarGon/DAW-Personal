/*Menú calculadora con opciones:
 * 1. Suma
 * 2. Resta
 * 3. Multiplicación
 * 4. División
 * 0. Salir
*/
import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcion;
        double numero1 = 0;
        double numero2 = 0;
        double resultado = 0;

        do{//do-while para que se ejecute el programa hasta que el usuario introduzca un 0
            System.out.print("\tCalculadora\n"
            +"Opción 1: suma\n"
            +"Opción 2: resta\n"
            +"Opción 3: multiplicación\n"
            +"Opción 4: división\n"
            +"Opción 0: salir\n"
            +"Seleccione una de las siguientes opciones: ");
            opcion = entrada.nextInt();

            /*Pongo este condicional para que una vez haya pedido el número de la opción, si ese número está entre 1 y 4 entre a hacer
            la operación correspondiente; en el caso que el número no esté en ese rango, saltará un mensaje de error si es != 0,
            o cerrará el programa si es 0.*/
            if(opcion >= 1 && opcion <= 4){
                System.out.print("Introduce el número 1: ");
                numero1 = entrada.nextDouble();
                System.out.print("Introduce el número 2: ");
                numero2 = entrada.nextDouble();

                if(opcion == 1){
                    resultado = numero1+numero2;
                    System.out.println("El resultado es: "+resultado+".\n");
                }
                else if(opcion == 2){
                /*lo hago para que el resultado de la resta no salga un número negativo, por eso hago las comparaciones;
                en caso de querer números negativos, se quitan los dos if y se deja solo -> resultado = numero1-numero2;*/
                    if(numero1>numero2){
                        resultado = numero1 - numero2;
                        System.out.println("El resultado es: "+resultado+".\n");
                    }
                    else if(numero2>numero1){
                        resultado = numero2 - numero1;
                        System.out.println("El resultado es: "+resultado+".\n");
                    }
                }
                else if(opcion == 3){
                    resultado = numero1 * numero2;
                    System.out.println("El resultado es: "+resultado+".\n");
                }
                else if(opcion == 4){
                    resultado = numero1 / numero2;
                    System.out.println("El resultado es: "+resultado+".\n");
                }
            }
            else if(opcion == 0){
                System.out.println("Saliendo de la calculadora.\n");
            }
            else{//Ha seleccionado una opción diferente a 1, 2, 3, 4 y 0. Opción no válida
                System.out.println("Error, ha seleccionado una opción no válida. Vuelva a introducir una opción.\n");
            }
        }while(opcion != 0);
        entrada.close();
    }
}