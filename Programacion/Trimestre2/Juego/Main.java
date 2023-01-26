import java.util.ArrayList;

import clases.*;
public class Main {
    public static void main(String[] args) {
        ArrayList<Mascota> mascotasA = new ArrayList<Mascota>();
        mascotasA.add(new Mascota("Manolito", 7, 5));
        mascotasA.add(new Mascota("Perrete", 6, 3));
        ArrayList<Mascota> mascotasB = new ArrayList<Mascota>();
        mascotasB.add(new Mascota("pajarillo", 1, 1));
        mascotasB.add(new Mascota("ganso", 1, 1));

        Equipo equipoA = new Equipo("Equipo A", mascotasA);
        Equipo equipoB = new Equipo("Equipo B", mascotasB);

        
        fight(null, null);
    }

    public static void fight(Mascota m1, Mascota m2){
        while((m1.getVida() > 0) && (m2.getVida() > 0)){
            m1.atacar(m2);
        }
    }
}