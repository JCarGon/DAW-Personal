import java.util.Scanner;
public class AdivinarNumero {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int numeroUsuario = 0;
        /* Número aleatorio para la máquina entre 1 y 100*/
        int numeroMaquina = (int) (Math.random()*(100+1));
        int vidas = 10;
        int contador = 0;

        System.out.println("Bienvenido al juego 'Adivina el número'. Tendrá una cantidad de 10 vidas para tratar de adivinar el número "
        +"que la máquina ha generado entre 1 y 100. Si lo consigue antes de que sus vidas llegan a 0, ganará; por el contrario, "
        +"si no lo consigue, perderá. Cuando inserte un número se le indicará si el número introducido es mayor o menor "
        +"que el número de la máquina.");

        System.out.print("Introduce un número: ");
        numeroUsuario = entrada.nextInt();
        contador++;
        vidas--;
        while(vidas>0 && numeroUsuario != numeroMaquina){
            if(numeroUsuario<numeroMaquina){
                System.out.println("El número introducido es menor que el número de la máquina.");
                vidas--;
                contador++;
            }
            else if(numeroUsuario>numeroMaquina){
                System.out.println("El número introducido es mayor que el número de la máquina.");
                vidas--;
                contador++;
            }
            else{
                break;
            }
            System.out.print("Introduce un número: ");
            numeroUsuario = entrada.nextInt();
        }
        entrada.close();
        if(numeroUsuario==numeroMaquina && vidas>0){
            System.out.println("Enhorabuena, ha acertado el número de la máquina en "+contador+" intentos.");
        }
        else{
            System.out.println("Has perdido. Tus vidas han llegado a 0. El número de la máquina era "+numeroMaquina+".");
        }
    }
}