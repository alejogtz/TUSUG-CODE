
package CONTROLLERS;

import GUI.AutobusGUI;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        //matricula = ui.txt_matricula.getText().toLowerCase();
    }    
}
