package Main;
import bbdd.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        try {
            Conexion.conectar();
            ResultSet rs = Conexion.ejecutarSentencia("SELECT * FROM pokemon");
            while(rs.next()){
                String name = rs.getString(2); //Es lo mismo que: String name = rs.getString("nombre_Pokemon");
                System.out.println(name);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}