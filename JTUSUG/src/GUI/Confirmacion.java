package GUI;
import Validacion.Validador;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
/**
 *
 * @author BARTO
 */
public final class Confirmacion extends JFrame{
    String ruta = "src/imagenes/";
    ActionListener listener;
    Validador valida;
    public JTextArea advertencia;
    public JButton aceptar,cancelar;
    public JLabel advertenciaIcon;
    public JPanel panel;
    JFrame f;
    public Confirmacion()
    {
        f = Builder.construirFrame("Confirmacion", new Rectangle(200, 50, 459, 254), false);
        inicializarcomp();
    }
    
    public void inicializarcomp(){
        panel = Builder.crearPanel(f,new Rectangle(1,1, 459, 254), null, true);
        panel.setBackground(Color.white);
        aceptar = Builder.crearBoton(panel, "Aceptar",new Rectangle(134, 160, 84, 25), null, true, false);
        aceptar = Builder.crearBoton(panel, "Cancelar",new Rectangle(241, 160, 84, 25), null, true, false);
        advertenciaIcon = Builder.crearLabelImagen(panel, ruta+ "advertencia.png", new Rectangle(31, 66, 64, 64));
        advertencia = new JTextArea();
        advertencia.append("¡ATENCION! Usted esta apunto de eliminar un\nregistro de un trabajador.Hacer esto implica borrar\ntodo registro relacionado al trabajador dentro de la\nbase de datos. Esta accion no se podra revertir.\n\n¿Esta usted seguro de ello?");
        advertencia.setBounds(new Rectangle(129, 45, 300, 118));
        advertencia.setEditable(false);
        advertencia.setOpaque(true);
        panel.add(advertencia);
    }   
    public static void main (String []args)
    {
        Confirmacion c  = new Confirmacion();
    }
}
