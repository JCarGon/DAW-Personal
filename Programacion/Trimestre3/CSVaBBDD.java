import java.sql.*;
import java.io.*;

public class CSVaBBDD {
    
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mi_bd";
        String usuario = "usuario";
        String contraseña = "contraseña";
        String archivo = "datos.csv";
        String separador = ",";
        
        try {
            Connection conn = DriverManager.getConnection(url, usuario, contraseña);
            Statement stmt = conn.createStatement();
            
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(separador);
                String nombre = campos[0];
                int edad = Integer.parseInt(campos[1]);
                String sql = "INSERT INTO personas (nombre, edad) VALUES ('" + nombre + "', " + edad + ")";
                stmt.executeUpdate(sql);
            }
            br.close();
            
            stmt.close();
            conn.close();
        } catch (IOException | SQLException ex) {
            ex.printStackTrace();
        }
    }
}