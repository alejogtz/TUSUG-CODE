/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Servicios.Encriptar;
import CONTROLLERS.Conexion;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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

    private String rol;
    private String nombre_usuario;
    private String rfc;
    private String contrasenia;

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
        frame = Builder.construirFrame("Sistema Integral Tusug Login",
                new Rectangle(0, 0, 700, 600), false);
        loginUI = Builder.crearPanel(frame, new Rectangle(0, 0, 700, 600),
                "src/Imagenes/login.png", true);
        txt_rfc = Builder.crearTextField(loginUI, new Rectangle(205, 233, 293, 38),
                "", null, null, null, true, true, true);
        txt_rfc.addKeyListener(new CustomKeyListener());
        txt_rfc.setFont(font);
        txt_rfc.setBackground(new Color(0xe4, 0xe4, 0xe4));
        txt_password = Builder.crearPasswordField(loginUI, new Rectangle(205, 298, 293, 38),
                "", null, null, null, true, true);
        txt_password.setFont(font);
        txt_password.addKeyListener(new CustomKeyListener());
        txt_password.setBackground(new Color(0xe4, 0xe4, 0xe4));
        b = Builder.crearBoton(loginUI, "Ingresar", new Rectangle(257, 383, 185, 39),
                escucha, false, false);

        b.addKeyListener(new CustomKeyListener());
    }

    public static void main(String[] args) {
        LoginGUI login = new LoginGUI();
    }

    public void cargarSesion() {
        try {
            String rfc = txt_rfc.getText();
            String query = "SELECT rfc, descripcion, contrasenia  FROM sistemaTusug.usuario as a INNER JOIN "
                    + "sistemaTusug.rol as b  ON a.id_rol = b.id_rol "
                    + "WHERE  a.rfc  = '" + rfc + "'";
            PreparedStatement s = conn.prepareStatement(query);
            ResultSet rs = s.executeQuery();
            if (rs.next()) {
                nombre_usuario = rs.getString("rfc");;
                rol = rs.getString("descripcion");
                contrasenia = rs.getString("contrasenia");
            } else {
                nombre_usuario = "";
                rol = "";
                contrasenia = "";
            }
            rs.close();
            s.close();
        } catch (SQLException ex) {
            Logger.getLogger(LoginGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void iniciarSesion() throws Exception {
        cargarSesion();
        if (contrasenia.equals(
                Encriptar.md5(txt_password.getText()))) {
            RootGUI main = new RootGUI(rol, nombre_usuario);
            Conexion.setRol(rol);
            frame.dispose();
        } else {
            // Code here:
            // Aviso de contraseña incorrecta
            javax.swing.JOptionPane.showMessageDialog(null,
                    "Usuario o contraseña incorrectos");
            //txt_rfc.setText("");
            txt_password.setText("");
        }
        
    }
    class CustomActionListener implements ActionListener {

            String comando = "";

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    comando = e.getActionCommand();
                    switch (comando) {
                        case "Ingresar":
                            iniciarSesion();
                            break;
                    }
                } catch (Exception ex) {

                }
            }
        }

        class CustomKeyListener extends KeyAdapter {

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode()==10){
                    try {
                        iniciarSesion();
                    } catch (Exception ex) {}
                }
            }

        }
}
