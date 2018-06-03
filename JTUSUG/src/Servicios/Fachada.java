/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Alekhius
 */
public class Fachada {
    public static String getSelectedFileImage(){
        String path = null;
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
          //filter the files
          FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png");
          file.addChoosableFileFilter(filter);
          int result = file.showSaveDialog(null);
           //if the user click on save in Jfilechooser
          if(result == JFileChooser.APPROVE_OPTION){
              File selectedFile = file.getSelectedFile();
              path = selectedFile.getAbsolutePath();
          }
           //if the user click on save in Jfilechooser
          else if(result == JFileChooser.CANCEL_OPTION){
              System.out.println("No File Select");
          }
        return path;
    }
    
    public static boolean isSomeEmpty(JTextComponent... fila){
        for (JTextComponent actual: fila)
            if (actual.getText().isEmpty())  return true;
        return true;
    }
}
