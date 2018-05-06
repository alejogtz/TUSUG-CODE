/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author Alekhius
 * En esta clase se guardaran algunos datos importantes para la sesion en turno
 */
public class Sesion {
    private String rol;
    private String usuario; //nombre del usuario
    private String pass; // MD5
    public Sesion(){
        this("root", "postgres", "root");
    }
    
    public Sesion(String rol, String user, String pass){
        this.rol = rol;
        this.usuario = user;
        this.pass = pass;
    }

    public String getRol() {
        return rol;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPass() {
        return pass;
    }

    
    public void setRol(String rol) {
        this.rol = rol;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
}
