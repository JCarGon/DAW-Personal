package clases;

public class Niño extends Paciente{
    public Niño(String nombre, int edad, char sexo){
        super(nombre, edad, sexo);
    }

    public void saludar(Paciente paciente){
        System.out.println("El niño "+this.getNombre()+" saluda a "+paciente.getNombre());
    }

    @Override
    public String toString(){
        return this.getNombre()+", "+this.getEdad()+", "+this.getSexo()+", "+super.getEnfermedades();
    }
}