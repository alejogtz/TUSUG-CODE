package GUI;

import CustomComponents.PanelImagen;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class Builder {

    public static void buildFrame(JFrame r, String title, Rectangle bounds, boolean undecorated) {
        r.setBounds(bounds);
        r.setResizable(false);
        r.setLayout(null);
        r.setLocationRelativeTo(null);
        r.setBackground(java.awt.Color.WHITE);
        r.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        r.setUndecorated(undecorated);
        r.setVisible(true);
    }

    public static JFrame construirFrame(String title, Rectangle bounds, boolean undecorated) {
        JFrame r = new JFrame(title);
        r.setBounds(bounds);
        r.setResizable(false);
        r.setLayout(null);
        r.setLocationRelativeTo(null);
        r.setBackground(java.awt.Color.WHITE);
        r.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        r.setUndecorated(undecorated);
        r.setVisible(true);
        return r;
    }

    public static JLabel crearLabel(Container ui, String text, Rectangle bounds,
            Color background, Color foreground, Object... args) {
        JLabel lb = new JLabel(text);
        ui.add(lb);
        lb.setBounds(bounds);
        if (background != null) {
            lb.setBackground(background);
        }
        if (foreground != null) {
            lb.setForeground(foreground);
        }
        if (args.length>0)lb.setFont((Font)args[0]);
        if (args.length>1)lb.setVisible((Boolean)args[1]);
        else lb.setVisible(true);
        return lb;
    }

    public static JLabel crearLabelImagen(Container context, String url, Rectangle bounds) {
        Icon icon = new ImageIcon(url);
        JLabel rtn = new JLabel(icon);
        context.add(rtn);
        rtn.setBounds(bounds);
        rtn.setVisible(true);
        return rtn;
    }

    public static JButton crearBoton(Container context, String accessName, Rectangle bounds,
            ActionListener listener, boolean enabled, boolean border) {
        JButton btn = new JButton(accessName);
        btn.setActionCommand(accessName);
        btn.addActionListener(listener);
        context.add(btn);
        btn.setBounds(bounds);
        if (!border) {
            btn.setBorder(null);
        }
        return btn;
    }

    public static JButton crearButtonIcon(Container ui, String accessName, String urlimg, Rectangle bounds,
            ActionListener listener, boolean enabled, boolean border, Object...args) {
        Icon icono = new ImageIcon(urlimg);
        JButton btn = new JButton(icono);
        btn.setActionCommand(accessName);
        btn.addActionListener(listener);
        ui.add(btn);
        btn.setBounds(bounds);
        if (!border) {
            btn.setBorder(null);
        }
        if (args.length>0)btn.setVisible((Boolean)args[0]);
        else btn.setVisible(true);
        if (args.length>1)btn.setBackground((Color)args[1]);
        if (args.length>2)btn.setForeground((Color)args[2]);
        return btn;

    }

    public static JCheckBox crearCheckBox(Container ui, Rectangle bounds, String text,
            ItemListener listener, boolean enabled, Color cfondo, Color ctexto) {
        JCheckBox cbox = new JCheckBox(text, enabled);
        ui.add(cbox);
        cbox.setBounds(bounds);
        if (ctexto!=null)cbox.setForeground(ctexto);
        if (cfondo!=null)cbox.setBackground(cfondo);
        return cbox;
    }

    public static JComboBox<String> crearComboBox(Container ui, Rectangle bounds, String[] options,
            ItemListener listener, Color cfondo, Color ctexto) {
         JComboBox cbox = null;
        if (options!=null) cbox = new JComboBox(options);
        else cbox = new JComboBox();
        ui.add(cbox);
        cbox.setBounds(bounds);
        if (ctexto!=null)cbox.setForeground(ctexto);
        if (cfondo!=null)cbox.setBackground(cfondo);
        return cbox;
    }

    public static JTextField crearTextField(Container ui, Rectangle bounds, String text, Color cfondo, Color ctexto,
            Font f, boolean editable, boolean enabled, boolean visible, Object...args) {
        JTextField txtField = new JTextField(text == null ? "" : text);
        ui.add(txtField);
        txtField.setBounds(bounds);
        if (cfondo != null) {
            txtField.setBackground(cfondo);
        }
        if (ctexto != null) {
            txtField.setForeground(ctexto);
        }
        if (f != null) {
            txtField.setFont(f);
        }
        txtField.setEnabled(enabled);
        txtField.setEditable(editable);
        txtField.setVisible(visible);
        if (args.length>0)txtField.addKeyListener((KeyListener)args[0]);
        return txtField;
    }

    public static JPasswordField crearPasswordField(Container ui, Rectangle bounds, String text, Color cfondo, Color ctexto,
            Font f, boolean enabled, boolean visible){
        JPasswordField pass = new JPasswordField(text);
        ui.add(pass);
        pass.setBounds(bounds);
        if (cfondo != null) {
            pass.setBackground(cfondo);
        }
        if (ctexto != null) {
            pass.setForeground(ctexto);
        }
        if (f != null) {
            pass.setFont(f);
        }
        pass.setEnabled(enabled);
        pass.setVisible(visible);
        return pass;
    }
    
    /**
     * @param Container ui
     * @param Rectangle bounds
     * @param String urlImg
     * @param boolean opaque
     */
    public static JPanel crearPanel(Container ui, Rectangle bounds, String urlImg, boolean opaque) {
        JPanel panel = null;
        if (urlImg!=null) panel = new PanelImagen(urlImg);
        else panel = new JPanel();
        ui.add(panel);
        panel.setLayout(null);
        panel.setBounds(bounds);
        //panel.setOpaque(opaque);        
        return panel;
    }
    
    public static JTextArea crearTextArea(Container ui, Rectangle bounds, Color fondo){
        JTextArea area = new JTextArea();
        ui.add(area);
        area.setBounds(bounds);
        area.setForeground(fondo);
        return area;
    }
    /**
     * 
     * @param ui
     * @param params    V = visible, B = bounds, f = font, c = Foreground, b = Background
     * @param args
     * @return 
     */
    public static JTextArea crearTextArea(Container ui, String params, Object... args){
        JTextArea producto = new JTextArea();
        ui.add(producto);
        
        int index = 0;
        for (Character op: params.toCharArray()){
            switch (op){
                case 'B': producto.setBounds    ( (Rectangle)args[index++]); break;
                case 'V': producto.setVisible   ( (Boolean)args[index++]); break;
                case 'f': producto.setFont      ( (Font)args[index++]); break;
                case 'c': producto.setForeground( (Color)args[index++]); break;
                case 'b': producto.setBackground( (Color)args[index++]); break;
				case 'T': producto.setText		( (String)args[index++]); break;
                default: index++;
            }
        }
        return producto;
    }
    
    public static void main(String[] args) {
        JFrame f = new JFrame();
        Builder.buildFrame(f, "@Test", new Rectangle(200, 50, 700, 600), false);
        Builder.crearButtonIcon(f, "Btn1", "src/imagenes/logo_tusug.png", new Rectangle(100, 100, 200, 70), null, true, false);
        Builder.crearTextField(f, new Rectangle(100, 200, 200, 70), null, null, null, null, true, true, true);
        Builder.crearPanel(f, new Rectangle(100, 300, 200, 70),"src/imagenes/logo_tusug.png", false );
        Builder.crearComboBox(f, new Rectangle(100, 400, 200, 70), null, null, null, null);
    }

}
