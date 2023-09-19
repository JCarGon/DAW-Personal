package clases;

public class ContactoEmpresa extends Contacto implements IcontactoEmpresa {
    private String paginaWeb;

    public ContactoEmpresa(String nombre, String telefono, String paginaWeb) {
        super(nombre, telefono);
        this.paginaWeb = paginaWeb;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    @Override
    public String toString(){
        return super.toString()
        +"\nPágina WEB: "+this.paginaWeb;
    }
}