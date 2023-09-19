public class Funcion{
    
    public static int suma(int a, int b){
        return a+b;
    }
    public static int resta(int a, int b){
        return a-b;
    }
    public static int multiplicacion(int a, int b){
        return a*b;
    }
    public static double division(double a, double b){
        return a/b;
    }
    public static double resto(double a, double b){
        return a%b;
    }
    public static void imprimeN(int n){
        for(int i=0; i<n; i++){
            System.out.println(i);
        }
    }
    public static void main(String[] args) {
        /* 
            public static tipoDato nombreFuncion(parametro) {
                return variable (igual al tipo de dato);
            }
            public static int suma(int a, int b){
                return a+b;
            }

            --PARA INVOCAR LA FUNCION--
            nombre(parametros);

            int c = suma(5,8);
        */

        int c = suma(5, 8);
        System.out.println("La suma es: "+c);

        c = resta(5, 8);
        System.out.println("La resta es: "+c);
        
        c = multiplicacion(5, 8);
        System.out.println("La multiplicacion es: "+c);

        double d = division(5, 8);
        System.out.println("La division es: "+d);

        d = resto(5, 8);
        System.out.println("La resto es: "+d);

        imprimeN(10);
    }
}