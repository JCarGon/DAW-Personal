import java.time.LocalDate;

import clases.*;

public class Main {
    public static void main(String[] args) {
        LocalDate fecha1 = LocalDate.of(1987, 5, 18);
        Jugador jugador = new Jugador("Pique", fecha1, "catalana", "delantero", 3, "F.C. Barcelona");
        String jugadorPorPantalla = jugador.toString();
        jugador.setDorsal(15);
        jugador.setNTarjetasAmarillas(4);
        jugador.setNTarjetasRojas(1);
        System.out.println(jugadorPorPantalla);
        
        Equipo equipo1 = new Equipo("Pelotas FC", "2022-2023");
        String equipoPorPantalla = equipo1.toString();
        System.out.println(equipoPorPantalla);

        Persona persona1 = new Persona("Jesus", 29, 'M'); //creamos la persona
        Camiseta camiseta1 = new Camiseta("Rojo", 'L', "Adidas", "Algodón"); //creamos la camiseta
        persona1.ponerCamiseta(camiseta1); //le ponemos la camiseta1 a la persona1
        System.out.println(camiseta1.toString()); //sacamos los datos de la camiseta
        System.out.println(persona1.toString()); //sacamos los datos de la persona
        boolean test = persona1.probarCamiseta(); //comprobamos las tallas
        System.out.println(test); //resultado de comprobar si las tallas de camiseta y persona son iguales
        System.out.println(persona1.getCamiseta()); //comprobar la camiseta que tiene (si es false, no tiene camiseta)
        
        // //crear un objeto con atributos de la clase carta
        // Carta micarta2 = new Carta(0, null);
        // micarta2.valor = 3;
        // micarta2.palo = "corazones";
        // mostrarCarta(micarta2);

        // //Generar 10 cartas de cada palo
        // Carta[] oros = generarCartas(10, "oros");
        // Carta[] bastos = generarCartas(10, "bastos");
        // Carta[] espadas = generarCartas(10, "espadas");
        // Carta[] copas = generarCartas(10, "copas");

        // //Mostrar las 10 cartas de cada palo
        // for(int i=0; i<oros.length; i++){
        //     mostrarCarta(oros[i]);
        // }
        // for(int i=0; i<bastos.length; i++){
        //     mostrarCarta(bastos[i]);
        // }
        // for(int i=0; i<espadas.length; i++){
        //     mostrarCarta(espadas[i]);
        // }
        // for(int i=0; i<copas.length; i++){
        //     mostrarCarta(copas[i]);
        // }
        
        // /* Meter todas las cartas en una baraja */
        // System.out.println("\nEmpieza la baraja");
        // Carta[] baraja = new Carta[oros.length+bastos.length+espadas.length+copas.length]; //extensión = suma de cartas de cada palo
        // for(int i=0; i<oros.length; i++){
        //     baraja[i] = oros[i];
        //     baraja[i+10] = bastos[i]; //la primera de bastos es la 10 de la baraja
        //     baraja[i+20] = espadas[i];//la primera de espadas es la 20 de la baraja
        //     baraja[i+30] = copas[i];//la primera de copas es la 30 de la baraja
        // }
        // //Mostrar las cartas de la baraja
        // for(int i=0; i<baraja.length; i++){
        //     mostrarCarta(baraja[i]);
        // }

        // //objeto de la clase zapato
        // Zapato zapato1 = new Zapato();
        // zapato1.numero = 42;
        // zapato1.marca = "Nike";
        // zapato1.color = "blanco";
        // zapato1.mostrarDatos();
    }

    static void mostrarCarta(Carta carta){
        System.out.println(carta.valor+" de "+carta.palo);
    }

    static Carta[] generarCartas(int numCartas, String palo){
        Carta[] cartas = new Carta[numCartas]; //array de objetos cartas
        for(int i=0; i<cartas.length; i++){
            cartas[i] = new Carta(i+1, palo); //crea el objeto específico carta
            cartas[i].valor = i+1; //le asigna un valor
            cartas[i].palo = palo; //y un palo
        }
        return cartas;
    }
}