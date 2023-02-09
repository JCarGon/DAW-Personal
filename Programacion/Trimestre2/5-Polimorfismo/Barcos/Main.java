import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import clases.*;

public class Main{
    public static void main(String[] args) {
        //Creamos 3 tripulantes, cada uno de un tipo
        Tripulante t1 = new Capitan(89765432, 55, 765, "Manolete");
        Tripulante t2 = new Marinero(76586432, 43, 230, "Lolito", 249);
        Tripulante t3 = new JefeFlota(12342156, 30, 598, "Federico");
        //Creamos la lista para guardar los tripulantes
        List<Tripulante> pasajeros = new ArrayList<Tripulante>();
        //Añadimos los tripulantes a la lista
        pasajeros.add(t1);
        pasajeros.add(t2);
        pasajeros.add(t3);

        //Creamos un objeto fecha de tipo LocalDate
        LocalDate fecha = LocalDate.now();
        //Creamos un objeto GPS y añadimos la fecha como un parámetro
        Gps gps1 = new Gps(24.76, 66.98, fecha);

        //Creamos un objetoBarca al que le pasamos como parámetro la lista y el objeto gps creados anteriormente
        Barco barco1 = new Barco("María II", "Crucero", 200, pasajeros, gps1);

        //For each para recorrer la lista y mostrar los datos de cada objeto de la lista
    //-> for("tipo de objeto" "nombre" : "nombre del objeto a recorrer")
        for(Tripulante t : pasajeros){
            System.out.println(t.mostrarDatos()+"\n");
        }
        //Datos del barco
        System.out.println(barco1.toString()+"\n");


        List<Tripulante> aforoComedor = new ArrayList<>();
        String[] rangosPermitidosComedor = {"Capitan", "Marinero"};
        Sala sala1 = new Sala("comedor", 50, aforoComedor, rangosPermitidosComedor);
        sala1.entrarSala(t3); //JefeFlota
        sala1.entrarSala(t1); //Capitan
    }
}