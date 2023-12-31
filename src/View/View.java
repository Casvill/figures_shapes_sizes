package View;
/**
 *
 * @author Daniel Castillo Villamarín
 * @FPOE group 81
 * @Lab number 1
 */

import Controller.GameLogic;
import java.awt.Font;
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
    
    public static Font font;
    
    private static boolean inGame; // Check if player is in Game View or not.    
    
    //Constructor:------------------------------------------------------------------------------------
    
    public View() 
    {   
        setSize(1123, 693);
        setLayout(null);
        initComponents();
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
    }
    
    //-------------------------------------------------------------------------------------------------
    
    private void initComponents()
    {
        //Variable initialization:-------------------------------------------
        panel = new JPanel();
        vBackground = new ViewBackground("/Images/ViewLogging.png");
        jbQuit = new JButton("Quit Game");
        font = new Font("Arial",Font.PLAIN, 28);
        
        inGame = false;
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

        answer = JOptionPane.showConfirmDialog
        (
                    null,"Do you really want to close the game?", "Warning",
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.WARNING_MESSAGE
        );
        
        if(answer == JOptionPane.YES_OPTION)
        {
            if(inGame)
            {                
                dispose();
                
                if (GameLogic.getTries() > 0) 
                {
                    int totalRounds = GameLogic.getRounds();
                    int totalFails = GameLogic.getFails();
                    int totalHits = totalRounds - 1;

                    double failPercentage = (totalFails * 100.0) / GameLogic.getTries();
                    double hitPercentage = (totalHits * 100.0) / GameLogic.getTries();

                    String message = String.format("""
                            GAME STATISTICS                
                            Total Rounds : %d
                            Total Fails  : %d  (%.2f%%)
                            Total Hits   : %d  (%.2f%%)""",
                            totalRounds, totalFails, failPercentage, totalHits, hitPercentage);

                    JOptionPane.showMessageDialog(null, message, "Hasta la vista Baby!!!", JOptionPane.INFORMATION_MESSAGE);
                }

                else
                {
                    JOptionPane.showMessageDialog(null,
                    """
                    GAME STATISTICS                
                    Total Rounds : """ + GameLogic.getRounds() +                
                    "\nTotal Fails: " +  GameLogic.getFails()+ 
                    "\nTotal hits : " + (GameLogic.getRounds()-1),
                    "Hasta la vista Baby!!!",
                    JOptionPane.INFORMATION_MESSAGE);  
                }
                                 
            }
            
            System.exit(0);
        }
    }
    
    //------------------------------------------------------------------------------------------------
    
    public static void setInGame(boolean inGame) 
    {
        View.inGame = inGame;
    }
    
    //------------------------------------------------------------------------------------------------
}