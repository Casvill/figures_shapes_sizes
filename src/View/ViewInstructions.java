package View;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Daniel Casvill
 */

public class ViewInstructions extends View
{
    private JLabel jltInstructions;
    private JButton jbPlay;
    private JButton jbBack;
    
    //------------------------------------------------------------------------------------------------
    
    public ViewInstructions() 
    {
        //Variable initialization:-------------------------------------------
        jltInstructions = new JLabel("Instructions: Lorem ipsum bla bla bla");
        jbPlay = new JButton("Play");
        jbBack = new JButton("Back");                
        
        jltInstructions.setFont(font);
        //--------------------------------------------------------------------
        
        
        // Action Listeners:--------------------------------------------------
        jbPlay.addActionListener((ActionEvent evt) -> {            
            // Play logic
            play();
        });
        
        jbBack.addActionListener((ActionEvent evt) -> {            
            // Back logic
            back();
        });
        //--------------------------------------------------------------------
        
        
        // Components coordinates:-------------------------------------------
        jltInstructions.setBounds(400, 200, 500, 30);
        jbPlay.setBounds(480, 400, 150, 30);
        jbBack.setBounds(480, 440, 150, 30);
        //--------------------------------------------------------------------
        
        
        // Add components to the main panel:----------------------------------
        add(jltInstructions);
        add(jbPlay);
        add(jbBack);
        //--------------------------------------------------------------------
        
        
        // Configuation of the order of the components (at the bottom, on top, etc)
        getContentPane().setComponentZOrder(jltInstructions,0);
        getContentPane().setComponentZOrder(jbPlay,0);
        getContentPane().setComponentZOrder(jbBack,0);
        //--------------------------------------------------------------------
        
        getContentPane().revalidate();  
    }
    
    //------------------------------------------------------------------------------------------------
    
    private void play()
    {
        new ViewGame().setVisible(true);
        dispose();
    }
    
    //------------------------------------------------------------------------------------------------
    
    private void back()
    {
        new ViewLobby().setVisible(true);
        dispose();
    }
    
    //------------------------------------------------------------------------------------------------
}
