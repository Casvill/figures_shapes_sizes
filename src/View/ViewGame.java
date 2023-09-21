package View;

import javax.swing.JPanel;

/**
 *
 * @author Daniel Casvill
 */

public class ViewGame extends View{
    
    private ViewBackground leftPanel;

    public ViewGame() 
    {
        initComponents();                
    }
    
    private void initComponents()
    {
        vBackground.setName("/Images/ViewGame.png");
        leftPanel = new ViewBackground("/Images/Figures/Triangles/Blue/tmBlue.png");
        
        
        leftPanel.setBounds(120,400,150,150);
        
        add(leftPanel);
        getContentPane().setComponentZOrder(leftPanel,0);
        
        getContentPane().revalidate();          
    }
    
    
    
    
}
