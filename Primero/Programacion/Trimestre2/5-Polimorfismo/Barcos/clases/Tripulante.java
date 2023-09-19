package clases;

public abstract class Tripulante {
    private int nCarnet;
    private int edad;
    private int tiempoEmpresa;
    private String nombre;
    
    public Tripulante(int nCarnet, int edad, int tiempoEmpresa, String nombre){
        this.nCarnet = nCarnet;
        this.edad = edad;
        this.tiempoEmpresa = tiempoEmpresa;
        this.nombre = nombre;
    }

    public int getnCarnet() {
        return nCarnet;
    }

    public int getEdad() {
        return edad;
    }

    public int getTiempoEmpresa() {
        return tiempoEmpresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setnCarnet(int nCarnet) {
        this.nCarnet = nCarnet;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setTiempoEmpresa(int tiempoEmpresa) {
        this.tiempoEmpresa = tiempoEmpresa;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public abstract double sueldo();
    public abstract String mostrarDatos();
}