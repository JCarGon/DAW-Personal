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
    
    public void atacar(Mascota mascota){ //mascota1.atacar(mascota2);
        mascota.setVida(mascota.getVida()-this.ataque); //la mascota 1 ataca a la 2
        this.vida -= mascota.getAtaque(); //la mascota 2 ataca a la 1
    }
    
    @Override
    public String toString(){
        return "La mascota "+nombre+" tiene "+ataque+" puntos de ataque y "+vida+" puntos de vida.";
    }

}