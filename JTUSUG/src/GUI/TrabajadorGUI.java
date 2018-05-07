package GUI;
import CONTROLLERS.Trabajador;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.time.LocalDate;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ImageIcon;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;

public class TrabajadorGUI {
    String dia[]={"1","2","3","4","5","6","7","8","9","10","11","12","13","14",
                  "15","16","17","18","19","20","21","22","23","24","25","26",
                  "27","28","29","30","31"};
    String mes[]={"1","2","3","4","5","6","7", "8","9", "10", "11", "12"};
    String anio[]={"1990", "1991", "1992", "1993", "1994", "1995", "1996", 
                   "1997", "1998", "1999", "2000"};
    String Cargo[]={"secretaria", "chofer", "mantenimiento", "recursos humanos"};
    String Categoria[]= {"1","2","3","4","5"};
    String st[]={"activo", "pasivo", "baja"};
    private JComboBox<String> cb4;
    JFrame x;
    JPanel p;
    public JLabel trabajadores;
    public JTextField tfrfc, tfapp, tfapm, tfnom, tfgen,  tfeda, tffna, tfsa, 
                      tfdir, tffin, tftce, tfema,tftca,buscador;
    public JTextArea area1;
    public JComboBox cb1, cb2, cb3, cb5,cb6, cb7,cbPuesto;

    Trabajador interfaz;

