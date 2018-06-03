package GUI;

import CONTROLLERS.ReporteMantenimiento;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class GUIReporteManten{
    private ReporteMantenimiento controlador;
    private JFrame          ventana;
    public JPanel          panel;
    public JTextField      txt_responsable, txt_solicitante, txt_areaTrabajo,
                            txt_prioridad, txt_tipoManten, txt_direccion, txt_telefono, txt_email, 
                            txt_descripGenerica,
                            txt_marca, txt_matricula, txt_condiTecn;
    public JComboBox<String> cbx_codAutobus;
    public JTextArea       text_descripcionEquipos, text_solicitud;
    public JButton         btn_genReporte, btn_cerrarsesion, btn_regresar;
    
    public JDateChooser    calendario;
    public GUIReporteManten(){
        initComponents();
    }
    
    private void initComponents(){
        Font  f = new Font("Segoe UI", Font.PLAIN, 11);
        Color c = new Color(33,33,33);
        ventana =       Builder.construirFrame("Reporte de Matenimiento", new Rectangle(200,50,700,600),false);
        panel   =       Builder.crearPanel(ventana, new Rectangle(0,0,700,600), "src/imagenes/fondo_frame_ter.png", true);
        calendario      =       new JDateChooser();
        panel.add(calendario);
        calendario.setBounds(355,354,155, 22);
        JLabel lb_fecha          = Builder.crearLabel(  panel, "Fecha:",                    new Rectangle(517,57,154,15),   null, c, f);
        JLabel lb_datosGenerales = Builder.crearLabel(  panel, "Datos generales",           new Rectangle(83,90,120,20),    null, c, f);
        JLabel lb_responsable    = Builder.crearLabel(  panel, "Responsable de trabajo",    new Rectangle(44,162,129,15),   null, c, f);
        JLabel lb_solicitante    = Builder.crearLabel(  panel, "Solicitante",               new Rectangle(44,120,63,15),    null, c, f);
        JLabel lb_solicitud      = Builder.crearLabel(  panel, "Solicitud",                 new Rectangle(44,207,54,15),    null, c, f);
        JLabel lb_areaTrabajo    = Builder.crearLabel(  panel, "Area de Trabajo",           new Rectangle(44,298,85,15),    null, c, f);
        JLabel lb_prioridad      = Builder.crearLabel(  panel, "Prioridad",                 new Rectangle(171,298,57,15),   null, c, f);
        JLabel lb_tipoManten     = Builder.crearLabel(  panel, "Tipo de mantenimiento",     new Rectangle(44,343,127,15),   null, c, f);
        JLabel lb_direccion      = Builder.crearLabel(  panel, "Direccion:",                new Rectangle(44,388,58,15),    null, c, f);
        JLabel lb_telefono       = Builder.crearLabel(  panel, "Telefono:",                 new Rectangle(44,432,54,15),    null, c, f);
        JLabel lb_email          = Builder.crearLabel(  panel, "E - Mail",               new Rectangle(44,477,54,15),    null, c, f);
        JLabel lb_descripGenerica= Builder.crearLabel(  panel, "Descripcion_generica",      new Rectangle(431,90,153,20),   null, c, f);
        JLabel lb_codAutobus     = Builder.crearLabel(  panel, "Codigo del Autobus",        new Rectangle(355,137,107,15),   null, c, f);
        JLabel lb_marca          = Builder.crearLabel(  panel, "Marca",                     new Rectangle(355,162,44,15),   null, c, f);
        JLabel lb_matricula      = Builder.crearLabel(  panel, "Matricula",                 new Rectangle(504,162,59,15),   null, c, f);
        JLabel lb_condicionesTec = Builder.crearLabel(  panel, "Condiciones Tecnicas",      new Rectangle(355,207,114,15),  null, c, f);
        JLabel lb_descEquipoObsver=Builder.crearLabel(  panel, "Descripcion de equipo"
                                                                          + "observaciones",new Rectangle(355,251,193,15),  null, c, f);
        JLabel lb_plazoEntrega   = Builder.crearLabel(  panel, "Plazo de Entrega (Fechay hora)",new Rectangle(355,329,165,15),null, c, f);
        JLabel lb_notas          = Builder.crearLabel(  panel, "Notas",                     new Rectangle(345,374,305,53),  null, c, f);
        
        txt_responsable=        Builder.crearTextField( panel, new Rectangle(44,177,186,20), "", null, null, f, true, true, true);
        txt_solicitante=        Builder.crearTextField( panel, new Rectangle(44,135,186,20), "", null, null, f, true, true, true);
        //text_solicitud  =       Builder.crearTextArea(panel, new Rectangle(44,222,219,66), c);
        text_solicitud  =       Builder.crearTextArea(panel, "B", new Rectangle(44,222,219,66));
        txt_areaTrabajo=        Builder.crearTextField( panel, new Rectangle(44,313,110,20), "", null, null, f, true, true, true);
        txt_prioridad  =        Builder.crearTextField( panel, new Rectangle(171,313,92,20), "", null, null, f, true, true, true);
        txt_tipoManten =        Builder.crearTextField( panel, new Rectangle(44,358,135,20), "", null, null, f, true, true, true);
        txt_direccion  =        Builder.crearTextField( panel, new Rectangle(44,402,186,20), "", null, null, f, true, true, true);
        txt_telefono   =        Builder.crearTextField( panel, new Rectangle(44,447,135,20), "", null, null, f, true, true, true);
        txt_email      =        Builder.crearTextField( panel, new Rectangle(44,492,162,20), "", null, null, f, true, true, true);
        cbx_codAutobus =        Builder.crearComboBox(  panel, new Rectangle(462,135,139,22),    null, null, null, c);        
        txt_marca      =        Builder.crearTextField( panel, new Rectangle(355,177,127,20),"", null, null, f, true, true, true);
        txt_matricula  =        Builder.crearTextField( panel, new Rectangle(504,177,127,20),"", null, null, f, true, true, true);
        txt_condiTecn  =        Builder.crearTextField( panel, new Rectangle(355,222,165,20),"", null, null, f, true, true, true);
        text_descripcionEquipos=Builder.crearTextArea(  panel, new Rectangle(355,266,276,53), c);
        btn_genReporte =        Builder.crearBoton(     panel, "Generar Reporte", new Rectangle(440,447,105,27), null, true, true);
        btn_cerrarsesion=       Builder.crearBoton(     panel, "Cerrar Sesion",   new Rectangle(460,506,201,63), null, true, true);
        btn_regresar    =       Builder.crearBoton(     panel, "Regresar",        new Rectangle(326,518,32,32),  null, true, true);
    }
    
    public static void main(String[] args){
        new GUIReporteManten();
    }
    
    class ReportCustomListener implements ActionListener{
        String op;
        @Override
        public void actionPerformed(ActionEvent e) {
            op = e.getActionCommand();
            switch (op){
                case "Generar Reporte": 
                    controlador.generarReporte();
                    break;
                case "Cerrar Sesion":
                    break;
                case "Regresar":
                    break;
            }
        }
        
    }
}