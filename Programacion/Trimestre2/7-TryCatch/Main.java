import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Introduce un número: ");
        try {
            int numero = Integer.parseInt(entrada.nextLine());
            boom();
        } catch (NumberFormatException e) {
            System.out.println("No has introducido un número.");
        } catch (Exception e){
            System.out.println("Explotó porque sí.");
            System.out.println(e.getMessage());
            System.out.println(e);
        }
    }

    public static void boom() throws CustomException{
        try {
            throw new Exception("Porque quiero y puedo");
        } catch (Exception e) {
            String message = "Custom: " + e.getMessage();
            throw new CustomException(message, 723);
        }
    }
}

class CustomException extends Exception{
    int code;

    public CustomException(){
        super();
    }

    public CustomException(String m){
        super(m);
    }

    public CustomException(String message, int code){
        super(message);
        this.code = code;
    }
}