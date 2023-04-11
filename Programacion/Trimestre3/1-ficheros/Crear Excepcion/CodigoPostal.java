public class CodigoPostal {
    private String cp;

    public CodigoPostal(String cp) throws ExcepcionCodigoPostal{
        this.cp = cp;
        if(cp.length() > 5){
            throw new ExcepcionCodigoPostal("El código postal introducido no es válido.");
        }
    }
}