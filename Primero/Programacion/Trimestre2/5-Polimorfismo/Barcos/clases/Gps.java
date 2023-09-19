package clases;
import java.time.LocalDate;

public class Gps {
    private double coorX;
    private double coorY;
    private LocalDate fecha;

    public Gps(double coorX, double coorY, LocalDate fecha){
        this.coorX = coorX;
        this.coorY = coorY;
        this.fecha = fecha;
    }

    public double getCoorX() {
        return coorX;
    }

    public double getCoorY() {
        return coorY;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setCoorX(double coorX) {
        this.coorX = coorX;
    }
    
    public void setCoorY(double coorY) {
        this.coorY = coorY;
    }
    
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Coordenadas: [X=" + coorX + ", Y=" + coorY + "]";
    }
}