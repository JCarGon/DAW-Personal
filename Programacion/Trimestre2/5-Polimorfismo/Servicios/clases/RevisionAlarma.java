package clases;
import java.time.LocalDate;

public class RevisionAlarma extends Servicio{
    private int numeroAlarmas;

    public RevisionAlarma(Persona trabajador, Persona cliente, LocalDate fechaInicio, int numeroAlarmas){
        super(trabajador, cliente, fechaInicio);
        super.setTrabajador("Revisor", "Especialista Contraincendios");
        this.numeroAlarmas = numeroAlarmas;
    }

    public void setNumeroAlarmas(int numeroAlarmas){
        this.numeroAlarmas = numeroAlarmas;
    }

    public int getNumeroAlarmas(){
        return this.numeroAlarmas;
    }

    @Override
    public double costeMaterial(){
        return 0;
    }

    @Override
    public double costeManoObra(){
        double coste_mano_obra = 0;
        if(numeroAlarmas > 0){
            coste_mano_obra = (this.numeroAlarmas / 3) * 40;
            return coste_mano_obra;
        }else{
            return coste_mano_obra;
        }
    }

    @Override
    public double costeTotal(){
        return costeManoObra();
    }

    @Override
    public String detalleServicio(){
        return "REVISIÓN PERIÓDICA ALARMAS CONTRAINCENDIOS"+
        "\nCliente: "+super.getCliente()+
        "\nFecha revisión: "+super.getFechaInicio()+
        "\n------------------------------------------"+
        "\nTOTAL: ..... "+costeTotal()+
        "\n------------------------------------------";
    }
}