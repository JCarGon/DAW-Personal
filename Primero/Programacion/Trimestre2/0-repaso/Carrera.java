public class Carrera{
    public static boolean superaCarrera(String[] array, String pista){
        boolean comprobacion = true;
        String palabra;
        String pistaFinal = "";
        char letra;
        for(int i=0; i<array.length; i++){
            palabra = array[i];
            letra = pista.charAt(i);
            if(palabra.equals("run")){
                if(letra == '|'){
                    pistaFinal += "x";
                    comprobacion = false;
                }else{
                    pistaFinal += "_";
                }
            }else if(palabra.equals("jump")){
                if(letra == '_'){
                    pistaFinal += "/";
                    comprobacion = false;
                }else{
                    pistaFinal += "|";
                }
            }
        }
        System.out.println(pistaFinal);
        return comprobacion;
    }

    public static void main(String[] args) {
        String[] carrera1 = {"run", "run", "run", "run", "run",};
        String pista1 = "|____";
        boolean resultado1 = superaCarrera(carrera1, pista1); // true
        System.out.println("El resultado de la prueba 1 es: " +resultado1+"\n");

        String[] carrera2 = {"run", "run", "jump", "run", "run",};
        String pista2 = "_____";
        boolean resultado2 = superaCarrera(carrera2, pista2); // false
        System.out.println("El resultado de la prueba 2 es: " +resultado2+"\n");

        String[] carrera3 = {"run", "jump", "run", "jump", "run",};
        String pista3 = "_|_|_";
        boolean resultado3 = superaCarrera(carrera3, pista3); // true
        System.out.println("El resultado de la prueba 3 es: " +resultado3+"\n");
    }
}