import java.util.ArrayList;

import clases.*;
public class Main {
    public static void main(String[] args) {
        ArrayList<Mascota> mascotasLocal = new ArrayList<Mascota>();
        mascotasLocal.add(new Mascota("Manolito", 7, 5));
        mascotasLocal.add(new Mascota("Perrete", 6, 3));
        ArrayList<Mascota> mascotasVisitante = new ArrayList<Mascota>();
        mascotasVisitante.add(new Mascota("pajarillo", 1, 1));
        mascotasVisitante.add(new Mascota("ganso", 1, 1));

        Equipo equipoA = new Equipo("Equipo A", mascotasLocal);
        Equipo equipoB = new Equipo("Equipo B", mascotasVisitante);

        
        fight(null, null);
    }

    public static void fight(Mascota m1, Mascota m2){
        while((m1.getVida() > 0) && (m2.getVida() > 0)){
            m1.atacar(m2);
        }
    }
}