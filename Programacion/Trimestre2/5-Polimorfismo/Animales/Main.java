import clases.*;

public class Main{
    public static void main(String[] args) {
    /*
    DEclaramos cada animal en el tipo que le pertenece pero los creamos en la clase Animal, para que así, además de su tipo concreto,
    sean considerados como animales.
    */
        Animal gato = new Gato("Gatete");
        Animal perro = new Perro("Perrete");
        Animal bulldog = new Bulldog("Bulldog");
        Animal pajarillo = new Pajaro("Pajarillo");
        Animal dragon =new Dragon("Dragón");

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
        }
    }
}