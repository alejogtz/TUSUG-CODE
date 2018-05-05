package GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
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

public class Builder {

    public static void buildFrame(JFrame r, String title, Rectangle bounds, boolean undecorated) {
        r.setBounds(bounds);
        r.setResizable(false);
        r.setLayout(null);
        r.setLocationRelativeTo(null);
        r.setBackground(java.awt.Color.GRAY);
        r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        r.setUndecorated(undecorated);
        r.setVisible(true);
    }

    public static JFrame construirFrame(String title, Rectangle bounds, boolean undecorated) {
        JFrame r = new JFrame(title);
        r.setBounds(bounds);
        r.setResizable(false);
        r.setLayout(null);
        r.setLocationRelativeTo(null);
        r.setBackground(java.awt.Color.GRAY);
        r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        r.setUndecorated(undecorated);
        r.setVisible(true);
        return r;
    }

    public static JLabel crearLabel(Container ui, String text, Rectangle bounds, Color background, Color foreground) {
        JLabel lb = new JLabel(text);
        ui.add(lb);
        lb.setBounds(bounds);
        if (background != null) {
            lb.setBackground(background);
        }
        if (foreground != null) {
            lb.setForeground(foreground);
        }
        lb.setVisible(true);
        return lb;
    }

    public static JLabel crearLabelImagen(Container context, String url, Rectangle bounds) {
        Icon icon = new ImageIcon(url);
        JLabel rtn = new JLabel(icon);
        context.add(rtn);
        rtn.setBounds(bounds);
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
            ActionListener listener, boolean enabled, boolean border) {
        Icon icono = new ImageIcon(urlimg);
        JButton btn = new JButton(icono);
        btn.setActionCommand(accessName);
        btn.addActionListener(listener);
        ui.add(btn);
        btn.setBounds(bounds);
        if (!border) {
            btn.setBorder(null);
        }
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
            Font f, boolean editable, boolean enabled, boolean visible) {
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
     * @param ui
     * @param bounds
     * @param
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
    
    public static void main(String[] args) {
        JFrame f = new JFrame();
        Builder.buildFrame(f, "@Test", new Rectangle(200, 50, 700, 600), false);
        Builder.crearButtonIcon(f, "Btn1", "src/imagenes/logo_tusug.png", new Rectangle(100, 100, 200, 70), null, true, false);
        Builder.crearTextField(f, new Rectangle(100, 200, 200, 70), null, null, null, null, true, true, true);
        Builder.crearPanel(f, new Rectangle(100, 300, 200, 70),"src/imagenes/logo_tusug.png", false );
        Builder.crearComboBox(f, new Rectangle(100, 400, 200, 70), null, null, null, null);
    }

}
