package clases;
import java.util.ArrayList;

public class Coleccion {
    String nombreColeccion;
    ArrayList<Figura> listaFiguras; //lista de figuras

    public Coleccion(String nombreColeccion){
        this.nombreColeccion = nombreColeccion;
        this.listaFiguras = new ArrayList<Figura>();
    }

    public void setNombreColeccion(String nombreColeccion){
        this.nombreColeccion = nombreColeccion;
    }

    public String getNombreColeccion(){
        return this.nombreColeccion;
    }

    public void addFigura(Figura figura){
        this.listaFiguras.add(figura);
    }

    public void subirPrecio(double cantidad, String id){
        for(int i=0; i<listaFiguras.size(); i++){
            Figura figura = listaFiguras.get(i);
            if(id.equals(figura.getCodigoFigura())){
                figura.subirPrecio(cantidad);
            }else{
                System.out.println("Ese código no se corresponde con ninguna figura. No puedo subir el precio.");
            }
        }
    }

    public ArrayList<Figura> conCapa(ArrayList<Figura> listaFiguras){
        ArrayList<Figura> listaDevolver = new ArrayList<>();
        for(int i=0; i<listaFiguras.size(); i++){
            Figura figura = listaFiguras.get(i);
            if(figura.getHeroe().getCapa()){
                listaDevolver.add(figura);
            }
        }
        return listaDevolver;
    }

    public Figura masValioso(ArrayList<Figura> listaFiguras){
        Figura figura = new Figura(nombreColeccion, 0, null, null);
        double precioMayor = 0;
        for(int i=0; i<listaFiguras.size(); i++){
            Figura figuraAux = listaFiguras.get(i);
            if(figuraAux.getPrecioFigura() > precioMayor){
                figura = figuraAux;
                precioMayor = figuraAux.getPrecioFigura();
            }
        }
        return figura;
    }

    public double getValorColeccion(ArrayList<Figura> listaFiguras){
        Figura figura = new Figura(nombreColeccion, 0, null, null);
        double precioColeccion = 0;
        for(int i=0; i<listaFiguras.size(); i++){
            figura = listaFiguras.get(i);
            precioColeccion += figura.getPrecioFigura();
        }
        return precioColeccion;
    }
        
    public double getVolumenColeccion(ArrayList<Figura> listaFiguras){
        Dimension dimensiones;
        double volumenColeccion = 0;
        for(int i=0; i<listaFiguras.size(); i++){
            dimensiones = listaFiguras.get(i).getDimension();
            volumenColeccion += dimensiones.getVolumen(dimensiones.getAltoFigura(), dimensiones.getAnchoFigura(), dimensiones.getProfundidadFigura());
        }
        volumenColeccion += 200;
        return volumenColeccion;
    }
        
    @Override
    public String toString(){
        return "\n\nNOMBRE DE COLECCIÓN: "+this.nombreColeccion+""+this.listaFiguras;
    }
}