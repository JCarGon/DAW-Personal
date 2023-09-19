package clases;

public class Dimension {
    double altoFigura;
    double anchoFigura;
    double profundidaFigura;

    public Dimension(){
        this.altoFigura = 0;
        this.anchoFigura = 0;
        this.profundidaFigura = 0;
    }

    public Dimension(double altoFigura, double anchoFigura, double profundidaFigura){
        this.altoFigura = altoFigura;
        this.anchoFigura = anchoFigura;
        this.profundidaFigura = profundidaFigura;
    }

    public void setAltoFigura(double altoFigura){
        this.altoFigura = altoFigura;
    }

    public double getAltoFigura(){
        return this.altoFigura;
    }

    public void setAnchoFigura(double anchoFigura){
        this.anchoFigura = anchoFigura;
    }

    public double getAnchoFigura(){
        return this.anchoFigura;
    }

    public void setProfundidadFigura(double profundidaFigura){
        this.profundidaFigura = profundidaFigura;
    }

    public double getProfundidadFigura(){
        return this.profundidaFigura;
    }

    public double getVolumen(double altoFigura, double anchoFigura, double profundidaFigura){
        double volumen = this.altoFigura*this.anchoFigura*this.profundidaFigura;
        return volumen;
    }

    @Override
    public String toString(){
        return "Alto: "+this.altoFigura+"cm; ancho: "+this.anchoFigura+"cm; profundidad: "+this.profundidaFigura+"cm; volumen máximo: "+
        getVolumen(this.altoFigura, this.anchoFigura, this.profundidaFigura)+".";
    }
}
