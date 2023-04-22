package ConnectionBBDD;

import java.sql.*;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;
import Modelo.Pokemon;
import Modelo.User;

public class Conexion {
	
    static String timeZone = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    static String dbName = "pokedex";
    static String host = "localhost";
    static int port = 3306;
    static String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName + timeZone;
    static String user = "root";
    static String pass = "1234";
    static String driver = "com.mysql.cj.jdbc.Driver";

    static Connection conexion;
    static Statement consulta;
    static ResultSet resultado;
    
    public static void conectar(){
    	try {
            Class.forName(driver) ;
            conexion = DriverManager.getConnection(url, user, pass);
            System.out.println("Base de datos situada en :\n "+url);
            consulta = conexion.createStatement();
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public static ResultSet ejecutarSentencia(String sentencia){
        try {
            resultado = consulta.executeQuery(sentencia);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println("Error: " + sentencia);
        }
        return resultado;
    }
      
    public static void ejecutarUpdate(String sentencia){
    	try{
            consulta.executeUpdate(sentencia);
            System.out.println("Done: " + sentencia);
    	}catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println("Error: " + sentencia);
    	} 
    }
    
    public static void cerrar(){
        try{
            consulta.close();
        }catch(SQLException e){}
    }
    
    /*Recibe el número del pokemon por parámetro, monta la consulta con dicho número, crea el objeto Pokemon y lo devuelve*/
    public static Pokemon darPokemon(String numero){
        String consulta = "SELECT * FROM pokemon WHERE ID = "+numero;
        System.out.println(consulta);
        ResultSet rs = ejecutarSentencia(consulta);
        Pokemon pokemon = null;
        try {
            while(rs.next()){
                String nombre_Pokemon = rs.getString("nombre_Pokemon");
                String tipo_Pokemon = rs.getString("tipo_Pokemon");
                String habilidad_Pokemon = rs.getString("habilidad_Pokemon");
                String habilidad_Oculta = "";
                if(rs.getString("habilidad_Oculta")== null){
                    habilidad_Oculta = "No tiene habilidad oculta";
                }else{
                    habilidad_Oculta = rs.getString("habilidad_Oculta");
                }
                String fase_Evolutiva = "";
                if(rs.getString("fase_Evolutiva")== null){
                    fase_Evolutiva = "No tiene evolución";
                }else{
                    fase_Evolutiva = rs.getString("fase_Evolutiva");
                }
                String foto = rs.getString("imagen_Pokemon");
                pokemon = new Pokemon(nombre_Pokemon, tipo_Pokemon, habilidad_Pokemon, habilidad_Oculta, fase_Evolutiva, foto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pokemon;
    }
    
    /*Recibe por parámetro nombre y contraseña;
    Hago una consulta a la bbdd para comprobar si hay alguna coincidencia con ese nombre y contraseña:
    -Si devuelve 1, significa que hay un usuario con esos datos y hace login (entra al sistema)
    -Si devuelve 0, significa que no hay un usuario con esos datos y no hace login.*/
    public static boolean login(String nombreUser, String pass){
        User user = new User(nombreUser, pass);
        String select = "SELECT COUNT(*) FROM user WHERE Nombre = '" + user.getNombre() + "' AND Pass = '" + user.getPassword() + "'";
        System.out.println(select);
        int count = 0;
        boolean login = false;
        ResultSet result;
        result = ejecutarSentencia(select);
        try {
            if(result.next()){
                count = result.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("Error en la consulta sql: SELECT COUNT(*) FROM user WHERE Nombre = '" + user.getNombre() + "' AND Pass = '" + user.getPassword() + "'");
        }
        if(count == 1){
            JOptionPane.showMessageDialog(null, "Bienvenido a la Pokédex, entrenador "+user.getNombre()+".");
            login = true;
        }else{
            JOptionPane.showMessageDialog(null, "Credenciales incorrectas.");
        }
        return login;
    }
    
    /*Recibe por parámetro nombre y contraseña; si el usuario es root, no se puede crear;
    Hago una consulta a la bbdd para comprobar si hay alguna coincidencia con ese nombre de usuario:
    -Si devuelve 1, significa que ya hay un usuario y no dejo crear otro con el mismo nombre
    -Si devuelve 0, significa que no existe ese nombre y creo el usuario.*/
    public static void crearUsuario(String nombre, String pass){
        User user = new User(nombre, pass);
        int count = 0;
        ResultSet r;
        if(user.getNombre().toUpperCase().equals("ROOT")){
            JOptionPane.showMessageDialog(null, "No se puede crear un usuario root. Ya eres el root.");
        }else{
            try {
                r = ejecutarSentencia("SELECT COUNT(*) FROM user WHERE Nombre = '"+user.getNombre()+"'");
                if(r.next()){
                   count = r.getInt(1);
                }
                if(count == 1){
                    JOptionPane.showMessageDialog(null, "El usuario ya existe.");
                }else{
                    String insert = "INSERT INTO user VALUES ('" + user.getNombre() + "', '" + user.getPassword() + "')";
                    ejecutarUpdate(insert);
                    JOptionPane.showMessageDialog(null, "Usuario agregado a la base de datos correctamente.");
                }
            } catch (SQLException ex) {
                System.out.println("Error en el Select COUNT(*)."+ex);
            }
        }
    }
    
    /*Recibe por parámetro nombre de usuario; si el nombre introducido es ROOT, no se puede eliminar a dicho usuario;
    Hago una consulta a la bbdd para comprobar si hay alguna coincidencia con ese nombre:
    -Si devuelve 1, significa que hay un usuario con ese nombre, lo elimina de la bbdd y devuelve un true;
    -Si devuelve 0, significa que no hay un usuario con esos datos y devuelve un false.*/
    public static boolean deleteUser(String nombreUser){
        User user = new User(nombreUser, null);
        int count = 0;
        ResultSet r;
        boolean eliminar = false;
        if(user.getNombre().toUpperCase().equals("ROOT")){
            JOptionPane.showMessageDialog(null, "No se puede eliminar al usuario root.");
        }else{
            try {
                r = ejecutarSentencia("SELECT COUNT(*) FROM user WHERE Nombre = '"+user.getNombre()+"'");
                if(r.next()){
                   count = r.getInt(1);
                }
            } catch (SQLException ex) {
                System.out.println("Error en el Select COUNT(*)."+ex);
            }
            if(count == 1){
                eliminar = true;
                String delete = "DELETE FROM user WHERE Nombre = '"+user.getNombre()+"'";
                System.out.println(delete);
                ejecutarUpdate(delete);
                JOptionPane.showMessageDialog(null, "El usuario "+user.getNombre()+" ha sido borrado.");
            }else{
                JOptionPane.showMessageDialog(null, "Este usuario no se puede borrar porque no existe.");
            }
        }
        return eliminar;
    }
    
    /*Recibe por parámetro nombre de usuario; si el nombre introducido es ROOT, no se puede modificar a dicho usuario;
    Hago una consulta a la bbdd para comprobar si hay alguna coincidencia con ese nombre:
    -Si devuelve 1, significa que hay un usuario con ese nombre y devuelve un true;
    -Si devuelve 0, significa que no hay un usuario con esos datos y devuelve un false.*/
    public static boolean comprobarExistenciaUser(String nombre){
        User user = new User(nombre, null);
        int count = 0;
        ResultSet r;
        boolean existe = false;
        if(user.getNombre().toUpperCase().equals("ROOT")){
            JOptionPane.showMessageDialog(null, "No se puede modificar al usuario root.");
        }else{
            try {
                r = ejecutarSentencia("SELECT COUNT(*) FROM user WHERE Nombre = '"+user.getNombre()+"'");
                if(r.next()){
                   count = r.getInt(1);
                }
                if(count == 1){
                    existe = true;
                }else{
                    JOptionPane.showMessageDialog(null, "Este usuario no se puede modificar porque no existe.");
                }
            } catch (SQLException ex) {
                System.out.println("Error en el Select COUNT(*)."+ex);
            }
        }
        return existe;
    }
    
    public static void modificarUser(String nombre, String pass, String nombreParaModificar){
        String update = "UPDATE user SET Nombre = '"+nombre+"', Pass = '"+pass+"' WHERE Nombre = '"+nombreParaModificar+"'";
        ejecutarUpdate(update);
   }
}