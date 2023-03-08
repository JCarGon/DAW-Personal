package clases;

public class Anciano extends Paciente{
    public Anciano(String nombre, int edad, char sexo){
        super(nombre, edad, sexo);
    }

    public void saludar(Paciente paciente){
        System.out.println("El adulto "+this.getNombre()+" saluda a "+paciente.getNombre());
    }

    @Override
    public String toString(){
        return this.getNombre()+", "+this.getEdad()+", "+this.getSexo()+", "+super.getEnfermedades();
    }
}