import lib.Ejercicios;

public class Examen1T {

	public static void main(String[] args) {
		/* Ejemplo de ejecución */
		String[] regalos = { "gato", "juego", "calcetines" };
		String[] regalos1Envueltos = Ejercicios.envolverRegalos(regalos);
		String regalo1 = "";
		String regalo1Comprobacion = "******\n*gato*\n******\n*******\n*juego*\n*******\n************\n*calcetines*\n************";
		
		/*  ARRAY REGALOS 1 GUARDAR EN REGALO1 */
		for(int i=0; i<regalos1Envueltos.length; i++){
			regalo1 += regalos1Envueltos[i];

			if(i < regalos1Envueltos.length-1){
				regalo1 += "\n";
			}
		}

		String[] regalos2 = { "xbox", "playstation", "switch" };
		String[] regalos2Envueltos = Ejercicios.envolverRegalos(regalos2);
		String regalo2 = "";
		String regalo2Comprobacion = "******\n*xbox*\n******\n*************\n*playstation*\n*************\n********\n*switch*\n********";
		
		/* ARRAY REGALOS 2 GUARDAR EN REGALO2 */
		for(int i=0; i<regalos2Envueltos.length; i++){
			regalo2 += regalos2Envueltos[i];
			if(i < regalos2Envueltos.length-1){
				regalo2 += "\n";
			}
		}

		String[] regalos3 = { "cocina", "aspiradora", "escoba" };
		String[] regalos3Envueltos = Ejercicios.envolverRegalos(regalos3);
		String regalo3 = "";
		String regalo3Comprobacion = "********\n*cocina*\n********\n************\n*aspiradora*\n************\n********\n*escoba*\n********";

		/* ARRAY REGALOS 3 GUARDAR EN REGALO3 */
		for(int i=0; i<regalos3Envueltos.length; i++){
			regalo3 += regalos3Envueltos[i];
			if(i < regalos3Envueltos.length-1){
				regalo3 += "\n";
			}
		}
		boolean testEj1 = regalo1.equals(regalo1Comprobacion) && regalo2.equals(regalo2Comprobacion) && regalo3.equals(regalo3Comprobacion);
		System.out.println("Test 1: "+testEj1);



		String cubo = Ejercicios.crearCubo(1);
		String cubo1Comprobacion = "/\\_\\\n\\/_/";
		//System.out.println(cubo);
		
		String cubo2 = Ejercicios.crearCubo(2);
		//System.out.println(cubo2);
		String cubo2Comprobacion = " /\\_\\_\\\n/\\/\\_\\_\\\n\\/\\/_/_/\n \\/_/_/";
		//System.out.println(cubo2Comprobacion);

		String cubo3 = Ejercicios.crearCubo(3);
		//System.out.println(cubo3);
		String cubo3Comprobacion = "  /\\_\\_\\_\\\n /\\/\\_\\_\\_\\\n/\\/\\/\\_\\_\\_\\\n\\/\\/\\/_/_/_/\n \\/\\/_/_/_/\n  \\/_/_/_/";
		//System.out.println(cubo3Comprobacion);

		boolean testEj2 = cubo.equals(cubo1Comprobacion) && cubo2.equals(cubo2Comprobacion) && cubo3.equals(cubo3Comprobacion);
		System.out.println("Test 2: "+testEj2);

		String palabra = "oso";
		boolean testEj3v1 = Ejercicios.comprobarPalabraEsPalindroma(palabra);
		String palabra2 = "alas";
		boolean testEj3v2 = Ejercicios.comprobarPalabraEsPalindroma(palabra2);
		String palabra3 = "alta";
		boolean testEj3v3 = Ejercicios.comprobarPalabraEsPalindroma(palabra3);
		boolean testEj3 = testEj3v1 && testEj3v2 && testEj3v3;
		System.out.println("Test 3: "+testEj3);
		
		boolean[] comprobaciones = {testEj1, testEj2, testEj3};
		int porcentaje = Ejercicios.calcularProbabilidad(comprobaciones);
		System.out.println("Probabilidad de sueños cumplidos: "+porcentaje+" %.");
	}
}