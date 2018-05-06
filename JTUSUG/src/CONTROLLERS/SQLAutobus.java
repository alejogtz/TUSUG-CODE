/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLERS;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Alekhius
 */
public class SQLAutobus {
    Connection conn;
    
    public SQLAutobus(){
        conn = Conexion.getConexion();
    }    
    
    public void ingresarAutobus(String matr, String id, String marca, 
            String num_eco, int km, int asientos, 
            String url_img) throws SQLException{
        
        String sql = 
                "insert into sistemaTusug.autobus values (?,?,?,?,?,?,?)";
        PreparedStatement pst = null;
        pst = conn.prepareStatement(sql);
        pst.setString(1, matr);
        pst.setString(2, id);
        pst.setString(3, marca);
        pst.setString(4, num_eco);
        pst.setInt(5, km);
        pst.setInt(6, asientos);
        pst.setString(7, url_img);
        int n = pst.executeUpdate();
        System.err.println(
                n);
    }
    // caso "matricula"
    public void borrarAutobusBy(String columnName, String arg) 
            throws SQLException{
        
        if (columnName==null)columnName = "matricula";// By default
        String sql = "delete * from sistemaTusug.autobus where " + 
                columnName + " = " + arg;
        Statement st = conn.createStatement();
        st.executeUpdate(sql);
    }
}
