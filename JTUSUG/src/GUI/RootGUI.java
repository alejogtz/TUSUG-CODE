package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.plaf.FontUIResource;

/**
 *
 * @author Alekhius
 */
public class RootGUI {
    Font font;
    public static JFrame root;
    public JButton btn_close, btn_secre, btn_almacenm, btn_manten, btn_rrhh;
    
    public RootGUI(){
        font = new Font("Segoe UI", Font.PLAIN, 14);
        initComponents();
        
    }
    
    public void initComponents(){
        root = Builder.construirFrame("GUI root - Bienvenido -", 
                new Rectangle(460, 506, 700,600) , false);
        JLabel lb_text = Builder.crearLabel(root, "Seleccione el icono de la seccion que desea visitar", 
                new Rectangle(193, 172, 300, 60), null, null, font);
        btn_close = Builder.crearButtonIcon(root, "CerrarSesion", "src/imagenes/cerrar_sesion.png",
                new Rectangle(460, 506, 201,63), null, true, true);
        
    }
}
