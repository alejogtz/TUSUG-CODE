package GUI;
import CONTROLLERS.SQLAutobus;
import CONTROLLERS.Trabajador;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import Validacion.Validador;
import static Validacion.Validador.*;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.text.JTextComponent;

public class TrabajadorGUI {
    Validador valida;
    String              dia[]={"1","2","3","4","5","6","7","8","9","10","11","12","13","14",
                            "15","16","17","18","19","20","21","22","23","24","25","26",
                            "27","28","29","30","31"};
    String              mes[]={"1","2","3","4","5","6","7", "8","9", "10", "11", "12"};
    String              anio[]={"1990", "1991", "1992", "1993", "1994", "1995", "1996", 
                            "1997", "1998", "1999", "2000"};
    String              Cargo[]={"secretaria", "chofer", "mantenimiento", "recursos humanos"};
    String              Categoria[]= {"1","2","3","4","5"};
    String              st[]={"activo", "pasivo", "baja"};
    private JComboBox<String> cb4;
    JFrame x;
    JPanel p;
    public JLabel       trabajadores;
    public JTextField   tfrfc, tfapp, tfapm, tfnom, tfgen,  tfeda, tffna, tfsa, 
                        tfdir, tffin, tftce, tfema,tftca,buscador;
    public JTextArea    area1;
    public JComboBox    cb1, cb2, cb3, cb5,cb6, cb7,cbPuesto;

    Trabajador          interfaz;

    public LocalDate    fecha1,fecha2;
    public int          dia1,mes1,anio1;
    public JList        lista;
    public JButton      btInicio,btLT,btBuscar,btActualizar,sesion,back,nuevo,
                        agregar,baja,btlista,btactinac, Cfoto,btn_guardar,btn_cancelar,btn_guardar_mod;
    public JScrollBar   scroll;
    public Date         fecha,fechaA;
    public TrabajadorGUI(){
        initComponents();
        cargarLista(lista);
    }
    
