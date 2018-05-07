/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import CONTROLLERS.Conexion;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Alekhius
 */
public class LoginGUI {

    static Sesion sesion;
    JFrame frame;
    JPanel loginUI;
    JTextField txt_rfc;
    JTextField txt_password;
    JButton b;
    Connection conn;

    public LoginGUI() {
        Font font = new Font("Segoe UI", Font.BOLD, 18);
        Conexion.setConfiguracion("postgres", "root");
        conn = Conexion.getConexion();
        CustomActionListener escucha = new CustomActionListener();
        frame = Builder.construirFrame("Sistema Integral Tusug -\n Login",
                new Rectangle(0, 0, 700, 600), false);
        loginUI = Builder.crearPanel(frame, new Rectangle(0, 0, 700, 600),
                "src/Imagenes/login.png", true);
        txt_rfc = Builder.crearTextField(loginUI, new Rectangle(205, 233, 293, 38),
                "", null, null, null, true, true, true);
        txt_rfc.setFont(font);

        txt_password = Builder.crearPasswordField(loginUI, new Rectangle(205, 298, 293, 38),
                "", null, null, null, true, true);
        txt_password.setFont(font);

        b = Builder.crearBoton(loginUI, "Ingresar", new Rectangle(257, 383, 185, 39),
                escucha, false, false);

    }

    public static void main(String[] args) {
        LoginGUI login = new LoginGUI();
    }

    //Logica del Login
    public boolean validarUsuario(String rfc, String pass) {
        boolean valid = false;

        return valid;
    }

    public static String md5(String clear) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] b = md.digest(clear.getBytes());

        int size = b.length;
        StringBuffer h = new StringBuffer(size);
        for (int i = 0; i < size; i++) {
            int u = b[i] & 255;
            if (u < 16) {
                h.append("0" + Integer.toHexString(u));
            } else {
                h.append(Integer.toHexString(u));
            }
        }
        //System.out.println(h.toString());
        return h.toString();
    }

    class CustomActionListener implements ActionListener {

        String comando = "";

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                comando = e.getActionCommand();
                switch (comando) {
                    case "Ingresar":
                        cargarSesion();
                        if (sesion.getPass().equals(txt_password.getText())){
                            RootGUI main = new RootGUI();
                            Conexion.setConfiguracion(
                                    sesion.getRol(), sesion.getPass());
                            main.initComponents(sesion.getRol());
                            frame.dispose();
                        }else {
                            // Code here:
                            // Aviso de contraseña incorrecta
                            javax.swing.JOptionPane.showMessageDialog(null, 
                                    "Usuario o contraseña incorrectos");
                            //txt_rfc.setText("");
                            txt_password.setText("");
                        }
                        break;
                }
            } catch (Exception ex) {
                
            }
        }

    }

    public Sesion cargarSesion() {
        sesion = new Sesion();
        try {
            String rfc = txt_rfc.getText();
            String query = "SELECT rfc, descripcion, contrasenia  FROM sistemaTusug.usuario as a INNER JOIN "
                    + "sistemaTusug.rol as b  ON a.id_rol = b.id_rol "
                    + "WHERE  a.rfc  = '" + rfc + "'";
            PreparedStatement s = conn.prepareStatement(query);
            ResultSet rs = s.executeQuery();
            if (rs.next()) {
                sesion.setUsuario(rs.getString("rfc"));
                sesion.setRol(rs.getString("descripcion"));
                sesion.setPass(rs.getString("contrasenia"));
            }
            rs.close();
            s.close();
        } catch (SQLException ex) {
            Logger.getLogger(LoginGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sesion;
    }
}
