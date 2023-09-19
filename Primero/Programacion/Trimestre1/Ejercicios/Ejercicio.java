//import java.util.Scanner;

public class Ejercicio{
	public static void main(String[] args) {
		//if(args.length<2) return; //si la extensión del array tiene menos de 2 valores, que salga.
        /*Introducir un caracter como argumento y decir si es un número */
        
        // char caracter = args[0].charAt(0);
        // if(caracter >= '0' /*tabla ascii 48*/ && caracter <= '9' /*tabla ascii 57*/){
        //     System.out.println("El caracter "+caracter+" es un número.");
        // }
        // else{
        //     System.out.println("El carácter no es un número.");
        // }

        /* Decir si el caracter introducido es una mayúscula (SALE)*/ 
        // if(Character.isUpperCase(args[0].charAt(0)) == true){ //Si es verdad que el primer caracter del argumento está en mayúsculas
        //     System.out.println("El caracter introducido está en mayúscula.");
        // }
        // else{
        //     System.out.println("El caracter introducido está en minúsculas.");
        // }

        /*Introducir dos argumentos y decir si son iguales (SALE)*/
        // if(args.length<2) return;
        // if(args[0].equals(args[1])){
        //     System.out.println("Los parámetros son iguales.");
        // }
        // else{
        //     System.out.println("Los parámetros son diferentes.");
        // }

        /* Comparar 2 números y ver cuál es mayor (SALE)*/
        // if(Integer.parseInt(args[0]) > Integer.parseInt(args[1])){ //con Integer.paseInt convertimos en Integer el argumento
        //     System.out.println("El número "+args[0]+" es mayor que el número "+args[1]+".\n");
        // }
        // else if(Integer.parseInt(args[1]) > Integer.parseInt(args[0])){
        //     System.out.println("El número "+args[1]+" es mayor que el número "+args[0]+".\n");
        // }
        // else{
        //     System.out.println("Los números son iguales.\n");
        // }

        /* Introducir un número por argumentos y sacar los 3 números siguientes: (SALE)*/
        // System.out.println("El número introducido es "+args[0]+".\n"
        // +"Los 3 números siguientes son: "+(Integer.parseInt(args[0])+1)+", "+(Integer.parseInt(args[0])+2)+", "
        // +(Integer.parseInt(args[0])+3)+"\n");

        /* Introducir un número por argumentos y sacar los 3 números anteriores: (SALE)*/
        // System.out.println("El número introducido es: "+args[0]+".\n"
        // +"Los tres números anteriores son: "+(Integer.parseInt(args[0])-1)+", "+(Integer.parseInt(args[0])-2)+", "
        // +(Integer.parseInt(args[0])-3)+"\n");

        /* Introducir un número por argumentos y sacar las siguientes 3 potencias: (SALE)*/
        // System.out.println("El número introducido es: "+args[0]+", que está elevado a 1.\n"
        // +"Las tres potencias siguientes son: "+(Math.pow(Integer.parseInt(args[0]), 2))+", "+(Math.pow(Integer.parseInt(args[0]), 3))+", "
        // +(Math.pow(Integer.parseInt(args[0]), 4))+"\n");

        /* Transformar una nota numérica a su equivalente en letra */
        // Scanner entrada = new Scanner(System.in);
        // double nota = 0;

        // System.out.print("Introduce la nota numérica para comprobar cuál es su calificación: ");
        // nota = entrada.nextDouble();

        // if(nota<=4.9){
        //     System.out.println("La calificación es Insuficiente.");
        // }
        // else if(nota>=5 && nota <=5.9){
        //     System.out.println("la calificación es Suficiente.");
        // }
        // else if(nota>=6 && nota <= 6.9){
        //     System.out.println("La calificación es Bien.");
        // }
        // else if(nota>=7 && nota<= 8.9){
        //     System.out.println("La calificación es Notable.");
        // }
        // else if(nota>=9 && nota <= 10){
        //     System.out.println("La calificación es Sobresaliente.");
        // }
        // else{
        //     System.out.println("Ha introducido una nota no válida.");
        // }
        // System.out.println();

        // /* Introducir un número y decir con qué mes se corresponde */
        // int mes = 0;
        // System.out.print("Introduce un dígito del 1 al 12 para decir qué mes es: ");
        // mes = entrada.nextInt();
        // if(mes == 1){
        //     System.out.println("El mes es enero.");
        // }
        // else if(mes == 2){
        //     System.out.println("El mes es febrero.");
        // }
        // else if(mes == 3){
        //     System.out.println("El mes es marzo.");
        // }
        // else if(mes == 4){
        //     System.out.println("El mes es abril.");
        // }
        // else if(mes == 5){
        //     System.out.println("El mes es mayo.");
        // }
        // else if(mes == 6){
        //     System.out.println("El mes es junio.");
        // }
        // else if(mes == 7){
        //     System.out.println("El mes es julio.");
        // }
        // else if(mes == 8){
        //     System.out.println("El mes es agosto.");
        // }
        // else if(mes == 9){
        //     System.out.println("El mes es septiembre.");
        // }
        // else if(mes == 10){
        //     System.out.println("El mes es octubre.");
        // }
        // else if(mes == 11){
        //     System.out.println("El mes es noviembre.");
        // }
        // else if(mes == 12){
        //     System.out.println("El mes es diciembre.");
        // }
        // else{
        //     System.out.println("Ha introducido un número que no se corresponde con ningún mes.");
        // }
        // entrada.close();

        /* Programa que indique si una fecha es válida: dd (args[1]) / mm (args[2]) / aaaa (args[1]); Todos los meses son de 30 días; */
        // int dia = Integer.parseInt(args[0]);
        // int mes = Integer.parseInt(args[1]);
        // int año = Integer.parseInt(args[2]);
        // if(dia>=1 && dia<=30){
        //     if(mes>=1 && mes<=12){
        //         System.out.println("El año introducido es: "+dia+"/"+mes+"/"+año);
        //     }
        //     else{
        //         System.out.println("Ha introducido un mes no válido.");
        //     }
        // }
        // else{
        //     System.out.println("Ha introducido un día no válido.");
        // }

        /* Particularizar por mes; */
        int dia = Integer.parseInt(args[0]);
        int mes = Integer.parseInt(args[1]);
        int año = Integer.parseInt(args[2]);
        if(dia>=1 && dia<=28){
            if(mes==2){
                System.out.println("El año introducido es: "+dia+"/"+mes+"/"+año);
            }
            else if(dia>=1 && dia<=30){
                if(mes==4 || mes==6 || mes==9 || mes==11){
                    System.out.println("El año introducido es: "+dia+"/"+mes+"/"+año);
                }
                else if(dia>=1 && dia<=31){
                    if(mes==1 || mes==3 || mes==5 || mes==7 || mes==8 || mes==10 || mes==12){
                        System.out.println("El año introducido es: "+dia+"/"+mes+"/"+año);
                    }
                    else{
                        System.out.println("Ha introducido un día no válido para ese mes.");
                    }
                }
                else{
                    System.out.println("Ha introducido un día no válido para ese mes.");
                }
            }
        }

        /* Entrada DD/MM/AAA. Ejemplo: 01/10/2020 */
	}
}