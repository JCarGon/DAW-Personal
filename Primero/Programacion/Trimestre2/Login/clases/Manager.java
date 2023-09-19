package clases;

public class Manager extends Usuario{
    public Manager(String nombre, String pass){
        super(nombre, pass);
    }

    public void addUsuario(Usuario user){
        
    }

    @Override
    public String toString(){
        return "Soy un manager.";
    }
}