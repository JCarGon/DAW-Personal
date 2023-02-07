import java.time.LocalDate;

import clases.*;

public class Main{
    public static void main(String[] args) {
        Persona trabajador1 = new Persona("Manolete", "Padilla");
        Persona cliente1 = new Persona("Lolito", "Fernández");
        LocalDate fecha = LocalDate.now();
        TrabajoPintura trabajo1 = new TrabajoPintura(trabajador1, cliente1, fecha, 100, 5);

        System.out.println(trabajo1.costeMaterial());
        System.out.println(trabajo1.costeManoObra());
        System.out.println(trabajo1.costeTotal());
        System.out.println();
        System.out.println(trabajo1.detalleServicio());

        Persona trabajador2 = new Persona(null, null);
        int numeroAlarmas = 3;
        RevisionAlarma revision1 = new RevisionAlarma(trabajador2, cliente1, fecha, numeroAlarmas);
        System.out.println();
        System.out.println(revision1.costeMaterial());
        System.out.println(revision1.costeManoObra());
        System.out.println(revision1.costeTotal());
        System.out.println();
        System.out.println(revision1.detalleServicio());
    }
}

/*
costeMaterial, costeManoObra, costeTotal, detalleServicio son métodos abstractos de la clase abstracta servicios
-clase TrabajoPintura y RevisionAlarma heredan de servicio
*/