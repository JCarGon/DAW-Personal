package Controlador;
import Modelo.Pokemon;
import Services.*;
import java.io.IOException;
import javax.swing.Icon;

public class Controlador {
    //método que recoja por parámetro el número para montar la consulta, se lo pasa al método darPokemon y me devuelva el objeto Pokemon creado
    public static Pokemon obtenerPkmDeBBDD(String numero){
        return ServicesPokemon.darPokemon(numero);
    }
    
    //método que recoje por parámetros un pokemon, altura y anchura para devolver un icon reescalado a dichos tamaños
    public static Icon obtenerIcon(Pokemon pokemon, int width, int height) throws IOException{
        return ServicesPokemon.devolverIconPokemon(pokemon, width, height);
    }
    
    //método que recoja por parámetros un pokemon y devuelva un String para montar los datos
    public static String devolverDatosPokemon(Pokemon pokemon){
        return ServicesPokemon.devolverDatos(pokemon);
    }
    
    //método que recoja nombre de usuario y contraseña y lo busque a bbdd para ver si existe el nombre; si existe no hago nada, si no existe lo creo (INSERT INTO)
    public static void crearUser(String nombre, String pass){
        ServicesUsuario.crearUsuario(nombre, pass);
    }
    
    //método que recoja el nombre de usuario y lo busque en bbdd; si elimina al usuario devuelve true - si no lo elimina, devuelve false
    public static boolean deleteUser(String nombre){
        return ServicesUsuario.deleteUser(nombre);
    }
    
    //método que recoja nombre de usuario y lo manda a bbdd para ver si está; si retorna true -> existe el usuario / si retorna false -> usuario no encontrado
    public static boolean comprobarExistenciaUser(String nombre){
        return ServicesUsuario.comprobarExistenciaUser(nombre);
    }
    
    //método que recoja nombre de usuario y lo mande a bbdd para ver si está; devuelve true si hay login - false si no lo hay
    public static boolean login(String nombre, String pass){
        return ServicesUsuario.login(nombre, pass);
    }
    
    public static void modificarUser(String nombre, String pass, String nombreParaModificar){
        ServicesUsuario.modificarUser(nombre, pass, nombreParaModificar);
    }
    
    //método pque recibe por parámetro el pokemon y una ruta de archivo para escribir los datos del pokemon en dicho archivo
    public static void escribirDatosPokemon(Pokemon pokemon, String ruta) throws IOException{
        ServicesPokemon.escribirPokemonEnFichero(pokemon, ruta);
    }
}