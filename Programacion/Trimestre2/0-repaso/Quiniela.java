public class Quiniela {
    /* Generar una quyiniela de quince partidos con cinco apuestas. Consideraremos que la probabilidad de que gane el equipo de casa
    es del 50%, de empate un 30% y de que pierda un 20%.
     * Casa 50% -> >=0 && <=0.5
     * Empate 30% -> >0.5 && <= 0.7
     * Visitante 20% -> >0.7 && <=1
    */

    public static char RellenarPosicionQuiniela(double numeroAleatorio){
        char letra;
        boolean victoriaLocal = numeroAleatorio >= 0 && numeroAleatorio <= 0.5;
        boolean empate = numeroAleatorio > 0.5 && numeroAleatorio <= 0.7;
        boolean victoriaVisitante = numeroAleatorio > 0.7 && numeroAleatorio <= 1;
        if(victoriaLocal){
            letra = '1';
        }else if(empate){
            letra = 'X';
        }else{
            letra = '2';
        }
        return letra;
    }

    public static void mostrarQuiniela(char[][] quiniela){
        for(int i=0; i<quiniela.length; i++){
            System.out.print("Partido "+(i+1));
            if(i<9){
                System.out.print("     ");
            }else{
                System.out.print("    ");
            }
            for(int j=0; j<quiniela[i].length; j++){
                System.out.print(quiniela[i][j]+" ");
                System.out.print("   ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int numeroPartido = 15;
        int numeroApuestas = 5;
        char[][] quiniela = new char[numeroPartido][numeroApuestas];
        double numeroAleatorio;
        
        for(int i=0; i<quiniela.length; i++){
            for(int j=0; j<quiniela[i].length; j++){
                numeroAleatorio = Math.random(); //generar número aleatorio entre 0 y 1
                quiniela[i][j] = RellenarPosicionQuiniela(numeroAleatorio);
            }
        }
        mostrarQuiniela(quiniela);
    }
}