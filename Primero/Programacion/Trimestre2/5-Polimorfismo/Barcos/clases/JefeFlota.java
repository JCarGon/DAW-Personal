package clases;

public class JefeFlota extends Tripulante{
    
    public JefeFlota(int nCarnet, int edad, int tiempoEmpresa, String nombre){
        super(nCarnet, edad, tiempoEmpresa, nombre);
    }

    @Override
    public double sueldo(){
        return 2000;
    }

    @Override
    public String mostrarDatos(){
        return "Datos del Jefe de flota: "+
        "\nNúmero de carnet: "+super.getnCarnet()+
        "\nEdad: "+super.getEdad()+
        "\nTiempo en la empresa (en días): "+super.getTiempoEmpresa()+
        "\nNombre: "+super.getNombre()+
        "\nSueldo: "+sueldo()+" euros.";
    }
}