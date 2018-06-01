package GUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class GFacturas2 extends JFrame {
    String ruta = "src/imagenes/";
    public JLabel factura, fEmision, fechaE, gF, confirmar, pestaña,subT,tot,impuesto,desc;
    public JTextField subtotal,total,iva,descuento;
    public JButton regresar, cSesion, b1, b2, agregar, siguiente,anterior,eliminar,confirm;
    public JTable tabla;
    static String encabezado[]  = {"Código","Descripcion","Unidades","Precio","Descuento","Subtotal"};
    static Object [][]datos = {{"","","","","",""},
                                {"","","","","",""},
                                {"","","","","",""},
                                {"","","","","",""},
                                {"","","","","",""}};
    DefaultTableModel dtm;
    public LocalDate fecha;
    JFrame f;
    JPanel p;
    ActionListener listener;
    public GFacturas2() 
    {
        f = Builder.construirFrame("Facturas", new Rectangle(0,0, 700, 600), false); 
        p = Builder.crearPanel(f, new Rectangle(0, 0, 700, 600),ruta+"fondo_vta_generar_factura_p_2.png", false);
        javax.swing.border.Border border = LineBorder.createGrayLineBorder();
        fecha = LocalDate.now();
        String fechaN = fecha.format(DateTimeFormatter.ofPattern("dd/MMMM/yyyy"));
        
        
        
        //etiquetas
        gF = Builder.crearLabelImagen(p, ruta+"img_generar_factura.png", new Rectangle(35,168,200,330));
        gF.setBorder(border);
        pestaña = Builder.crearLabelImagen(p, ruta+"img_indicador_1_y_2__2_.png", new Rectangle(586,122,60,30));
        fEmision = Builder.crearLabel(p,"Fecha de Emisión: ",new Rectangle(446,89,200,15), null, null, new Font("Segoe UI", Font.PLAIN, 11));
        fechaE   = Builder.crearLabel(p,fechaN,new Rectangle(545,89,200,15), null, Color.blue, new Font("Segoe UI", Font.PLAIN, 11));
        confirmar= Builder.crearLabel(p,"Confirmar Costos",new Rectangle(417,122,110,20), null, null, new Font("Segoe UI", Font.PLAIN, 11));
        subT = Builder.crearLabel(p,"Subtotal Factura:",new Rectangle(288,367,90,15), null, null, new Font("Segoe UI", Font.PLAIN, 11));
        tot = Builder.crearLabel(p,"Total a Pagar:",new Rectangle(483,368,75,15), null, null, new Font("Segoe UI", Font.PLAIN, 11));
        impuesto = Builder.crearLabel(p,"IVA:",new Rectangle(356,395,20,15), null, null, new Font("Segoe UI", Font.PLAIN, 11));
        desc = Builder.crearLabel(p,"Descuento:",new Rectangle(318,425,65,15), null, null, new Font("Segoe UI", Font.PLAIN, 11));
        
        //botones
        b1 = Builder.crearButtonIcon(p,"1", ruta+"btn_1_selected.png",new Rectangle(77,106,36,36), listener, true,false);
        b2 = Builder.crearButtonIcon(p,"2", ruta+"btn_2.png",new Rectangle(156,106,36,36), listener, true,false);
        regresar = Builder.crearButtonIcon(p, "regresar", ruta+"regresar.png",new Rectangle(326,513, 41,41), listener, true, false);
        cSesion = Builder.crearButtonIcon(p,"Cerrar Sesión", ruta+"boton_cerrar_sesion.png",new Rectangle(460,510, 142,45), listener, true, false);
        anterior = Builder.crearButtonIcon(p,"anterior", ruta+"img_anterior.png",new Rectangle(320,460,87,43), listener, true, false);
        agregar = Builder.crearButtonIcon(p,"agregar", ruta+"bag.png",new Rectangle(292,148,24,24), listener, true, false);
        eliminar = Builder.crearButtonIcon(p,"agregar", ruta+"shopping-cart.png",new Rectangle(341,148,24,24), listener, true, false);
        confirm = Builder.crearButtonIcon(p,"confirmar", ruta+"btn_confirmar.png",new Rectangle(532,411,114,43), listener, true, false);
        
        //Tabla
        dtm= new DefaultTableModel();
        tabla = new JTable(datos,encabezado);
        //tabla.setBackground(Color.GRAY);
        tabla.setPreferredSize(new Dimension(392,179));
        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setBounds(281,176,392,179);
        p.add(scrollPane);
        
        //JTextField
        subtotal = Builder.crearTextField(p,new Rectangle(383,365,82,20), "", null, null, new Font("Segoe UI", Font.PLAIN, 11), true,true, true,listener);
        total = Builder.crearTextField(p,new Rectangle(560,365,86,20), "", null, null, new Font("Segoe UI", Font.PLAIN, 11), true,true, true,listener);
        iva = Builder.crearTextField(p,new Rectangle(383,392,82,20), "", null, null, new Font("Segoe UI", Font.PLAIN, 11), true,true, true,listener);
        descuento = Builder.crearTextField(p,new Rectangle(383,422,82,20), "", null, null, new Font("Segoe UI", Font.PLAIN, 11), true,true, true,listener);
    }
     public static void main (String []args)
    {
        GFacturas2 g = new GFacturas2();
    }
}
