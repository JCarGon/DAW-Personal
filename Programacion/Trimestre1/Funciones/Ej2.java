import java.util.Scanner;

public class Ej2 {
    /* Índice de masa corporal masa (kg)/(estatura)(metro)^2 */

    public static double indiceMasa(double masa, double estatura){
        double resultado;
        resultado = masa/(estatura*estatura);
        resultado = Math.round((resultado)*100.0)/100.0; //usar solo dos decimales
        return resultado;
    }
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        double masa;
        double estatura;

        System.out.print("Introduce un valor para la masa (en kg): ");
        masa = entrada.nextDouble();
        System.out.print("Introduce un valor para la estatura (en metros - RECUERDA USAR ',' EN LUGAR DE '.'): ");
        estatura = entrada.nextDouble();
        System.out.println("Tu índice de masa corporal es: "+indiceMasa(masa, estatura)+".");
        double IMC = indiceMasa(masa, estatura);

        if (IMC < 18.5) {
            System.out.println("Peso bajo.");
        }
        else if (IMC >= 18.5 && IMC < 25) {
            System.out.println("Peso normal.");
        }
        else if (IMC >= 25 && IMC < 30) {
            System.out.println("Sobrepeso.");
        }
        else {
            System.out.println("Obesidad.");
        }

        entrada.close();
    }
}