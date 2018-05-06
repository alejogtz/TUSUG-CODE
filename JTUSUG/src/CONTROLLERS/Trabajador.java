
package CONTROLLERS;

import java.sql.Date;
import GUI.TrabajadorGUI;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Trabajador {
    TrabajadorGUI interfaz;
    Connection c = Conexion.getConexion();
    
    public Trabajador(TrabajadorGUI ui){
        interfaz = ui;
       
    }
     
    
    public void agregaTrabajador(){
        int rfc= Integer.parseInt(interfaz.tfrfc.getText());
        String nombre= interfaz.tfnom.getText();
    }
    
    public void addT(int rfc,  String nombre, String apellidos, String domicilio, String curp, Date f_nac, Date f_cont, Date f_ter, String estado, String urlImage ){
                try { 
            PreparedStatement pstm = c.prepareStatement("insert into " +
                    "sistemaTusug.trabajador(rfc,nss,nombre,apellido,domicilio,curp,fecha_nacimiento,fecha_contratacion,fecha_terminacion,estado,url_img) " +
                    " values(?,?,?,?,?,?,?,?,?,?)");
            pstm.setInt(1, rfc);
            pstm.setString(2, nombre);
            pstm.setString(3, apellidos);
            pstm.setString(4, domicilio);
            pstm.setString(5,curp);
            pstm.setDate(6, f_nac);
            pstm.setDate(7, f_cont);
            pstm.setDate(8, f_ter);
            pstm.setString(9, estado);
            pstm.setString(10, urlImage);
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
