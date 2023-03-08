package clases;

public class Resfriado implements Ienfermedad{
    private String codigo;
    private boolean esCurable;

    public Resfriado(String codigo){
        this.codigo = codigo;
        esCurable = true;
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
        return this.getClass().getSimpleName() + ", curable: "+this.esCurable;
    }
}