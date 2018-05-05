package Datos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Conexion{
	private static Connection conn = null;
	//URL de Descargar del Driver
	//https://jdbc.postgresql.org/download.html
	private Conexion(){}
	
	public void realizaConexion(){            
            String urlDatabase =  "jdbc:postgresql://localhost:5432/Tusug"; 
            try {
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection(urlDatabase, "postgres", "root");
            } catch (SQLException e) {
                System.err.println("Ocurrio un error : "+e.getMessage());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
	}
	
	public static Connection getConexion(){
		if (conn == null)
			new Conexion().realizaConexion();
		return conn;
	}
        public static void main(String [] args){
            System.out.println(
                    Conexion.getConexion()
            );
        }
}
