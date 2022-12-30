import java.util.Scanner;

public class TableroAjedrez {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int nfilas;
        /*Una vez que tenemos las dos primeras filas hechas, las 6 restantes es repetir estas dos en este orden, por lo que no
        tenemos más que hacer un bucle for que lo repita 3 veces más (hasta que i sea menor que 4, ya que empieza en 0)*/
        System.out.print("¿Cuántas filas quieres que tenga?: ");
        nfilas = entrada.nextInt();
        entrada.close();
        for(int i=1; i<=nfilas; i++){
            if(i%2 == 0){ //filas pares
                System.out.println("  ##  ##  ##  ##");
            }
            else{ //filas impares
                System.out.println("##  ##  ##  ##  ");
            }
        }
    }
}