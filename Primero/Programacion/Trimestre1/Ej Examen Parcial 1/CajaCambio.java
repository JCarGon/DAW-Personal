import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class CajaCambio {
    public static void main(String[] args) {
        /*Lo he hecho con BigDecimal porque al hacerlo con float o double vi que había un error de precisión en el cálculo del cambio
        y eso lo arrastraba durante todo el código, mostrando de manera incorrecta el cambio y los billetes/monedas que devolvía, debido
        a que la máquina opera en binario y no en decimal, por lo que se pierden partes de las cantidades.
        BigDecimal te asegura que no se pierda precisión en los cálculos, y que el resultado sea el correcto.
         */
        Scanner entrada = new Scanner(System.in);
        /*Para declarar un BigDecimal se hace: BigDecimal "nombre" = new BigDecimal (valor)*/
        BigDecimal importeCompra = new BigDecimal (0);
        BigDecimal pago = new BigDecimal (0);
        BigDecimal cambioInicial = new BigDecimal (0), cambioFinal = new BigDecimal (0);
        /*Aquí declaro e inicializo  el contador de cada billete a 0*/
        BigDecimal contadorBilletes500 = new BigDecimal(0), contadorBilletes200 = new BigDecimal(0),
        contadorBilletes100 = new BigDecimal(0), contadorBilletes50 = new BigDecimal(0), contadorBilletes20 = new BigDecimal(0),
        contadorBilletes10 = new BigDecimal(0), contadorBilletes5 = new BigDecimal(0);
        /*Aquí declaro e inicializo  el contador de cada moneda a 0*/
        BigDecimal contadorMonedas2e = new BigDecimal(0), contadorMonedas1e = new BigDecimal(0),
        contadorMonedas50c = new BigDecimal(0), contadorMonedas20c = new BigDecimal(0), contadorMonedas10c = new BigDecimal(0),
        contadorMonedas5c = new BigDecimal(0), contadorMonedas2c = new BigDecimal(0), contadorMonedas1c = new BigDecimal(0);
        
        System.out.print("\tCaja de cambio\n"
        +"Introduce el importe total de la compra: ");
        importeCompra = entrada.nextBigDecimal();
        /* Bucle para que me pida la cantidad con la que voy a pagar, mientras sea menor que la cantidad que tengo que pagar */
        do{
            System.out.print("Introduce la cantidad con la que vas a pagar: ");
            pago = entrada.nextBigDecimal();
            /*Para comparar dos valores BigDecimal se usa el método .compareTo(), que tiene 3 posibilidades:
             * Si pago es mayor que importeCompra, devolvería 1;
             * Si pago es igual que importeCompra, devolvería 0;
             * Si pago es menor que importeCompra, devolvería -1;
             * Si el pago comparado con el importeCompra es menor (==-1), que muestre el mensaje por pantalla.*/
            if(pago.compareTo(importeCompra) == -1){
                System.out.println("La cantidad con la que vas a pagar debe ser mayor que la cantidad que tienes que pagar");
            }
        //Mientras pago sea menor que importeCompra, que vuelva a pedir el pago hasta que sea igual o mayor
        }while(pago.compareTo(importeCompra) == -1);
        entrada.close();

        /* La variable cambioInicial la voy a utilizar para mostrar en la salida final cuánto es la vuelta */
        cambioInicial = pago.subtract(importeCompra);
        /* La variable cambioFinal la voy a utilizar para operar con ella con los billetes y monedas */
        cambioFinal = cambioInicial;

        /*Este condicional if es para que entre si el cambio es mayor a 0, ya que si no tuviéramos cambio, no haría nada porque ya es 0.*/
        if(cambioFinal.intValue() > 1){
            /*Aquí se calculan cuántos billetes de 500€, etc. se van a usar, siendo contadorBilletes500 (la cantidad de billetes de 
            cada operación) el cociente de dividir el cambio actual entre 500; el resto de la división se guarda de nuevo en 
            cambioFinal para seguir operando con él y la siguiente cantidad.
            *Para dividir con la clase BigDecimal se utiliza numero1.divide(numero2) en vez de "/" y
            numero1.remainder(numero2) para sacar el resto de una división en lugar de "%".
            Dentro del método: divide(número entre el que vas a dividir, base de la operación (decimal=10), modo de redondeo(RoundingMode.HALF_UP))*/
            contadorBilletes500 = cambioFinal.divide(new BigDecimal(500),10,RoundingMode.HALF_UP);
            cambioFinal = cambioFinal.remainder(new BigDecimal(500));
            
            contadorBilletes200 = cambioFinal.divide(new BigDecimal(200),10,RoundingMode.HALF_UP);
            cambioFinal = cambioFinal.remainder(new BigDecimal(200));
        
            contadorBilletes100 = cambioFinal.divide(new BigDecimal(100),10,RoundingMode.HALF_UP);
            cambioFinal = cambioFinal.remainder(new BigDecimal(100));
        
            contadorBilletes50 = cambioFinal.divide(new BigDecimal(50),10,RoundingMode.HALF_UP);
            cambioFinal = cambioFinal.remainder(new BigDecimal(50));
        
            contadorBilletes20 = cambioFinal.divide(new BigDecimal(20),10,RoundingMode.HALF_UP);
            cambioFinal = cambioFinal.remainder(new BigDecimal(20));
        
            contadorBilletes10 = cambioFinal.divide(new BigDecimal(10),10,RoundingMode.HALF_UP);
            cambioFinal = cambioFinal.remainder(new BigDecimal(10));
        
            contadorBilletes5 = cambioFinal.divide(new BigDecimal(5),10,RoundingMode.HALF_UP);
            cambioFinal = cambioFinal.remainder(new BigDecimal(5));
        
            contadorMonedas2e = cambioFinal.divide(new BigDecimal(2),10,RoundingMode.HALF_UP);
            cambioFinal = cambioFinal.remainder(new BigDecimal(2));
        
            contadorMonedas1e = cambioFinal.divide(new BigDecimal(1),10,RoundingMode.HALF_UP);
            cambioFinal = cambioFinal.remainder(new BigDecimal(1));
        
            contadorMonedas50c = cambioFinal.divide(new BigDecimal(0.5),10,RoundingMode.HALF_UP);
            cambioFinal = cambioFinal.remainder(new BigDecimal("0.5"));
            /*Se pone entre "numero decimal" para que el decimal se considere como String e internamente lo convierta a BigDecimal*/
        
            contadorMonedas20c = cambioFinal.divide(new BigDecimal(0.2),10,RoundingMode.HALF_UP);
            cambioFinal = cambioFinal.remainder(new BigDecimal("0.2"));
        
            contadorMonedas10c = cambioFinal.divide(new BigDecimal(0.1),10,RoundingMode.HALF_UP);
            cambioFinal = cambioFinal.remainder(new BigDecimal("0.1"));
        
            contadorMonedas5c = cambioFinal.divide(new BigDecimal(0.05),10,RoundingMode.HALF_UP);
            cambioFinal = cambioFinal.remainder(new BigDecimal("0.05"));
        
            contadorMonedas2c = cambioFinal.divide(new BigDecimal(0.02),10,RoundingMode.HALF_UP);
            cambioFinal = cambioFinal.remainder(new BigDecimal("0.02"));
        
            contadorMonedas1c = cambioFinal.divide(new BigDecimal(0.01),10,RoundingMode.HALF_UP);
            cambioFinal = cambioFinal.remainder(new BigDecimal("0.01"));
        }
        
        /*Organizo cada contador dentro de un if > 0, para que así solo me muestre por pantalla los contadores de billetes y/o
        monedas que sean mayores a 0, es decir, los que tengan que devolver mínimo 1 billete o moneda.*/
        System.out.println("Su cambio es: "+cambioInicial+".\n");
        if(contadorBilletes500.intValue() > 0){
            System.out.println("Aquí tiene "+contadorBilletes500.intValue()+" billete/s de 500.");
            /*.intValue() para convertir el BigDecimal a entero y compararlo con 0, de manera que si es mayor muestra el mensaje por pantalla.
             *Dentro del mensaje, .intValue() para que me muestre la parte entera de contador.
            */
        }
        if(contadorBilletes200.intValue() > 0){
            System.out.println("Aquí tiene "+contadorBilletes200.intValue()+" billete/s de 200.");
        }
        if(contadorBilletes100.intValue() > 0){
            System.out.println("Aquí tiene "+contadorBilletes100.intValue()+" billete/s de 100.");
        }
        if(contadorBilletes50.intValue() > 0){
            System.out.println("Aquí tiene "+contadorBilletes50.intValue()+" billete/s de 50.");
        }
        if(contadorBilletes20.intValue() > 0){
            System.out.println("Aquí tiene "+contadorBilletes20.intValue()+" billete/s de 20.");
        }
        if(contadorBilletes10.intValue() > 0){
            System.out.println("Aquí tiene "+contadorBilletes10.intValue()+" billete/s de 10.");
        }
        if(contadorBilletes5.intValue() > 0){
            System.out.println("Aquí tiene "+contadorBilletes5.intValue()+" billete/s de 5.");
        }
        if(contadorMonedas2e.intValue() > 0){
            System.out.println("Aquí tiene "+contadorMonedas2e.intValue()+" moneda/s de 2 euros.");
        }
        if(contadorMonedas1e.intValue() > 0){
            System.out.println("Aquí tiene "+contadorMonedas1e.intValue()+" moneda/s de 1 euro.");
        }
        if(contadorMonedas50c.intValue() > 0){
            System.out.println("Aquí tiene "+contadorMonedas50c.intValue()+" moneda/s de 50 céntimos.");
        }
        if(contadorMonedas20c.intValue() > 0){
            System.out.println("Aquí tiene "+contadorMonedas20c.intValue()+" moneda/s de 20 céntimos.");
        }
        if(contadorMonedas10c.intValue() > 0){
            System.out.println("Aquí tiene "+contadorMonedas10c.intValue()+" moneda/s de 10 céntimos.");
        }
        if(contadorMonedas5c.intValue() > 0){
            System.out.println("Aquí tiene "+contadorMonedas5c.intValue()+" moneda/s de 5 céntimos.");
        }
        if(contadorMonedas2c.intValue() > 0){
            System.out.println("Aquí tiene "+contadorMonedas2c.intValue()+" moneda/s de 2 céntimos.");
        }
        if(contadorMonedas1c.intValue() > 0){
            System.out.println("Aquí tiene "+contadorMonedas1c.intValue()+" moneda/s de 1 céntimo.");
        }

        /*También se puede hacer con arrays y bucles for que reduciría las líneas. Comentar lo anterior y descomentar esto:*/
        // Scanner entrada = new Scanner(System.in);
        // /*Para declarar un BigDecimal se hace: BigDecimal "nombre" = new BigDecimal (valor)*/
        // BigDecimal importeCompra = new BigDecimal (0);
        // BigDecimal pago = new BigDecimal (0);
        // BigDecimal cambioInicial = new BigDecimal (0), cambioFinal = new BigDecimal (0);
        // //Array en el que inicializamos los contadores para los billetes a 0
        // BigDecimal[] contadorBilletes = {new BigDecimal(0), new BigDecimal(0), new BigDecimal(0),
        // //Array en el que inicializamos los contadores para las monedas a 0
        // new BigDecimal(0), new BigDecimal(0), new BigDecimal(0), new BigDecimal(0)};
        // BigDecimal[] contadorMonedas = { new BigDecimal(0), new BigDecimal(0), new BigDecimal(0), new BigDecimal(0),
        // new BigDecimal(0), new BigDecimal(0), new BigDecimal(0), new BigDecimal(0)};
        // //Array en el que inicializamos los valores de los billetes
        // BigDecimal[] cantidadesBilletes = {new BigDecimal(500), new BigDecimal(200), new BigDecimal(100),
        // new BigDecimal(50), new BigDecimal(20), new BigDecimal(10), new BigDecimal(5)};
        // //Array en el que inicializamos los valores de las monedas entre "" para que lo trate como String e internamente lo convierta a BigDecimal
        // BigDecimal[] cantidadesMonedas = {new BigDecimal(2), new BigDecimal(1), new BigDecimal("0.5"), new BigDecimal("0.2"),
        // new BigDecimal("0.1"), new BigDecimal("0.05"), new BigDecimal("0.02"), new BigDecimal("0.01")};

        // System.out.print("\tCaja de cambio\n"
        // +"Introduce el importe total de la compra: ");
        // importeCompra = entrada.nextBigDecimal();
        // /* Bucle para que me pida la cantidad con la que voy a pagar mientras sea menor que la cantidad que tengo que pagar */
        // do{
        //     System.out.print("Introduce la cantidad con la que vas a pagar: ");
        //     pago = entrada.nextBigDecimal();
        //     /*Para comparar dos valores BigDecimal se usa el método .compareTo(), que tiene 3 posibilidades:
        //      * Si pago es mayor que importeCompra, devolvería 1;
        //      * Si pago es igual que importeCompra, devolvería 0;
        //      * Si pago es menor que importeCompra, devolvería -1;
        //      * Si el pago comparado con el importeCompra es menor (==-1), que muestre el mensaje por pantalla.*/
        //     if(pago.compareTo(importeCompra) == -1){
        //         System.out.println("La cantidad con la que vas a pagar debe ser mayor que la cantidad que tienes que pagar");
        //     }
        // }while(pago.compareTo(importeCompra) == -1);
        // entrada.close();

        // /* La variable cambioInicial la voy a utilizar para mostrar en la salida final cuánto es la vuelta */
        // cambioInicial = pago.subtract(importeCompra);
        // /* La variable cambioFinal la voy a utilizar para operar con ella con los billetes y monedas */
        // cambioFinal = cambioInicial;

        // //Bucle for para recorrer el array de los billetes
        // for(int i=0; i<cantidadesBilletes.length; i++){
        //     //si cambioFinal es mayor (1) o igual (0) a la cantidad del billete actual, entra en el if
        //     if((cambioFinal.compareTo(cantidadesBilletes[i]) == 1) || (cambioFinal.compareTo(cantidadesBilletes[i]) == 0)){
        //         contadorBilletes[i] = cambioFinal.divide(cantidadesBilletes[i],10,RoundingMode.HALF_UP);
        //         cambioFinal = cambioFinal.remainder(cantidadesBilletes[i]);
        //     }
        // }
        // for(int i=0; i<cantidadesMonedas.length; i++){
        //     //si cambioFinal es mayor (1) o igual (0) a la cantidad de moneda actual, entra en el if
        //     if((cambioFinal.compareTo(cantidadesMonedas[i]) == 1) || (cambioFinal.compareTo(cantidadesMonedas[i]) == 0)){
        //         contadorMonedas[i] = cambioFinal.divide(cantidadesMonedas[i],10,RoundingMode.HALF_UP);
        //         cambioFinal = cambioFinal.remainder(cantidadesMonedas[i]);
        //     }
        // }

        // //Mensaje para mostrar el cambio a devolver
        // System.out.println("Su cambio es: "+cambioInicial+" euros.");
        // //Bucle for para mostrar la salida por pantalla de cada billete que se va a devolver, siempre que sea mayor a 0.
        // for(int i=0; i<cantidadesBilletes.length; i++){
        //     if(contadorBilletes[i].intValue() > 0){
        //         System.out.print("Aquí tiene "+contadorBilletes[i].intValue() + " billete/s de " + cantidadesBilletes[i] + ".\n");
        //     }
        // }
        // //Bucle for para mostrar la salida por pantalla de cada moneda que se va a devolver, siempre que sea mayor a 0.
        // for(int i=0; i<cantidadesMonedas.length; i++){
        //     if(contadorMonedas[i].intValue() > 0){
        //         System.out.print("Aquí tiene "+contadorMonedas[i].intValue() + " moneda/s de " + cantidadesMonedas[i] + ".\n");
        //     }
        // }
    }
}