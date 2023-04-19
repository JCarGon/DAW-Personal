package Modelo;

public class Pokemon {
    private int ID;
    private String nombre_Pokemon;
    private String tipo_Pokemon;
    private String habilidad_pokemon;
    private String habilidad_Oculta;
    private String fase_Evolutiva;
    private String imagen_pokemon;

    public Pokemon(String nombre_Pokemon, String tipo_Pokemon, String habilidad_pokemon, String habilidad_Oculta, String fase_Evolutiva, String imagen_pokemon) {
        this.nombre_Pokemon = nombre_Pokemon;
        this.tipo_Pokemon = tipo_Pokemon;
        this.habilidad_pokemon = habilidad_pokemon;
        this.habilidad_Oculta = habilidad_Oculta;
        this.fase_Evolutiva = fase_Evolutiva;
        this.imagen_pokemon = imagen_pokemon;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre_Pokemon() {
        return nombre_Pokemon;
    }

    public void setNombre_Pokemon(String nombre_Pokemon) {
        this.nombre_Pokemon = nombre_Pokemon;
    }

    public String getTipo_Pokemon() {
        return tipo_Pokemon;
    }

    public void setTipo_Pokemon(String tipo_Pokemon) {
        this.tipo_Pokemon = tipo_Pokemon;
    }

    public String getHabilidad_pokemon() {
        return habilidad_pokemon;
    }

    public void setHabilidad_pokemon(String habilidad_pokemon) {
        this.habilidad_pokemon = habilidad_pokemon;
    }

    public String getHabilidad_Oculta() {
        return habilidad_Oculta;
    }

    public void setHabilidad_Oculta(String habilidad_Oculta) {
        this.habilidad_Oculta = habilidad_Oculta;
    }

    public String getFase_Evolutiva() {
        return fase_Evolutiva;
    }

    public void setFase_Evolutiva(String fase_Evolutiva) {
        this.fase_Evolutiva = fase_Evolutiva;
    }

    public String getImagen_pokemon() {
        return imagen_pokemon;
    }

    public void setImagen_pokemon(String imagen_pokemon) {
        this.imagen_pokemon = imagen_pokemon;
    }
    
    @Override
    public String toString(){
        return this.ID +", "+this.nombre_Pokemon+", "+this.tipo_Pokemon+", "+this.habilidad_pokemon+", "+this.habilidad_Oculta+", "+this.fase_Evolutiva+".";
    }
}