import java.util.Arrays;
import java.util.List;

import clases.*;

public class Main{
    public static void main(String[] args) {
        Persona p1 = new Deportista("Joselito", 22);
        Persona p2 = new Informatico("Manolete", 30);
        Persona p3 = new Deportista("Paquito", 28);
        Persona p4 = new Informatico("Lolita", 25);

        List<Persona> lista = Arrays.asList(p1, p2, p3, p4);
        /* 
        Con ArrayList no encuentro forma de añadir varios al mismo tiempo, habría que ir de uno en uno
        ArrayList<Persona> personas = new ArrayList<>();
        personas.add(p1);
        personas.add(p2);
        personas.add(p3);
        personas.add(p4);
        */
        // for(tipo-de-variable nombre : colección-a-iterar)
        for (Persona p : lista) {
            System.out.println(p.getNombre()+", "+p+" corre: "+p.correr());
        }
    }
}