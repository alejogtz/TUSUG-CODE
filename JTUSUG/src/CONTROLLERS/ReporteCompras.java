
package CONTROLLERS;

import GUI.GFacturas2;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class ReporteCompras {
     Connection c;
     GFacturas2 interfaz;
     ArrayList<String> datos= new ArrayList();
     int x;
     
     public ReporteCompras(GFacturas2 ui){
            interfaz = ui;
            datos=ui.datos_com;
            Conexion.setConfiguracion("postgres", "root");
            c = Conexion.getConexion();
     }

             public void creaRepor() throws JRException{
               try{
          
            Map parametros = new HashMap();
            parametros.clear();
            parametros.put("para1", Integer.parseInt(datos.get(0)));
            JasperReport reporte=JasperCompileManager.compileReport("report1.jrxml");
            JasperPrint p= JasperFillManager.fillReport(reporte, parametros, c);
            JasperViewer ventanavisor= new JasperViewer(p, false);
            ventanavisor.setTitle("REPORTE DE COMPRA");
            ventanavisor.setVisible(true);
               }catch(HeadlessException | JRException e){
                     JOptionPane.showMessageDialog(null,"Error en el reporte"+ e);
                 }
               
               }
           
  
        public void addC() {
            
      
        try {
           

            PreparedStatement pstm = c.prepareStatement("insert into "
                    + "sistemaTusug.compras(numero_factura,cod_provedor, razon_social,direccion,poblacion,provincia,cp,persona_contacto,email,telefono,subtotal,iva,descuento,total) "
                    + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?) returning numero_factura");
            ResultSet res;
            pstm.setInt(1, Integer.parseInt(datos.get(0)));
            pstm.setString(2, datos.get(1));
            pstm.setString(3, datos.get(2));
            pstm.setString(4, datos.get(3));
            pstm.setString(5, datos.get(4));
            pstm.setString(6, datos.get(5));
            pstm.setInt(7, Integer.parseInt(datos.get(6)));
            pstm.setString(8, datos.get(7));
            pstm.setString(9, datos.get(8));
            pstm.setInt(10, Integer.parseInt(datos.get(9)));
            pstm.setInt(11, Integer.parseInt(datos.get(10)));
            pstm.setInt(12,Integer.parseInt(datos.get(11)));
            pstm.setInt(13,Integer.parseInt(datos.get(12)));
            pstm.setInt(14,Integer.parseInt(datos.get(13)));
            res=pstm.executeQuery();
            if(res.next()){
            
            x=res.getInt(1);
            System.out.print(x);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
      System.out.print("agregado");
    }
    
}
