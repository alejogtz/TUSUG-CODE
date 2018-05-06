package Validacion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Validador extends JFrame
{
    public Validador()
    {
    }
    public static void validaNombre(java.awt.event.KeyEvent evt,JTextField text,int x)
    {
        Matcher m = Pattern.compile("[a-zA-ZáéíóúÁÉÍÓÚ]+").matcher(Character.toString(evt.getKeyChar()));
        if (!m.find())
           evt.consume();
        if(text.getText().length()>=x)
            evt.consume();  
        jTextField1KeyReleased(evt,text);
    }
    public static void validaAlfanumerico(java.awt.event.KeyEvent evt,JTextField text,int x)
    {
        Matcher m = Pattern.compile("[a-zA-ZáéíóúÁÉÍÓÚ1234567890-]+").matcher(Character.toString(evt.getKeyChar()));
        if (!m.find())
           evt.consume();
        if(text.getText().length()>=x)
            evt.consume();  
        jTextField1KeyReleased(evt,text);
    }
    public static void validaNum(java.awt.event.KeyEvent evt,JTextField text,int x)//Valida sólo numeros
    {                                                                               //x es la longitud
        Matcher m = Pattern.compile("[0-9]").matcher(Character.toString(evt.getKeyChar()));
        if (!m.find())
           evt.consume();
        if(text.getText().length()>=x)
            evt.consume();  
    }
    private static void jTextField1KeyReleased(java.awt.event.KeyEvent evt,JTextField text) 
    {                                        
        text.setText(text.getText().toUpperCase());
    }
    public static void main(String[]args)
    {
        Validador v = new Validador();
        JTextField JTextField=new JTextField();
        //Este es el formato para mandar a llamar los listener
        JTextField.addKeyListener(new java.awt.event.KeyAdapter() 
        {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) 
            {
                validaNum(evt,JTextField,20);
            }
        });
        //Aqui acaba :v
        v.add(JTextField);
        v.setSize(200,200);
        v.setVisible(true);
    }
}
