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
    public JList list;
    public JTextField txt_buscar,txt_marca,txt_No_Eco,txt_Km,txt_matricula,txt_id,txt_asientos;
    public JFileChooser url_img;
    public JButton btn_Act_List,btn_nuevo_autobus,btn_modificar,btn_eliminar,btn_agregar_img,btn_regresar;
    public JLabel lb_codigo_auto,lb_imagen_autobus;
    public AutobusGUI()
    {
        listener = new CustomActionListener();
        Builder.buildFrame(this,"Autobus", new Rectangle(200,50,700,600),false);
        inicializarcomp();
        controlador = new Autobus(this);
    }
    
    public void inicializarcomp()
    {
        JButton inicio=Builder.crearButtonIcon(this,"","/home/gallardo/TUSUG-CODE/JTUSUG/src/imagenes/boton_inicio.png",new Rectangle(14,63,101,43),null,false,false);
        JButton sesion=Builder.crearButtonIcon(this,"","/home/gallardo/TUSUG-CODE/JTUSUG/src/imagenes/boton_cerrar_sesion.png",new Rectangle(539,65,142,43),null,false,false);
        JButton buscar = Builder.crearButtonIcon(this,"","/home/gallardo/TUSUG-CODE/JTUSUG/src/imagenes/buscar.png",new Rectangle(26,185,32,32),null,false,false);
        buscar.setBackground(new Color (233,233,233));
        buscar.setForeground(Color.white);
        txt_buscar=new JTextField(30);
        txt_buscar=Builder.crearTextField(this, new Rectangle(68, 189, 106, 25), "", null, null,new Font("Segoe UI", Font.BOLD, 10),true,true,true);
        String[] datos={"","Hola","Soy","Un","Pan"};
        list=new JList(datos);
        list.setBounds(14,236,172,198);
        this.add(list);
        btn_Act_List=new JButton();
        btn_Act_List = Builder.crearButtonIcon(this,"actualizar_lista","/home/gallardo/TUSUG-CODE/JTUSUG/src/imagenes/boton_actualizar_lista.png",new Rectangle(26,446,145,36),null,false,false);
        btn_Act_List.setBackground(new Color(233,233,233));
        btn_nuevo_autobus=new JButton();
        btn_nuevo_autobus = Builder.crearButtonIcon(this,"agregar","/home/gallardo/TUSUG-CODE/JTUSUG/src/imagenes/anadir.png",new Rectangle(218,136,32,32),null,false,false);
        btn_nuevo_autobus.setBackground(new Color(233,233,233));
        btn_modificar = Builder.crearButtonIcon(this,"modificar","/home/gallardo/TUSUG-CODE/JTUSUG/src/imagenes/lapiz.png",new Rectangle(218,202,32,32),null,false,false);
        btn_modificar.setBackground(new Color(233,233,233));
        btn_eliminar=new JButton();
        btn_eliminar=Builder.crearButtonIcon(this,"eliminar","/home/gallardo/TUSUG-CODE/JTUSUG/src/imagenes/boton-x.png",new Rectangle(218,255,32,32),null,false,false);
        btn_eliminar.setBackground(new Color(233,233,233));
        btn_agregar_img=new JButton();
        btn_agregar_img=Builder.crearButtonIcon(this,"","/home/gallardo/TUSUG-CODE/JTUSUG/src/imagenes/foto.png",new Rectangle(626,215,32,32),null,false,false);
        btn_regresar=new JButton();
        btn_regresar=Builder.crearButtonIcon(this,"regresar","/home/gallardo/TUSUG-CODE/JTUSUG/src/imagenes/regresar.png",new Rectangle(626,450,32,32),null,false,false);
        btn_regresar.setBackground(new Color(233,233,233));
        JLabel lb_codigo_auto=Builder.crearLabel(this, "(Matricula)", new Rectangle(423,132, 107 , 13),null,null);
        JLabel lb_imagen_autobus=Builder.crearLabelImagen(this, "/home/gallardo/TUSUG-CODE/JTUSUG/src/imagenes/autobu.png", new Rectangle(354,162,245 , 139));
        JLabel lb_Marca = Builder.crearLabel(this, "Marca: ", new Rectangle(344,355,35,13),null,null);
        JLabel lb_Num_Eco = Builder.crearLabel(this, "Numero Economico:", new Rectangle(278,383,101,13),null,null);
        JLabel lb_Mat_Auto = Builder.crearLabel(this, "Matricula Autobus", new Rectangle(329,416, 50, 13),null,null);
        JLabel lb_Km = Builder.crearLabel(this, "Kilometraje", new Rectangle(521,350,60,13),null,null);
        JLabel lb_Asien = Builder.crearLabel(this, "Asientos", new Rectangle(514,383,67,13),null,null);

        txt_marca=new JTextField(25);
        txt_marca=Builder.crearTextField(this, new Rectangle(389,345,108,23), "", null, null,new Font("Segoe UI", Font.BOLD, 10),true,true,true);
        txt_No_Eco=new JTextField(25);
        txt_No_Eco=Builder.crearTextField(this, new Rectangle(389,378,108,23), "", null, null,new Font("Segoe UI", Font.BOLD, 10),true,true,true);
        txt_Km=new JTextField(10);
        txt_Km=Builder.crearTextField(this, new Rectangle(584,345,74,23), "", null, null,new Font("Segoe UI", Font.BOLD, 10),true,true,true);
        txt_matricula=new JTextField(10);
        txt_matricula=Builder.crearTextField(this, new Rectangle(389,411,108,23), "", null, null,new Font("Segoe UI", Font.BOLD, 10),true,true,true);
        //txt_id=new JTextField(10);
        //txt_id=Builder.crearTextField(this, new Rectangle(365,359,300,19), "", null, null, new Font("Segoe UI", Font.BOLD, 10), true, true,true);
        txt_asientos=new JTextField(10);
        txt_asientos=Builder.crearTextField(this, new Rectangle(584,378,74,23), "", null, null, new Font("Segoe UI", Font.BOLD, 10), true, true,true);
        
        
        JLabel fondo=Builder.crearLabelImagen(this, "/home/gallardo/TUSUG-CODE/JTUSUG/src/imagenes/fondo_ventana_2.png", new Rectangle(0,0,700,518));
        valida();
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
                    controlador.seleccionarImg();
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
    public void valida()
    {
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
        
        txt_buscar.addKeyListener(new java.awt.event.KeyAdapter() 
        {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) 
            {
                validaAlfanumerico(evt,txt_buscar,10);
            }
        });
        txt_Km.addKeyListener(new java.awt.event.KeyAdapter() 
        {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) 
            {
                validaNum(evt,txt_Km,10);
            }
        });
        txt_asientos.addKeyListener(new java.awt.event.KeyAdapter() 
        {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) 
            {
                validaNum(evt,txt_asientos,10);
            }
        });
    }
}