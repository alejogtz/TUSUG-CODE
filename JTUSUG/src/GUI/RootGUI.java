package GUI;

import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Alekhius
 */
public class RootGUI {
    CustomActionListener listen;
    String carpeta_img = "src/imagenes/";
    Font font;
    public static JFrame root;
    public static JPanel panel;
    public JButton btn_close, btn_secre, btn_almacen, btn_manten, btn_rrhh;
    
    public RootGUI(){
        font = new Font("Segoe UI", Font.PLAIN, 14);
        listen = new CustomActionListener();
        initComponents();
    }
    
    public void initComponents(){
        root = Builder.construirFrame("GUI root - Bienvenido -", 
                new Rectangle(460, 506, 700,600) , false);
        panel = Builder.crearPanel(root, new Rectangle(0,0, 700, 600), 
                "src/imagenes/pagina_de_fondo.png", true);
        
        JLabel lb_text = Builder.crearLabel(panel, "Seleccione el icono de la seccion que desea visitar", 
                new Rectangle(193, 172, 300, 60), null, null, font);
        btn_close = Builder.crearButtonIcon(panel, "CerrarSesion", carpeta_img + "cerrar_sesion.png",
                new Rectangle(460, 506, 201,63), listen, true, true);
        btn_secre = Builder.crearButtonIcon(panel, "btnSecretaria", carpeta_img + "secretaria.png", 
                new Rectangle(85, 256, 256, 63), listen, true, true);
        btn_almacen = Builder.crearButtonIcon(panel, "btnAlmacen", carpeta_img + "almacen.png", 
                new Rectangle(85,352, 256, 63), listen, true, true);
        btn_manten = Builder.crearButtonIcon(panel, "btnManten", carpeta_img + "mantenimiento.png",
                new Rectangle(379, 256, 256, 63), listen, true, true);
        btn_rrhh = Builder.crearButtonIcon(panel, "btnRRHH", carpeta_img + "recursos_humanos.png", 
                new Rectangle(379,352,256, 63), listen, true, true);
        
    }
    class CustomActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String op = e.getActionCommand();
            switch(op){
                case "CerrarSesion":
                    System.err.println("Cerrar Sesion");
                    break;
                case "btnSecretaria":
                    break;
                case "btnAlmacen":
                    break;
            }
        }
    }
    
    class CustomKeyListener implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void keyPressed(KeyEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void keyReleased(KeyEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
    
    class CustomFocusListener implements FocusListener{

        @Override
        public void focusGained(FocusEvent e) {
            
        }

        @Override
        public void focusLost(FocusEvent e) {

        }
    }
    
    class CustomMouseListener implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            
        }

        @Override
        public void mousePressed(MouseEvent e) {
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
            
        }
        
    }
}
