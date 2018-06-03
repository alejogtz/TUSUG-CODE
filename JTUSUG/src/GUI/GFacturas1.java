package GUI;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
public class GFacturas1 extends JFrame{
    String ruta = "src/imagenes/";
    public JLabel factura,fEmision,fechaE,gF,dEmisor,pestaña,nFactura,cProveedor,tPersona,rSocial,direccion,poblacion,provincia,postal,contacto,email,phone;
    public JTextField nF,cP,rS,Direc,pob,prov,cp,pContacto,mail,telefono;
    public JButton regresar, cSesion, b1,b2,vaciar,siguiente;
    public JCheckBox nFact,cProv;
    public LocalDate fecha;
    public JRadioButton fisica,juridica;
    JFrame f;
    JPanel p;
    ActionListener listener;
    
    ArrayList<String> pagina1= new ArrayList<>();
    public GFacturas1()
    {
       
       listener= new GFacturas1.CustomActionListener();
        f = Builder.construirFrame("Facturas", new Rectangle(0,0, 700, 600), false); 
        p = Builder.crearPanel(f, new Rectangle(0, 0, 700, 600),ruta+"img_fondo_ventana_facturas.png", false);
        fecha = LocalDate.now();
        String fechaN = fecha.format(DateTimeFormatter.ofPattern("dd/MMMM/yyyy"));
        
        listener= new GFacturas1.CustomActionListener();
        //etiquetas
        fEmision = Builder.crearLabel(p,"Fecha de Emisión: ",new Rectangle(446,89,200,15), null, null, new Font("Segoe UI", Font.PLAIN, 11));
        fechaE   = Builder.crearLabel(p,fechaN,new Rectangle(545,89,200,15), null, Color.blue, new Font("Segoe UI", Font.PLAIN, 11));
        gF = Builder.crearLabelImagen(p, ruta+"img_generar_factura.png", new Rectangle(35,168,200,330));
        dEmisor = Builder.crearLabel(p,"Datos de emisor", new Rectangle(417,122,109,20),null, null,new Font("Segoe UI", Font.PLAIN, 11));
        pestaña = Builder.crearLabelImagen(p, ruta+"img_indicador_1_y_2__1_.png", new Rectangle(586,122,60,30));
        nFactura = Builder.crearLabel(p,"Numero de Factura:", new Rectangle(333,152,102,15),null, null,new Font("Segoe UI", Font.PLAIN, 11));
        cProveedor = Builder.crearLabel(p, "Codigo de Proveedor:", new Rectangle(321,186,115,15),null,null,new Font("Segoe UI", Font.PLAIN, 11));
        tPersona = Builder.crearLabel(p, "Tipo de Persona:", new Rectangle(347,212,88,15),null,null,new Font("Segoe UI", Font.PLAIN, 11));
        rSocial = Builder.crearLabel(p, "Razón Social:", new Rectangle(365,237,70,15),null,null,new Font("Segoe UI", Font.PLAIN, 11));
        direccion = Builder.crearLabel(p, "Dirección:", new Rectangle(380,262,55,15),null,null,new Font("Segoe UI", Font.PLAIN, 11));
        poblacion = Builder.crearLabel(p, "Población:", new Rectangle(378,287,55,15),null,null,new Font("Segoe UI", Font.PLAIN, 11));
        provincia = Builder.crearLabel(p, "Provincia:", new Rectangle(382,312,55,15),null,null,new Font("Segoe UI", Font.PLAIN, 11));
        postal = Builder.crearLabel(p, "C.P:", new Rectangle(410,337,20,15),null,null,new Font("Segoe UI", Font.PLAIN, 11));
        contacto = Builder.crearLabel(p, "Persona en Contacto:", new Rectangle(322,372,115,15),null,null,new Font("Segoe UI", Font.PLAIN, 11));
        email = Builder.crearLabel(p, "Email:", new Rectangle(402,397,35,15),null,null,new Font("Segoe UI", Font.PLAIN, 11));
        phone = Builder.crearLabel(p, "Teléfono:", new Rectangle(383,422,50,15),null,null,new Font("Segoe UI", Font.PLAIN, 11));
        
        
        
        
         
        //botones
        b1 = Builder.crearButtonIcon(p,"1", ruta+"btn_1_selected.png",new Rectangle(77,106,36,36), listener, true,false);
        b2 = Builder.crearButtonIcon(p,"2", ruta+"btn_2.png",new Rectangle(156,106,36,36), listener, true,false);
        vaciar = Builder.crearBoton(p, "Vaciar",new Rectangle(446,471,62,21) , listener, true, false);
        vaciar.setBackground(Color.white);
        vaciar.setForeground(Color.black);
        regresar = Builder.crearButtonIcon(p, "regresar", ruta+"regresar.png",new Rectangle(326,513, 41,41), listener, true, false);
        cSesion = Builder.crearButtonIcon(p,"Cerrar Sesión", ruta+"boton_cerrar_sesion.png",new Rectangle(460,510, 142,45), listener, true, false);
        siguiente = Builder.crearButtonIcon(p,"Siguiente", ruta+"img_siguiente.png",new Rectangle(552,460,87,43), listener, true, false);
        
        
        //RadioButton
        fisica = new JRadioButton("Fisica");
        p.add(fisica);
        fisica.setBounds(new Rectangle(444,211,70,16));
        juridica = new JRadioButton("Juridica");
        p.add(juridica);
        juridica.setBounds(new Rectangle(511,211,75,16));

        //Jtext
        nF = Builder.crearTextField(p,new Rectangle(444,152,82,20), "", null, null, new Font("Segoe UI", Font.PLAIN, 11), true,true, true);
        cP = Builder.crearTextField(p,new Rectangle(444,184,82,20), "", null, null, new Font("Segoe UI", Font.PLAIN, 11), true,true, true);
        rS = Builder.crearTextField(p,new Rectangle(444,237,82,20), "", null, null, new Font("Segoe UI", Font.PLAIN, 11), true,true, true);
        Direc = Builder.crearTextField(p,new Rectangle(444,262,165,20), "", null, null, new Font("Segoe UI", Font.PLAIN, 11), true,true, true);
        pob = Builder.crearTextField(p,new Rectangle(444,287,127,20), "", null, null, new Font("Segoe UI", Font.PLAIN, 11), true,true, true);
        prov = Builder.crearTextField(p,new Rectangle(444,312,127,20), "", null, null, new Font("Segoe UI", Font.PLAIN, 11), true,true, true);
        cp = Builder.crearTextField(p,new Rectangle(444,337,82,20), "", null, null, new Font("Segoe UI", Font.PLAIN, 11), true,true, true);
        pContacto = Builder.crearTextField(p,new Rectangle(444,372,127,20), "", null, null, new Font("Segoe UI", Font.PLAIN, 11), true,true, true);
        mail = Builder.crearTextField(p,new Rectangle(444,397,165,20), "", null, null, new Font("Segoe UI", Font.PLAIN, 11), true,true, true);
        telefono = Builder.crearTextField(p,new Rectangle(444,422,127,20), "", null, null, new Font("Segoe UI", Font.PLAIN, 11), true,true, true);
        
    }
    public void arre(){
        pagina1.add(nF.getText());
        pagina1.add(cP.getText());
        pagina1.add(rS.getText());
        pagina1.add(Direc.getText());
        pagina1.add(pob.getText());
        pagina1.add(prov.getText());
        pagina1.add(cp.getText());
        pagina1.add(pContacto.getText());
        pagina1.add(mail.getText());
        pagina1.add(telefono.getText());
             
        
    }
     class CustomActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String op = e.getActionCommand();
            switch(op)
            {                    
                case "Regresar":
                    f.dispose();
                case "Cerrar Sesión":
                    LoginGUI l = new LoginGUI();
                    f.dispose();
                case "Siguiente":
                    f.dispose();
                    arre();
                    GFacturas2 g2 = new GFacturas2(pagina1);
            }
        }
    }
    public static void main (String []args)
    {
        GFacturas1 g = new GFacturas1();
    }
}


