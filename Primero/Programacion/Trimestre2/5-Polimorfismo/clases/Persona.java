package clases;

//Clase padre o superclase
public class Persona{
    /*
        TIPOS DE PRIVACIDAD PARA VARIABLES
            private: solo yo
            protected: dentro de mi paquete
            public: todos
    */
    protected String dni;
    protected String nombre;
    protected String apellido;
    protected int edad;

    public Persona(String dni, String nombre, String apellido, int edad){
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public void saludar(){
        System.out.println("Hola soy persona");
    }

    @Override
    public String toString(){
        return this.nombre+" "+this.apellido+
        "\nDNI: "+this.dni+
        "\nEdad: "+this.edad+" años";
    }
}
