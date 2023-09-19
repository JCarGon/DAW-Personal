package clases;

public class Cafetera{
    int capacidadMaxima;
    int capacidadActual;

    public Cafetera(){
        this.capacidadMaxima = 1000;
        this.capacidadActual = 0;
    }

    public Cafetera(int capacidadMaxima){
        this.capacidadMaxima = capacidadMaxima;
        this.capacidadActual = capacidadMaxima;
    }

    public void llenarCafetera(){
        //cantidad actual = a cantidad máxima
        if(this.capacidadActual < this.capacidadMaxima){
            this.capacidadActual = this.capacidadMaxima;
        }else{
            System.out.println("La capacidad actual ya es la capacidad máxima.");
        }
    }

    public void servirTaza(int cantidad){
        if(this.capacidadActual < cantidad){
            System.out.println("No se puede llenar la taza porque la capacidad actual es menor que la cantidad de la taza.");
        }else{
            this.capacidadActual -= cantidad;
            System.out.println("Aquí tiene su taza.");
        }
    }

    public void vaciarCafetera(){
        if(this.capacidadActual == 0){
            System.out.println("La cafetera ya está vacía.");
        }else{
            this.capacidadActual = 0;
        }
    }

    public void agregarCafe(int cantidad){
        int cantidadFinal = this.capacidadActual + cantidad;
        if(cantidadFinal > this.capacidadMaxima){
            cantidadFinal = this.capacidadMaxima-this.capacidadActual;
            this.capacidadActual = this.capacidadMaxima;
            System.out.println("No puedo añadir "+cantidad+"cc de café porque rebosaría. He agregado "+cantidadFinal+"cc para llegar al máximo.");
        }else{
            this.capacidadActual += cantidad;
        }
    }

    @Override
    public String toString(){
        return "La cafetera tiene actualmente "+capacidadActual+"cc de café; su capacidad máxima es de "+capacidadMaxima+"cc.";
    }
}