import clases.*;

public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona("12345678-l", "Juan", "Aguilar", 30);
        System.out.println(persona.toString()+"\n");

        Joven joven = new Joven("87654321-J", "Manolo", "Caro", 20);
        System.out.println(joven.toString()+"\n");
        joven.saludar2();
    }
}