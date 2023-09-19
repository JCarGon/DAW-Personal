package clases;

import java.time.LocalDate;

public class ContactoPersona extends Contacto implements IcontactoPersona{
    private LocalDate fechaNacimiento;

    public ContactoPersona(String nombre, String telefono, LocalDate fechaNacimiento) {
        super(nombre, telefono);
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString(){
        return super.toString()
        +"\nFecha de nacimiento: "+this.fechaNacimiento;
    }
}