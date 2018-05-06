package GUI;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Alekhius
 */
public class PanelImagen extends JPanel{    
    private URL url;
    Image image;
 
    public PanelImagen(String img){
        //this.url = getClass().getResource(img);
        this.image = new ImageIcon(img).getImage();
        //new ImageIcon(img)
    }
    @Override
    public void paint(Graphics g){
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        super.setOpaque(false);
        super.paint(g);
    }
}
