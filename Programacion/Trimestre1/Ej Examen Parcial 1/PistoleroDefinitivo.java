import java.util.Scanner;

public class PistoleroDefinitivo {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String nombreUsuario = " ";      
        int respuestaUsuario = 0;
        int contadorRonda = 1; //contador para saber en qué ronda estamos
        int vidaUsuario = 1; //vida del usuario
        int vidaMaquina = 1; //vida de la máquina
        int balasUsuario = 0; //el usuario empieza con 0 balas
        int balasMaquina = 0; //la máquina empieza con 0 balas
        int opcionMaquina = 0;

        System.out.print("Bienvenido al juego de los vaqueros, inserte un nombre: ");
        nombreUsuario = entrada.next();
        System.out.println("El juego va a comenzar, agárrense los machos.");
        System.out.println("*** Ronda "+contadorRonda+" ***");
        System.out.println("Las opciones son:\n \t1. Recargar\n \t2. Bloquear\n \t3. Disparar\nEn la primera ronda ambos jugadores recargan.");
            if(contadorRonda == 1){ //en la primera ronda ambos jugadores recargan
                balasUsuario++;
                balasMaquina++;
                contadorRonda++;
                System.out.println(nombreUsuario+": "+balasUsuario+" bala.\n"
                +"Máquina: "+balasMaquina+" bala.\n");
            }
        /*Empieza el juego*/
        do{
            if(balasMaquina<1){ //si la máquina no tiene balas, no puede disparar, es decir que solo tiene las opciones 1 (recargar) y 2 (bloquear)
                do{
                    opcionMaquina = (int) (Math.random() * 3 + 1);
                }while(opcionMaquina==3); //que repita la elección mientras la opción sea 3 (disparar), que no queremos que sea esa
            }
            else{
                opcionMaquina = (int) (Math.random() * 3 + 1); //en caso contrario, la máquina elige un número entre 1 y 3
            }
            if(balasUsuario==0){ //si usuario no tiene balas, la máquina no bloquea, solo recarga o dispara
                do{
                    opcionMaquina = (int) (Math.random() * 3 + 1);
                }while(opcionMaquina==2); //que repita la elección mientras la opción sea 2 (recargar), que no queremos que sea esa
            }
            do{
                System.out.println("*** Ronda "+contadorRonda+" ***");
                System.out.print("Las opciones son:\n \t1. Recargar\n \t2. Bloquear\n \t3. Disparar\nElige una opción: ");
                respuestaUsuario = entrada.nextInt();
                System.out.println(); //salto de línea
                if(respuestaUsuario<1 || respuestaUsuario>3){
                    System.out.println("Ha introducido una respuesta no válida. Introduzca otra.");
                }
                if(balasMaquina<1 && respuestaUsuario == 2){ //si la máquina no tiene balas y el usuario elige bloquear
                    do{
                        System.out.println(nombreUsuario+": "+balasUsuario+" bala/s.\n"
                        +"Máquina: "+balasMaquina+" bala/s.");
                        System.out.println("No bloquees, que la máquina no tiene balas... ¡¡¡ ATACA !!! \n");
                        do{
                            System.out.println("*** Ronda "+contadorRonda+" ***");
                            System.out.print("Las opciones son:\n \t1. Recargar\n \t2. Bloquear\n \t3. Disparar\nElige una opción: ");
                            respuestaUsuario = entrada.nextInt();
                            System.out.println(); //salto de línea
                            if(respuestaUsuario<1 || respuestaUsuario>3){
                                System.out.println("Ha introducido una respuesta no válida. Introduzca otra.");
                            }
                        }while(respuestaUsuario<1 || respuestaUsuario>3); //que no me deje introducir un número que no es una opción (!= de 1, 2 y 3)
                    }while(respuestaUsuario == 2); //no me dejes elegir la opción de bloquear
                }
                if(balasUsuario<1 && respuestaUsuario == 3){ //si el usuario no tiene balas e intenta disparar
                    do{
                        System.out.println(nombreUsuario+": "+balasUsuario+" bala/s.\n"
                        +"Máquina: "+balasMaquina+" bala/s.");
                        System.out.println("No puedes disparar si no tienes balas... ¡¡¡ ESPABILA !!! \n");
                        do{
                            System.out.println("*** Ronda "+contadorRonda+" ***");
                            System.out.print("Las opciones son:\n \t1. Recargar\n \t2. Bloquear\n \t3. Disparar\nElige una opción: ");
                            respuestaUsuario = entrada.nextInt();
                            System.out.println(); //salto de línea
                            if(respuestaUsuario<1 || respuestaUsuario>3){
                                System.out.println("Ha introducido una respuesta no válida. Introduzca otra.");
                            }
                        }while(respuestaUsuario<1 || respuestaUsuario>3); //que no me deje introducir un número que no es una opción (!= de 1, 2 y 3)
                    }while(respuestaUsuario == 3); //no me dejes elegir la opción de disparar
                }
            }while(respuestaUsuario<1 || respuestaUsuario>3); //que me siga preguntando mientras el usuario introduzca un número menor de 0 o mayor de 3 (no válido)
            contadorRonda++;
            
            if(respuestaUsuario == 1){ //si la opción del usuario es 1 (Recargar)
                if(opcionMaquina == 1){ //si la respuesta de la máquina es 1 (Recargar)
                    balasUsuario++;
                    balasMaquina++;
                    System.out.println("El usuario ha recargado una bala.");
                    System.out.println("La máquina ha recargado una bala.");
                    System.out.println(nombreUsuario+": "+balasUsuario+" bala/s.\n"
                    +"Máquina: "+balasMaquina+" bala/s.\n");
                }
                else if(opcionMaquina == 2){ //si la opción de la máquina es 2 (Bloquear)
                    balasUsuario++;
                    System.out.println("El usuario ha recargado una bala.");
                    System.out.println("La máquina bloquea.");
                    System.out.println(nombreUsuario+": "+balasUsuario+" bala/s.\n"
                    +"Máquina: "+balasMaquina+" bala/s.\n");
                }
                else{ //si la opción de la máquina es 3 (Disparar)
                    balasUsuario++;
                    System.out.println("El usuario ha recargado una bala.");
                    System.out.println("La máquina dispara.");
                    vidaUsuario--;
                    System.out.println(nombreUsuario+": "+balasUsuario+" bala/s.\n"
                    +"Máquina: "+balasMaquina+" bala/s.\n");
                    System.out.println("¡ Ha ganado la máquina porque ha disparado mientras recargabas !\n");
                    break;
                }
            }
            else if(respuestaUsuario == 2){ //si la opción del usuario es 2 (Bloquear)
                if(opcionMaquina == 1){ //si la respuesta de la máquina es 1 (Recargar)
                    balasMaquina++;
                    System.out.println("El usuario bloquea.");
                    System.out.println("La máquina ha recargado una bala.");
                    System.out.println(nombreUsuario+": "+balasUsuario+" bala/s.\n"
                    +"Máquina: "+balasMaquina+" bala/s.\n");
                }
                else if(opcionMaquina == 2){ //si la opción de la máquina es 2 (Bloquear)
                    System.out.println("El usuario bloquea.");
                    System.out.println("La máquina bloquea.");
                    System.out.println(nombreUsuario+": "+balasUsuario+" bala/s.\n"
                    +"Máquina: "+balasMaquina+" bala/s.\n");
                }
                else{ //si la opción de la máquina es 3 (Disparar)
                    balasMaquina--;
                    System.out.println("El usuario bloquea");
                    System.out.println("La máquina dispara.");
                    System.out.println(nombreUsuario+": "+balasUsuario+" bala/s.\n"
                    +"Máquina: "+balasMaquina+" bala/s.\n");
                }
            }
            else{ //si la opción del usuario es 3 (Disparar)
                if(opcionMaquina == 1){ //si la respuesta de la máquina es 1 (Recargar)
                    balasUsuario--;
                    balasMaquina++;
                    System.out.println("El usuario dispara.");
                    System.out.println("La máquina ha recargado una bala.");
                    System.out.println(nombreUsuario+": "+balasUsuario+" bala/s.\n"
                    +"Máquina: "+balasMaquina+" bala/s.\n");
                    System.out.println("¡ Has ganado "+nombreUsuario+" porque has disparado mientras la máquina recargaba !");
                    break;
                }
                else if(opcionMaquina == 2){ //si la opción de la máquina es 2 (Bloquear)
                    balasUsuario--;
                    System.out.println("El usuario dispara.");
                    System.out.println("La máquina bloquea.");
                    System.out.println(nombreUsuario+": "+balasUsuario+" bala/s.\n"
                    +"Máquina: "+balasMaquina+" bala/s.\n");
                }
                else{ //si la opción de la máquina es 3 (Disparar)
                    balasUsuario--;
                    balasMaquina--;
                    System.out.println("El usuario dispara");
                    System.out.println("La máquina dispara.");
                    System.out.println(nombreUsuario+": "+balasUsuario+" bala/s.\n"
                    +"Máquina: "+balasMaquina+" bala/s.\n");
                }
            }
        }while(vidaUsuario>0 || vidaMaquina>0);
        entrada.close();
    }
}