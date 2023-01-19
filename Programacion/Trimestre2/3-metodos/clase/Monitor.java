package clase;

public class Monitor {
    public String marca;
    public double pulgadas;
    public String resolucionPantalla;
    public int tiempoRespuesta;
    public String formaPantalla;

    public Monitor(String marca, double pulgadas, String resolucionPantalla, int tiempoRespuesta, String formaPantalla){
        this.marca = marca;
        this.pulgadas = pulgadas;
        this.resolucionPantalla = resolucionPantalla;
        this.tiempoRespuesta = tiempoRespuesta;
        this.formaPantalla = formaPantalla;
    }

    public void setMarca(String marca){
        this.marca = marca;
    }

    public String getMarca(){
        return marca;
    }

    public void setPulgada(double pulgadas){
        this.pulgadas = pulgadas;
    }

    public double getPulgadas(){
        return pulgadas;
    }

    public void setResolucionPantalla(String resolucionPantalla){
        this.resolucionPantalla = resolucionPantalla;
    }

    public String getResolucionPantalla(){
        return resolucionPantalla;
    }

    public void setTiempoRespuesta(int tiempoRespuesta){
        this.tiempoRespuesta = tiempoRespuesta;
    }

    public int getTiempoRespuesta(){
        return tiempoRespuesta;
    }

    public void setFormaPantalla(String formaPantalla){
        this.formaPantalla = formaPantalla;
    }

    public String getFormaPantalla(){
        return formaPantalla;
    }

    @Override
    public String toString(){
        return "El monitor es la marca "+marca+", tiene "+pulgadas+" pulgadas, la resolución de pantalla es "+resolucionPantalla+", el tiempo de respuesta es "+tiempoRespuesta+" y la forma de la pantalla es "+formaPantalla+".";
    }
}