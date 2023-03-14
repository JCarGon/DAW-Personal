package clases;

public interface Ialimento {
    public boolean isCaducado(); //consulta la propiedad caducado si es true or false, return
    public void setCaducado(boolean caducado); //hace que un alimento se caduque si es false
    public void caducar(); //aleatoriza el caducar un alimento
}