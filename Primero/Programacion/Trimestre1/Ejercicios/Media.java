import java.util.Scanner;
public class Media {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        float nota1;
        float nota2;
        float nota3;
        float notaFinal;
        String nombre;

        System.out.print("Escriba el nombre del alumno: ");
        nombre=entrada.nextLine();
        /* Para que no dé error al introducir un float hay que separar el número con "," no con "." */
        System.out.print("A continuación, se le pedirá las notas de las 3 evaluaciones."
        +"Nota de la evaluación 1: ");
        nota1=entrada.nextFloat();
        System.out.print("Nota de la evaluación 2: ");
        nota2=entrada.nextFloat();
        System.out.print("Nota de la evaluación 3: ");
        nota3=entrada.nextFloat();
        entrada.close();

        notaFinal = (nota1+nota2+nota3)/3;
        System.out.println("El promedio de las 3 notas del alumno "+nombre+" es: "+notaFinal+"\n");
    }
}