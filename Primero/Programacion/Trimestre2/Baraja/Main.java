import clases.Baraja;

public class Main {
    public static void main(String[] args) {
        Baraja baraja = new Baraja();
        System.out.println(baraja.toString());
        baraja.barajar();
        System.out.println(baraja.toString());
    }
}