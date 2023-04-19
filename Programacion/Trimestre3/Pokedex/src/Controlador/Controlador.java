package Controlador;
import Modelo.Pokemon;
import ConnectionBBDD.Conexion;

public class Controlador {
    //método que recoja nombre de usuario y lo mande a bbdd para ver si está; si no está no hay login - si está y contraseña coincide hay login
    
    //método que recoja la consulta, llame al método ejecutar consulta en la clase de Conexion y me devuelva el objeto Pokemon montado
    public static Pokemon obtenerPkmDeBBDD(String numero){
        return Conexion.darPokemon(numero);
    }
}