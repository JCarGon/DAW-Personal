package clases;

public class Mascota {
    String nombre;
    int vida;
    int ataque;

    public Mascota(String nombre, int vida, int ataque){
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setVida(int vida){
        this.vida = vida;
    }

    public int getVida(){
        return this.vida;
    }

    public void setAtaque(int ataque){
        this.ataque = ataque;
    }

    public int getAtaque(){
        return ataque;
    }

    @Override
    public String toString(){
        return "La mascota "+nombre+" tiene "+ataque+" puntos de ataque y "+vida+" puntos de vida.";
    }

    public void atacar(Mascota mascota){
        mascota.setVida(mascota.getVida()-this.ataque);
        if(mascota.getVida() > 0){
            System.out.println("La mascota "+mascota.getNombre()+" sigue con vida.");
        }else{
            System.out.println("La mascota "+mascota.getNombre()+" ha muerto.");
        }
        this.vida -= mascota.getAtaque();
        if(this.vida > 0){
            System.out.println("La mascota"+this.nombre+" sigue con vida.");
        }else{
            System.out.println("La mascota "+this.nombre+" ha muerto.");
        }
    }
}