    private void initComponents(){
        interfaz= new Trabajador(this);
        x = Builder.construirFrame("Trabajador", new Rectangle(0,0,700,600), false); 
        p = Builder.crearPanel(x, new Rectangle(0,0,700,518),"src/imagenes/fondo_ventana_2.png", false);
        
        Color color = new Color(233,233,233);
        //etiquetas
        JLabel imagen=  Builder.crearLabelImagen( p,"src/imagenes/icono usuario.jpg",new Rectangle(539, 130, 128, 128));
        trabajadores =  Builder.crearLabel( p, "Trabajadores",          new Rectangle(65, 130, 80, 20), null, null, new Font("Segoe UI",Font.PLAIN,11));
        JLabel jlrfc=   Builder.crearLabel( p, "RFC: ",                 new Rectangle(351,143,28, 13),  null, null, new Font("Segoe UI",Font.PLAIN,11));
        JLabel jlapp=   Builder.crearLabel( p, "Apellido Paterno: ",    new Rectangle(285,216,95, 13),  null, null, new Font("Segoe UI",Font.PLAIN,11));
        JLabel jlapm=   Builder.crearLabel( p, "Apellido Materno: ",    new Rectangle(282,245,100, 13), null, null, new Font("Segoe UI",Font.PLAIN,11));
        JLabel jlnom=   Builder.crearLabel( p, "Nombre(s): ",           new Rectangle(319,179,60, 13),  null, null, new Font("Segoe UI",Font.PLAIN,11));
        JLabel jlfna=   Builder.crearLabel( p, "Fecha nac. :",          new Rectangle(270, 311,70, 26), null, null, new Font("Segoe UI",Font.PLAIN,11));
        JLabel jlsts=   Builder.crearLabel( p, "Status :",              new Rectangle(270, 290,131, 17),null, null, new Font("Segoe UI",Font.PLAIN,11));
        JLabel jldir=   Builder.crearLabel( p, "Domicilio :",           new Rectangle(322, 378,54, 13), null, null, new Font("Segoe UI",Font.PLAIN,11));
        JLabel puesto=  Builder.crearLabel( p, "Puesto :",              new Rectangle(322, 440,50, 13), null, null, new Font("Segoe UI",Font.PLAIN,11));
        
        
        //botones
        btInicio =      Builder.crearButtonIcon( p, "Inicio",               "src/imagenes/boton_inicio.png",                        new Rectangle(14, 63, 88, 43),   null,   true, false);
        btBuscar =      Builder.crearButtonIcon( p, "Buscar",               "src/imagenes/buscar.png",                              new Rectangle(26,185,32,32) , null,   true, false);
        btActualizar =  Builder.crearButtonIcon( p, "Buscar",               "src/imagenes/boton_actualizar_lista.png",              new Rectangle(26, 446, 145, 36), actualizarT,true, false);
        sesion =        Builder.crearButtonIcon( p, "Cerrar sesion",        "src/imagenes/boton_cerrar_sesion.png",                 new Rectangle(539, 65, 130, 27), null,   true, false);
        back =          Builder.crearButtonIcon( p, "Regresar",             "src/imagenes/regresar.png",                            new Rectangle(626, 452, 32, 32), regresarV,true, false);
        nuevo=          Builder.crearButtonIcon( p, "Nuevo Empleado",       "src/imagenes/agregar-usuario.png",                     new Rectangle(218, 140, 32, 32), nuevoT, true, false,true,color);
        agregar=        Builder.crearButtonIcon( p, "Modificar Empleado",   "src/imagenes/anadir-punto-de-anclaje.png",             new Rectangle(218, 202, 32, 32), modificarT,true, false,true,color);
        btn_cancelar=   Builder.crearButtonIcon( p, "cancelar",             "src/imagenes/btn_cancelar.png",                        new Rectangle(300,464,97,38),    cancel,true,false, true, color);
        btn_guardar=    Builder.crearButtonIcon( p, "guardar",              "src/imagenes/btn_guardar.png",  new Rectangle(413,464,106,38),guardarN,true,false, true, color);
        btn_guardar_mod=Builder.crearButtonIcon( p, "guardar_modificacion", "src/imagenes/btn_guardar.png",  new Rectangle(413,464,106,38),guardarMod,true,false, true, color);
        btn_guardar.    setVisible(false);
        btn_cancelar.   setVisible(false);
        btn_guardar_mod.setVisible(false);
        baja=           Builder.crearButtonIcon( p, "Eliminar Empleado",    "src/imagenes/usuario.png",                             new Rectangle(218, 268, 32, 32), bajaT,   true, false,true,color); 
        btlista=        Builder.crearButtonIcon( p, "Lista Trabajadores",   "src/imagenes/boton_lista_trabajadores__selected_.png", new Rectangle(175, 67, 140, 27), null,   true, false); 
        btactinac=      Builder.crearButtonIcon( p, "Activos e Inactivos",  "src/imagenes/boton_activos_inactivos.png",             new Rectangle(342, 67, 130, 27), null,   true, false); 
        Cfoto=          Builder.crearBoton(      p, "Cambiar Foto",         new Rectangle(547, 273, 109, 20),null, true, true);
        Cfoto.setBackground(Color.white);
        
        
        //Jtext
         buscador = Builder.crearTextField(p, new Rectangle(68, 189, 106, 25),  null, null, null, null, true, true, true);
         tfrfc=     Builder.crearTextField(p, new Rectangle(381, 138, 127, 23), null, null, null, null, true, false, true, new KeyListenerValidation(20));
         tfapp=     Builder.crearTextField(p, new Rectangle(381, 207, 127, 23), null, null, null, null, true, false, true, new KeyListenerValidation(20) );
         tfapm=     Builder.crearTextField(p, new Rectangle(381, 240, 127, 23), null, null, null, null, true, false, true, new KeyListenerValidation(10) );
         tfnom=     Builder.crearTextField(p, new Rectangle(381, 174, 127, 23), null, null, null, null, true, false, true, new KeyListenerValidation(10) );
       
         //comboBox
         cb1=       Builder.crearComboBox(p, new Rectangle(351,316,52,17),  dia,  null, null, null);  
         cb2=       Builder.crearComboBox(p, new Rectangle(420,316,56,17),  mes,  null, null, null);
         cb3=       Builder.crearComboBox(p, new Rectangle(488,316,72,17),  anio, null, null, null);
         cb6=       Builder.crearComboBox(p, new Rectangle(351,290,80,17),  st,   null, null, null);
         cbPuesto=  Builder.crearComboBox(p, new Rectangle(380,438,111,17), Cargo,null, null, null);
          //area de texto
         area1 = new JTextArea();
         p.add(area1);
         area1.setBounds(381, 378, 277, 56);
         area1.setVisible(true);
         area1.setEnabled(false);
         //lista
         lista= new JList();
         p.add(lista);
         lista.setBounds(new Rectangle(14,236,176,198));
         lista.setVisible(true);
         lista.addMouseListener(new TrabajadorGUI.CustomMouseListener());
     
         fecha =    new Date(cb3.getItemCount(),cb2.getItemCount(),cb1.getItemCount());
         fecha2 =   LocalDate.now();
         fechaA =   new Date(fecha2.getYear(),fecha2.getMonthValue(),fecha2.getDayOfMonth());
         JLabel fondo    =   Builder.crearLabelImagen(p, "src/imagenes/fondo_ventana_2.png", new Rectangle(0,0,700,518));
    }
    public void disable(){
        for (Component c: p.getComponents()) c.setEnabled(false);
    }
         public void cargarLista(JList l){
        DefaultListModel modelo = new DefaultListModel();
                    String list[] = interfaz.listatrabajador();
                    for(int i = 0;i<list.length;i++){
                        modelo.addElement(list[i]);
                    }
                    l.setModel(modelo);
    }
    static void textField(JTextField... text){
        for(JTextField tf:text){
            tf.setEnabled(true);
            tf.setText(null);
        }
    }
    static void textField2(JTextField... text){
        for(JTextField tf:text){
            tf.setEnabled(false);
            tf.setText(null);
        }
    }
    
