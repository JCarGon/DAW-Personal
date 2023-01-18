package clases;

public class Persona {
    public String nombre;
    public int edad;
    public char talla;
    public Camiseta camiseta;

    //constructor
    public Persona(String nombre, int edad, char talla){
        this.nombre = nombre;
        this.edad = edad;
    }

    //set
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setTalla(char talla){
        this.talla = talla;
    }
    public void setEdad(int edad){
        this.edad = edad;
    }
    public void setCamiseta(Camiseta camiseta){
        this.camiseta = camiseta;
    }

    //get
    public String getNombre(){
        return nombre;
    }
    public char getTalla(){
        return talla;
    }
    public int getEdad(){
        return edad;
    }
    public Camiseta getCamiseta(){
        return camiseta;
    }

    @Override
    public String toString(){
        return "La persona se llama "+nombre+", tiene"+edad+" años y tiene la talla "+talla+".";
    }

    /* le pasamos un objeto camiseta para que lo guarde en el atributo camiseta
    de la persona, que es un objeto camiseta */
    public void ponerCamiseta(Camiseta camiseta){
        this.camiseta = camiseta;
    }

    public void quitarCamiseta(Camiseta camiseta){
        this.camiseta = null;
    }

    public boolean probarCamiseta(){
        boolean comprobar = false;
        if(camiseta.talla == talla){ //comprobamos si la talla de la camiseta es igual a la talla del usuario
            comprobar = true;
        }else{
            quitarCamiseta(camiseta);
        }
        return comprobar;
    }
}