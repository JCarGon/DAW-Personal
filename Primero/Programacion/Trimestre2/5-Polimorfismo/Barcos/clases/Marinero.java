package clases;

public class Marinero extends Tripulante{
    private int capturas;

    public Marinero(int nCarnet, int edad, int tiempoEmpresa, String nombre, int capturas){
        super(nCarnet, edad, tiempoEmpresa, nombre);
        this.capturas = capturas;
    }

    public int getCapturas() {
        return capturas;
    }

    public void setCapturas(int capturas) {
        this.capturas = capturas;
    }

    @Override
    public double sueldo(){
        double salario = 900 + this.capturas;
        return salario;
    }

    @Override
    public String mostrarDatos(){
        return "Datos del Marinero: "+
        "\nNúmero de carnet: "+super.getnCarnet()+
        "\nEdad: "+super.getEdad()+
        "\nTiempo en la empresa (en días): "+super.getTiempoEmpresa()+
        "\nNombre: "+super.getNombre()+
        "\nSueldo: "+sueldo()+" euros.";
    }
}