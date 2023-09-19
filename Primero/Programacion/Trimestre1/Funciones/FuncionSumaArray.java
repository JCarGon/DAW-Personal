public class FuncionSumaArray {
    /* Pasar array lleno de números y que muestre la suma de números */
    
    /* Sumar números de un array */
    public static int sumaArray(int[] numeros){
        int sumatorio = 0;
        for(int i=0; i<numeros.length; i++){
            sumatorio += numeros[i];
        }
        return sumatorio;
    }

    /* Generar un array de números random */
    public static int[] randomArray(int n){
        int[] array = new int[n];
        for(int i=0; i<n; i++){
            array[i] = (int)((Math.random()*100));
        }
        return array;
    }

    public static String toString(int[] numeros){
        String arrayStr = "[";
        for(int i=0; i<numeros.length-1; i++){ //recorremos hasta antes de la última posición para después ponerla manualmente
            arrayStr += numeros[i]+", ";
        }
        arrayStr += numeros[numeros.length-1]+"]"; //ponemos la última posición manualmente y le añadimos el ] final
        return arrayStr;
    }

    public static void main(String[] args) {
        int[] numerosRandom = randomArray(7); //Creamos un array de extensión 7 con números aleatorios y lo guardamos en un array
        System.out.println(toString(numerosRandom)); //Mostrar por pantalla con toString el array
        System.out.println(sumaArray(numerosRandom)); //Sumar los números del array creado
        int[] numeros = {1,2,3,4,5,6};
        int[] numeros2 = {1,2,3,6};
        int[] numeros3 = {1,2,3,3,3,3,3,3,3,4,5,6};
        System.out.println(sumaArray(numeros));
        System.out.println(sumaArray(numeros2));
        System.out.println(sumaArray(numeros3));
    }
}