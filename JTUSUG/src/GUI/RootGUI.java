package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;;
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
    //Datos de la sesion
    String rol_activo;
    String nombre_usuario;
    
    CustomActionListener listen;
    String carpeta_img = "src/imagenes/";
    Font font;
    public static JFrame root;
    public static JPanel panel;
    public JButton btn_close, btn_secre, btn_almacen, btn_manten, btn_rrhh;

    //Para reciclar
    private JLabel lb_title, lb_descripcion;
    // Botones para la secretaria    
    private JButton btn_regresar, btn_listaBus, btn_facturas, btn_reportes;
    // Botones para almacenista
    private JButton btn_insumos, btn_lista_invent, btn_gener_inventario;
    // Botones de Recursos Humanos
    private JButton btn_trabajadores, btn_expedientes, btn_nuevosempleado, btn_iactivos;
    // Botones de Mantenimiento
    private JButton btn_nuevoreporte, btn_reUnidades, btn_historial;

    public RootGUI(String rol, String name){
        font = new Font("Segoe UI", Font.PLAIN, 14);
        listen = new CustomActionListener();
        root = Builder.construirFrame(name + " - Bienvenido -",
                new Rectangle(460, 506, 700, 600), false);
        panel = Builder.crearPanel(root, new Rectangle(0, 0, 700, 600),
                "src/imagenes/pagina_de_fondo.png", true);
        lb_title = Builder.crearLabel(panel, "",
                new Rectangle(317, 202, 200, 40), Color.BLUE, null, font);        
        btn_close = Builder.crearButtonIcon(panel, "CerrarSesion", carpeta_img + "cerrar_sesion.png",
                new Rectangle(460, 506, 201, 63), listen, true, true);
        this.rol_activo = rol;
        //System.err.println(rol + " -v-v-v-");
        switch(rol){            
            case "root":
                initComponents();
                break;
            case "secretaria":
                cargarBtnSecre();                
                break;
            case "mantenimiento":
                cargarBtnManten();
                break;
            case "almacen":
                cargarBtnAlmacen();
                break;
            case "recursos humanos":
                cargarBtnRH();
                break;
            default:
                // Code Here:
                // Accion para caso no previsto
        }
        if (!rol_activo.equals("root"))btn_regresar.setVisible(false);
    }
    public RootGUI() {
        this("", "");
    }

    public void initComponents() {
        JLabel lb_text = Builder.crearLabel(panel, "Seleccione el icono de la seccion que desea visitar",
                new Rectangle(193, 172, 300, 60), null, null, font);        
        btn_secre = Builder.crearButtonIcon(panel, "btnSecretaria", carpeta_img + "secretaria.png",
                new Rectangle(85, 256, 256, 63), listen, true, true);
        btn_almacen = Builder.crearButtonIcon(panel, "btnAlmacen", carpeta_img + "almacen.png",
                new Rectangle(85, 352, 256, 63), listen, true, true);
        btn_manten = Builder.crearButtonIcon(panel, "btnManten", carpeta_img + "mantenimiento.png",
                new Rectangle(379, 256, 256, 63), listen, true, true);
        btn_rrhh = Builder.crearButtonIcon(panel, "btnRRHH", carpeta_img + "recursos_humanos.png",
                new Rectangle(379, 352, 256, 63), listen, true, true);

    }

    private void cargarBtnSecre() {
        btn_regresar = Builder.crearButtonIcon(panel, "btn_regresar",
                carpeta_img + "regresar.png", new Rectangle(335, 523, 32, 32),
                listen, true, true);
        btn_listaBus = Builder.crearButtonIcon(panel, "modulo_autobus",
                carpeta_img + "lista_de_autobuses.png", new Rectangle(85, 256, 256, 63),
                listen, false, true);
        btn_facturas = Builder.crearButtonIcon(panel, "facturas",
                carpeta_img + "facturas.png", new Rectangle(85, 352, 256, 63),
                listen, false, true);
        btn_reportes = Builder.crearButtonIcon(panel, "reportes",
                carpeta_img + "reportes.png", new Rectangle(379, 256, 256, 63),
                listen, false, true);
        lb_descripcion = Builder.crearLabel(panel, "descripcion",
                new Rectangle(114, 445, 100, 40), null, null, font);
        lb_title.setText("Secretaria");
        lb_title.setVisible(true);
        lb_title.setEnabled(true);
        //lb_title = Builder.crearLabel(panel, "Mantenimiento",
        //        new Rectangle(317, 202, 100, 40), null, null, font);
    }

    private void cargarBtnAlmacen() {
        btn_regresar = Builder.crearButtonIcon(panel, "btn_back_almacen",
                carpeta_img + "regresar.png", new Rectangle(335, 523, 32, 32),
                listen, true, false);
        lb_descripcion = Builder.crearLabel(panel, "descripcion",
                new Rectangle(114, 445, 100, 40), null, null, font);
        lb_title.setText("Almacen");
        lb_title.setVisible(true);
        lb_title.setEnabled(true);
        //lb_title = Builder.crearLabel(panel, "Mantenimiento",
        //        new Rectangle(317, 202, 100, 40), null, null, font);

        btn_insumos = Builder.crearButtonIcon(panel, "insumos",
                carpeta_img + "Insumos.png", new Rectangle(85, 256, 256, 63),
                listen, false, true);
        btn_lista_invent = Builder.crearButtonIcon(panel, "lista_inventario",
                carpeta_img + "lista_de_inventario.png", new Rectangle(85, 352, 256, 63),
                listen, false, true);
        btn_gener_inventario = Builder.crearButtonIcon(panel, "generarInventario",
                carpeta_img + "Generar_inventario.png", new Rectangle(379, 256, 256, 63),
                listen, false, true);

    }

    private void cargarBtnRH() {
        btn_regresar = Builder.crearButtonIcon(panel, "btn_back_RH",
                carpeta_img + "regresar.png", new Rectangle(335, 523, 32, 32),
                listen, true, false);
        lb_descripcion = Builder.crearLabel(panel, "descripcion",
                new Rectangle(114, 445, 100, 40), null, null, font);
        lb_title.setText("Recursos Humanos");
        lb_title.setVisible(true);
        lb_title.setEnabled(true);
        //lb_title = Builder.crearLabel(panel, "Mantenimiento",
        //        new Rectangle(317, 202, 100, 40), null, null, font);
        btn_trabajadores = Builder.crearButtonIcon(panel, "btntrabajadores",
                carpeta_img + "trabajadores.png", new Rectangle(85, 256, 256, 63),
                listen, false, true);
        btn_expedientes = Builder.crearButtonIcon(panel, "btnexpedientes",
                carpeta_img + "expedientes.png", new Rectangle(85, 352, 256, 63),
                listen, false, true);
        btn_nuevosempleado = Builder.crearButtonIcon(panel, "btnnuevoempleados",
                carpeta_img + "nuevos_empleados.png", new Rectangle(379, 256, 256, 63),
                listen, false, true);
        btn_iactivos = Builder.crearButtonIcon(panel, "btniactivos",
                carpeta_img + "activos_e_inactivos.png", new Rectangle(379, 352, 256, 63),
                listen, false, true);
    }

    private void cargarBtnManten() {
        btn_regresar = Builder.crearButtonIcon(panel, "btn_back_Mant",
                carpeta_img + "regresar.png", new Rectangle(335, 523, 32, 32),
                listen, true, false);
        lb_descripcion = Builder.crearLabel(panel, "descripcion",
                new Rectangle(114, 445, 100, 40), null, null, font);
        lb_title.setText("Mantenimiento");
        lb_title.setVisible(true);
        lb_title.setEnabled(true);
        //lb_title = Builder.crearLabel(panel, "Mantenimiento",
        //        new Rectangle(317, 202, 100, 40), null, null, font);
        btn_nuevoreporte = Builder.crearButtonIcon(panel, "MnuevoReporte",
                carpeta_img + "Generar_nuevo_reporte.png", new Rectangle(85, 256, 256, 63),
                listen, false, true);
        btn_reUnidades = Builder.crearButtonIcon(panel, "MreUnidades",
                carpeta_img + "reincorporar_nuevas_unidades.png", new Rectangle(85, 352, 256, 63),
                listen, false, true);
        btn_historial = Builder.crearButtonIcon(panel, "Mhistorial",
                carpeta_img + "Historial.png", new Rectangle(379, 256, 256, 63),
                listen, false, true);
        
    }

    private static void cambiarEstadoBtns(boolean val, Component... btns) {
        for (Component b : btns) {
            b.setVisible(val);
            b.setEnabled(val);
        }
    }

    class CustomActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String op = e.getActionCommand();
            switch (op) {
                // Btns Principales
                case "CerrarSesion":
                    LoginGUI l = new LoginGUI();
                    root.dispose();
                    break;
                case "btnSecretaria":
                    cambiarEstadoBtns(false, btn_secre, btn_almacen, btn_manten, btn_rrhh);
                    cargarBtnSecre();
                    break;
                case "btnAlmacen":
                    cambiarEstadoBtns(false, btn_secre, btn_almacen, btn_manten, btn_rrhh);
                    cargarBtnAlmacen();
                    break;
                case "btnManten":
                    cambiarEstadoBtns(false, btn_secre, btn_almacen, btn_manten, btn_rrhh);
                    cargarBtnManten();
                    break;
                case "btnRRHH":
                    cambiarEstadoBtns(false, btn_secre, btn_almacen, btn_manten, btn_rrhh);
                    cargarBtnRH();
                    break;
                // Btns de Regresar segun el caso
                case "btn_regresar": //Secretaria
                    cambiarEstadoBtns(false, btn_regresar, btn_listaBus, btn_facturas, btn_reportes);
                    initComponents();
                    break;
                case "btn_back_almacen":
                    cambiarEstadoBtns(false, btn_regresar, btn_insumos, btn_lista_invent, btn_gener_inventario);
                    initComponents();
                    break;
                case "btn_back_RH":
                    cambiarEstadoBtns(false, btn_regresar, btn_trabajadores, btn_expedientes, btn_nuevosempleado, btn_iactivos);
                    initComponents();
                    break;
                case "btn_back_Mant":
                    cambiarEstadoBtns(false, btn_regresar, btn_nuevoreporte, btn_reUnidades, btn_historial);
                    initComponents();
                    break;
                //  Botones de la Secretaria
                case "modulo_autobus":
                    AutobusGUI auto = new AutobusGUI();
                    break;
                case "facturas":
                    javax.swing.JOptionPane.showMessageDialog(null, "Esta funcion aun no esta implementada");
                    break;
                case "reportes":
                    javax.swing.JOptionPane.showMessageDialog(null, "Esta funcion aun no esta implementada");
                    break;
                //Botones de almacen
                case "insumos":
                    javax.swing.JOptionPane.showMessageDialog(null, "Esta funcion aun no esta implementada");
                    break;
                case "lista_inventario":
                    javax.swing.JOptionPane.showMessageDialog(null, "Esta funcion aun no esta implementada");
                    break;
                case "generarInventario":
                    javax.swing.JOptionPane.showMessageDialog(null, "Esta funcion aun no esta implementada");
                    break;
                // Btns de Recursos Humanos RRHH
                case "btntrabajadores":
                    TrabajadorGUI employer = new TrabajadorGUI();
                    break;
                case "btnexpedientes":
                    javax.swing.JOptionPane.showMessageDialog(null, "Esta funcion aun no esta implementada");
                    break;
                case "btnnuevoempleados":
                    javax.swing.JOptionPane.showMessageDialog(null, "Esta funcion aun no esta implementada");
                    break;
                case "btniactivos":
                    javax.swing.JOptionPane.showMessageDialog(null, "Esta funcion aun no esta implementada");
                    break;
                // Botones de Mantenimiento
                case "MnuevoReporte":
                    javax.swing.JOptionPane.showMessageDialog(null, "Esta funcion aun no esta implementada");
                    break;
                case "MreUnidades":
                    javax.swing.JOptionPane.showMessageDialog(null, "Esta funcion aun no esta implementada");
                    break;
                case "Mhistorial":
                    javax.swing.JOptionPane.showMessageDialog(null, "Esta funcion aun no esta implementada");
                    break;
            }
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
}
