package View;
/**
 *
 * @author Daniel Casvill
 */

import static View.View.nickname;
import static View.View.font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;

//----------------------------------------------------------------------------------------------------

public class ViewLobby extends View
{
    
    //Variable declaration:
    private JLabel jlMessage;
    private JButton jbInstructions;
    private JButton jbStart;
        
    //------------------------------------------------------------------------------------------------
    
    //Constructor:
    public ViewLobby()
    {
        initComponents();
    }
    
    //------------------------------------------------------------------------------------------------
    
    private void initComponents()
    {
        //Variable initialization:-------------------------------------------
        jlMessage = new JLabel("Welcome "+nickname+" !!");
        jlMessage.setFont(font);
        jbInstructions = new JButton("Instructions");
        jbStart = new JButton("Start");
        //--------------------------------------------------------------------
        
        
        // Action Listeners:--------------------------------------------------
        jbInstructions.addActionListener((ActionEvent evt) -> 
        {            
            // Instructions logic
            instructions();
        });
        
        jbStart.addActionListener((ActionEvent evt) -> 
        {            
            // Start logic
            start();
        });
        //--------------------------------------------------------------------
        
        
        // Components coordinates:-------------------------------------------
        jlMessage.setBounds(440, 180, 500, 30);
        jbInstructions.setBounds(480, 300, 150, 30);
        jbStart.setBounds(480, 340, 150, 30);
        //--------------------------------------------------------------------
        
        
        // Add components to the main panel:----------------------------------
        add(jlMessage);
        add(jbInstructions);
        add(jbStart);
        //--------------------------------------------------------------------
        
        // Configuation of the order of the components (at the bottom, on top, etc)
        getContentPane().setComponentZOrder(jlMessage,0);
        getContentPane().setComponentZOrder(jbInstructions,0);
        getContentPane().setComponentZOrder(jbStart,0);
        //--------------------------------------------------------------------
        
        
        getContentPane().revalidate();  
    }
    
    //------------------------------------------------------------------------------------------------
    
    private void start()
    {
        new ViewGame().setVisible(true);
        dispose();
    }
    
    //------------------------------------------------------------------------------------------------
    
    
    //------------------------------------------------------------------------------------------------
    
    private void instructions()
    {
        new ViewInstructions().setVisible(true);
        dispose();
    }
    
    //------------------------------------------------------------------------------------------------
}