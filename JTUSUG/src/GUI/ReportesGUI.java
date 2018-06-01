package GUI;
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
public class ReportesGUI {
    String ruta = "src/imagenes/";
    public JLabel reporte,nReporte,nombre;
    public JButton buscar,abrir,imprimir,guardar,regresar,sesion,cSesion;
    JTextField numR,name;
    JFrame f;
    JPanel p;
    public JTable tabla;
    ActionListener listener;
    DefaultTableModel dtm;
    static String encabezado[]  = {"Numero de Reporte","Nombre"};
     static Object [][]datos = {{"",""},
                                {"",""},
                                {"",""},
                                {"",""},
                                {"",""},
                                {"",""},
                                {"",""},
                                {"",""}};
    public ReportesGUI()
    {
        f = Builder.construirFrame("Reportes", new Rectangle(0,0, 700, 600), false); 
        p = Builder.crearPanel(f, new Rectangle(0, 0, 700, 600),ruta+"fondo_mant.png", false);
        
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
        reporte = Builder.crearLabel(p,"Reportes",new Rectangle(298,160,59,18),new Color(79,79,79), null, new Font("Segoe UI", Font.PLAIN, 14));
        nReporte = Builder.crearLabel(p,"Numero de Reporte:",new Rectangle(158,90,125,18),new Color(79,79,79), null, new Font("Segoe UI", Font.PLAIN, 14));
        nombre = Builder.crearLabel(p,"Nombre:",new Rectangle(451,90,55,18),new Color(79,79,79), null, new Font("Segoe UI", Font.PLAIN, 14));
        
        
        //JtextField
        numR = Builder.crearTextField(p,new Rectangle(293,88,131,22),"",null, null,new Font("Segoe UI", Font.PLAIN, 11), true, true, true, listener);
        name = Builder.crearTextField(p,new Rectangle(516,88,131,22),"",null, null,new Font("Segoe UI", Font.PLAIN, 11), true, true, true, listener);
        
         //Tabla
        dtm= new DefaultTableModel();
        tabla = new JTable(datos,encabezado);
        tabla.setBackground(Color.GRAY);
        tabla.setPreferredSize(new Dimension(504,278));
        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setBounds(75,196,504,278);
        p.add(scrollPane);
    }
    public static void main(String []agrs)
    {
        ReportesGUI r = new ReportesGUI();
    }
}
