package ConnectionBBDD;

import java.sql.*;
import java.io.*;

public class CSVaBBDD {
    public static void main(String[] args) {
        String timeZone = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String url = "jdbc:mysql://localhost:3307/pokedex"+timeZone;
        String usuario = "root";
        String pass = "1234";
        String archivo = "pokedex.csv";
        String separador = ";";
        
        try {
            Connection conn = DriverManager.getConnection(url, usuario, pass);
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
                String faseEvolutiva = campos[5];
                String imagenPkm = campos[6];
                String sql = "INSERT INTO pokemon VALUES ('" + ID + "', '" + nombrePokemon + "', '" + tipoPokemon + "', '" 
                + habilidadPokemon + "', '" + habilidadOculta + "', '" + faseEvolutiva + "', '" + imagenPkm + "')";
                stmt.executeUpdate(sql);
            }
            br.close();
            stmt.close();
            conn.close();
        }  catch (IOException e){
            System.out.println("Error lectura fichero");
        } catch (SQLException ex) {
            System.out.println("No se ha podido conectar con la base de datos.");
        }
    }
}