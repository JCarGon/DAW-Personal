import clase.Dni;

public class Main {
    public static void main(String[] args) {
        Dni dni1 = new Dni();
        Dni dni2 = new Dni(30266219);

        System.out.println(dni1.toString());
        System.out.println(dni2.toString()
        );
    }
}