    ActionListener nuevoT=new ActionListener() {
        public void actionPerformed(ActionEvent ae)
        {
                textField(tfrfc,tfapp,tfapm,tfnom);
                btn_guardar.setVisible(true);
                lista.setEnabled(false);
                nuevo.setEnabled(false);
                agregar.setEnabled(false);
                baja.setEnabled(false);
                btn_cancelar.setVisible(true);
        }
    };
    
    ActionListener bajaT=new ActionListener() {
        public void actionPerformed(ActionEvent ae)
        {
           
           if(lista.getSelectedValue()==null){
                        baja.setEnabled(false);
           } else{
                        baja.setEnabled(true);
                        interfaz.eliminaTrabajador(tfrfc.getText());
                        cargarLista(lista);
                    }
        }
    };
    
    ActionListener modificarT=new ActionListener() {
        public void actionPerformed(ActionEvent ae)
        {
            if("".equals(tfrfc.getText())){}
                    else{
                        tfrfc.setEnabled(true);
                        tfapp.setEnabled(true);
                        tfapm.setEnabled(true);
                        tfnom.setEnabled(true);
                        lista.setEnabled(false);
                        nuevo.setEnabled(false);
                        baja.setEnabled(false);
                        btn_guardar_mod.setVisible(true);
                        agregar.setEnabled(false);
                        btn_guardar_mod.setVisible(true);
                        
                    }
        }
    };
    ActionListener actualizarT=new ActionListener() {
        public void actionPerformed(ActionEvent ag)
        {
            //interfaz.agregaTrabajador(); 
            //actualizarLista(lista);
            textField2(tfrfc,tfapp,tfapm,tfnom);
            cargarLista(lista);
            baja.setEnabled(false);
            
        }
    };
    ActionListener cancel=new ActionListener() {
        public void actionPerformed(ActionEvent ae)
        {
           lista.setEnabled(true);
           textField2(tfrfc,tfapp,tfapm,tfnom);
            nuevo.setEnabled(true);
            btn_guardar.setVisible(false);
            agregar.setEnabled(true);
            baja.setEnabled(true);
            btn_cancelar.setVisible(false);
            
        }
    };
    ActionListener regresarV=new ActionListener() {
        public void actionPerformed(ActionEvent ae)
        {
            x.dispose();
        }
    };
    ActionListener guardarN=new ActionListener() {
        public void actionPerformed(ActionEvent ae)
        {
           if(validaIngreso(tfrfc,tfapp,tfapm,tfnom)){
                interfaz.agregaTrabajador(); 
                cargarLista(lista);
                textField2(tfrfc,tfapp,tfapm,tfnom);
                btn_guardar.setVisible(false);
                lista.setEnabled(true);
                nuevo.setEnabled(true);
                agregar.setEnabled(true);
                baja.setEnabled(true);
                btn_cancelar.setVisible(false);
            }
            else
                JOptionPane.showMessageDialog(null,"Campos vacios");
        }
    };
    ActionListener guardarMod=new ActionListener() {
        public void actionPerformed(ActionEvent ae)
        {
            if(validaIngreso(tfrfc,tfapp,tfapm,tfnom)){
                interfaz.modificaTrabajador(tfnom.getText(), tfapp.getText(), tfapm.getText(), area1.getText(),( (String)cbPuesto.getSelectedItem()), tfrfc.getText());
                cargarLista(lista);
                btn_guardar_mod.setVisible(false);
                lista.setEnabled(true);
                nuevo.setEnabled(true);
                baja.setEnabled(true);
                textField2(tfrfc,tfapp,tfapm,tfnom);
                agregar.setEnabled(true);
            }else
                JOptionPane.showMessageDialog(null,"Campos vacios");
        }
    };
    
        class CustomMouseListener extends MouseAdapter{
        public void mouseClicked(MouseEvent me){
            String matricula = (String)lista.getSelectedValue();
            interfaz.listaParametro(matricula);
        };
        
   
    
    public void actualizarLista(JList lista){
        lista.removeAll();
        
        for(String s: interfaz.listaTrabajador()){
            lista.add(s,null);
        }
    }    
}
    class KeyListenerValidation extends KeyAdapter{
        int numLetrasValidas;
        public KeyListenerValidation(int length){
            super();
            
            
            numLetrasValidas = length;
        }
        @Override
        public void keyTyped(java.awt.event.KeyEvent evt){            
            Matcher m = Pattern.compile("[a-zA-ZáéíóúÁÉÍÓÚ1234567890-]+").matcher(Character.toString(evt.getKeyChar()));
            if(!m.find()||((JTextComponent)evt.getComponent()).getText().length()>=numLetrasValidas)
                evt.consume();
            else evt.setKeyChar(Character.toUpperCase(evt.getKeyChar()));
        }
    }    
    public static void main(String[]args)
    {
        new TrabajadorGUI();
    }
}