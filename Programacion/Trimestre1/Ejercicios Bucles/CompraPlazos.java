import java.util.Scanner;

public class CompraPlazos {
    public static void main(String[] args) {
        /*Una persona adquirió un producto para pagar en 20 meses. El primer mes pagó 10€, el segundo 20€, el tercero 40€ y así sucesivamente.
         * Realizar un programa para determinar cuánto debe pagar mensualmente y el total de lo que pagará después de los 20 meses. Este
         * programa puede serbir para calcular otras compras y con diferentes plazos.
         * -> Hacerlo general para introducir los valores de la cuota del mes 1 y los meses en los que se va a pagar la compra.*/
        Scanner entrada = new Scanner(System.in);
        double cuota; //= 10;
        int numeroMeses;
        int contadorMes= 1;

        System.out.print("Introduzca la primera cuota del producto: ");
        cuota = entrada.nextDouble();
        System.out.print("Introduce el número de meses en las que va a pagar la compra: ");
        numeroMeses = entrada.nextInt();
        while(contadorMes <= numeroMeses){
            System.out.println("El mes "+contadorMes+" ha pagado: "+cuota+" euros.");
            contadorMes++;
            cuota = cuota*2;
        }
        entrada.close();
        System.out.println("El precio total de la compra es: "+cuota+" euros.");
    }
}