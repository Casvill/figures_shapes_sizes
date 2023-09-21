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
import java.awt.Font;


//----------------------------------------------------------------------------------------------------

public class ViewLogging extends View
{ 
    //Variable declaration:
    private JLabel jlNickname;
    private JTextField jtfNickname;
    private JButton jbGo;
    private Font font;
        
    //------------------------------------------------------------------------------------------------
    
    //Constructor:
    public ViewLogging() 
    {
        initComponents();
    }
    
    //------------------------------------------------------------------------------------------------
    
    private void initComponents() 
    {   
        //Variable initialization:-------------------------------------------
        jlNickname = new JLabel("Nickname: ");
        font = new Font("Arial",Font.PLAIN, 24);
        jtfNickname = new JTextField(20);
        jbGo = new JButton("Go!");
        //--------------------------------------------------------------------
        
        
        // Action Listeners:--------------------------------------------------
        jbGo.addActionListener((ActionEvent evt) -> {
            String nickname = jtfNickname.getText();
            System.out.println(nickname);
        });
        //--------------------------------------------------------------------
        
        
         // Components coordinates:-------------------------------------------
        jlNickname.setBounds(500, 260, 200, 30);
        jlNickname.setFont(font);
        jtfNickname.setBounds(480, 300, 150, 30);
        jbGo.setBounds(460, 340, 200, 30);
        //--------------------------------------------------------------------
        
        
        // Add components to the main panel:----------------------------------
        add(jlNickname);
        add(jtfNickname);
        add(jbGo);
        //--------------------------------------------------------------------
        
        
        // Configuation or the order of the components (at the bottom, on top, etc)
        getContentPane().setComponentZOrder(jlNickname,0);
        getContentPane().setComponentZOrder(jtfNickname,0);
        getContentPane().setComponentZOrder(jbGo,0);
        //--------------------------------------------------------------------
        
        
        getContentPane().revalidate();        
    }
    
    
    //------------------------------------------------------------------------------------------------
    
    public static void main(String args[]) 
    {
        java.awt.EventQueue.invokeLater(() -> 
        {
            new ViewLogging().setVisible(true);
        });
    }
    
    //------------------------------------------------------------------------------------------------
    
}
//------------------------------------------------------------------------------------------------------


