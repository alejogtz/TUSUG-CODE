package CONTROLLERS;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author gallardo
 */
public class SQLHistMant {
    Connection conn;
    public SQLHistMant(){
            conn = Conexion.getConexion();
    }
    public String[][] obtenerRegistro(){
        String sql = "select count(codigo_m) as total from sistemaTusug.mantenimiento ";
            PreparedStatement pst;
            ResultSet res;
            int n = 0;
        try {
            pst = conn.prepareStatement(sql);
        
            res = pst.executeQuery();
            res.next();
            n = res.getInt("total");
            res.close();
            } catch (SQLException ex) {
            Logger.getLogger(SQLAutobus.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String tabla[][] = new String[n][3];
        
        try{
            sql = "select codigo_m from sistemaTusug.mantenimiento ORDER BY codigo_m";
            pst = conn.prepareStatement(sql);
            res = pst.executeQuery();
            int index = 0;
            while(res.next()){
                String dato=res.getString("codigo_m");
                tabla[index][0] = dato;
                index++;
                System.out.println(dato);
            }
            sql = "select responsable from sistemaTusug.mantenimiento ORDER BY codigo_m";
            pst = conn.prepareStatement(sql);
            res = pst.executeQuery();
            int index2 = 0;
            while(res.next()){
                String dato2=res.getString("responsable");
                tabla[index2][1] = dato2;
                index2++;
            }
            sql = "select fecha_ingreso from sistemaTusug.mantenimiento ORDER BY codigo_m";
            pst = conn.prepareStatement(sql);
            res = pst.executeQuery();
            int index3 = 0;
            while(res.next()){
                String dato3=res.getString("fecha_ingreso");
                tabla[index3][2] = dato3;
                index3++;
            }
            res.close();
        } catch (SQLException ex) {
            Logger.getLogger(SQLAutobus.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tabla;
    }
    public String[][] obtenerRegistroArgs(String args){
        String sql = "select count(codigo_m) as total from sistemaTusug.mantenimiento ";
            PreparedStatement pst;
            ResultSet res;
            int n = 0;
        try {
            pst = conn.prepareStatement(sql);
        
            res = pst.executeQuery();
            res.next();
            n = res.getInt("total");
            res.close();
            } catch (SQLException ex) {
            Logger.getLogger(SQLAutobus.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String tabla[][] = new String[n][3];
        
        try{
            sql = "select codigo_m from sistemaTusug.mantenimiento ORDER BY codigo_m";
            pst = conn.prepareStatement(sql);
            res = pst.executeQuery();
            int index = 0;
            while(res.next()){
                String dato=res.getString("codigo_m");
                tabla[index][0] = dato;
                index++;
                System.out.print(dato);
            }
            sql = "select responsable from sistemaTusug.mantenimiento ORDER BY codigo_m";
            pst = conn.prepareStatement(sql);
            res = pst.executeQuery();
            int index2 = 0;
            while(res.next()){
                String dato2=res.getString("responsable");
                tabla[index2][1] = dato2;
                index2++;
            }
            sql = "select fecha_ingreso from sistemaTusug.mantenimiento ORDER BY codigo_m";
            pst = conn.prepareStatement(sql);
            res = pst.executeQuery();
            int index3 = 0;
            while(res.next()){
                String dato3=res.getString("fecha_ingreso");
                tabla[index3][2] = dato3;
                index3++;
            }
            res.close();
        } catch (SQLException ex) {
            Logger.getLogger(SQLAutobus.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tabla;
    } 
}
