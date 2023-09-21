package View;
/**
 *
 * @author Daniel Casvill
 */

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class View extends JFrame 
{
    //Variable declaration:
    private int initialX;
    private int initialY;
    public ViewBackground vBackground;    
    private JButton jbQuit;
    private JPanel panel;
    public static String nickname;
    
    //Constructor:------------------------------------------------------------------------------------
    public View() 
    {   
        setSize(1123, 693);
        setLayout(null);
        initComponents();
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
    }
    //------------------------------------------------------------------------------------------------
    private void initComponents()
    {
        //Variable initialization:-------------------------------------------
        panel = new JPanel();
        vBackground = new ViewBackground("/Images/ViewLogging.png");
        jbQuit = new JButton("Quit Game");
        //--------------------------------------------------------------------
        
        
        //Listeners:---------------------------------------------------------
        jbQuit.addActionListener((ActionEvent evt) -> 
        {
            //System.exit(0);
            closeWindow();
        });               
        
        addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mousePressed(MouseEvent e) 
            {
                initialX = e.getX();
                initialY = e.getY();
            }
        });
        
        addMouseMotionListener(new MouseAdapter() 
        {
            @Override
            public void mouseDragged(MouseEvent e) {
                int newX = getLocation().x + e.getX() - initialX;
                int newY = getLocation().y + e.getY() - initialY;
                setLocation(newX, newY);
                getContentPane().revalidate();   
            }
        });
        //--------------------------------------------------------------------
        
        
        // Components coordinates:-------------------------------------------
        jbQuit.setBounds(975,20,100,33);
        vBackground.setBounds(0,0,1123,693);
        //--------------------------------------------------------------------
        
        
        // Add components to the main panel:----------------------------------
        getContentPane().add(panel);            
        add(jbQuit);
        add(vBackground);
        //--------------------------------------------------------------------        
    }
    
    //------------------------------------------------------------------------------------------------
    
    public void closeWindow(){
        int answer;

        answer = JOptionPane.showConfirmDialog(
                    null,"Do you really want to close the game?", "Warning",
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.WARNING_MESSAGE);
        if(answer == JOptionPane.YES_OPTION)
        {
            System.exit(0);
        }
    }
    
    //------------------------------------------------------------------------------------------------
}