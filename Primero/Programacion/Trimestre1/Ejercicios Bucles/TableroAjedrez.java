public class TableroAjedrez {
    public static void main(String[] args) {
        /*Fila 1 o A*/
        String filaA = "  ##  ##  ##  ##";
        /*Fila 2 o B*/
        String filaB = "##  ##  ##  ##  ";

        /*Una vez que tenemos las dos primeras filas hechas, las 6 restantes es repetir estas dos en este orden, por lo que no
        tenemos más que hacer un bucle for que lo repita 3 veces más (hasta que i sea menor que 4, ya que empieza en 0)*/
        for(int i=0; i<4; i++){
            System.out.println(filaA +"\n"+ filaB);
        }
    }
}