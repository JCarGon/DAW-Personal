import clases.Cafetera;;

public class Main {
    public static void main(String[] args) {
        Cafetera cafetera1 = new Cafetera();
        Cafetera cafetera2 = new Cafetera(2000);
        
        System.out.println(cafetera1.toString());
        System.out.println(cafetera2.toString());

        cafetera1.llenarCafetera();
        cafetera2.llenarCafetera();

        System.out.println(cafetera1.toString());
        System.out.println(cafetera2.toString());

        cafetera1.vaciarCafetera();
        cafetera2.vaciarCafetera();

        System.out.println(cafetera1.toString());
        System.out.println(cafetera2.toString());

        cafetera1.servirTaza(200);
        cafetera2.servirTaza(250);

        cafetera1.llenarCafetera();
        cafetera2.llenarCafetera();

        cafetera1.servirTaza(350);
        cafetera2.servirTaza(1000);

        System.out.println(cafetera1.toString());
        System.out.println(cafetera2.toString());

        cafetera1.agregarCafe(500);
        cafetera2.agregarCafe(500);

        System.out.println(cafetera1.toString());
        System.out.println(cafetera2.toString());
    }
}