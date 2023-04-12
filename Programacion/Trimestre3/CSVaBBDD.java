import java.sql.*;
import java.io.*;

public class CSVaBBDD {
    
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mi_bd";
        String usuario = "usuario";
        String contraseña = "contraseña";
        String archivo = "pokedex.csv";
        String separador = ";";
        
        try {
            Connection conn = DriverManager.getConnection(url, usuario, contraseña);
            Statement stmt = conn.createStatement();
            
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(separador);
                String ID = campos[0];
                String nombrePokemon = campos[1];
                String tipoPokemon = campos[2];
                String habilidadPokemon = campos[3];
                String habilidadOculta = campos[4];
                int faseEvolutiva = campos[5];
                String imagenPkm = campos[6];
                String sql = "INSERT INTO personas (nombre, edad) VALUES ('" + ID + "', '" + nombrePokemon + "', '" + tipoPokemon + "', '" + habilidadPokemon 
                + "', '" + habilidadOculta + "', " + faseEvolutiva + ", '" + imagenPkm + "')";
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