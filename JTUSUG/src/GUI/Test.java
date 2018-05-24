/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import CONTROLLERS.Conexion;

/**
 *
 * @author Alekhius
 */
public class Test {
    public static void main(String [] args){
        Conexion.setRol("root");
        //RootGUI r = new RootGUI("secretaria", "Alejo Gutierrez");
        //RootGUI s = new RootGUI("almacen", "Alejo Gutierrez");
        //RootGUI t = new RootGUI("mantenimiento", "GURA96");        
        //RootGUI u = new RootGUI("recursos humanos", "Alejo Gutierrez");
        new TrabajadorGUI();
    }
}
