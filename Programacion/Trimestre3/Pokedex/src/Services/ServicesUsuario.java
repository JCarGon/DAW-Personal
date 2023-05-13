package Services;

import Modelo.Pokemon;
import Modelo.User;
import java.sql.*;
import javax.swing.JOptionPane;

public class ServicesUsuario {
    /*Recibe por parámetro nombre y contraseña;
    Hago una consulta a la bbdd para comprobar si hay alguna coincidencia con ese nombre y contraseña:
    -Si devuelve 1, significa que hay un usuario con esos datos y hace login (entra al sistema)
    -Si devuelve 0, significa que no hay un usuario con esos datos y no hace login.*/
    public static boolean login(String nombreUser, String pass){
        User user = new User(nombreUser, pass);
        String select = "SELECT COUNT(*) FROM user WHERE Nombre = '" + user.getNombre() + "' AND Pass = '" + user.getPassword() + "'";
        System.out.println(select);
        int count = 0;
        boolean login = false;
        ResultSet result;
        result = Conexion.ejecutarSentencia(select);
        try {
            if(result.next()){
                count = result.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("Error en la consulta sql: SELECT COUNT(*) FROM user WHERE Nombre = '" + user.getNombre() + "' AND Pass = '" + user.getPassword() + "'");
        }
        if(count == 1){
            JOptionPane.showMessageDialog(null, "Bienvenido a la Pokédex, entrenador "+user.getNombre()+".");
            login = true;
        }else{
            JOptionPane.showMessageDialog(null, "Credenciales incorrectas.");
        }
        return login;
    }
    
    /*Recibe por parámetro nombre y contraseña; si el usuario es root, no se puede crear;
    Hago una consulta a la bbdd para comprobar si hay alguna coincidencia con ese nombre de usuario:
    -Si devuelve 1, significa que ya hay un usuario y no dejo crear otro con el mismo nombre
    -Si devuelve 0, significa que no existe ese nombre y creo el usuario.*/
    public static void crearUsuario(String nombre, String pass){
        User user = new User(nombre, pass);
        int count = 0;
        ResultSet r;
        if(user.getNombre().toUpperCase().equals("ROOT")){
            JOptionPane.showMessageDialog(null, "No se puede crear un usuario root. Ya eres el root.");
        }else{
            try {
                r = Conexion.ejecutarSentencia("SELECT COUNT(*) FROM user WHERE Nombre = '"+user.getNombre()+"'");
                if(r.next()){
                   count = r.getInt(1);
                }
                if(count == 1){
                    JOptionPane.showMessageDialog(null, "El usuario ya existe.");
                }else{
                    String insert = "INSERT INTO user (Nombre, Pass) VALUES ('" + user.getNombre() + "', '" + user.getPassword() + "')";
                    Conexion.ejecutarUpdate(insert);
                    JOptionPane.showMessageDialog(null, "Usuario agregado a la base de datos correctamente.");
                }
            } catch (SQLException ex) {
                System.out.println("Error en el Select COUNT(*)."+ex);
            }
        }
    }
    
    /*Recibe por parámetro nombre de usuario; si el nombre introducido es ROOT, no se puede eliminar a dicho usuario;
    Hago una consulta a la bbdd para comprobar si hay alguna coincidencia con ese nombre:
    -Si devuelve 1, significa que hay un usuario con ese nombre, lo elimina de la bbdd y devuelve un true;
    -Si devuelve 0, significa que no hay un usuario con esos datos y devuelve un false.*/
    public static boolean deleteUser(String nombreUser){
        User user = new User(nombreUser, null);
        int count = 0;
        ResultSet r;
        boolean eliminar = false;
        if(user.getNombre().toUpperCase().equals("ROOT")){
            JOptionPane.showMessageDialog(null, "No se puede eliminar al usuario root.");
        }else{
            try {
                r = Conexion.ejecutarSentencia("SELECT COUNT(*) FROM user WHERE Nombre = '"+user.getNombre()+"'");
                if(r.next()){
                   count = r.getInt(1);
                }
            } catch (SQLException ex) {
                System.out.println("Error en el Select COUNT(*)."+ex);
            }
            if(count == 1){
                eliminar = true;
                String delete = "DELETE FROM user WHERE Nombre = '"+user.getNombre()+"'";
                System.out.println(delete);
                Conexion.ejecutarUpdate(delete);
                JOptionPane.showMessageDialog(null, "El usuario "+user.getNombre()+" ha sido borrado.");
            }else{
                JOptionPane.showMessageDialog(null, "Este usuario no se puede borrar porque no existe.");
            }
        }
        return eliminar;
    }
    
    /*Recibe por parámetro nombre de usuario; si el nombre introducido es ROOT, no se puede modificar a dicho usuario;
    Hago una consulta a la bbdd para comprobar si hay alguna coincidencia con ese nombre:
    -Si devuelve 1, significa que hay un usuario con ese nombre y devuelve un true;
    -Si devuelve 0, significa que no hay un usuario con esos datos y devuelve un false.*/
    public static boolean comprobarExistenciaUser(String nombre){
        User user = new User(nombre, null);
        int count = 0;
        ResultSet r;
        boolean existe = false;
        if(user.getNombre().toUpperCase().equals("ROOT")){
            JOptionPane.showMessageDialog(null, "No se puede modificar al usuario root.");
        }else{
            try {
                r = Conexion.ejecutarSentencia("SELECT COUNT(*) FROM user WHERE Nombre = '"+user.getNombre()+"'");
                if(r.next()){
                   count = r.getInt(1);
                }
                if(count == 1){
                    existe = true;
                }else{
                    JOptionPane.showMessageDialog(null, "Este usuario no se puede modificar porque no existe.");
                }
            } catch (SQLException ex) {
                System.out.println("Error en el Select COUNT(*)."+ex);
            }
        }
        return existe;
    }
    
    public static void modificarUser(String nombre, String pass, String nombreParaModificar){
        String update = "UPDATE user SET Nombre = '"+nombre+"', Pass = '"+pass+"' WHERE Nombre = '"+nombreParaModificar+"'";
        Conexion.ejecutarUpdate(update);
    }
    
    public static boolean comprobarSiUserTienePokemon(User user, Pokemon pokemon){
        boolean tienePokemon = false;
        for (Pokemon p : user.getEquipoPokemon()) {
            if(p.getID() == pokemon.getID()){ //si los ID son iguales, se trata del mismo pokemon y no lo añado
                tienePokemon = true;
                break; //que salga en el momento que encuentre el mismo pokemon, no es necesario seguir buscando
            }
        }
        return tienePokemon;
    }
    
    public static boolean addPokemonAlEquipo(User user, Pokemon pokemon){
        boolean add = false;
        if(user.getEquipoPokemon().isEmpty()){ //si la lista está vacía, añado al pokemon al equipo directamente
            add = true;
        }else if(user.getEquipoPokemon().size()==6){ // si la lista tiene un tamaño de 6, no se puede agregar más pokemon
            JOptionPane.showMessageDialog(null, "Ya tienes 6 pokemon en el equipo.");
            add = false;
        }else{ //si la lista no está vacía, la recorro para ver si ya está en la lista ese pokemon
            if(comprobarSiUserTienePokemon(user, pokemon)){ //si este método me devuelve true significa que ya está ese pokemon en la lista
               JOptionPane.showMessageDialog(null, "Ya tienes este pokemon en tu equipo.");
                add = false;
            }else{
                add = true;
            }
        }
        if(add){
            user.getEquipoPokemon().add(pokemon);
        }
        return add;
    }
    
    public static boolean deletePokemonDeEquipo(User user, Pokemon pokemon){
        boolean delete = false;
        if(user.getEquipoPokemon().isEmpty()){ //si el equipo está vacío, no hay nada que eliminar
            JOptionPane.showMessageDialog(null, "El equipo está vacío, no hay nada que eliminar.");
        }else if(!comprobarSiUserTienePokemon(user, pokemon)){
            JOptionPane.showMessageDialog(null, "No puedes eliminar este pokemon porque no está en tu equipo.");
        }else{
            for (Pokemon p : user.getEquipoPokemon()) {
                if(p.getID() == pokemon.getID()){ //si los ID son iguales, se trata del mismo pokemon y no lo añado
                    user.getEquipoPokemon().remove(p);
                    delete = true;
                    break; //que salga en el momento que encuentre el mismo pokemon, no es necesario seguir buscando
                }
            }
        }
        return delete;
    }
}