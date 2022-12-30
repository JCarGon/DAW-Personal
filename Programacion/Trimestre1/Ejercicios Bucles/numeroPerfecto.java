import java.util.Scanner;
public class numeroPerfecto {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int numero;
        int sumaDivisores = 0;

        System.out.print("Introduce un número para comprobar si es perfecto: ");
        numero = entrada.nextInt();
        entrada.close();

        for(int i=1; i<numero; i++){
            if(numero%i == 0){
                sumaDivisores += i;
            }
        }
        if(sumaDivisores == numero){
            System.out.println("El número "+numero+" es perfecto");
        }
        else{
            System.out.println("El número "+numero+" no es perfecto");
        }
    }
}