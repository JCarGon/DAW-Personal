import java.util.Scanner;
public class Atleta {
    public static void main(String[] args) {
        /*Se pretende realizar un programa para gestionar la lista de participantes en una competición de salto de longitud.
        El número de plazas disponibles es de 10. Sus datos se irán introduciendo en el mismo orden que vayan inscribiéndose los atletas.
        Diseñar el programa que muestre las siguientes opciones:
        1- Inscribir un participante.
        2- Mostrar listado por dorsal.
        3- Mostrar listado por marcas.
        4- Finalizar el programa.

        Si se selecciona1, se introducirán los datos de unos de los participantes: nombre, dorsal, mejor marca del 2002,
        mejor marca del 2001 y mejor marca del 2000.
        Si se elige la opción 2, se debe mostrar un listado por número de dorsal.
        La opción 3 mostrará un listado ordenado por la marca del 2002, de mayor a menor.
        Tras procesar cada opción, se debe mostrar de nuevo el menú inicial, hasta que se seleccione la opción 4, que terminará el programa.*/

        Scanner entrada = new Scanner(System.in);
        String[][] datos = new String[10][5];//[contadorfila][contadorColumna]
        String menu = "\t\tMENÚ DEL PROGRAMA"+
        "\n1- Inscribir un participante."+
        "\n2- Mostrar el listado por dorsal."+
        "\n3- Mostrar el listado por marcas."+
        "\n4- Finalizar el programa.";
        int opcion;
        int contadorColumna = 0;
        int contadorFila = 0;
        
        do{
            System.out.println(menu);
            System.out.print("Elige una opción: ");
            opcion = entrada.nextInt();
            System.out.println();//salto de línea para separar
            entrada.nextLine();
            switch(opcion){
                case 1: //insertar atleta
                    if(contadorFila<datos.length){
                        System.out.print("Introduce un nombre para el atleta "+(contadorFila+1)+": ");
                        datos[contadorFila][contadorColumna] = entrada.nextLine();
                        contadorColumna++;
                        System.out.print("Introduce un dorsal: ");
                        datos[contadorFila][contadorColumna] = entrada.nextLine();
                        contadorColumna++;
                        System.out.print("Introduce la mejor marca del 2002 (recuerda introducir el número con '.' no con ','): ");
                        datos[contadorFila][contadorColumna] = entrada.nextLine();
                        contadorColumna++;
                        System.out.print("Introduce la mejor marca del 2001 (recuerda introducir el número con '.' no con ','): ");
                        datos[contadorFila][contadorColumna] = entrada.nextLine();
                        contadorColumna++;
                        System.out.print("Introduce la mejor marca del 2000 (recuerda introducir el número con '.' no con ','): ");
                        datos[contadorFila][contadorColumna] = entrada.nextLine();
                        contadorColumna = 0; //restablecemos el contador para la siguiente vuelta
                        contadorFila++; //sumamos 1 al contador de la fila para que la siguiente vez empiece en la siguiente fila, que sería la 1
                        System.out.println();//salto de línea para separar
                    }
                    else{
                        System.out.println("No puedes introducir más atletas porque ya están los 10.");
                    }
                    break;
                case 2: //Ordenar el listado por dorsal (columna 1 = 2ª)
                    for(int i=0; i<datos.length-1; i++) {
                        for(int j=0; j<datos[i].length; j++){
                            if(datos[i+1][1] != null){ //si el dato de la posición siguiente no está vacío, entro
                                String aux = "";
                                int l=i;
                                boolean bandera = false;
                                while(!bandera && Integer.parseInt(datos[l][1]) > Integer.parseInt(datos[l+1][1])) {
                                    for(int k=0; k<datos[l].length; k++){ //para cambiar las líneas
                                        aux = datos[l][k]; //guardo el valor actual en una variable auxiliar
                                        datos[l][k] = datos[l+1][k]; //a la posición actual le asigno el valor de la siguiente porque es más pequeño
                                        datos[l+1][k]= aux; //a la posición siguiente le asigno el valor que tenía guardado en la variable auxiliar
                                    }
                                    l++; //aumento el iterador que uso dentro de este bucle
                                    if(datos[l+1][1] == null){ //si la fila siguiente tiene valor 'null'
                                        bandera = true; //bandera cambia a true y ya no entra a seguir comprobando valores
                                    }
                                }
                            }
                        }
                    }
                    //salida por pantalla
                    for(int i=0; i<datos.length; i++){
                        System.out.print("Atleta "+(i+1)+": ");
                        for(int j=0; j<datos[i].length; j++){
                            System.out.print(datos[i][j]+" ");
                        }
                        System.out.println();
                    }
                    System.out.println();//salto de línea para separar
                    break;
                case 3: //Mostrar el listado ordenado por la marca del 2002, de mayor a menor (columna 3 = 2)
                    for(int i=0; i<datos.length-1; i++) {  
                        for(int j=0; j<datos[i].length; j++){
                            if(datos[i+1][2] != null){ //si el dato de la posición siguiente no está vacío, entro
                                String aux = "";
                                int l=i;
                                boolean bandera = false;
                                while(!bandera && Double.parseDouble(datos[l][2]) < Double.parseDouble(datos[l+1][2])) {
                                    for(int k=0; k<datos[l].length; k++){ //Para cambiar las líneas
                                        aux = datos[l][k]; //guardo el valor actual en una variable aux
                                        datos[l][k] = datos[l+1][k]; //a la posición actual le asigno el valor de la siguiente porque es más pequeño
                                        datos[l+1][k]= aux; //a la posición siguiente le asigno el valor que tenía guardado en la variable auxiliar
                                    }
                                    l++; //aumento el iterador que uso dentro de este bucle
                                    if(datos[l+1][1] == null){ //si la fila siguiente tiene valor 'null'
                                        bandera = true; //bandera cambia a true y ya no entra a seguir comprobando valores
                                    }
                                }
                            }
                        }
                    }
                    //salida por pantalla
                    for(int i=0; i<datos.length; i++){
                        System.out.print("Atleta "+(i+1)+": ");
                        for(int j=0; j<datos[i].length; j++){
                            System.out.print(datos[i][j]+" ");
                        }
                        System.out.println();
                    }
                    System.out.println();//salto de línea para separar
                    break;
                case 4: //salir
                System.out.println("Saliendo del programa.");
                System.out.println();//salto de línea para separar
                    break;
                default: //control de opción no válida
                    System.out.println("Ha introducido una opción no válida, vuelva a introducir otra.");
                    break;
            }
        }while(opcion != 4);
        entrada.close();
    }
}