
package GUI;

import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Insumos {
       JFrame x;
       JPanel p;
       JLabel JLani,JLcdp,JLdes, JLcan;
       JButton JBace, JBcan;
       JTextField JTcod,JTdes,JTcan;
       
       public Insumos(){
           Color c= new Color(0xE4,0xE4,0xE4);
      
        x = Builder.construirFrame("Insumos", new Rectangle(0,0, 511, 260), false); 
        p = Builder.crearPanel(x, new Rectangle(0, 0, 511, 260),null, false);
        p.setBackground(c);
        
        
        
        
        
        //JLabel
        
        JLani= Builder.crearLabel(p, "Agregar nuevo insumo", new Rectangle(154,7, 204,22), null, null);
        JLcdp= Builder.crearLabel(p, "Codigo del Producto", new Rectangle(66,48,137,18), null, null);
        JLdes= Builder.crearLabel(p, "Descripcion", new Rectangle(118,85,85,18), null, null);
        JLcan= Builder.crearLabel(p, "Cantidad", new Rectangle(143,163,67,18), null, null);
        
        //JTextField
        
        JTcod= Builder.crearTextField(p, new Rectangle(203,45,219,45), null, null, null, null, true, true, true);
        JTdes= Builder.crearTextField(p, new Rectangle(203,85,219,68), null, null, null, null, true, true, true);
        JTcan= Builder.crearTextField(p, new Rectangle(203,163,219,27), null, null, null, null, true, true, true);
        
        //JButton
        
        JBace= Builder.crearBoton(p, "Aceptar", new Rectangle(173,211,69,25), null, true, false);
        JBcan= Builder.crearBoton(p, "Cancelar",  new Rectangle(270,211, 69,25), null, true, false);
        
        
        
        
       }
       
       public static void main(String [] args){
           Insumos i= new Insumos();
       } 
}
