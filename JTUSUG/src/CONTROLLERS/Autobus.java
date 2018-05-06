
package CONTROLLERS;

import GUI.AutobusGUI;
import java.io.File;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Alekhius
 */
public class Autobus {
    public AutobusGUI ui;
    private SQLAutobus bd;
    private String matricula, id, marca, num_eco, url_img;
    private int km, asientos;
    public Autobus(AutobusGUI ui){
        this.ui = ui;
        this.bd = new SQLAutobus();
    }
    
    public void ingresarAutobus(){
        cargarvariables();
        try {            
            bd.ingresarAutobus(marca, id, marca, num_eco, km, asientos, url_img);
        } catch (SQLException ex) {
            System.err.println(
                    ex.getErrorCode());
            Logger.getLogger(Autobus.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void borrarAutobus(){
        cargarvariables();
        try {
            bd.borrarAutobusBy(null, matricula);
        } catch (SQLException e) {
        }
    }
    public void cargarvariables(){
        matricula = ui.txt_matricula.getText().toLowerCase();
        id = ui.txt_id.getText().toLowerCase();
        marca = ui.txt_marca.getText().toLowerCase();
        num_eco = ui.txt_No_Eco.getText().toLowerCase();
        km = Integer.valueOf(ui.txt_Km.getText().toLowerCase());
        asientos = Integer.valueOf(ui.txt_asientos.getText().toLowerCase());
        ui.url_img.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                //if ()
                return false;
            }

            @Override
            public String getDescription() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
               
        url_img = ui.url_img.getSelectedFile();
    }    
}
