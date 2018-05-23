package GUI;

import java.awt.Rectangle;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author BARTO
 */
public class VFacturas extends JFrame {

    String ruta = "src/imagenes/";
    public JLabel vFacturas;
    public JButton regresar, cSesion, b1,b2,buscar,abrir,imprimir,guardar, vFactura;
    JFrame f;
    JPanel p;
    ActionListener listener;
    public VFacturas() {
        //listener = new GFacturas.CustomActionListener();
        f = Builder.construirFrame("Facturas", new Rectangle(0,0, 700, 600), false); 
        p = Builder.crearPanel(f, new Rectangle(0, 0, 700, 600),ruta+"img_fondo_ventana_facturas.png", false);
        
        //etiquetas
        vFacturas = Builder.crearLabelImagen(p, ruta+"img_visualizar_factura.png",  new Rectangle(35,168, 198,326));

        //botones  
        regresar = Builder.crearButtonIcon(p, "regresar", ruta+"regresar.png",new Rectangle(326,513, 41,41), listener, true, false);
        cSesion = Builder.crearButtonIcon(p,"Cerrar Sesión", ruta+"boton_cerrar_sesion.png",new Rectangle(460,510, 142,45), listener, true, false);
        b1 = Builder.crearButtonIcon(p,"1", ruta+"btn_1.png",new Rectangle(77,106,36,36), listener, true,false);
        b2 = Builder.crearButtonIcon(p,"1", ruta+"btn_2_selected.png",new Rectangle(156,106,36,36), listener, true,false);
        
    }

    public static void main(String[] args) {
        VFacturas f = new VFacturas();
    }
}
