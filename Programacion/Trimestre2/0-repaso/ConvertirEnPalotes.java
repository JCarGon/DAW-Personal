import java.util.Scanner;

public class ConvertirEnPalotes {
    
    public static int PedirNumero(){
        Scanner entrada = new Scanner(System.in);
        int numero = 0;
        do{
            System.out.print("Introduzca un número que sea positivo: ");
            numero = entrada.nextInt();
            if(numero<0){
                System.out.println("Error, ha introducido un número incorrecto. Vuelva a introducir otro.");
            }
        }while(numero<0);
        entrada.close();
        return numero;
    }
    
    public static String convertirEnPalotes(int numero){ /* 465 - |||| |||||| ||||| (en caso de ser 0 poner un '-') ; restricción número > 0 */
        String palotes = "";
        String numeroAux = "";
        String numeroAuxiliar;
        int num = 0;

        numeroAux += numero;
        for(int i=0; i<numeroAux.length(); i++){
            numeroAuxiliar = String.valueOf(numeroAux.charAt(i));
            num = Integer.parseInt(numeroAuxiliar);
            if(num == 0){
                palotes += "-";
            }else{
                for(int j=0; j<num; j++){
                    palotes += "|";
                }
            }
            if(i != (numeroAux.length()-1)){
                palotes += "-";
            }
        }
        return palotes;
    }
    
    public static void main(String[] args) {
        System.out.println(convertirEnPalotes(PedirNumero()));
    }
}