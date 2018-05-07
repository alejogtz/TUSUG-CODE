package GUI;

import java.awt.Component;
import java.awt.Font;
import java.awt.Point;
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

    // Botones para la secretaria
    private JLabel lb_title, lb_descripcion;
    private JButton btn_regresar, btn_listaBus, btn_facturas, btn_reportes;

    public RootGUI() {
        font = new Font("Segoe UI", Font.PLAIN, 14);
        listen = new CustomActionListener();
        //initComponents("secretaria");
        root = Builder.construirFrame("GUI root - Bienvenido -",
                new Rectangle(460, 506, 700, 600), false);
        panel = Builder.crearPanel(root, new Rectangle(0, 0, 700, 600),
                "src/imagenes/pagina_de_fondo.png", true);
    }

    public void initComponents(String rol) {  
        JLabel lb_text = Builder.crearLabel(panel, "Seleccione el icono de la seccion que desea visitar",
                new Rectangle(193, 172, 300, 60), null, null, font);
        btn_close = Builder.crearButtonIcon(panel, "CerrarSesion", carpeta_img + "cerrar_sesion.png",
                new Rectangle(460, 506, 201, 63), listen, true, true);
        btn_secre = Builder.crearButtonIcon(panel, "btnSecretaria", carpeta_img + "secretaria.png",
                new Rectangle(85, 256, 256, 63), listen, true, true);
        btn_almacen = Builder.crearButtonIcon(panel, "btnAlmacen", carpeta_img + "almacen.png",
                new Rectangle(85, 352, 256, 63), listen, true, true);
        btn_manten = Builder.crearButtonIcon(panel, "btnManten", carpeta_img + "mantenimiento.png",
                new Rectangle(379, 256, 256, 63), listen, true, true);
        btn_rrhh = Builder.crearButtonIcon(panel, "btnRRHH", carpeta_img + "recursos_humanos.png",
                new Rectangle(379, 352, 256, 63), listen, true, true);

    }

    class CustomActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String op = e.getActionCommand();
            switch (op) {
                case "CerrarSesion":
                    LoginGUI l = new LoginGUI();
                    root.dispose();
                    break;
                case "btnSecretaria":
                    cambiarEstadoBtns(false, btn_secre, btn_almacen, btn_manten, btn_rrhh);
                    cargarBtnSecre();
                    break;
                case "btnAlmacen":
                    javax.swing.JOptionPane.showMessageDialog(null, "Esta funcion aun no esta implementada");
                    break;
                case "btnManten":
                    javax.swing.JOptionPane.showMessageDialog(null, "Esta funcion aun no esta implementada");
                    break;
                case "btnRRHH":
                    javax.swing.JOptionPane.showMessageDialog(null, "Esta funcion aun no esta implementada");
                    break;
                //  Botones de la Secretaria
                case "modulo_autobus":
                    AutobusGUI auto = new AutobusGUI();
                    
                    //javax.swing.JOptionPane.showMessageDialog(null, "Esta funcion aun no esta implementada");
                    break;
                case "facturas":
                    javax.swing.JOptionPane.showMessageDialog(null, "Esta funcion aun no esta implementada");
                    break;
                case "reportes":
                    javax.swing.JOptionPane.showMessageDialog(null, "Esta funcion aun no esta implementada");
                    break;
                case "btn_regresar":
                    cambiarEstadoBtns(false,btn_regresar, btn_listaBus, btn_facturas, btn_reportes);
                    initComponents(LoginGUI.sesion.getRol());
                    //javax.swing.JOptionPane.showMessageDialog(null, "Esta funcion aun no esta implementada");
                    break;

            }
        }

        private void cargarBtnSecre() {
            btn_regresar = Builder.crearButtonIcon(panel, "btn_regresar", 
                        carpeta_img + "regresar.png", new Rectangle(335,523, 32,32), 
                    listen, true, false);
            btn_listaBus = Builder.crearButtonIcon(panel, "modulo_autobus", 
                    carpeta_img + "lista_de_autobuses.png", new Rectangle(85,256, 256, 63), 
                    listen, false, false);
            btn_facturas = Builder.crearButtonIcon(panel, "facturas", 
                    carpeta_img + "facturas.png", new Rectangle(85,352, 256, 63), 
                    listen, false, false);
            btn_reportes = Builder.crearButtonIcon(panel, "reportes", 
                    carpeta_img + "Reportes.png", new Rectangle(85,352, 256, 63), 
                    listen, false, false);
            lb_title = Builder.crearLabel(panel, "descripcion", 
                    new Rectangle(new Point(114,445)), null, null,font);
            lb_descripcion = Builder.crearLabel(panel, "secretaria", 
                    new Rectangle(new Point(317,202)), null, null,font);
        }
    }

    private static void cambiarEstadoBtns(boolean val, Component... btns) {
        for (Component b : btns) {
            b.setVisible(val);
            b.setEnabled(val);
        }
    }

    class CustomKeyListener implements KeyListener {

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

    class CustomFocusListener implements FocusListener {

        @Override
        public void focusGained(FocusEvent e) {

        }

        @Override
        public void focusLost(FocusEvent e) {

        }
    }

    class CustomMouseListener implements MouseListener {

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
