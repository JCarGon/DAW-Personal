public class FuncionTexto {
    /*Función que le pase un número y un texto, e imprima el texto el número de veces */
    
    public static void repetirTexto(int a, String b){
        for(int i=0; i<a; i++){
            System.out.println(b);
        }
    }
    public static void main(String[] args) {
        repetirTexto(5, "Hola");
    }
}