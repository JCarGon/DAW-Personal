import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Prueba {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        BigDecimal importeCompra = new BigDecimal (0);
        BigDecimal pago = new BigDecimal (0);
        BigDecimal cambioInicial = new BigDecimal (0), cambioFinal = new BigDecimal (0);
        BigDecimal contadorBilletes500 = new BigDecimal(0), contadorBilletes200 = new BigDecimal(0),
        contadorBilletes100 = new BigDecimal(0), contadorBilletes50 = new BigDecimal(0), contadorBilletes20 = new BigDecimal(0),
        contadorBilletes10 = new BigDecimal(0), contadorBilletes5 = new BigDecimal(0);
        BigDecimal contadorMonedas2e = new BigDecimal(0), contadorMonedas1e = new BigDecimal(0),
        contadorMonedas50c = new BigDecimal(0), contadorMonedas20c = new BigDecimal(0), contadorMonedas10c = new BigDecimal(0),
        contadorMonedas5c = new BigDecimal(0), contadorMonedas2c = new BigDecimal(0), contadorMonedas1c = new BigDecimal(0);

        System.out.print("\tCaja de cambio\n"
        +"Introduce el importe total de la compra: ");
        importeCompra = entrada.nextBigDecimal();
        /* Bucle para que me pida la cantidad con la que voy a pagar mientras sea menor que la cantidad que tengo que pagar */
        do{
            System.out.print("Introduce la cantidad con la que vas a pagar: ");
            pago = entrada.nextBigDecimal();
            if(pago.compareTo(importeCompra) == -1){
                System.out.println("La cantidad con la que vas a pagar debe ser mayor que la cantidad que tienes que pagar");
            }
        }while(pago.compareTo(importeCompra) == -1);
        entrada.close();

        /* La variable cambioInicial la voy a utilizar para mostrar en la salida final cuánto es la vuelta */
        cambioInicial = pago.subtract(importeCompra);
        /* La variable cambioFinal la voy a utilizar para operar con ella con los billetes y monedas */
        cambioFinal = cambioInicial;

        /*Este condicional if es para que entre si el cambio es mayor a 0, ya que si no tuviéramos cambio, no haría nada porque ya es 0.*/
        if(cambioFinal.compareTo(new BigDecimal(0)) == 1){
            /*Aquí se calculan los billetes de 500€, etc., siendo contadorBilletes500 (la cantidad de billetes de cada operación) 
            el resto de dividir el cambio actual entre 500 (y transformado en int); el resto de la división se guarda de nuevo en 
            cambioFinal para seguir operando con él y la siguiente cantidad.*/
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
            cambioFinal = cambioFinal.remainder(new BigDecimal(0.5));
        
            contadorMonedas20c = cambioFinal.divide(new BigDecimal(0.2),10,RoundingMode.HALF_UP);
            cambioFinal = cambioFinal.remainder(new BigDecimal(0.2));
        
            contadorMonedas10c = cambioFinal.divide(new BigDecimal(0.1),10,RoundingMode.HALF_UP);
            cambioFinal = cambioFinal.remainder(new BigDecimal(0.1));
        
            contadorMonedas5c = cambioFinal.divide(new BigDecimal(0.05),10,RoundingMode.HALF_UP);
            cambioFinal = cambioFinal.remainder(new BigDecimal(0.05));
        
            contadorMonedas2c = cambioFinal.divide(new BigDecimal(0.02),10,RoundingMode.HALF_UP);
            cambioFinal = cambioFinal.remainder(new BigDecimal(0.02));
        
            contadorMonedas1c = cambioFinal.divide(new BigDecimal(0.01),10,RoundingMode.HALF_UP);
            cambioFinal = cambioFinal.remainder(new BigDecimal(0.01));
        }
        
        /*Organizo cada contador dentro de un if > 0, para que así solo me muestre por pantalla los contadores de billetes y/o
        monedas que sean mayores a 0, es decir, los que tengan que devolver mínimo 1 billete o moneda.*/
        System.out.println("Su cambio es: "+cambioInicial+".\n");
        if(contadorBilletes500.compareTo(BigDecimal.ZERO) == 1){
            System.out.println("Aquí tiene "+contadorBilletes500.longValue()+" billete/s de 500.");
        }
        if(contadorBilletes200.compareTo(BigDecimal.ZERO) == 1){
            System.out.println("Aquí tiene "+contadorBilletes200.longValue()+" billete/s de 200.");
        }
        if(contadorBilletes100.compareTo(BigDecimal.ZERO) == 1){
            System.out.println("Aquí tiene "+contadorBilletes100.longValue()+" billete/s de 100.");
        }
        if(contadorBilletes50.compareTo(BigDecimal.ZERO) == 1){
            System.out.println("Aquí tiene "+contadorBilletes50.longValue()+" billete/s de 50.");
        }
        if(contadorBilletes20.compareTo(BigDecimal.ZERO) == 1){
            System.out.println("Aquí tiene "+contadorBilletes20.longValue()+" billete/s de 20.");
        }
        if(contadorBilletes10.compareTo(BigDecimal.ZERO) == 1){
            System.out.println("Aquí tiene "+contadorBilletes10.longValue()+" billete/s de 10.");
        }
        if(contadorBilletes5.compareTo(BigDecimal.ZERO) == 1){
          System.out.println("Aquí tiene " + contadorBilletes5.longValue() + " billete/s de 5.");
        }
        if(contadorMonedas2e.compareTo(BigDecimal.ZERO) == 1){
          System.out.println("Aquí tiene " + contadorMonedas2e.longValue() + " moneda/s de 2 euros.");
        }
        if(contadorMonedas1e.compareTo(BigDecimal.ZERO) == 1){
            System.out.println("Aquí tiene "+contadorMonedas1e.longValue()+" moneda/s de 1 euro.");
        }
        if(contadorMonedas50c.compareTo(BigDecimal.ZERO) == 1){
            System.out.println("Aquí tiene "+contadorMonedas50c.longValue()+" moneda/s de 50 céntimos.");
        }
        if(contadorMonedas20c.compareTo(BigDecimal.ZERO) == 1){
            System.out.println("Aquí tiene "+contadorMonedas20c.longValue()+" moneda/s de 20 céntimos.");
        }
        if(contadorMonedas10c.compareTo(BigDecimal.ZERO) == 1){
            System.out.println("Aquí tiene "+contadorMonedas10c.longValue()+" moneda/s de 10 céntimos.");
        }
        if(contadorMonedas5c.compareTo(BigDecimal.ZERO) == 1){
            System.out.println("Aquí tiene "+contadorMonedas5c.longValue()+" moneda/s de 5 céntimos.");
        }
        if(contadorMonedas2c.compareTo(BigDecimal.ZERO) == 1){
            System.out.println("Aquí tiene "+contadorMonedas2c.longValue()+" moneda/s de 2 céntimos.");
        }
        if(contadorMonedas1c.compareTo(BigDecimal.ZERO) == 1){
          System.out.println("Aquí tiene " + contadorMonedas1c.longValue() + " moneda/s de 1 céntimo.");
        }
    }
}