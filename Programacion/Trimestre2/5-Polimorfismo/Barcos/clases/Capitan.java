package clases;

public class Capitan extends Tripulante{
    public Capitan(int nCarnet, int edad, int tiempoEmpresa, String nombre){
        super(nCarnet, edad, tiempoEmpresa, nombre);
    }

    @Override
    public double sueldo(){
        double salario = 1000 + super.getTiempoEmpresa();
        return salario;
    }

    @Override
    public String mostrarDatos(){
        return "Datos del Capitán: "+
        "\nNúmero de carnet: "+super.getnCarnet()+
        "\nEdad: "+super.getEdad()+
        "\nTiempo en la empresa (en días): "+super.getTiempoEmpresa()+
        "\nNombre: "+super.getNombre()+
        "\nSueldo: "+sueldo()+" euros.";
    }
}