import clases.*;

public class Main{
    public static void main(String[] args) {
        Vehiculo vehiculo = new Vehiculo("Vehiculo", 1, 5);
        Motorizado motorizado = new Motorizado("Motorizado", 3);
        Nomotorizado noMotorizado = new Nomotorizado("No Motorizado", 4, 20);
        Moto moto = new Moto("Moto");
        Coche coche = new Coche("Coche");
        Camion camion = new Camion("Camión");
        Bicicleta bici = new Bicicleta("Bici", 50);
        Patin patines = new Patin("Patines", 6, 40, "linea");

        System.out.println(vehiculo.toString()+"\n");
        System.out.println(motorizado.toString()+"\n");
        System.out.println(noMotorizado.toString()+"\n");
        System.out.println(moto.toString()+"\n");
        System.out.println(coche.toString()+"\n");
        System.out.println(camion.toString()+"\n");
        System.out.println(bici.toString()+"\n");
        System.out.println(patines.toString()+"\n");

        coche.arrancar();
        System.out.println(coche.toString());
    }
}