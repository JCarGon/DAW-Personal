package lectura;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class EjEnClase {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Persona persona =new Persona("Manuel Paco", 40);
        try {
            //serializa la persona en un documento que crea
            FileOutputStream fos = new FileOutputStream("C:\\Users\\jesus\\Desktop\\persona.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(persona);

            oos.close();
            fos.close();

            //coge un archivo donde está un objeto persona y lo deserializa
            FileInputStream fis = new FileInputStream("C:\\Users\\jesus\\Desktop\\persona.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Persona persona2 = (Persona)ois.readObject();
            System.out.println(persona2.toString());

            ois.close();
        } catch (FileNotFoundException e) {
            System.out.println("error.");
        }
    }
}