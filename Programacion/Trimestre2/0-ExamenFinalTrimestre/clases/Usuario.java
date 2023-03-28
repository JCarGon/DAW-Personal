import java.time.LocalDate;
import java.util.ArrayList;

public class Usuario extends Persona{
    private ArrayList<PlataformaStreaming> plataformasStreaming;
    private double saldo;
    private ArrayList<Contenido> contenidoFavoritos;

    public Usuario(int id, String nombre, LocalDate fechaNacimiento, double saldo){
        super(id, nombre, fechaNacimiento);
        this.plataformasStreaming = new ArrayList<>();
        this.saldo = saldo;
        this.contenidoFavoritos = new ArrayList<>();
    }

    public ArrayList<PlataformaStreaming> getPlataformasStreaming() {
        return plataformasStreaming;
    }

    public void setPlataformasStreaming(ArrayList<PlataformaStreaming> plataformasStreaming) {
        this.plataformasStreaming = plataformasStreaming;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public ArrayList<Contenido> getContenidoFavoritos() {
        return contenidoFavoritos;
    }

    public void setContenidoFavoritos(ArrayList<Contenido> contenidoFavoritos) {
        this.contenidoFavoritos = contenidoFavoritos;
    }
    
    public String listarPlataformas(){ //listar las plataformas a las que está suscritas el susuario
        String salidaPlataformas = "";
        for (PlataformaStreaming p : plataformasStreaming) {
            salidaPlataformas += p + "\n";
        }
        return salidaPlataformas;
    }

    public void darAltaPLataforma(PlataformaStreaming p){
        if(this.saldo > p.getPrecioSuscripcion()){ //compruebo si tiene dinero suficiente para pagar la suscripción
            if(this.plataformasStreaming.size()>0){ //compruebo que la lista tenga algo
                for(int i=0; i<this.plataformasStreaming.size(); i++){
                    if(this.plataformasStreaming.get(i).getId() == p.getId()){ //si el id de la plataforma que se quiere añadir coincide con un id ya existente
                        this.plataformasStreaming.remove(i); //elimino esa plataforma
                    }
                }
                this.plataformasStreaming.add(p); //añado la nueva
            }else{ //si la lista está vacía, lo añado directamente
                this.plataformasStreaming.add(p);
            }
        }else{ //no tiene suficiente dinero
            System.out.println("No tienes suficiente dinero para pagar la suscripción.");
        }

        //buscar si contengo el ID 1 y si lo está, dar de baja primero
        // if(this.plataformasStreaming.size()>0){
        //     for(int i=0; i<this.plataformasStreaming.size(); i++){
        //         if(this.plataformasStreaming.get(i).getId() == p.getId()){ //si el id ya está, lo elimino
        //             this.plataformasStreaming.remove(i);
        //             if(this.saldo >= p.getPrecioSuscripcion()){ //si el saldo del usuario es suficiente para pagar la suscripción, la añado a la lista
        //                 this.plataformasStreaming.add(p);
        //             }else{
        //                 System.out.println("No tiene suficiente dinero para pagar la suscripción.");
        //             }
        //         }else{
        //             if(this.saldo >= p.getPrecioSuscripcion()){ //si el saldo del usuario es suficiente para pagar la suscripción, la añado a la lista
        //                 this.plataformasStreaming.add(p);
        //             }else{
        //                 System.out.println("No tiene suficiente dinero para pagar la suscripción.");
        //             }
        //         }
        //     }
        // }else{
        //     if(this.saldo >= p.getPrecioSuscripcion()){ //si el saldo del usuario es suficiente para pagar la suscripción, la añado a la lista
        //         this.plataformasStreaming.add(p);
        //     }else{
        //         System.out.println("No tiene suficiente dinero para pagar la suscripción.");
        //     }
        // }
        
    }

    public void darBajaPlataforma(PlataformaStreaming p){
        //buscar si existe esa plataforma en la lista y si existe, quitarla
        if(this.plataformasStreaming.contains(p)){
            this.plataformasStreaming.remove(p);
        }
    }

    public void compartirContenido(Usuario u, Contenido c){
        //agregar un contenido favorito de un usuario a la lista del usuario del parámetro
        if(this.contenidoFavoritos.contains(c)){ //si el contenido está en mi lista de favoritos
            if(!u.getContenidoFavoritos().contains(c)){ //si el contenido no está en la lista de favoritos del usuario del parámetro, la añadimos
                u.getContenidoFavoritos().add(c);
            }else{ //si el contenido ya está en su lista de favoritos
                System.out.println("Este contenido ya está en su lista de favoritos.");
            }
        }else{ //si el contenido no está en mi lista de favoritos
            System.out.println("No se puede añadir porque no está en mi lista de favoritos.");
        }
    }

    public boolean addContenidoFavorito(Contenido c){
        if(!this.contenidoFavoritos.contains(c)){ //si mi lista no contiene el cotenido, lo añado
            return this.contenidoFavoritos.add(c);
        }else{ //si ya lo tengo en mi lista, no lo añado
            return false;
        }
        //si no está en la lista, añadir
    }

    public boolean eliminarContenidoFavorito(Contenido c){
        if(this.contenidoFavoritos.contains(c)){ //si mi lista tiene el contenido, lo elimino
            return this.contenidoFavoritos.remove(c);
        }else{ //si no está en la lista, notiificar que no está
            return false;
        }
    }

    public String listarContenidoFavoritos(){
        String listaContenidos = "";
        for (Contenido c : contenidoFavoritos) {
            listaContenidos += c + "\n";
        }
        return listaContenidos;
    }

    @Override
    public String toString(){
        return super.toString()+", saldo "+this.saldo+", plataformas de streaming "+this.plataformasStreaming+", contenidos favoritos "+this.contenidoFavoritos;
    }
}