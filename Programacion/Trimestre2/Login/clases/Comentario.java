package clases;

import java.time.LocalDate;

public class Comentario {
    String usuario;
    String texto;
    LocalDate fecha;

    public Comentario(String usuario, String texto) {
        this.usuario = usuario;
        this.texto = texto;
        this.fecha = LocalDate.now();
    }

    public String getUsuario() {
        return usuario;
    }

    public String getTexto() {
        return texto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString(){
        return "Usuario del comentario: "+this.usuario+
        "\nComentario: "+this.texto+
        "\nFecha del comentario: "+this.fecha;
    }
}