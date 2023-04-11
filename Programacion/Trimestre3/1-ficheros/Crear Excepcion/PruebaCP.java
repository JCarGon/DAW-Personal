public class PruebaCP {
    public static void main(String[] args) {
        try {
            CodigoPostal cp = new CodigoPostal("410164");
        } catch (ExcepcionCodigoPostal e) {
            System.out.println(e);
        }
    }
}