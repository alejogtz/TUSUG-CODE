package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author BARTO
 */
public class VFacturas extends JFrame {

    String ruta = "src/imagenes/";
    public JLabel vFacturas,nFacturas,cProveedor,ordenar;
    public JTextField nF,cP;
    public JButton regresar, cSesion, b1,b2,buscar,abrir,imprimir,guardar, vFactura;
    public JTable tabla;
    public JCheckBox fechaE,nFact,cProv;
    static String encabezado[]  = {"Numero de Factura","Código de Vendedor"};
     static Object [][]datos = {{"","","",""},
                                {"","","",""},
                                {"","","",""},
                                {"","","",""},
                                {"","","",""},
                                {"","","",""},
                                {"","","",""},
                                {"","","",""}};
    DefaultTableModel dtm;
    JFrame f;
    JPanel p;
    ActionListener listener;
    public VFacturas() {
        //listener = new GFacturas.CustomActionListener();
        f = Builder.construirFrame("Facturas", new Rectangle(0,0, 700, 600), false); 
        p = Builder.crearPanel(f, new Rectangle(0, 0, 700, 600),ruta+"img_fondo_ventana_facturas.png", false);
        javax.swing.border.Border border = LineBorder.createGrayLineBorder();
        
        //etiquetas
        vFacturas = Builder.crearLabelImagen(p, ruta+"img_visualizar_factura.png",  new Rectangle(35,168, 198,326));
        vFacturas.setBorder(border);
        nFacturas = Builder.crearLabel(p,"Numero de factura: ",new Rectangle(393,93,103,16), null, null, new Font("Segoe UI", Font.PLAIN, 11));
        cProveedor = Builder.crearLabel(p,"Codigo de Proveedor:",new Rectangle(380,119,118,16), null, null, new Font("Segoe UI", Font.PLAIN, 11));
        ordenar = Builder.crearLabel(p,"Ordenar por:",new Rectangle(304,441,68,16), null, null, new Font("Segoe UI", Font.PLAIN, 11));
        
        
        
        //botones  
        regresar = Builder.crearButtonIcon(p, "regresar", ruta+"regresar.png",new Rectangle(326,513, 41,41), listener, true, false);
        cSesion = Builder.crearButtonIcon(p,"Cerrar Sesión", ruta+"boton_cerrar_sesion.png",new Rectangle(460,510, 142,45), listener, true, false);
        b1 = Builder.crearButtonIcon(p,"1", ruta+"btn_1.png",new Rectangle(77,106,36,36), listener, true,false);
        b2 = Builder.crearButtonIcon(p,"2", ruta+"btn_2_selected.png",new Rectangle(156,106,36,36), listener, true,false);
        buscar = Builder.crearBoton(p, "Buscar",new Rectangle(291,106,74,21) , listener, true, false);
        buscar.setBackground(Color.white);
        buscar.setForeground(Color.black);
        abrir = Builder.crearButtonIcon(p,"abrir", ruta+"folder.png",new Rectangle(643,213,24,24), listener, true,false);
        imprimir = Builder.crearButtonIcon(p,"imprimir", ruta+"print.png",new Rectangle(643,274,26,24), listener, true,false);
        guardar = Builder.crearButtonIcon(p,"guardar", ruta+"save.png",new Rectangle(643,332,28,28), listener, true,false);
        
        
        //cuadros de texto
        nF = Builder.crearTextField(p,new Rectangle(506,90,131,22) , "",null, null, new Font("Segoe UI", Font.PLAIN, 11), true, true, true);
        cP = Builder.crearTextField(p,new Rectangle(506,118,131,22) , "",null, null, new Font("Segoe UI", Font.PLAIN, 11), true, true, true);
        
        //Tabla
        dtm= new DefaultTableModel();
        tabla = new JTable(datos,encabezado);
        tabla.setBackground(Color.GRAY);
        tabla.setPreferredSize(new Dimension(302,272));
        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setBounds(318,150,302,272);
        p.add(scrollPane);
        
        //checkbox
        fechaE = Builder.crearCheckBox(p, new Rectangle(382,441,124,16),"Fecha de Emisión", null, false,null, null);
        nFact = Builder.crearCheckBox(p, new Rectangle(382,467,133,16),"Numero de Factura", null, false,null, null);
        cProv = Builder.crearCheckBox(p, new Rectangle(511,441,143,16),"Codigo de Proveedor", null, false,null, null);
        
        
        
    }

    public static void main(String[] args) {
        VFacturas f = new VFacturas();
    }
}