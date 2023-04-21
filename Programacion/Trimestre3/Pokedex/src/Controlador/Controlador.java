package Controlador;
import Modelo.Pokemon;
import ConnectionBBDD.Conexion;

public class Controlador {
    //método que recoja la consulta, llame al método ejecutar consulta en la clase de Conexion y me devuelva el objeto Pokemon montado
    public static Pokemon obtenerPkmDeBBDD(String numero){
        return Conexion.darPokemon(numero);
    }
    
    //método que recoja nombre de usuario y contraseña, lo mande a bbdd para ver si existe el nombre; si existe no hago nada, si no existe lo creo
    public static void crearUser(String nombre, String pass){
        Conexion.crearUsuario(nombre, pass);
    }
    
    //método que recoja el nombre de usuario, lo busque en bbdd y si coincide, que elimine el registro
    public static boolean deleteUser(String nombre){
        return Conexion.deleteUser(nombre);
    }
    
    //método que recoja nombre de usuario y lo mande a bbdd para ver si está; si retorna true -> ventana de modificar / si retorna false -> usuario no enocntrado
    public static boolean comprobarExistenciaUser(String nombre){
        return Conexion.comprobarExistenciaUser(nombre);
    }
    
    //método que recoja nombre de usuario y lo mande a bbdd para ver si está; si no está no hay login - si está y contraseña coincide hay login
    public static boolean login(String nombre, String pass){
        return Conexion.login(nombre, pass);
    }
}