package clases;

public class Figura {
    String codigoFigura;
    double precioFigura;
    Superheroe heroe = new Superheroe("All Might");
    Dimension medida = new Dimension();

    public Figura(String codigoFigura, double precioFigura, Superheroe heroe, Dimension medida){
        this.codigoFigura = codigoFigura;
        this.precioFigura = precioFigura;
        this.heroe = heroe;
        this.medida = medida;
    }

    public void setCodigoFigura(String codigoFigura){
        this.codigoFigura = codigoFigura;
    }

    public String getCodigoFigura(){
        return this.codigoFigura;
    }

    public void setPrecioFigura(double precioFigura){
        this.precioFigura = precioFigura;
    }

    public double getPrecioFigura(){
        return this.precioFigura;
    }

    public void setHeore(Superheroe heroe){
        this.heroe = heroe;
    }

    public Superheroe getHeroe(){
        return heroe;
    }

    public void setDimension(Dimension medida){
        this.medida = medida;
    }

    public Dimension getDimension(){
        return medida;
    }

    public double subirPrecio(double precio){
        this.precioFigura += precio;
        return this.precioFigura;
    }

    @Override
    public String toString(){
        return "\nCódigo de figura: "+this.codigoFigura+";\nPrecio: "+this.precioFigura+" euros;\n"+heroe.toString()+"\n"+medida.toString();
    }
}