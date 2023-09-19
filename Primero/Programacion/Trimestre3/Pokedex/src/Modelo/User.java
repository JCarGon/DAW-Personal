package Modelo;

import java.util.ArrayList;

public class User {
    private String nombre;
    private String password;
    private ArrayList<Pokemon> EquipoPokemon;

    public User(String nombre, String password) {
        this.nombre = nombre;
        this.password = password;
        EquipoPokemon = new ArrayList<Pokemon>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Pokemon> getEquipoPokemon() {
        return EquipoPokemon;
    }

    public void setEquipoPokemon(ArrayList<Pokemon> EquipoPokemon) {
        this.EquipoPokemon = EquipoPokemon;
    }
    
    @Override
    public String toString(){
        return this.nombre+", "+this.password+".";
    }
}