import java.util.ArrayList;
import clases.*;

public class Main {
    public static void main(String[] args) {
        Ienfermedad gripe = new Gripe("1234");
        Ienfermedad resfriado = new Resfriado("5463");

        ArrayList<Ienfermedad> enfermedadesPaciente1 = new ArrayList<>();
        enfermedadesPaciente1.add(resfriado);
        enfermedadesPaciente1.add(gripe);
        Paciente paciente1 = new Paciente("pepe", 0, 'a');
        paciente1.setEnfermedades(enfermedadesPaciente1);
        System.out.println(paciente1.getEnfermedades());
        
        ArrayList<Ienfermedad> enfermedadesPaciente2 = new ArrayList<>();
        enfermedadesPaciente2.add(gripe);
        Paciente paciente2 = new Paciente("lolita", 0, 'm');
        paciente2.setEnfermedades(enfermedadesPaciente2);
        System.out.println(paciente2.getEnfermedades());
        
        Sanitario sanitario = new Sanitario("Shin chan", 0, 'a', null);
        
        paciente2.saludar(paciente1);
        paciente1.saludar(paciente2);
        paciente1.saludar(sanitario);

        sanitario.curar(paciente2);
        System.out.println(paciente2.getEnfermedades());
    }
}