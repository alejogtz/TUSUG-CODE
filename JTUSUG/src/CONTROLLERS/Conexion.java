package CONTROLLERS;
<<<<<<< HEAD
/*<<<<<<< HEAD
=======
//URL de Descargar del Driver
//https://jdbc.postgresql.org/download.html

>>>>>>> 8840b9aebe1899d36b9e81b4f8ec6aae7bbe557f*/
=======
>>>>>>> a1687182100ebde9b658097ae96887147c776014
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    //Rol por defecto
    private static String rol;
    private static String contrasena;
    private static Connection conn = null;

    private Conexion() {
    }

    public void realizaConexion() {
        String urlDatabase = "jdbc:postgresql://localhost:5432/Tusug";
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(urlDatabase, rol, contrasena);
        } catch (SQLException e) {
            System.err.println("Ocurrio un error : " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Connection getConexion() {
        if (conn == null) {
            new Conexion().realizaConexion();
        }
        return conn;
    }

    public static void main(String[] args) {
        Conexion.setRol("postgres");
        Conexion.setContrasena("root");
        System.out.println(
                Conexion.getConexion()
        );
    }

    public static void setRol(String rol) {
        Conexion.rol = rol;
    }

    public static void setContrasena(String contrasena) {
        Conexion.contrasena = contrasena;
    }
    
    public static void setConfiguracion(String rol, String contrasena){
        Conexion.rol = rol;
        Conexion.contrasena = contrasena;
    }
}