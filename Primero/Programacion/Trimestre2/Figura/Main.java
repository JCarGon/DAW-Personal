import clases.Coleccion;
import clases.Dimension;
import clases.Figura;
import clases.Superheroe;

public class Main {
    public static void main(String[] args) {
        //Creación héroe 1
        Superheroe heroe1 = new Superheroe("All Might");
        System.out.println(heroe1.toString());
        heroe1.setDescripcion("El héroe que siempre sonríe ante cualquier mal");
        heroe1.setCapa(true);
        System.out.println(heroe1.toString()); //mostrar datos héroe 1
        //creación héroe 2
        Superheroe heroe2 = new Superheroe("Midoriya Izuku");
        heroe2.setDescripcion("Aprendiendo a controlar One for All");
        heroe2.setCapa(false);

        //medidas constructor vacío
        Dimension medida1 = new Dimension();
        System.out.println(medida1.toString());
        //medidas constructor con datos
        Dimension medida2 = new Dimension(10.16, 6.14, 5.59);
        System.out.println(medida2.toString());

        //creación de figura 1 insertando código, precio, figura 1 y medidas 1
        Figura figura1 = new Figura("EACD001", 79.90, heroe1, medida1);
        System.out.println("\n\nDATOS FIGURA:");
        System.out.println(figura1.toString());

        //Creación figura 2 insertando código, precio, figura 2 y medidas 2
        Figura figura2 = new Figura("ABB01", 49.99, heroe2, medida2);
        
        //Crear colección 1
        Coleccion coleccion1 = new Coleccion("My Hero Academia");
        coleccion1.addFigura(figura1); //insertar la figura 1 en la colección
        coleccion1.addFigura(figura2); //insertar figura 2 en la colección
        System.out.println(coleccion1.toString()); //mostrar la colección por pantalla
        coleccion1.subirPrecio(10, "ABB01"); //subir el precio a la figura con ese código (figura2)
        coleccion1.subirPrecio(10, "ABB021"); //intentar subir el precio a una figura inexistente
        System.out.println(coleccion1.toString()); //volver a mostrar por pantalla para comprobar la subida

        String coleccionConCapa = coleccion1.conCapa(); //Lista para guardar las figuras con capa
        System.out.println("\nDATOS DE LA COLECCIÓN DE FIGURAS CON CAPA: "+coleccionConCapa); // mostrar la lista de figuras con capa por pantalla
        Figura figuraMasValiosa = coleccion1.masValioso(); //objeto figura para la figura de mayor valor
        System.out.println("La figura más valiosa es: "+figuraMasValiosa.toString()); // mostrarla por pantalla
        Double valorColeccion = coleccion1.getValorColeccion(); // variable para el valor total de las figuras de esa colección
        System.out.println("El valor total de la colección es: "+valorColeccion+" euros."); // mostrar por pantalla el valor total
        double volumenColeccion = coleccion1.getVolumenColeccion(); // variable para el volumen total de la colección de figuras
        System.out.println("El volumen total de la colección es: "+volumenColeccion); // mostrar por pantalla
    }
}