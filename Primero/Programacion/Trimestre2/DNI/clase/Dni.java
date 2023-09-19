package clase;

public class Dni {
    int numeroDNI;
    String letra;

    public Dni(){
        this.numeroDNI = 0;
        this.letra = "";
    }

    public Dni(int numeroDNI){
        //recibe dni y te dice la letra
        this.numeroDNI = numeroDNI;
        this.letra = letraDNI(numeroDNI);
    }

    private String letraDNI(int numero){
        String[] letras = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};
        String letra ="";
        int resto = (int) numero % 23;
        for(int i=0; i<letras.length; i++){
            if(resto == i){
                letra = letras[i];
            }
        }
        return letra;
    }

    @Override
    public String toString(){
        return "El DNI es: "+this.numeroDNI+"-"+this.letra+".";
    }
}