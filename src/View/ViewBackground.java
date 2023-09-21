package View;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
class ViewBackground extends JPanel{
    ImageIcon image;
    String name;
    
    public ViewBackground(String nombre){
        this.name = nombre;
    }
    
    @Override
    public void paint(Graphics g){
        image = new ImageIcon(getClass().getResource(name));
        g.drawImage(image.getImage(), 0, 0, null);
        setOpaque(false);
        super.paint(g);
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}