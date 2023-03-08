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
        for (Ienfermedad e : paciente.getEnfermedades()) {
            System.out.println("La enfermedad "+e.getCodigo()+" es "+e.getEsCurable());
        }
    }

    public void curar(Paciente paciente){
        for(int i=0; i<paciente.getEnfermedades().size(); i++){
            if(paciente.getEnfermedades().get(i).getEsCurable()){
                paciente.getEnfermedades().remove(paciente.getEnfermedades().get(i));
                System.out.println("La enfermedad "+paciente.getEnfermedades().get(i)+" se ha curado.");
            }else{
                System.out.println("La enfermedad "+paciente.getEnfermedades().get(i)+" no es curable.");
            }
        }
    }

    @Override
    public String toString(){
        return this.getNombre()+", "+this.getEdad()+", "+this.getSexo()+", "+this.categoria;
    }
}