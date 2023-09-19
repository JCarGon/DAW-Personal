import java.time.LocalDate;
import java.time.LocalDateTime;

public class Profesor extends Persona{
    private LocalDateTime horario;

    public Profesor(int id, String nombre, LocalDate fechaNacimiento, LocalDateTime horario){
        super(id, nombre, fechaNacimiento);
        this.horario = horario;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public void setHorario(LocalDateTime horario) {
        this.horario = horario;
    }
    
    @Override
    public String toString(){
        return "Profesor: "+super.toString()+", horario "+this.horario;
    }
}