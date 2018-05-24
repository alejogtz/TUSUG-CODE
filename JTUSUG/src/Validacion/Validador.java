package Validacion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Validador extends JFrame
{
    public Validador(){}
    public static void validaNombre(java.awt.event.KeyEvent evt,JTextField text,int x){
        Matcher m = Pattern.compile("[a-zA-ZáéíóúÁÉÍÓÚ]+").matcher(Character.toString(evt.getKeyChar()));
        if (!m.find())
           evt.consume();
        if(text.getText().length()>=x)
            evt.consume();  
        txtNumeroControlKeyTyped(evt);
    }
    public static void validaAlfanumerico(java.awt.event.KeyEvent evt,JTextField text,int x){
        Matcher m = Pattern.compile("[a-zA-ZáéíóúÁÉÍÓÚ1234567890-]+").matcher(Character.toString(evt.getKeyChar()));
        if (!m.find())
           evt.consume();
        if(text.getText().length()>=x)
            evt.consume();  
        txtNumeroControlKeyTyped(evt);
    }
    public static void validaNum(java.awt.event.KeyEvent evt,JTextField text,int x){//Valida sólo numeros                                                                               //x es la longitud
        Matcher m = Pattern.compile("[0-9]").matcher(Character.toString(evt.getKeyChar()));
        if (!m.find())
           evt.consume();
        if(text.getText().length()>=x)
            evt.consume();  
    }
    private static void jTextField1KeyReleased(java.awt.event.KeyEvent evt,JTextField text){                                        
        text.setText(text.getText().toUpperCase());
    }
    private static void txtNumeroControlKeyTyped(java.awt.event.KeyEvent evt){
        char c = evt.getKeyChar();
        String cad = ("" + c).toUpperCase();
        c = cad.charAt(0);
        evt.setKeyChar(c);
    } 
    public static boolean validaIngreso(JTextField... lb){
        boolean aux=true;
        for(JTextField l:lb)
            if(l.getText().equals(""))
            {
                aux=false;
                break;
            }
        return aux;
    }
    public static void main(String[]args){
        Validador v = new Validador();
        JTextField JTextField=new JTextField();
        JTextField JTex=new JTextField();
        JTextField JTextFi=new JTextField();
        JTextField.setText("TuGfa");
        JTextFi.setText("Hola");
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
        System.out.println(validaIngreso(JTextField,JTex,JTextFi));
        v.add(JTextField);
        v.setSize(200,200);
        v.setVisible(true);
    }
}
