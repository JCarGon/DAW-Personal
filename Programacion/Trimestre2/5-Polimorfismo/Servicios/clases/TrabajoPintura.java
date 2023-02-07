package clases;
import java.time.LocalDate;

public class TrabajoPintura extends Servicio{
    double superficie;
    double precioPintura;

    public TrabajoPintura(Persona trabajador, Persona cliente, LocalDate fechaInicio, double superficie, double precioPintura){
        super(trabajador, cliente, fechaInicio);
        this.superficie = superficie;
        this.precioPintura = precioPintura;
    }

    public void setSuperficie(double superficie){
        this.superficie = superficie;
    }

    public double getSuperficie(){
        return this.superficie;
    }

    public void setPrecioPintura(double precioPintura){
        this.precioPintura = precioPintura;
    }

    public double getPrecioPintura(){
        return this.precioPintura;
    }

    @Override
    public double costeMaterial(){
        double coste_material = (this.superficie / 7.8) * this.precioPintura;
        return coste_material;
    }

    @Override
    public double costeManoObra(){
        double coste_mano_obra = (this.superficie / 10) * 9.5;
        return coste_mano_obra;
    }

    @Override
    public double costeTotal(){
        double coste_total = costeMaterial() + costeManoObra();
        if(getSuperficie() < 50){
            coste_total += (coste_total*0.15);
        }
        return coste_total;
    }

    @Override
    public String detalleServicio(){
        return "TRABAJO DE PINTURA"+
        "\nCliente: "+super.getCliente()+
        "\nFecha de inicio: "+super.getFechaInicio()+
        "\n--------------------------------------------"+
        "\nPintor: "+super.getTrabajador()+
        "\nCoste Material..... "+costeMaterial()+
        "\nCoste Mano Obra.... "+costeManoObra()+
        "\nTOTAL.............. "+costeTotal()+
        "\n--------------------------------------------";
    }
}