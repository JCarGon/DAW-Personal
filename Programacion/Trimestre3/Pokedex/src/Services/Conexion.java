package Services;

import java.sql.*;
import javax.swing.JOptionPane;

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
}