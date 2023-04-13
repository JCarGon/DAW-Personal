package ConnectionBBDD;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import javax.swing.JOptionPane;

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
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        conectar();
        String archivo = "pokedex.csv";
        String separador = ";";
        BufferedReader br = new BufferedReader(new FileReader(archivo));
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] campos = linea.split(separador);
            String ID = campos[0];
            String nombrePokemon = campos[1];
            String tipoPokemon = campos[2];
            String habilidadPokemon = campos[3];
            String habilidadOculta = campos[4];
            String faseEvolutiva = campos[5];
            String imagenPkm = campos[6];
            String sql = "INSERT INTO pokemon VALUES (" + ID + ", '" + nombrePokemon + "', '" + tipoPokemon + "', '" 
            + habilidadPokemon + "', '" + habilidadOculta + "', " + faseEvolutiva + ", '" + imagenPkm + "')";
            System.out.println(sql);
            try {
                consulta.executeUpdate(sql);
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("Error en la consulta:" + ex.getMessage());
            }
        }
        br.close();
        cerrar();
    }
    
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
    
}