public class ejercicio3g {
    public static void main(String[] args) {
        /* Realizar árbol de navidad */
        /* fase 1: 1-3 */
        for(int i=1; i<=3; i+=2){
            for(int j=i; j<7; j+=2){
                System.out.print(" ");
            }
            for(int k=i; k>0; k--){
                System.out.print("*");
            }
            System.out.println();
        }
        /* Fase 2: 1-3-5 */
        for(int i=1; i<=5; i+=2){
            for(int j=i; j<7; j+=2){
                System.out.print(" ");
            }
            for(int k=i; k>0; k--){
                System.out.print("*");
            }
            System.out.println();
        }
        /* Fase 3: 1-3-5-7 */
        for(int i=1; i<=7; i+=2){
            for(int j=i; j<7; j+=2){
                System.out.print(" ");
            }
            for(int k=i; k>0; k--){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int z=0; z<2; z++){
            System.out.println("  |||  ");
        }
    }
}