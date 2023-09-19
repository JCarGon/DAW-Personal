import java.util.Scanner;

public class AhorcadoArray{
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        char letra = ' ';
        char respuesta = ' ';
        boolean comprobar = false;
        
        do{
            String palabra[] = {"perro", "calcetin", "basura", "java", "programacion", "ordenador", "teclado", "raton", "monitor", "consola"};
            String palabraRandom = palabra[(int)((Math.random()*10)+1)];
            int vidas = 10;
            StringBuilder palabraFinal = new StringBuilder();
            for(int i=0; i<palabraRandom.length(); i++){ //recorrer la extensión de la palabraRandom
                palabraFinal.append('_');//agrega al StringBuilder un _ por cada letra que tenga la palabraRandom
            }
    
            System.out.println("Juego del ahorcado. Tendrás que adivinar una palabra aleatoria insertando una letra por turno.");
            System.out.print("La palabra que tienes que adivinar es: "+palabraFinal+". ");
            //System.out.print(palabraRandom);//mostrar la palabra a adivinar por pantalla
    
            while( (vidas > 0) && (palabraFinal.toString().equals(palabraRandom) == false) ){ //mientras vidas sea mayor a 0 y la palabra actual sea diferente de la palabra random
                System.out.print("\nInserta una letra: ");//pedimos una letra
                letra = entrada.next().charAt(0);//guardamos la letra
    
                for (int i = 0; i < palabraRandom.length(); i++) {//recorremos el array donde está guardada esa palabra en letras
                    if(Character.compare(letra, palabraRandom.charAt(i)) == 0){ //si los caracteres son iguales
                        palabraFinal.setCharAt(i, letra); //método para reemplazar el caracter "i" por el caracter introducido en letra
                        comprobar = true; //si la letra está al menos una vez, el boolean cambia a true
                    }
                }
                System.out.print(palabraFinal); //imprimir por pantalla el estado actual de la palabra
                System.out.println(); //salto de línea para separar la siguiente acción
                
                if(comprobar == false){ //si el boolean es falso, es decir, que no ha sustituido ni una letra en la palabra (has fallado)
                    vidas--; //restar una vida
                    System.out.println("Has fallado. Te quedan " + vidas + " vida/s."); //dice las vidas que quedan por pantalla
                }
                comprobar = false; //reseteamos el boolean a falso antes de pedir la siguiente letra
    
            }
            /*Una vez fuera del bucle while, analizamos el resultado:
             *1. Si vidas es mayor a 0, y además, la palabraFinal es la misma que la palabraRandom, has ganado porque has acertado la palabra y te quedan vidas;
             *2. En el caso contrario, has perdido, ya que te has quedado sin vidas y no has acertado la palabra.*/
            if((vidas > 0) && (palabraFinal.toString().equals(palabraRandom))){
                System.out.println("\nHas acertado la palabra.");
            }
            else{
                System.out.println("\nTus vidas han llegado a cero. Has perdido. La palabra a adivinar era: "+palabraRandom+".");
            }
            System.out.print("¿Quieres volver a jugar? (s/n): ");
            respuesta = entrada.next().charAt(0);
            System.out.println();
        }while(respuesta == 's'); //al final se pregunta si se quiere volver a jugar;si la respuesta es "s" (si), se repetirá el juego
        System.out.println("Cerrando el juego. Gracias por jugar.");
        entrada.close();
    }
}