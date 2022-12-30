import java.util.concurrent.TimeUnit;
public class Reloj {
    public static void main(String[] args) throws InterruptedException {
        int segundos = 0;
        int minutos = 0;
        int horas = 0;
        String borrar = "\b\b\b\b\b\b\b\b";

        while(horas < 24){
            while(minutos < 60){
                while(segundos < 60){
                    System.out.printf("%02d:%02d:%02d", horas, minutos, segundos);
                    TimeUnit.SECONDS.sleep(1);
                    segundos++;
                    System.out.print(borrar);
                }
                segundos = 0;
                minutos++;
            }
            minutos = 0;
            horas++;
        }
    }
}