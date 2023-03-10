package clases;

import java.util.ArrayList;

public class Paciente extends Persona{
    private ArrayList<Ienfermedad> enfermedades;

    public Paciente(String nombre, int edad, char sexo){
        super(nombre, edad, sexo);
        this.enfermedades = new ArrayList<>();
    }

    public void saludar(Sanitario sanitario){
        System.out.println("El paciente "+this.getNombre()+" saluda al sanitario "+ sanitario.getNombre()+".");
        
    }

    public void saludar(Paciente p){
        if(tieneEnfermedad(this.getEnfermedades())){
            //escoger una enfermedad aleatoria de la lista
            int index = (int) (Math.random() * enfermedades.size());
            //comprobar si esa enfermedad está en la lista de la otra persona
            if(p.enfermedades.contains(this.enfermedades.get(index))){
                System.out.println("El paciente "+this.getNombre()+" saluda sin contagiar al paciente "+p.getNombre()+" porque ya tiene la enfermedad: "+this.enfermedades.get(index).getClass().getSimpleName()+".");
            }else{
                System.out.println("El paciente "+this.getNombre()+" al saludar al paciente "+p.getNombre()+", le ha contagiado de: "+this.enfermedades.get(index).getClass().getSimpleName()+".");
                p.enfermar(this.enfermedades.get(index));
            }
                //si está en la lista, saluda sin más
                //si no está en la lista, la contagia
        }else{
            System.out.println("Saluda sin contagiar porque no tiene enfermedades.");
        }
    }

    public ArrayList<Ienfermedad> getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(ArrayList<Ienfermedad> enfermedades) {
        this.enfermedades = enfermedades;
    }

    public void enfermar(Ienfermedad enfermedad){
        this.enfermedades.add(enfermedad);
    }

    public void curarse(ArrayList<Ienfermedad> enfermedades){
        for (int i = 0; i<enfermedades.size(); i++) {
            if(enfermedades.get(i).getEsCurable()){
                enfermedades.remove(enfermedades.get(i));
                i--; //si tiene dos enfermedades curables, elimina la primera, la segunda ocupa el primer lugar y al haberlo pasado no la elimina.
            }
        }
    }

    //método que compruebe si tengo más de 0 enfermedades en la lista
    public boolean tieneEnfermedad(ArrayList<Ienfermedad> e){
        boolean bandera = false;
        if(!e.isEmpty()){
            bandera = true;
        }
        return bandera;
    }

    //método que 
    @Override
    public String toString(){
        return this.getNombre()+", "+this.getEdad()+", "+this.getSexo()+", "+this.enfermedades;
    }
}