import clases.*;

public class Main {
    public static void main(String[] args) {
        Joven joven = new Joven("12345678-l", "Juan", "Aguilar", 30);
        Adulto adulto = new Adulto("12345678-l", "Juan", "Aguilar", 30);
        Anciano anciano = new Anciano("12345678-l", "Juan", "Aguilar", 30);
        Persona persona = new Persona("12345678-l", "Juan", "Aguilar", 30);
        
        /* Trata a cada clase como persona ya que heredan de esa clase
         * Persona joven = new Joven(); lo guarda y lo trata como una persona utilizando
           los métodos propios de la clase Joven.

           De esta manera podemos crear objetos de clases que heredan de la clase Persona,
           tratarlos y usarlos con los métodos de Persona y usan el suyo propio sobreescrito;
           además de esto, al ser objetos de clases diferentes, cada uno podrá usar sus
           métodos propios.
         */
        Persona[] personas = {
            joven, adulto, anciano, persona
        };
        
        for(Persona p : personas) { //bucle for each
            p.saludar();
            if(p instanceof Joven){
                Joven j = (Joven) p;
                j.saltar();
        //de esta manera casteamos el objeto Persona a Joven para usar su método propio
            }
        }
    }
}