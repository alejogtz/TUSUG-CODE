package GUI;
import CONTROLLERS.Autobus;
import Validacion.Validador;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author BARTO
 */
public final class ConfirmarAutobus extends JFrame{
    String ruta = "src/imagenes/";
    ActionListener listener;
    Validador valida;
    public JTextArea advertencia;
    public JButton aceptar,cancelar;
    public JLabel advertenciaIcon;
    public JPanel panel;
    Autobus controlador;
    JFrame f;
    public ConfirmarAutobus()
    {
        f = Builder.construirFrame("Confirmacion", new Rectangle(200, 50, 459, 254), false);
        inicializarcomp();
        f.setVisible(true);
        panel.setVisible(true);
        listener = new CustomActionListener();
        AutobusGUI auto=new AutobusGUI();
        controlador=new Autobus(auto);
    }
    
    public void inicializarcomp(){
        panel = Builder.crearPanel(f,new Rectangle(1,1, 459, 254), null, true);
        panel.setBackground(Color.white);
        aceptar = Builder.crearBoton(panel, "Aceptar",new Rectangle(134, 160, 84, 25), listener, true, false);
        cancelar = Builder.crearBoton(panel, "Cancelar",new Rectangle(241, 160, 84, 25), listener, true, false);
        advertenciaIcon = Builder.crearLabelImagen(panel, ruta+ "advertencia.png", new Rectangle(31, 66, 64, 64));
        advertencia = new JTextArea();
        
        advertencia.setBounds(new Rectangle(129, 45, 300, 118));
        panel.add(advertencia);
        advertencia.setEditable(false);
        advertencia.setOpaque(true);
        advertencia.append("¡ATENCION! Usted esta apunto de eliminar un\nregistro de un autobus.Hacer esto implica borrar\ntodo registro relacionado al trabajador dentro de la\nbase de datos. Esta accion no se podra revertir.\n\n¿Esta usted seguro de ello?");
        
    }   
    public static void main (String []args)
    {
        Confirmacion c  = new Confirmacion();
    }
    class CustomActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String op = e.getActionCommand();
            switch(op)
            {
                case "Aceptar":
                    f.dispose();
                    break;
                case "Cancelar":
                    f.dispose();
            }
        }
    }
}
