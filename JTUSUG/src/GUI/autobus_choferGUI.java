package GUI;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.*;

public class autobus_choferGUI {
    String ruta = "src/imagenes/";
    public JList lista;
    public JScrollBar   scroll; 
    public JButton btActualizar,confirm,regresar;
    public JLabel lTrabajadores,dGeneral,nombre,apP,apM,estado,cAutobus,matricula,marca,km;
    public JTextField name,ap_paterno,ap_materno,state,matric,marc,kilometraje;
    public JComboBox combo;
    public String user;
    JMenuBar barra;
    JMenu archivo;
    JMenuItem reestablecer;
    JMenuItem Cerrar_Sesion;
    JFrame x;    
    JPanel p;
    ActionListener listener;
    public autobus_choferGUI()
    {
        user = "Usuario";
        x = Builder.construirFrame("Trabajador", new Rectangle(0,0,700,600), false); 
        p = Builder.crearPanel(x, new Rectangle(0,0,700,600),ruta + "fondo_vta_chofer_autobus.png", false);
        
        //Menu
         barra=new JMenuBar();
         barra.setBackground(Color.GRAY);
         archivo=new JMenu(user);
         reestablecer = new JMenuItem("Reestablecer Contraseña");
         Cerrar_Sesion= new JMenuItem("Cerrar Sesión");
         archivo.add(reestablecer);
         archivo.add(Cerrar_Sesion);
         barra.add(archivo);
         p.add(barra);
         barra.setBounds(new Rectangle(478,518,55,34));
         barra.setVisible(true);
         
        //botones
        btActualizar =  Builder.crearButtonIcon( p, "Actualizar",ruta+"boton_actualizar_lista.png",new Rectangle(89,444,145,36),listener ,true, false);      
        confirm = Builder.crearButtonIcon(p,"confirmar", ruta+"btn_confirmar.png",new Rectangle(409,451,114,43), listener, true, false);
        regresar = Builder.crearButtonIcon(p, "regresar", ruta+"regresar.png",new Rectangle(326,513, 41,41), listener, true, false);

        
        
        
        //Labels
        lTrabajadores = Builder.crearLabel(p,"Lista de Trabajadores",new Rectangle(87,122,136,20),new Color(66,66,66), null, new Font("Segoe UI", Font.PLAIN, 14)); 
        dGeneral = Builder.crearLabel(p,"Descripcion General",new Rectangle(387,112,121,20),new Color(66,66,66), null, new Font("Segoe UI", Font.PLAIN, 14)); 
        nombre = Builder.crearLabel(p,"Nombre:",new Rectangle(336,150,55,20),new Color(66,66,66), null, new Font("Segoe UI", Font.PLAIN, 14)); 
        apP = Builder.crearLabel(p,"Ap. Paterno:",new Rectangle(314,183,76,20),new Color(66,66,66), null, new Font("Segoe UI", Font.PLAIN, 14)); 
        apM = Builder.crearLabel(p,"Ap. Materno:",new Rectangle(309,223,80,20),new Color(66,66,66), null, new Font("Segoe UI", Font.PLAIN, 14)); 
        estado = Builder.crearLabel(p,"Estado:",new Rectangle(344,258,45,20),new Color(66,66,66), null, new Font("Segoe UI", Font.PLAIN, 14)); 
        cAutobus = Builder.crearLabel(p,"Codigo Autobus:",new Rectangle(285,318,105,20),new Color(66,66,66), null, new Font("Segoe UI", Font.PLAIN, 14)); 
        matricula = Builder.crearLabel(p,"Matricula:",new Rectangle(328,349,62,20),new Color(66,66,66), null, new Font("Segoe UI", Font.PLAIN, 14)); 
        marca = Builder.crearLabel(p,"Marca:",new Rectangle(346,381,43,20),new Color(66,66,66), null, new Font("Segoe UI", Font.PLAIN, 14)); 
        km = Builder.crearLabel(p,"Kilometraje:",new Rectangle(315,416,73,20),new Color(66,66,66), null, new Font("Segoe UI", Font.PLAIN, 14)); 
        
        
        
        
        //lista
         lista= new JList();
         p.add(lista);
         lista.setBounds(new Rectangle(65,150,193,280));
         lista.setVisible(true);
         //lista.addMouseListener(new TrabajadorGUI.CustomMouseListener());
         
         //JTextField
         name = Builder.crearTextField(p,new Rectangle(401,146,129,25), "", null, null, new Font("Segoe UI", Font.PLAIN, 11), false,true, true,listener);
         ap_paterno = Builder.crearTextField(p,new Rectangle(401,181,129,25), "", null, null, new Font("Segoe UI", Font.PLAIN, 11), false,true, true,listener);
         ap_materno= Builder.crearTextField(p,new Rectangle(401,216,129,25), "", null, null, new Font("Segoe UI", Font.PLAIN, 11), false,true, true,listener);
         state = Builder.crearTextField(p,new Rectangle(401,251,129,25), "", null, null, new Font("Segoe UI", Font.PLAIN, 11), false,true, true,listener);
         matric = Builder.crearTextField(p,new Rectangle(401,346,129,25), "", null, null, new Font("Segoe UI", Font.PLAIN, 11), true,true, true,listener);
         marc = Builder.crearTextField(p,new Rectangle(401,381,129,25), "", null, null, new Font("Segoe UI", Font.PLAIN, 11), true,true, true,listener);
         kilometraje = Builder.crearTextField(p,new Rectangle(401,416,129,25), "", null, null, new Font("Segoe UI", Font.PLAIN, 11), true,true, true,listener);
         
         //JComboBox
         combo= Builder.crearComboBox(p, new Rectangle(401,314,129,22),null , null, null,null);
         
         
         
 
    }
    public static void main (String []agrs)
    {
        autobus_choferGUI autobus= new autobus_choferGUI();
    }
}
