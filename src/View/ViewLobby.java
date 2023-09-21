package View;
/**
 *
 * @author Daniel Casvill
 */

import static View.View.nickname;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;

//----------------------------------------------------------------------------------------------------

public class ViewLobby extends View{
    
    //Variable declaration:
    private JLabel jlMessage;
    private JButton jbInstructions;
    private JButton jbStart;
    private Font font;
        
    //------------------------------------------------------------------------------------------------
    
    //Constructor:
    public ViewLobby()
    {
        initComponents();
    }
    
    public void initComponents()
    {
        //Variable initialization:-------------------------------------------
        jlMessage = new JLabel("Welcome "+nickname+" !!");
        font = new Font("Arial",Font.PLAIN, 28);
        jlMessage.setFont(font);
        jbInstructions = new JButton("Instructions");
        jbStart = new JButton("Start");
        //--------------------------------------------------------------------
        
        
        // Action Listeners:--------------------------------------------------
        jbInstructions.addActionListener((ActionEvent evt) -> {            
            // Instructions logic
        });
        
        jbStart.addActionListener((ActionEvent evt) -> {            
            // Instructions logic
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
        
        // Configuation or the order of the components (at the bottom, on top, etc)
        getContentPane().setComponentZOrder(jlMessage,0);
        getContentPane().setComponentZOrder(jbInstructions,0);
        getContentPane().setComponentZOrder(jbStart,0);
        //--------------------------------------------------------------------
        
        
        getContentPane().revalidate();  
    }
    
}
