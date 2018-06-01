
package GUI;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


public class Reportes {
    
    JFrame x;
    JPanel p;
    JButton buscar, abrir, imprimir,guardar, regresar,cerrar_sesion;
    JLabel Numero_reporte, nombre, reporte;
    JTextField numero_reporte, nom;
    JTable JTreportes;
    
    public Reportes(){
      
        x = Builder.construirFrame("Reportes", new Rectangle(0,0, 700, 600), false); 
        p = Builder.crearPanel(x, new Rectangle(0, 0, 700, 600),"src/imagenes/fondo_mant.png", false);
        Color c= new Color(79, 79 ,79, 79);
        
        //jbutton      
        buscar=         Builder.crearButtonIcon(p, "buscar",       "src/imagenes/btn_buscar.png",   new Rectangle(54,84,74,21),    null, true, false);
        abrir=          Builder.crearButtonIcon(p, "abrir",        "src/imagenes/folder.png",       new Rectangle(663,182,24,24),  null, true, false);
        imprimir=       Builder.crearButtonIcon(p, "imprimir",     "src/imagenes/print.png",        new Rectangle(663,243,24,24),  null, true, false);
        guardar=        Builder.crearButtonIcon(p, "guardar",      "src/imagenes/save.png",         new Rectangle(663,301, 24, 24),null, true, false);
        regresar=       Builder.crearButtonIcon(p, "regresar",     "src/imagenes/regresar.png",     new Rectangle(362, 518,32, 32), null, true, false);
        cerrar_sesion=  Builder.crearButtonIcon(p, "cerrar_sesion","src/imagenes/cerrar_sesion.png",new Rectangle(460, 506, 201, 63) , null, true, false);
        
        //JLabel
        
        Numero_reporte= Builder.crearLabel(p, "Numero De Reporte", new Rectangle(158,90,125,18), null, c,  new Font("Segoe UI",Font.PLAIN,14));
        nombre        = Builder.crearLabel(p, "Nombre",            new Rectangle(451, 90,55,18), null, c,  new Font("Segoe UI",Font.PLAIN,14));
        reporte       = Builder.crearLabel(p, "Reporte",           new Rectangle(298,160,59,18), null, c,  new Font("Segoe UI",Font.PLAIN,14));
        
        //JTextField
        nom =           Builder.crearTextField(p, new Rectangle(516,88,131,22), " ",            null, null, null, true, true, true);
        numero_reporte= Builder.crearTextField(p, new Rectangle(293,88,131,22), " ", null, null, null, true, true, true);
        
        //JTable
        
        JTreportes = new JTable();
        JTreportes.setBackground(Color.GRAY);
        JTreportes.setPreferredSize(new Dimension(504,278));
        JScrollPane scrollPane = new JScrollPane(JTreportes);
        scrollPane.setBounds(75,196,504,278);
        p.add(scrollPane);
 }
    
    public static void main(String [] args){
        Reportes c= new Reportes();
    }
    
}
