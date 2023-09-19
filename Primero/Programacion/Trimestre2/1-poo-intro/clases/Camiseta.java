package clases;

public class Camiseta {
    public String color;
    public char talla;
    public String marca;
    public String tejido;

    public Camiseta(String color, char talla, String marca, String tejido){
        this.color = color;
        this.talla = talla;
        this.marca = marca;
        this.tejido = tejido;
    }

    public void setColor(String color){
        this.color = color;
    }

    public void setTalla(char talla){
        this.talla = talla;
    }

    public void setMarca(String marca){
        this.marca = marca;
    }

    public void setTejido(String tejido){
        this.tejido = tejido;
    }

    public String getColor(){
        return color;
    }

    public char getTalla(){
        return talla;
    }

    public String getMarca(){
        return marca;
    }

    public String getTejido(){
        return tejido;
    }

    @Override
    public String toString(){
        return "La camiseta es de color "+color+", talla "+talla+", de la marca "+marca+" y está hecha con el tejido "+tejido+".";
    }
}
