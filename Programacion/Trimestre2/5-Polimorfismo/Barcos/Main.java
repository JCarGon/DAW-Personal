import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import clases.*;

public class Main{
    public static void main(String[] args) {
        Tripulante t1 = new Capitan(89765432, 55, 765, "Manolete");
        Tripulante t2 = new Marinero(76586432, 43, 230, "Lolito", 249);
        Tripulante t3 = new JefeFlota(12342156, 30, 598, "Federico");
        List<Tripulante> pasajeros = new ArrayList<Tripulante>();

        LocalDate fecha = LocalDate.now();
        Gps gps1 = new Gps(24.76, 66.98, fecha);

        pasajeros.add(t1);
        pasajeros.add(t2);
        pasajeros.add(t3);
        Barco barco1 = new Barco("María II", "Crucero", 200, pasajeros);

        for(Tripulante t : pasajeros){
            System.out.println(t.mostrarDatos()+"\n");
        }
    }
}