package clases;
/* Nunca vamos a crear un objeto animal (no se puede al ser clase abstracta),
crearemos uno específico, pero sí queremos que esta clase sea padre
para que las demás hereden sus propiedades y métodos, siendo obligatorio
que los usen todos (hay que definirlos en las demás clases).
*/
public abstract class Animal {
    private String nombre;

    public Animal(String nombre){
        this.nombre = nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return this.nombre;
    }

    abstract public void saludar();

    abstract public void gritar();

    @Override
    public String toString(){
        return "Hola, soy un "+this.nombre;
    }
}