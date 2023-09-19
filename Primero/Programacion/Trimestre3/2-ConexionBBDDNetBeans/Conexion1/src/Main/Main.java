package Main;
import bbdd.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            Conexion.conectar();
            ResultSet rs = Conexion.ejecutarSentencia("SELECT * FROM pokemon WHERE ID = 25");
            while(rs.next()){
                String id = rs.getString("ID");
                String name = rs.getString("nombre_Pokemon"); //Es lo mismo que: String name = rs.getString(2);
                System.out.println(id+", "+name);
            }
        } catch (SQLException ex) {
            System.out.println("Eror al conectar con la BBDD. "+ex);
        }
    }
}