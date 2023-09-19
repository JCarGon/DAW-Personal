import java.util.HashMap;

public class Hashmap{
    public static void main(String[] args) {
        // HashMap<keyDataType, valueDataType> miHashMap = new HashMap<>();

        HashMap<Integer, String> lenguajes = new HashMap<Integer, String>();
        lenguajes.put(1, "C#");
        lenguajes.put(2, "Python");
        lenguajes.put(3, "Java");

        //salida por pantalla del valor que le corresponde al dato 2
        System.out.println(lenguajes.get(2));
        //reemplazar el valor que corresponde al dato 3
        lenguajes.replace(3, "Kotlin");
        System.out.println(lenguajes.get(3));
        //eliminar
        lenguajes.remove(1);
        System.out.println(lenguajes.get(1));

        //devuelve True-False si está la clave en el hashmap
        System.out.println(lenguajes.containsKey(2));
        //devuelve True-False si está el valor en el hashmap
        System.out.println(lenguajes.containsValue("Java"));
        System.out.println(lenguajes.size());
        System.out.println(lenguajes.keySet());
    }
}