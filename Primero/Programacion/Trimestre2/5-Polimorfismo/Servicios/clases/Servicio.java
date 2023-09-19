package clases;
import java.time.LocalDate;

public abstract class Servicio {
    Persona trabajador;
    Persona cliente;
    LocalDate fechaInicio;

    public Servicio(Persona trabajador, Persona cliente, LocalDate fechaInicio){
        this.trabajador = trabajador;
        this.cliente = cliente;
        this.fechaInicio = fechaInicio;
    }

    public void setTrabajador(String nombre, String apellidos){
        trabajador.setNombre(nombre);
        trabajador.setApellidos(apellidos);
    }

    public Persona getTrabajador(){
        return this.trabajador;
    }

    public void setCliente(String nombre, String apellidos){
        cliente.setNombre(nombre);
        cliente.setApellidos(apellidos);
    }
    
    public Persona getCliente(){
        return this.cliente;
    }

    public void setFechaInicio(LocalDate fecha){
        this.fechaInicio = fecha;
    }

    public LocalDate getFechaInicio(){
        return this.fechaInicio;
    }

    public abstract double costeMaterial();
    public abstract double costeManoObra();
    public abstract double costeTotal();
    public abstract String detalleServicio();
}