package View;

import javax.swing.JPanel;

/**
 *
 * @author Daniel Casvill
 */

public class ViewGame extends View{
    
    //Variable declaration:
    private ViewBackground leftPanel;
    private ViewBackground fPanel; //First
    private ViewBackground sPanel; //Second
    private ViewBackground tPanel; //Third
    
    //------------------------------------------------------------------------------------------------
    
    //Constructor:
    public ViewGame() 
    {
        initComponents();                
    }
    
    //------------------------------------------------------------------------------------------------
    
    private void initComponents()
    {
        //Variable initialization:-------------------------------------------
        vBackground.setName("/Images/ViewGame.png");
        
        leftPanel = new ViewBackground("/Images/Figures/Triangles/Blue/tbBlue.png");
        fPanel = new ViewBackground("/Images/Figures/Triangles/Blue/tsBlue.png");
        sPanel = new ViewBackground("/Images/Figures/Triangles/Blue/tbBlue.png");
        tPanel = new ViewBackground("/Images/Figures/Triangles/Blue/tmBlue.png");
        //--------------------------------------------------------------------
        
        
        // Components coordinates:-------------------------------------------
        leftPanel.setBounds(70,265,180,180);
        fPanel.setBounds(350,265,180,180);
        sPanel.setBounds(620,265,180,180);
        tPanel.setBounds(900,265,180,180);
        //--------------------------------------------------------------------
        
        
        // Add components to the main panel:----------------------------------
        add(leftPanel);
        add(fPanel);
        add(sPanel);
        add(tPanel);
        //--------------------------------------------------------------------
        
        
        // Configuation of the order of the components (at the bottom, on top, etc)
        getContentPane().setComponentZOrder(leftPanel,0);
        getContentPane().setComponentZOrder(fPanel,0);
        getContentPane().setComponentZOrder(sPanel,0);
        getContentPane().setComponentZOrder(tPanel,0);
        //--------------------------------------------------------------------
        
        
        
        getContentPane().revalidate();          
    }
    //------------------------------------------------------------------------------------------------    
}
//------------------------------------------------------------------------------------------------------
