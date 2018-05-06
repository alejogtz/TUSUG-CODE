
package CONTROLLERS;

import java.sql.Date;
import GUI.TrabajadorGUI;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Trabajador {
    TrabajadorGUI interfaz;
   
    Connection c;
    ArrayList<String> m;
    
    public Trabajador(TrabajadorGUI ui){
        interfaz = ui;
        c = Conexion.getConexion();
        Conexion.setConfiguracion("postgres","Kurama14");
     
    }
     
    
    public void agregaTrabajador(){
        int rfc= Integer.parseInt(interfaz.tfrfc.getText());
        String nombre= interfaz.tfnom.getText();
        String ap_paterno= interfaz.tfapp.getText();
        String ap_materno= interfaz.tfapm.getText();
        String domicilio= interfaz.tfdir.getText();
        Date f_nac;//=interfaz.fecha1.getText();
        Date f_cont;//= interfaz.fecha2.getText();
        String estado= (String)interfaz.cb6.getSelectedItem();
        
        
        
        
    }
    
    public void addT(int rfc,  String nombre, String ap_paterno,String ap_materno, String domicilio, Date f_nac, Date f_cont, String estado, String urlImage ){
                try { 
            System.out.print("agregado");

            PreparedStatement pstm = c.prepareStatement("insert into " +
                    "sistemaTusug.trabajador(rfc,nombre,ap_paterno, ap_materno,domicilio,fecha_nac,fecha_contratacion,estado,url_img) " +
                    " values(?,?,?,?,?,?,?,?,?)");
                        System.out.print("agregado");

            pstm.setInt(1, rfc);
            pstm.setString(2, nombre);
            pstm.setString(3, ap_paterno);
            pstm.setString(4, ap_materno);
            pstm.setString(5, domicilio);
            pstm.setDate(6, f_nac);
            pstm.setDate(7, f_cont);
            pstm.setString(8, estado);
            pstm.setString(9, urlImage);
            pstm.execute();
           // pstm.close(); 
            System.out.print("agregado");
        } catch(SQLException e){
         System.out.println(e);
      }
    }

    public void eliminaTrabajador(){
        
        
    }
    
    public void modificaTrabajador(){
        
    }
    
    public ArrayList<String> listaTrabajador(){try{
         
         String [] registros= new String[5];
        String cons="select rfc from sistemaTusug.trabajador" ;
        
            Statement st= c.createStatement();
            ResultSet rs = st.executeQuery(cons);
            while(rs.next()){
                registros[0]=rs.getString(1);
                System.out.print(registros[0]);
                m.add(registros[0]);
                          
            }
            
     }catch(Exception e){
                System.out.println(e.getMessage());
     }     
         return m;
    }
    

        public void listaParametro(String rfc){try{
            String [] registros= new String[9];
            PreparedStatement pstm = c.prepareStatement("select * from sistemaTusug.trabajador where rfc=?");
            pstm.setString(1, rfc);
            ResultSet rs =  pstm.executeQuery();
            while(rs.next()){
                registros[0]=rs.getString(1);
                
                registros[1]=rs.getString(2);
                interfaz.tfnom.setText(registros[1]);
                registros[2]=rs.getString(3);
                interfaz.tfapp.setText(registros[2]);
                registros[3]=rs.getString(4);
                interfaz.tfapm.setText(registros[3]);
                registros[4]=rs.getString(5);
                interfaz.tfdir.setText(registros[4]);
                registros[5]=rs.getString(6);
                registros[6]=rs.getString(7);
                registros[7]=rs.getString(8);
                registros[8]=rs.getString(19);             
            }
            
        
          
            
     }catch(Exception e){
                System.out.println(e.getMessage());
     }     
         
    }

    public static void main(String [] args){
        Trabajador t = new Trabajador(null);
        t.listaTrabajador();
        
    }
}


/*
public void actualizaCombo(){
combo.removeAllItems();
for (String s: listaTrabajador()){
   combo.addItem(s);
}
}


*/
