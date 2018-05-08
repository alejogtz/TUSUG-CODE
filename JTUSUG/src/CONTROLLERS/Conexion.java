package CONTROLLERS;

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
        //Roles y usuario y contraseña confifuracion
        if (rol.equals("root")) {
            Conexion.rol = "postgres";
            Conexion.contrasena = "root";
        } else if (rol.equals("secretaria")) {
            //Modificar
            Conexion.rol = "postgres";
            Conexion.contrasena = "root";
        }else {
            Conexion.rol = "postgres";
            Conexion.contrasena = "root";
        }

    }

    public static void setContrasena(String contrasena) {
        Conexion.contrasena = contrasena;
    }

    public static void setConfiguracion(String rol, String contrasena) {
        Conexion.rol = rol;
        Conexion.contrasena = contrasena;
    }
}
