package lectura;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        File fichero = new File("C:\\Users\\jesus\\Documents\\GitHub\\DAW-Personal\\Programacion\\Trimestre3\\1-ficheros\\Credenciales.txt");
        Scanner entrada = new Scanner(System.in);
        boolean login = false;
        do{
            System.out.print("Introduce el nombre de usuario: ");
            String user = entrada.nextLine();
            System.out.print("Introduce la contraseña: ");
            String pass = entrada.nextLine();
            try {
                Scanner lector = new Scanner(fichero);
                while(lector.hasNextLine() && !login){ //responde sí-no a si tiene siguiente línea
                    String[] linea = lector.nextLine().split(";");
                    if(user.equals(linea[0]) && pass.equals(linea[1])){
                        System.out.println("Acceso permitido. Bienvenido "+user+".");
                        login = true;
                    }else{
                        System.out.println("Usuario incorrecto.");
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println(e);
            }
        }while(!login);
    }
}