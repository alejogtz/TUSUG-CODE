package GUI;

import CONTROLLERS.Conexion;

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
