package Services;

import Modelo.Pokemon;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ServicesPokemon {
    /*Recibe el número del pokemon por parámetro, monta la consulta con dicho número, crea el objeto Pokemon y lo devuelve*/
    public static Pokemon darPokemon(String numero){
        String consulta = "SELECT * FROM pokemon WHERE PokemonID = "+numero;
        System.out.println(consulta);
        ResultSet rs = Conexion.ejecutarSentencia(consulta);
        Pokemon pokemon = null;
        try {
            while(rs.next()){
                int numero_Pokemon = rs.getInt("PokemonID");
                String nombre_Pokemon = rs.getString("nombre_Pokemon");
                String tipo_Pokemon = rs.getString("tipo_Pokemon");
                String habilidad_Pokemon = rs.getString("habilidad_Pokemon");
                String habilidad_Oculta = "";
                if(rs.getString("habilidad_Oculta").equals("NULL")){
                    habilidad_Oculta = "No tiene";
                }else{
                    habilidad_Oculta = rs.getString("habilidad_Oculta");
                }
                String fase_Evolutiva = "";
                if(rs.getString("fase_Evolutiva")== null){
                    fase_Evolutiva = "No tiene";
                }else{
                    fase_Evolutiva = rs.getString("fase_Evolutiva");
                }
                String foto = rs.getString("imagen_Pokemon");
                pokemon = new Pokemon(numero_Pokemon, nombre_Pokemon, tipo_Pokemon, habilidad_Pokemon, habilidad_Oculta, fase_Evolutiva, foto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pokemon;
    }
    
    //Recibe por parámetros un pokemon, alto y ancho para montar, reescalar la imagen y devolver un icon
    public static Icon devolverIconPokemon(Pokemon pokemon, int width, int height) throws IOException{
        BufferedImage img;
        //método para procesar la imagen
        img = ImageIO.read(new File("src/img/pokemons/"+pokemon.getImagen_pokemon()));
        // Create a ByteArrayOutputStream to write the image bytes to
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        // Write the image bytes to the ByteArrayOutputStream
        ImageIO.write(img, "png", baos);
        // Get the byte array from the ByteArrayOutputStream
        byte[] imageBytes = baos.toByteArray();
        ImageIcon imageIcon = new ImageIcon(imageBytes);
        Icon icon = new ImageIcon(imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
        return icon;
    }
    
    //Recibe por parámetro un pokemon para montar y devolver un String con sus datos
    public static String devolverDatos(Pokemon pokemon){
        String mostrarPantalla = "\n   Nombre: "+pokemon.getNombre_Pokemon()+"\n"
                +"   Tipo: "+pokemon.getTipo_Pokemon()+"\n"
                +"   Habilidad: "+pokemon.getHabilidad_pokemon()+"\n"
                +"   Habilidad Oculta: "+pokemon.getHabilidad_Oculta()+"\n"
                +"   Fase evolutiva: "+pokemon.getFase_Evolutiva();
        return mostrarPantalla;
    }
    
    public static void escribirPokemonEnFichero(Pokemon pokemon, String ruta) throws IOException{
        // Crear un objeto BufferedWriter para escribir en el archivo
        BufferedWriter writer = new BufferedWriter(new FileWriter(ruta, true));
        
        // Escribir en el fichero DatosPokemon.txt los datos del pokemon actual
        writer.write("###Número de Pokédex " +pokemon.getID()+ ", " +pokemon.getNombre_Pokemon() +" ![foto"+pokemon.getNombre_Pokemon()+"](.\\src\\img\\pokemons\\"+pokemon.getImagen_pokemon()+")"
            +"\n- Tipo: " +pokemon.getTipo_Pokemon() 
            +"\n- Habilidad: " + pokemon.getHabilidad_pokemon() 
            +"\n- Habilidad Oculta: " + pokemon.getHabilidad_Oculta() 
            +"\n- Fase evolutiva: " + pokemon.getFase_Evolutiva()+".");
        writer.newLine();

        // Cerrar el BufferedWriter para guardar los cambios en el archivo
        writer.close();
        
        // Mostrar un mensaje de éxito al usuario
        JOptionPane.showMessageDialog(null, "Datos generados correctamente.");
    }
}