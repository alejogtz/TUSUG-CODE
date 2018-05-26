
package GUI;

import CONTROLLERS.Autobus;
import Validacion.Validador;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;


public class HistorialMantenGUI {
    String              ruta = "src/imagenes/";
    ActionListener      listener;
    Autobus             controlador;
    Validador           valida;
    public JList        list;
    public JTextField   txt_no_manten,txt_fecha;
    public JFileChooser url_img;
    public JButton      btn_buscar,btn_abrir,btn_imprimir,btn_guardar,btn_regresar,btn_cerrarSesion;
    public JLabel       lb_no_manten,lb_fecha,lb_historial_manten;
    JFrame a;
    
    public HistorialMantenGUI()
    {
        
    }
    
    public void inicializarComp()
    {  
        btn_abrir  =       Builder.crearButtonIcon(a,"abrir",ruta + "folder.png",                  new Rectangle(643,282,24,24) ,listener,false,false);
        btn_imprimir =     Builder.crearButtonIcon(a,"imprimir",ruta + "print.png",                new Rectangle(643,243,24,24) ,listener,false,false);
        btn_buscar =       Builder.crearButtonIcon(a,"buscar",ruta + "btn_buscar.png",             new Rectangle(54,89,74,21)   ,listener,false,false);
        btn_regresar =     Builder.crearButtonIcon(a,"regresar",ruta + "regresar.png",             new Rectangle(643,301,24,24) ,listener,false,false);
        btn_guardar =      Builder.crearButtonIcon(a,"guardar",ruta + "btn_buscar.png",            new Rectangle(643,301,24,24) ,listener,false,false);
        btn_cerrarSesion = Builder.crearButtonIcon(a,"cerrarSesion",ruta + "cerrar_sesion.png",    new Rectangle(460,503,201,63),listener,false,false);
        
        
        lb_no_manten =           Builder.crearLabel(a, "No. Mantenimiento:",                new Rectangle(158,90,125,28) ,null,null);
        lb_fecha        =        Builder.crearLabel(a, "Fecha:",                            new Rectangle(461,90,45,18)  ,null,null);
        lb_historial_manten  =   Builder.crearLabel(a, "Historial de mantenimiento",        new Rectangle(260,170,170,18),null,null);
        
        
        txt_no_manten =    Builder.crearTextField(a, new Rectangle(293, 88, 131, 22), "", null, null,new Font("Segoe UI", Font.BOLD, 10),true,true,true);

        
        
    }
}
