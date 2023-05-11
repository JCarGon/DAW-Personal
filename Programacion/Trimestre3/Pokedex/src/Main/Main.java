package Main;

import Services.Conexion;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import Vista.PantallaCarga;

public class Main {

    public static void main(String[] args) {
        try{
            Conexion.conectar();
            ResultSet rs = Conexion.ejecutarSentencia("SELECT COUNT(*) FROM pokemon;");
            rs.next();
            int cantidadRegistros = rs.getInt(1);
            if(cantidadRegistros == 0){ //si la tabla pokemon está vacía, la rellena; en caso contrario inicia directamente el JFrame Inicio
                String archivo = "pokedex.csv";
                String separador = ";";
                BufferedReader br = null;
                try {
                    br = new BufferedReader(new FileReader(archivo));
                } catch (FileNotFoundException ex) {
                    System.out.println("Error en la lectura del archivo.");
                }
                String linea;
                try {
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
                        Conexion.ejecutarUpdate(sql);
                    }
                } catch (IOException ex) {
                System.out.println(ex);
                }
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        PantallaCarga pantallaCarga = new PantallaCarga();
    }
}