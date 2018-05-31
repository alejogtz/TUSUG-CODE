package GUI;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.scene.layout.Border;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
public class ReportesGUI {
    String ruta = "src/imagenes/";
    public JLabel reporte,nReporte,nombre;
    public JButton buscar,abrir,imprimir,guardar,regresar,sesion;
    JTextField numR,name;
    JFrame f;
    JPanel p;
    public JTable tabla;
    public ReportesGUI()
    {
        f = Builder.construirFrame("Reportes", new Rectangle(0,0, 700, 600), false); 
        p = Builder.crearPanel(f, new Rectangle(0, 0, 700, 600),ruta+"img_fondo_ventana_facturas.png", false);
        
        //botones
        buscar = Builder.crearBoton(p,"Buscar", new Rectangle(54,89,74,21), null, true, false);
    }
    public static void main(String []agrs)
    {
        ReportesGUI r = new ReportesGUI();
    }
}
