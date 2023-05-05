package Controlador;
import Modelo.Pokemon;
import Services.Conexion;

public class Controlador {
    //método que recoja por parámetro el número para montar la consulta, se lo pasa al método darPokemon y me devuelva el objeto Pokemon creado
    public static Pokemon obtenerPkmDeBBDD(String numero){
        return Conexion.darPokemon(numero);
    }
    
    //método que recoja nombre de usuario y contraseña y lo busque a bbdd para ver si existe el nombre; si existe no hago nada, si no existe lo creo (INSERT INTO)
    public static void crearUser(String nombre, String pass){
        Conexion.crearUsuario(nombre, pass);
    }
    
    //método que recoja el nombre de usuario y lo busque en bbdd; si elimina al usuario devuelve true - si no lo elimina, devuelve false
    public static boolean deleteUser(String nombre){
        return Conexion.deleteUser(nombre);
    }
    
    //método que recoja nombre de usuario y lo manda a bbdd para ver si está; si retorna true -> existe el usuario / si retorna false -> usuario no encontrado
    public static boolean comprobarExistenciaUser(String nombre){
        return Conexion.comprobarExistenciaUser(nombre);
    }
    
    //método que recoja nombre de usuario y lo mande a bbdd para ver si está; devuelve true si hay login - false si no lo hay
    public static boolean login(String nombre, String pass){
        return Conexion.login(nombre, pass);
    }
    
    public static void modificarUser(String nombre, String pass, String nombreParaModificar){
        Conexion.modificarUser(nombre, pass, nombreParaModificar);
    }
}