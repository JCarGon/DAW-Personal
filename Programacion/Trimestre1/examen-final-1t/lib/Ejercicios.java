package lib;

public class Ejercicios {
	
	/** [1 PUNTO]
	 * Recibe una lista de regalos y los devuelve envueltos
	 *
	 * @return lista de regalos envueltos
	 */
	public static String[] envolverRegalos(String[] regalos){
		// Algoritmo para envolver los regalos
		String[] aux = new String[regalos.length]; 
		String palabraAux;

		for(int i=0; i<aux.length; i++){
			palabraAux = "*";
			for(int j=0; j<regalos[i].length(); j++){
				palabraAux += "*";
			}
			palabraAux += "*";

			palabraAux += "\n*";
			palabraAux += regalos[i];
			palabraAux += "*\n";

			palabraAux += "*";
			for(int j=0; j<regalos[i].length(); j++){
				palabraAux += "*";
			}
			palabraAux += "*";
			aux[i] = palabraAux;
			palabraAux = "";
		}
		return aux;
	}

	/** [2 PUNTO]
	 * Recibe un número y crea un cubo de la dimensión dada
	 *
	 * @return Cadena de texto que forma el cubo al ser impreso
	 */
	public static String crearCubo(int n){
		// Algoritmo para crear cubo de dimension n
		String cubo = "";
		String principioLineaSuperior = "/\\";
		String principioLineaInferior = "\\/";
		String linea1 = "/\\_\\";
		String linea2 = "\\/_/";
		String finalLineaSuperior = "_\\";
		String finalLineaInferior = "_/";

		for(int i=0; i<n; i++){ //pintar la parte superior del cubo
			for(int j=i+1; j<n; j++){ //pintar n-1 espacios
				cubo += " ";
			}
			for(int j=(n-i); j<n; j++){ //pintar el principioLineaSuperior 
				cubo += principioLineaSuperior;
			}
			cubo += linea1;
			for(int j=0; j<(n-1); j++){
				cubo += finalLineaSuperior; //tiene que pintarlo n-1 veces
			}
			cubo += "\n";
		}
		for(int i=0; i<n; i++){ //pintar la parte inferior del cubo
			for(int j=n-i; j<n; j++){ //pintar n-1 espacios
				cubo += " ";
			}
			for(int j=(i+1); j<n; j++){ //pintar el principioLineaInferior
				cubo += principioLineaInferior;
			}
			cubo += linea2;
			for(int j=0; j<(n-1); j++){
				cubo += finalLineaInferior; //tiene que pintarlo n-1 veces
			}

			if(i < n-1){
				cubo += "\n";
			}
		}
		return cubo;
	}

	/** [2 PUNTO]
	 * Recibe una cadena de texto y comprueba si es palíndroma
	 * Si la cadena de texto es palíndroma al retirar un carácter tambien es válida
	 *
	 * @return Valor booleano que indica si es o no palíndroma
	 */
	public static boolean comprobarPalabraEsPalindroma(String palabra){
		// Comprobar palíndromo con carácter extra
		char[] palabra1 = new char[palabra.length()];
        char[] palabraAuxiliar = new char[palabra.length()-1];
		String palabraPalindroma ="";
		String palabraAux = palabra;
        int contadorJ = 0;
		boolean palindroma = false;

		for(int i=0; i<palabra.length(); i++){ //para que lo repita tantas veces como letras tenga la palabra en cuestión
			palabra1[i] = palabra.charAt(i);//meter las letras en posiciones del array
		}
		//meter en el String palabraPalindroma la palabra1 en sentido contrario
		for(int i=palabra1.length-1; i>=0; i--){
			palabraPalindroma += palabra1[i];
		}
		
		if(palabra.compareTo(palabraPalindroma) == 0){ //si la comparación de las dos palabras es igual (==0)
			palindroma = true; //palindroma es true porque las palabras son iguales en sentidos contrarios
		}else{ //en caso que no sea true, vamos a quitar la letra correspondiente a la posición para comprobar si lo es
            for(int i=0; i<palabra.length() && !palindroma; i++){
                for(int k=0; k<palabra.length(); k++){
                    palabra1[k] = palabra.charAt(k); //meter las letras en posiciones del array para que parta del mismo lugar siempre
                }
                palabra1[i] = ' ';
                palabra = "";
                for(int j=0; j<palabra1.length; j++){ //para que lo repita tantas veces como letras tenga la palabra en cuestión
					if(palabra1[j] != ' '){ //si el caracter actual es diferente de vacío
                        palabraAuxiliar[contadorJ] = palabra1[j]; //meto la letra en la posición del array
                        contadorJ++;
                    }
				}
                contadorJ = 0; //restablecer contador a 0 para la siguiente ronda
                
                for(int j=0; j<palabraAuxiliar.length; j++){
                    palabra += palabraAuxiliar[j]; //meter en palabra los caracteres actuales para que formen la palabra sin la letra que quitamos al principio
                }

                palabraPalindroma = ""; //vaciar el String para que no contenga nada y le inserte la palabra actual sin la letra
				//meter en el String palabraPalindroma la palabra sin el carácter y en sentido contrario
				for(int j=palabraAuxiliar.length-1; j>=0; j--){
					palabraPalindroma += palabraAuxiliar[j];
				}
				if(palabra.compareTo(palabraPalindroma) == 0){
					palindroma = true;
				}else{
					palabra = palabraAux;
				}
			}
		}

		return palindroma;
	}

	/** [1 PUNTO]
	 * Recibe un array de booleanos cuyas posiciones indican si han pasado los tests.
	 * Posición 0 => Test ejercicio 1
	 * Posición 1 => Test ejercicio 2
	 * Posición 2 => Test ejercicio 3
	 * 
	 * @return Valor entero que indica la probabilidad si tus sueños se han cumplido
	 */
	public static int calcularProbabilidad(boolean[] tests){
		int porcentaje = 25;
		int contadorTrue = 0;
		for(int i=0; i<tests.length; i++){
			if(tests[i] == true){
				contadorTrue++;
			}
		}
		if(contadorTrue == 0){
			porcentaje = 25;
		}else if(contadorTrue == 1){
			porcentaje = 50;
		}else if(contadorTrue == 2){
			porcentaje = 75;
		}else{
			porcentaje = 100;
		}
		return porcentaje;
	}
}
