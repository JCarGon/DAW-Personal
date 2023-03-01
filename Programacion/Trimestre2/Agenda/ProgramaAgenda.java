import clases.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProgramaAgenda{
    public static void main(String[] args) {
        LocalDate fechaContactoPersona1 = LocalDate.now();
        ContactoEmpresa contactoEmpresa1 = new ContactoEmpresa("Manolete", "987546258", "www.manolete.com");
        ContactoPersona contactoPersona1 = new ContactoPersona("Paquito", "564879254", fechaContactoPersona1);
        List<Contacto> contactos = new ArrayList<>();
        contactos.add(contactoEmpresa1);
        contactos.add(contactoPersona1);

        Agenda agenda = new Agenda(contactos);
        System.out.println(agenda.listarContactos());
        System.out.println(agenda.existeContacto("Manolete"));
        System.out.println(agenda.existeContacto("Francisco"));
        System.out.println(agenda.buscarContacto("Paquito"));
        System.out.println(agenda.buscarContacto("Antonio"));
    }
}