    public LocalDate fecha1,fecha2;
    public int dia1,mes1,anio1;
    public JList lista;
    public JButton btInicio,btLT,btBuscar,btActualizar,sesion,back,nuevo,
                   agregar,baja,btlista,btactinac, Cfoto;
    public JScrollBar scroll;
    public Date fecha,fechaA;
    public TrabajadorGUI(){

        interfaz= new Trabajador(this);
        JFrame x = Builder.construirFrame("Trabajador", new Rectangle(0,0, 700, 600), false); 
        JPanel p = Builder.crearPanel(x, new Rectangle(0, 0, 700, 600),"src/imagenes/fondo_ventana_2.png", false);
        

        //etiquetas
        trabajadores = Builder.crearLabel(p, "Trabajadores", new Rectangle(65, 160, 80, 20), null, null, new Font("Segoe UI",Font.PLAIN,11));
        JLabel imagen=Builder.crearLabelImagen(p,"src/imagenes/icono usuario.jpg",new Rectangle(539, 130, 128, 128));
        JLabel jlrfc= Builder.crearLabel(p, "RFC: ", new Rectangle(351,143,28, 13),null,null,new Font("Segoe UI",Font.PLAIN,11));
        JLabel jlapp= Builder.crearLabel(p, "Apellido Paterno: ", new Rectangle(285,216,95, 13),null, null,new Font("Segoe UI",Font.PLAIN,11));
        JLabel jlapm= Builder.crearLabel(p, "Apellido Materno: ", new Rectangle(282,245,100, 13),null, null,new Font("Segoe UI",Font.PLAIN,11));
        JLabel jlnom= Builder.crearLabel(p, "Nombre(s): ", new Rectangle(319,179,60, 13),null, null,new Font("Segoe UI",Font.PLAIN,11));
        JLabel jlfna= Builder.crearLabel(p, "Fecha nac. :", new Rectangle(270, 311,70, 26), null,null,new Font("Segoe UI",Font.PLAIN,11));
        JLabel jlsts= Builder.crearLabel(p, "Status :", new Rectangle(270, 290,131, 17), null,null,new Font("Segoe UI",Font.PLAIN,11));
        JLabel jldir= Builder.crearLabel(p, "Domicilio :", new Rectangle(322, 378,54, 13),null,null,new Font("Segoe UI",Font.PLAIN,11));
        JLabel puesto= Builder.crearLabel(p, "Puesto :", new Rectangle(322, 440,50, 13),null,null,new Font("Segoe UI",Font.PLAIN,11));
        
        
        //botones
        btInicio = Builder.crearButtonIcon(p, "Inicio","src/imagenes/boton_inicio.png",new Rectangle(14, 63, 88, 43), null, true, false);
        btBuscar = Builder.crearButtonIcon(p, "Buscar","src/imagenes/buscar.png",new Rectangle(20, 215, 33, 32) , null,true,false);
        btActualizar = Builder.crearButtonIcon(p,"Buscar","src/imagenes/boton_actualizar_lista.png", new Rectangle(26, 446, 145, 36), null, true, false);
        sesion = Builder.crearButtonIcon(p,"Cerrar sesion","src/imagenes/boton_cerrar_sesion.png", new Rectangle(539, 65, 130, 27), null, true, false);
        back = Builder.crearButtonIcon(p,"Regresar","src/imagenes/regresar.png", new Rectangle(626, 452, 32, 32), null, true, false);
        nuevo= Builder.crearButtonIcon(p,"Nuevo Empleado","src/imagenes/agregar-usuario.png", new Rectangle(218, 140, 32, 32), null, true, false);
        nuevo.addActionListener(accion);
        agregar= Builder.crearButtonIcon(p,"Modificar Empleado","src/imagenes/anadir-punto-de-anclaje.png", new Rectangle(218, 202, 32, 32), null, true, false); 
        baja= Builder.crearButtonIcon(p,"Eliminar Empleado","src/imagenes/usuario.png", new Rectangle(218, 268, 32, 32), null, true, false); 
        btlista= Builder.crearButtonIcon(p,"Lista Trabajadores","src/imagenes/boton_lista_trabajadores__selected_.png", new Rectangle(175, 67, 140, 27), null, true, false); 
        btactinac= Builder.crearButtonIcon(p,"Activos e Inactivos","src/imagenes/boton_activos_inactivos.png", new Rectangle(342, 67, 130, 27), null, true, false); 
        Cfoto= Builder.crearBoton(p, "Cambiar Foto", new Rectangle(547, 273, 109, 20),null, true, true);
        Cfoto.setBackground(Color.white);
        
        
        //Jtext
         buscador = Builder.crearTextField(p, new Rectangle(60, 223, 125, 25), null,null, null,null ,true, true, true);
         tfrfc= Builder.crearTextField(p, new Rectangle(381, 138, 127, 23), null, null,null, null, true, true, true);
         tfapp= Builder.crearTextField(p, new Rectangle(381, 207, 127, 23), null,null,null, null, true, true, true);
         tfapm= Builder.crearTextField(p, new Rectangle(381, 240, 127, 23), null, null,null, null, true, true, true);
         tfnom= Builder.crearTextField(p, new Rectangle(381, 174, 127, 23), null, null,null, null, true, true, true);
       
         //comboBox
         cb1= Builder.crearComboBox(p, new Rectangle(351,316,52,17),dia , null, null,null);  
         cb2= Builder.crearComboBox(p, new Rectangle(420,316,56,17),mes , null, null,null);
         cb3= Builder.crearComboBox(p, new Rectangle(488,316,72,17),anio , null, null,null);
         cb6= Builder.crearComboBox(p, new Rectangle(351,290,52,17), st, null, null, null);
         cbPuesto= Builder.crearComboBox(p, new Rectangle(380,438,111,17),Cargo , null, null,null);
          //area de texto
         area1 = new JTextArea();
         area1.setBounds(381, 378, 277, 56);
         area1.setVisible(true);
         p.add(area1);
         
         //lista
         lista= new JList();
         DefaultListModel modeloLista = new DefaultListModel();
         interfaz.listaTrabajador().forEach((d) -> {
             modeloLista.addElement(d);
        });
         lista.setModel(modeloLista);
         lista.setBounds(new Rectangle(14,236,176,198));
         lista.add(scroll);
         lista.setVisible(true);
         p.add(lista);
         
         fecha = new Date(cb3.getItemCount(),cb2.getItemCount(),cb1.getItemCount());
         fecha2 = LocalDate.now();
         fechaA = new Date(fecha2.getYear(),fecha2.getMonthValue(),fecha2.getDayOfMonth());
         
         System.out.println(fecha);
         System.out.println(fechaA);      
 
    }
    
    ActionListener accion=new ActionListener() {
        public void actionPerformed(ActionEvent ae)
        {
            interfaz.agregaTrabajador(); 
           // actualizarLista(lista);
        }
    };
    
    ActionListener accion2=new ActionListener() {
        public void actionPerformed(ActionEvent ae)
        {
           // interfaz.modificaTrabajador();
        }
    };
    
    ActionListener accion3=new ActionListener() {
        public void actionPerformed(ActionEvent ae)
        {
            //interfaz.eliminaTrabajador(); 
           // actualizarLista(lista);
        }
    };
    
    
    
    
    ActionListener accion4=new ActionListener() {
        public void actionPerformed(ActionEvent ae)
        {
            interfaz.agregaTrabajador(); 
            //actualizarLista(lista);
        }
    };
    
    
    public void actualizarLista(JList lista){
        lista.removeAll();
        
        for(String s: interfaz.listaTrabajador()){
            lista.add(s,null);
        }
    }
    
     

    
}
