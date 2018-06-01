package GUI;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
public class ListaInventario {
    String ruta = "src/imagenes/";
    JFrame f;
    JPanel p;
    public JTable tabla;
    ActionListener listener;
    DefaultTableModel dtm;
    public JLabel nInventario,fecha,lInventario;
    public JButton buscar,abrir,imprimir,guardar,regresar,sesion,cSesion;
    public JDateChooser dateChooser;
    public JTextField numInv;
    static String encabezado[]  = {"No. Inventario","Responsable","Fecha de Emisión"};
     static Object [][]datos = {{"","",""},
                                {"","",""},
                                {"","",""},
                                {"","",""},
                                {"","",""},
                                {"","",""},
                                {"","",""},
                                {"","",""}};
     public ListaInventario()
     {
        f = Builder.construirFrame("Inventario", new Rectangle(0,0, 700, 600), false); 
        p = Builder.crearPanel(f, new Rectangle(0, 0, 700, 600),ruta+"fondo_mant.png", false);
        
        //JCalendar
        dateChooser = new JDateChooser ();
         p.add(dateChooser);
        dateChooser.setBounds(480,90,170,22);
        
        //botones
        buscar = Builder.crearBoton(p,"Buscar", new Rectangle(54,89,74,21), null, true, false);
        buscar.setBackground(Color.white);
        buscar.setForeground(Color.black);
        abrir = Builder.crearButtonIcon(p,"abrir", ruta+"folder.png",new Rectangle(643,182,24,24), listener, true,false);
        imprimir = Builder.crearButtonIcon(p,"imprimir", ruta+"print.png",new Rectangle(643,243,24,24), listener, true,false);
        guardar = Builder.crearButtonIcon(p,"guardar", ruta+"save.png",new Rectangle(643,301,24,24), listener, true,false);
        regresar = Builder.crearButtonIcon(p, "regresar", ruta+"regresar.png",new Rectangle(326,513, 41,41), listener, true, false);
        cSesion = Builder.crearButtonIcon(p,"Cerrar Sesión", ruta+"boton_cerrar_sesion.png",new Rectangle(460,510, 142,45), listener, true, false);
        
        //label
        nInventario = Builder.crearLabel(p,"No. de Inventario:",new Rectangle(168,90,110,18),new Color(79,79,79), null, new Font("Segoe UI", Font.PLAIN, 14)); 
        fecha = Builder.crearLabel(p,"Fecha:",new Rectangle(430,90,45,18),new Color(79,79,79), null, new Font("Segoe UI", Font.PLAIN, 14)); 
        lInventario = Builder.crearLabel(p,"Lista de Inventario:",new Rectangle(270,180,118,18),new Color(79,79,79), null, new Font("Segoe UI", Font.PLAIN, 14)); 
        
        //JTextField
        numInv = Builder.crearTextField(p,new Rectangle(280,90,130,22), "", null, null, new Font("Segoe UI", Font.PLAIN, 11), true,true, true,listener);
        
        
        //Tabla
        dtm= new DefaultTableModel();
        tabla = new JTable(datos,encabezado);
        tabla.setBackground(Color.GRAY);
        tabla.setPreferredSize(new Dimension(515,277));
        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setBounds(79,220,515,277);
        p.add(scrollPane);
        
        
        
     }
     public static void main (String []args)
     {
         ListaInventario inventario = new ListaInventario();
     }
}
