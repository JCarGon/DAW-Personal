package clases;

public class Admin extends Manager{
    public Admin(String nombre, String pass){
        super(nombre, pass);
    }

    public void borrarUsuario(Usuario user){
        
    }

    @Override
    public String toString(){
        return "Soy un admin.";
    }
}