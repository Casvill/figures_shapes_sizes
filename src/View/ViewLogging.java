package view;
/**
 *
 * @author Daniel Casvill
 */

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import View.View;
import View.ViewLobby;
import javax.swing.JOptionPane;


//----------------------------------------------------------------------------------------------------

public class ViewLogging extends View
{ 
    //Variable declaration:
    private JLabel jlNickname;
    private JTextField jtfNickname;
    private JButton jbGo;
        
    //------------------------------------------------------------------------------------------------
    
    //Constructor:
    public ViewLogging() 
    {
        initComponents();
        setVisible(true);
    }
    
    //------------------------------------------------------------------------------------------------
    
    private void initComponents() 
    {   
        //Variable initialization:-------------------------------------------
        jlNickname = new JLabel("Nickname: ");
        jtfNickname = new JTextField(20);
        jlNickname.setFont(font);
        jbGo = new JButton("Go!");
        //--------------------------------------------------------------------
        
        
        // Action Listeners:--------------------------------------------------
        jbGo.addActionListener((ActionEvent evt) -> 
        {
            nickname = jtfNickname.getText();
            go();
        });
        //--------------------------------------------------------------------
        
        
         // Components coordinates:-------------------------------------------
        jlNickname.setBounds(500, 260, 200, 30);
        jtfNickname.setBounds(480, 300, 150, 30);
        jbGo.setBounds(452, 340, 200, 30);
        //--------------------------------------------------------------------
        
        
        // Add components to the main panel:----------------------------------
        add(jlNickname);
        add(jtfNickname);
        add(jbGo);
        //--------------------------------------------------------------------
        
        
        // Configuation of the order of the components (at the bottom, on top, etc)
        getContentPane().setComponentZOrder(jlNickname,0);
        getContentPane().setComponentZOrder(jtfNickname,0);
        getContentPane().setComponentZOrder(jbGo,0);
        //--------------------------------------------------------------------
        
        
        getContentPane().revalidate();        
    }
    
    //------------------------------------------------------------------------------------------------
    
    private void go()
    {
        if(verifyNickname())
        {
            dispose();
            new ViewLobby().setVisible(true); 
        }    
    }
    
    //------------------------------------------------------------------------------------------------
    
    private boolean verifyNickname()
    {
        if(jtfNickname.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Please enter a Nickname","warning",JOptionPane.ERROR_MESSAGE);
            jtfNickname.requestFocusInWindow();
            return false;
        }   
        return true;
    }
    
    //------------------------------------------------------------------------------------------------
    
}
//------------------------------------------------------------------------------------------------------


