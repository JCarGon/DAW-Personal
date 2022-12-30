/* Escribe un programa que repsonda a un usuario que quiere comprar un helado en una conocida marca de comida rápida.
¿Cuánto le costaría en función del topping que eliga? 
El helado sin topping cuesta 1.90€.
    El topping de oreo cuesta 1€.
    El topping de KitKat cuesta 1.50€.
    El topping de brownie cuesta 0.75€.
    El topping de lacasitos cuesta 0.95€
    En caso de no disponer del topping solicitado por el usuario el programa escribirá por pantalla << >> y a continuación
    informar del precio del helado sin ningún topping.

Finalmente, el programa escribe por pantalla el precio del helado con el topping seleccionado (o ninguno). Además, si te atreves,
puedes añadir antes de cobrar al cliente, si su situación aplica a algún descuento adicional:
    Familia numerosa (10%)
    Desempleado (15%)
*/
import java.util.Scanner;
public class Helados {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        double[] helados = {1,1.5,0.75,0.95}; /*Guardamos en un array lo que cuesta cada topping en la posición asociada a cada uno*/
        char respuesta1;
        int respuesta2;
        double resultado = 1.9;

        System.out.print("Bienvenido a la heladería. El helado sin topping cuesta 1.90€. A continuación se mostrarán los topping "
        +"disponibles y sus precios:"
        +"\n1. El topping de oreo cuesta 1€."
        +"\n2. El topping de KitKat cuesta 1.50€."
        +"\n3. El topping de brownie cuesta 0.75€."
        +"\n4. El topping de lacasitos cuesta 0.95€.\n");
        
        /*Bucle for para pedir si quiere o no los diferentes toppings*/
        for(int i=0; i<helados.length; i++){
            do{
                System.out.print("Quiere el topping número "+(i+1)+"? 's' (si quiere) o 'n' (si no quiere): ");
                respuesta1 = entrada.next().charAt(0);
                /*Si respuesta == n, no se le suma nada al valor total*/
                if(respuesta1 == 'n'){
                }
                /*Si respuesta == s, al resultado que ya teníamos se le suma el valor del topping actual*/
                else{
                    resultado = resultado + helados[i];
                }
            }while(respuesta1 != 's' && respuesta1 != 'n'); /*Que esto se ejecute mientras la respuesta sea diferente de 's' o 'n'*/
        }
        System.out.print("\nSi su situación se corresponde con alguna de las siguientes, se le aplicará un descuento: "
        +"\nOpción 1: Familia numerosa (10%)."
        +"\nOpción 2: Desempleado (15%)."
        +"\nOpción 3: Ninguna."
        +"\nElija una opción: ");
        respuesta2 = entrada.nextInt();
        entrada.close();
        /*Aplicar descuentos según la opción seleccionada*/
        if(respuesta2 == 1){
            resultado = resultado*0.9;
            System.out.println("El valor total del helado es: "+resultado+" euros.");
        }
        else if(respuesta2 == 2){
            resultado = resultado*0.85;
            System.out.println("El valor total del helado es: "+resultado+" euros.");
        }
        else if (respuesta2 == 3){
            System.out.println("El valor total del helado es: "+resultado+" euros.");
        }
        else{
            System.out.println("Ha introducido una opción no válida. El valor de su helado es: "+resultado+" euros.");
        }
    }
}