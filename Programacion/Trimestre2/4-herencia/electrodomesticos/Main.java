import clases.*;

public class Main{
    public static void main(String[] args) {
        Electrodomestico microondas = new Electrodomestico("microondas", "Fujitsu", 30);
        Lavadora lavadora1 = new Lavadora("Bosch", 60);
        Lavadora lavadora2 = new Lavadora("LG", 50, 379, true);

        System.out.println(microondas.toString()+"\n");
        System.out.println(lavadora1.toString()+"\n");
        System.out.println(lavadora2.toString()+"\n");

        lavadora1.setPrecio(480);
        System.out.println(lavadora1.toString()+"\n");

        System.out.println("El consumo de la lavadora "+lavadora1.getMarca()+" es: "+lavadora1.getConsumo(4));
        System.out.println("El coste por consumo de la lavadora "+lavadora1.getMarca()+" es: "+lavadora1.getCosteConsumo(4, 4.5));

        System.out.println("El consumo de la lavadora "+lavadora2.getMarca()+" es: "+lavadora2.getConsumo(4));
        System.out.println("El coste por consumo de la lavadora "+lavadora2.getMarca()+" es: "+lavadora2.getCosteConsumo(4, 4.5));
    }
}