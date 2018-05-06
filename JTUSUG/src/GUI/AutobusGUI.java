package GUI;
import CONTROLLERS.Autobus;
import CONTROLLERS.Conexion;
import Validacion.Validador;
import static Validacion.Validador.*;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import GUI.Builder;
//import GUI.PanelImagen;
public class AutobusGUI extends JFrame 
{
    ActionListener listener;
    Autobus controlador;
    Validador valida;
    public JTextField txt_buscar,txt_marca,txt_No_Eco,txt_Km,txt_matricula,txt_id,txt_asientos;
    public JFileChooser url_img;
    public AutobusGUI()
    {
        listener = new CustomActionListener();
        Builder.buildFrame(this,"Autobus", new Rectangle(200,50,700,600),false);
        inicializarcomp();
        controlador = new Autobus(this);
    }
    
    public void inicializarcomp()
    {
        JLabel l1 = Builder.crearLabel(this, "Codigo Autobus", new Rectangle(55, 112, 213, 41),null,null);
        l1.setForeground(Color.white);
        JLabel l2 = Builder.crearLabel(this, "________________", new Rectangle(43, 125, 213, 41),null,null);
        l2.setForeground(Color.white);
        JList jl = new JList();
        jl.setBounds(43,165,113,320);
        jl.setOpaque(false);
        this.add(jl);
        
        txt_buscar=new JTextField(30);
        txt_buscar=Builder.crearTextField(this, new Rectangle(305, 112, 224, 33), "", null, null,new Font("Segoe UI", Font.BOLD, 10),true,true,true);
        txt_marca=new JTextField(25);
        txt_marca=Builder.crearTextField(this, new Rectangle(305, 200, 351, 19), "", null, null,new Font("Segoe UI", Font.BOLD, 10),true,true,true);
        txt_No_Eco=new JTextField(25);
        txt_No_Eco=Builder.crearTextField(this, new Rectangle(401, 222, 255, 19), "", null, null,new Font("Segoe UI", Font.BOLD, 10),true,true,true);
        txt_Km=new JTextField(10);
        txt_Km=Builder.crearTextField(this, new Rectangle(374, 284, 161, 19), "", null, null,new Font("Segoe UI", Font.BOLD, 10),true,true,true);
        txt_matricula=new JTextField(10);
        txt_matricula=Builder.crearTextField(this, new Rectangle(365, 252, 292, 19), "", null, null,new Font("Segoe UI", Font.BOLD, 10),true,true,true);
        
        txt_marca.addKeyListener(new java.awt.event.KeyAdapter() 
        {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) 
            {
                validaNombre(evt,txt_marca,20);
            }
        });
        
        txt_No_Eco.addKeyListener(new java.awt.event.KeyAdapter() 
        {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) 
            {
                validaNombre(evt,txt_No_Eco,20);
            }
        });
        
        txt_matricula.addKeyListener(new java.awt.event.KeyAdapter() 
        {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) 
            {
                validaAlfanumerico(evt,txt_matricula,10);
            }
        });     
        
        JLabel l4 = Builder.crearLabel(this, "Marca: ", new Rectangle(254, 198, 55, 17),null,null);
        JLabel l5 = Builder.crearLabel(this, "Numero Economico:", new Rectangle(254, 220, 351, 17),null,null);
        JLabel l6 = Builder.crearLabel(this, "Matricula Autobus", new Rectangle(254, 252, 118, 17),null,null);
        JLabel l8 = Builder.crearLabel(this, "Kilometraje", new Rectangle(254, 321, 201, 17),null,null);
        JLabel l9 = Builder.crearLabel(this, "ID", new Rectangle(254, 359, 145, 17),null,null);
        JLabel l10 = Builder.crearLabel(this, "Asientos", new Rectangle(319, 392, 150, 35),null,null);
        JButton b1 = Builder.crearBoton(this,"Actualizar Lista",new Rectangle(33, 500, 133, 37) , listener,true,true);
        
        b1.setBackground(new Color (7,162,184));
        b1.setForeground(Color.white);
        JButton b2 = Builder.crearBoton(this, "Buscar", new Rectangle(222, 112, 84, 32), listener,true,false);
        b2.setBackground(new Color (7,162,184));
        b2.setForeground(Color.white);
        JButton b3 = Builder.crearBoton(this, "Nuevo autobus", new Rectangle(266, 490, 121, 27), listener,true,false);
        b3.setBackground(new Color (7,162,184));
        b3.setForeground(Color.white);
        JButton b4 = Builder.crearBoton(this, "Modificar",new Rectangle(414, 490, 97, 27), listener,true,false);
        b4.setBackground(new Color (102,102,102));
        b4.setForeground(Color.white);
        JButton b5 = Builder.crearBoton(this, "Eliminar",new Rectangle(550, 490, 80, 27), listener,true,false);
        b5.setBackground(new Color (152,0,0));
        b5.setForeground(Color.white);
        
        Builder.crearLabelImagen(this,"src/Imagenes/fondo ventana con logo.png" ,new Rectangle(0, 0, 700,600));
        
    }
    
    class CustomActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String op = e.getActionCommand();
            switch(op)
            {
                case "Nuevo autobus":
                    controlador.ingresarAutobus();
                    break;
                case "Modificar":
                    break;             
                case "cargarImagen":
                    break;
                case "Actualizar Lista":
                    break;
                case "Buscar":
                    break;
                case "Eliminar":
                    break;
            }
        }
    }
    
    public static void main(String []args)
    {
        Conexion.setConfiguracion("postgres", "root");
        AutobusGUI a= new AutobusGUI();
    }
}