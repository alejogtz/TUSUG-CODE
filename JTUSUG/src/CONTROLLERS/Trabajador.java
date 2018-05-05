
package CONTROLLERS;

import java.sql.Date;
import GUI.TrabajadorGUI;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Trabajador {
    TrabajadorGUI interfaz;
    Conexion c;
    
    public Trabajador(TrabajadorGUI ui, Conexion con){
        interfaz = ui;
        c = con;
    }
     
    
    public void agregaTrabajador(){
        int rfc=interfaz.jfrfc.getText();
    }
    
    public void addT(int rfc, String nss, String nombre, String apellidos, String domicilio, String curp, Date f_nac, Date f_cont, Date f_ter, String estado, String urlImage ){
                try { 
            PreparedStatement pstm = c.getConexion().prepareStatement("insert into " +
                    "sistemaTusug.trabajador(rfc,nss,nombre,apellido,domicilio,curp,fecha_nacimiento,fecha_contratacion,fecha_terminacion,estado,url_img) " +
                    " values(?,?,?,?,?,?,?,?,?,?,?)");
            pstm.setInt(1, rfc);
            pstm.setString(2, nss);
            pstm.setString(3, nombre);
            pstm.setString(4, apellidos);
            pstm.setString(5, domicilio);
            pstm.setString(6,curp);
            pstm.setDate(7, f_nac);
            pstm.setDate(8, f_cont);
            pstm.setDate(9, f_ter);
            pstm.setString(10, estado);
            pstm.setString(11, urlImage);
            pstm.execute();
            pstm.close(); 
        } catch(SQLException e){
         System.out.println(e);
      }
    }

    public void eliminaTrabajador(){
        
    }
    
    public void modificaTrabajador(){
        
    }
    
    public void listaTrabajador(){
        
    }
}
