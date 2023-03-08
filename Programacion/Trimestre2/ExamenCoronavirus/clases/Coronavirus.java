package clases;

public class Coronavirus implements Ienfermedad{
    private String codigo;
    private boolean esCurable;

    public Coronavirus(String codigo){
        this.codigo = codigo;
        esCurable = false;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public boolean getEsCurable() {
        return esCurable;
    }
    
    public void setEsCurable(boolean esCurable) {
        this.esCurable = esCurable;
    }

    public void setCodigo(String codigo){
        this.codigo = codigo;
    }

    public void contagiar(Paciente paciente){
        paciente.enfermar(this);
    }

    @Override
    public String toString(){
        return this.codigo + ", curable: "+this.esCurable;
    }
}