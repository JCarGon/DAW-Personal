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
    static int port = 3307;
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
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static ResultSet ejecutarSentencia(String sentencia){
        try {
            resultado = consulta.executeQuery(sentencia);
        }catch(Exception e){
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
        }catch(Exception e){}
    }
    
    public static Pokemon darPokemon(String numero){
        String consulta = "SELECT * FROM pokemon WHERE ID = "+numero;
        ResultSet rs = ejecutarSentencia(consulta);
        Pokemon pokemon = null;
        try {
            while(rs.next()){
                String nombre_Pokemon = rs.getString("nombre_Pokemon");
                String tipo_Pokemon = rs.getString("tipo_Pokemon");
                String habilidad_Pokemon = rs.getString("habilidad_Pokemon");
                String habilidad_Oculta = rs.getString("habilidad_Oculta");
                String fase_Evolutiva = "";
                if(rs.getString("fase_Evolutiva")== null){
                    fase_Evolutiva = "No tiene evolución.";
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
    
    public static void crearUsuario(String nombre, String pass){
        User user = new User(nombre, pass);
        int count = 0;
        ResultSet r = null;
        if(user.getNombre().toUpperCase().equals("ROOT")){
            JOptionPane.showMessageDialog(null, "No se puede crear un usuario root. Ya eres el root.");
        }else{
            //SELECT COUNT(*) FROM USER WHERE NOMBRE=user.getNOMBRE(); si == 1 -> no se puede crear; si == 0 -> lo creo
            try {
                r = ejecutarSentencia("SELECT COUNT(*) FROM user WHERE Nombre = '"+user.getNombre()+"';");
                count = r.getInt(1);
                if(count == 1){
                    JOptionPane.showMessageDialog(null, "El usuario ya existe.");
                }else{
                    String insert = "INSERT INTO user VALUES ('" + user.getNombre() + "', '" + user.getPassword() + "')";
                    ejecutarUpdate(insert);
                }
            } catch (SQLException ex) {
                System.out.println("Error en el Select COUNT(*)."+ex);
            }
        }
    }
}