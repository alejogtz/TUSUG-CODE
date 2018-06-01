package GUI;
import CONTROLLERS.Autobus;
import CONTROLLERS.Conexion;
import CONTROLLERS.SQLAutobus;
import Validacion.Validador;
import static Validacion.Validador.*;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.filechooser.FileNameExtensionFilter;
//import GUI.Builder;
//import GUI.PanelImagen;
public class AutobusGUI extends JFrame 
{ 
    String              ruta = "src/imagenes/";
    ActionListener      listener;
    Autobus             controlador;
    Validador           valida;
    public JList        list;
    public JTextField   txt_buscar,txt_marca,txt_No_Eco,txt_Km,txt_matricula,txt_id,txt_asientos;
    public JFileChooser url_img;
    public JButton      btn_Act_List,btn_nuevo_autobus,btn_modificar,btn_eliminar,btn_agregar_img,btn_regresar;
    public JLabel       lb_codigo_auto,lb_imagen_autobus;
    JFrame a;
    public AutobusGUI()
    {
        a = this;
        listener = new CustomActionListener();
        a=Builder.construirFrame("Autobus", new Rectangle(200,50,700,600),false);
        controlador = new Autobus(this);
        inicializarcomp();
    }
    
    public void inicializarcomp()
    {
        Color color = new Color(233,233,233);
        JButton inicio=     Builder.crearButtonIcon(a,"inicio",ruta + "boton_inicio.png",       new Rectangle(14,63,101,43), listener,false,false);
        JButton sesion=     Builder.crearButtonIcon(a,"sesion",ruta + "boton_cerrar_sesion.png",new Rectangle(539,65,142,43),listener,false,false);
        JButton buscar =    Builder.crearButtonIcon(a,"buscar",ruta + "buscar.png",             new Rectangle(26,185,32,32) ,listener,false,false);
        txt_buscar=         Builder.crearTextField(a, new Rectangle(68, 189, 106, 25), "", null, null,new Font("Segoe UI", Font.BOLD, 10),true,true,true);
        list=new JList();
        controlador.cargarLista(list);
        list.setBounds(14,236,172,198);
        list.addMouseListener(new CustomMouseListener());
        a.add(list);
        
        btn_Act_List =      Builder.crearButtonIcon(a,"actualizar_lista",   ruta + "boton_actualizar_lista.png",new Rectangle(26,446,145,36),listener,true,false);
        btn_nuevo_autobus = Builder.crearButtonIcon(a,"agregar",            ruta + "anadir.png",    new Rectangle(218,136,32,32),listener,true,false, true, color);
        btn_modificar =     Builder.crearButtonIcon(a,"modificar",          ruta + "lapiz.png",     new Rectangle(218,202,32,32),listener,true,false, true, color);
        btn_eliminar=       Builder.crearButtonIcon(a,"eliminar",           ruta + "boton-x.png",   new Rectangle(218,255,32,32),listener,true,false, true, color);
        btn_agregar_img=    Builder.crearButtonIcon(a,"cargarImagen",       ruta + "foto.png",      new Rectangle(626,215,32,32),listener,true,false, true, color);
        btn_regresar=       Builder.crearButtonIcon(a,"regresar",           ruta + "regresar.png",  new Rectangle(626,450,32,32),listener,true,false, true, color);
        lb_imagen_autobus=   Builder.crearLabelImagen(a,"src/imagenes/autobu.png",  new Rectangle(354,162,245 , 139));
        JLabel lb_codigo_auto=      Builder.crearLabel(a, "(Matricula)",               new Rectangle(423,132, 107 , 13),   null,null);
        JLabel lb_Marca =           Builder.crearLabel(a, "Marca:",                    new Rectangle(335,350,101,13),      null,null);
        JLabel lb_Num_Eco =         Builder.crearLabel(a, "Numero Economico:",         new Rectangle(270,383,120,13),      null,null);
        JLabel lb_Mat_Auto =        Builder.crearLabel(a, "Matricula:",                new Rectangle(315,416, 101, 13),    null,null);
        JLabel lb_Km =              Builder.crearLabel(a, "Kilometraje",               new Rectangle(499,350,101,13),      null,null);
        JLabel lb_Asien =           Builder.crearLabel(a, "Asientos:",                 new Rectangle(514,383,101,13),      null,null);

        txt_marca       =   Builder.crearTextField(a, new Rectangle(389,345,108,23), "", null, null,null,true,true,true);
        txt_No_Eco      =   Builder.crearTextField(a, new Rectangle(389,378,108,23), "", null, null,null,true,true,true);
        txt_Km          =   Builder.crearTextField(a, new Rectangle(584,345,74,23),  "", null, null,null,true,true,true);
        txt_matricula   =   Builder.crearTextField(a, new Rectangle(389,411,108,23), "", null, null,null,true,true,true);
        txt_asientos    =   Builder.crearTextField(a, new Rectangle(584,378,74,23),  "", null, null,null,true,true,true);        
        
        JLabel fondo    =   Builder.crearLabelImagen(a, ruta + "fondo_ventana_2.png", new Rectangle(0,0,700,518));
        valida();
    }
    
    static void p(Object o){
        System.err.println(o.toString());
    }
    
    class CustomActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String op = e.getActionCommand();
            switch(op)
            {
                case "agregar":
                    controlador.evtAgregarAutobus();
                    break;
                case "modificar":
                    controlador.modificarAutobus();
                    break;             
                case "cargarImagen":
                    controlador.evtCargarImagen();
                    break;
                case "actualizar_lista":
                    controlador.actualizarLista();
                    break;
                case "Buscar":
                    controlador.buscar();
                    break;
                case "eliminar":
                    controlador.borrarAutobus();                    
                    break;
                case "inicio":
                    controlador.inicio();
                     break;
                case "regresar":
                   controlador.regresar();
                    break;
                case "sesion":
                    LoginGUI l = new LoginGUI();
                    a.dispose();
                    break;
            }
        }
    }
    
    public static void main(String []args)
    {
        //Conexion.setConfiguracion("postgres", "root");
        Conexion.setRol("root");
        AutobusGUI a= new AutobusGUI();
        //p(Fachada.getSelectedFileImage());
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
                validaAlfanumerico(evt,txt_No_Eco,20);
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
    
    class CustomMouseListener extends MouseAdapter{
        public void mouseClicked(MouseEvent me){
        String matricula = (String)list.getSelectedValue();
        SQLAutobus s = new SQLAutobus();
        String registro[] = s.obtenerRegistro(matricula);
        txt_matricula.setText(registro[0].toUpperCase());
        txt_marca.    setText(registro[2].toUpperCase());
        txt_No_Eco.   setText(registro[3].toUpperCase());
        txt_Km.       setText(registro[4].toUpperCase());
        txt_asientos. setText(registro[5].toUpperCase());
        
        };
}
     
}