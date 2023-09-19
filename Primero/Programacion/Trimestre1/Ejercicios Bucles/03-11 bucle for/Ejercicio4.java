import java.util.concurrent.TimeUnit;

public class Ejercicio4 {
    public static void main(String[] args) throws InterruptedException {
        int columna1 = 0;
        int columna2 = 0;
        int columna3 = 0;
        int columna4 = 0;
        int columna5 = 0;
        String borrar = "\b\b\b\b\b\b\b\b\b\b\b\b";

        while(columna1 <= 9){
            while(columna2 <= 9){
                while(columna3 <= 9){
                    while(columna4 <= 9){
                        while(columna5 <= 9){
                            if(columna5 == 3){
                                String e  = "E";
                                System.out.print(columna1+"-"+columna2+"-"+columna3+"-"+columna4+"-"+e);
                                TimeUnit.SECONDS.sleep(1);
                                columna5++;
                                System.out.print(borrar);
                            }
                            else{
                                System.out.print(columna1+"-"+columna2+"-"+columna3+"-"+columna4+"-"+columna5);
                                TimeUnit.SECONDS.sleep(1);
                                columna5++;
                                System.out.print(borrar);
                            }
                        }
                        columna5=0;
                        columna4++;
                    }
                    columna4=0;
                    columna3++;
                }
                columna3=0;
                columna2++;
            }
            columna2=0;
            columna1++;
        }
    }
}