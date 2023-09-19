import clases.*;

public class Main{
    public static void main(String[] args) {
    /*
    DEclaramos cada animal en el tipo que le pertenece pero los creamos en la clase Animal, para que así, además de su tipo concreto,
    sean considerados como animales.
    */
        Gato gato = new Gato("Gatete");
        Perro perro = new Perro("Perrete");
        Bulldog bulldog = new Bulldog("Bulldog");
        Pajaro pajarillo = new Pajaro("Pajarillo");
        Dragon dragon =new Dragon("Dragón");

        System.out.println(gato);
        System.out.println(perro);
        System.out.println(bulldog);
        System.out.println(pajarillo);
        System.out.println(dragon);
        System.out.println();

//Meto los objetos de las diferentes clases en un array de objetos tipo Persona
        Animal[] animales = {gato, perro, bulldog, pajarillo, dragon};
//Recorro el array con un bucle for each y utilizo el método saludar de cada objeto
        for(Animal a: animales){
            a.saludar();
            a.gritar();
    /*Para comprobar si los objetos del array pueden volar lo hacemos con instanceof Volador, de manera que si es un objeto que pertenece a la interface 
    le hará cast a la clase Volador y usará el método volar de su propia clase.*/
            if(a instanceof Volador){
                ((Volador)a).volar();
            }
        }
    }
}

/* Lo mejor es instanciar un objeto con su propia clase para que así pueda ser considerado como un objeto de su clase padre y pueda utilizar métodos de su interface */