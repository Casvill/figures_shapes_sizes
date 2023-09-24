package View;
/**
 *
 * @author Daniel Casvill
 */

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;


public class ViewInstructions extends View
{
    private final JLabel jltInstructions;
    private final JLabel jltInstructions2;
    private final JButton jbPlay;
    private final JButton jbBack;
    
    //------------------------------------------------------------------------------------------------
    
    public ViewInstructions() 
    {
        //Variable initialization:-------------------------------------------
        jltInstructions = new JLabel("Look at the figure on the left and then choose one");
        jltInstructions2 = new JLabel("of the three we provide that has the same size.");
        jbPlay = new JButton("Play");
        jbBack = new JButton("Back");                
        
        jltInstructions.setFont(font);
        jltInstructions2.setFont(font);
        //--------------------------------------------------------------------
        
        
        // Action Listeners:--------------------------------------------------
        jbPlay.addActionListener((ActionEvent evt) -> 
        {            
            // Play logic
            play();
        });
        
        jbBack.addActionListener((ActionEvent evt) -> 
        {            
            // Back logic
            back();
        });
        //--------------------------------------------------------------------
        
        
        // Components coordinates:-------------------------------------------
        jltInstructions.setBounds(240, 240, 620, 30);
        jltInstructions2.setBounds(240, 280, 620, 30);
        jbPlay.setBounds(480, 400, 150, 30);
        jbBack.setBounds(480, 440, 150, 30);
        //--------------------------------------------------------------------
        
        
        // Add components to the main panel:----------------------------------
        add(jltInstructions);
        add(jltInstructions2);
        add(jbPlay);
        add(jbBack);
        //--------------------------------------------------------------------
        
        
        // Configuation of the order of the components (at the bottom, on top, etc)
        getContentPane().setComponentZOrder(jltInstructions,0);
        getContentPane().setComponentZOrder(jltInstructions2,0);
        getContentPane().setComponentZOrder(jbPlay,0);
        getContentPane().setComponentZOrder(jbBack,0);
        //--------------------------------------------------------------------
        
        getContentPane().revalidate();  
    }
    
    //------------------------------------------------------------------------------------------------
    
    private void play()
    {
        dispose();
        new ViewGame().setVisible(true);
    }
    
    //------------------------------------------------------------------------------------------------
    
    private void back()
    {
        dispose();
        new ViewLobby().setVisible(true);
    }
    
    //------------------------------------------------------------------------------------------------
}
