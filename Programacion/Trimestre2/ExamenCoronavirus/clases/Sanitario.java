package clases;

public class Sanitario extends Persona{
    private String categoria;

    public Sanitario(String nombre, int edad, char sexo, String categoria){
        super(nombre, edad, sexo);
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }
    
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void diagnosticar(Paciente paciente){
        System.out.println("Diagnóstico del paciente "+paciente.getNombre()+": ");
        for (Ienfermedad e : paciente.getEnfermedades()) {
            if(e.getEsCurable()){
                System.out.println("La enfermedad "+e.getClass().getSimpleName()+" es curable.");
            }else{
                System.out.println("La enfermedad "+e.getClass().getSimpleName()+" no es curable.");
            }
        }
    }

    public void curar(Paciente paciente){
        //si el tamaño de la lista de enfermedades es 1 y el nombre es diferente de Coronavirus, vacío la lista
        if((paciente.getEnfermedades().size() == 1) && (!paciente.getEnfermedades().get(0).getClass().getSimpleName().equals("Coronavirus"))){
            paciente.getEnfermedades().removeAll(paciente.getEnfermedades());
        }else{
            paciente.curarse(paciente.getEnfermedades());
        }
        System.out.println("El sanitario ha curado las enfermedades posibles del paciente "+paciente.getNombre()+".");
    }

    @Override
    public String toString(){
        return this.getNombre()+", "+this.getEdad()+", "+this.getSexo()+", "+this.categoria;
    }
}