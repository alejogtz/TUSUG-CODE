package CONTROLLERS;

import GUI.AutobusGUI;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Alekhius
 */
public class Autobus {

    public AutobusGUI ui;
    private SQLAutobus bd;
    private String matricula, id, marca, num_eco, url_img;
    private int km, asientos;

    public Autobus(AutobusGUI ui) {
        this.url_img = "src/imagenes/autobu.png";
        this.ui = ui;
        this.bd = new SQLAutobus();
    }

    public void ingresarAutobus() {
        cargarvariables();
        try {
            bd.ingresarAutobus(matricula, id, marca, num_eco, km, asientos, url_img);
        } catch (SQLException ex) {
            System.err.println(
                    ex.getErrorCode());
            Logger.getLogger(Autobus.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificarAutobus()
    {
        cargarvariables();
        try {
            bd.update(matricula,marca, num_eco, km, asientos);
        } catch (SQLException ex) {
            System.err.println(
                    ex.getErrorCode());
            Logger.getLogger(Autobus.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cargarvariables() {
        matricula = ui.txt_matricula.getText();//.toLowerCase();
        id = "";//ui.txt_id.getText().toLowerCase();
        marca = ui.txt_marca.getText();//.toLowerCase();
        num_eco = ui.txt_No_Eco.getText();//.toLowerCase();
        km = Integer.valueOf(ui.txt_Km.getText());
        asientos = Integer.valueOf(ui.txt_asientos.getText());        
        //Logger.getLogger("Hi").log(Level.SEVERE, " - Linea 55 - ");
        url_img = "Not found";//seleccionarImg();
    }

    public String seleccionarImg() 
    {
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF", "jpg", "gif");
        ui.url_img.setFileFilter(filter);
        ui.url_img.showOpenDialog(ui);
        String f = ui.url_img.getSelectedFile().getAbsolutePath();
        return f;
    }
    
    public String[] obtenerAutobus(String m){
        String registro[] = bd.obtenerRegistro(m);
        return registro;
    }
    
    public String[] obtenerlista(){

        String[] lista = bd.listaAutobuses();
       
        return lista;
    }
}
