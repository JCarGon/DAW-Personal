package clases;

public interface Ienfermedad {
    public String getCodigo();
    public void setCodigo(String codigo);
    public void setEsCurable(boolean esCurable);
    public boolean getEsCurable();
    public void contagiar(Paciente paciente);
}