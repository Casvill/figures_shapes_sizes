package View;
/**
 *
 * @author Daniel Castillo Villamarín
 * @FPOE group 81
 * @Lab number 1
 */

import javax.swing.JLabel;
import Controller.GameLogic;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collections;
import java.util.List;


public class ViewGame extends View
{
    
    //Variable declaration:
    private ViewBackground leftPanel;
    private ViewBackground fPanel; //First
    private ViewBackground sPanel; //Second
    private ViewBackground tPanel; //Third

    private List<String> figures;
        
    private JLabel jlNickname;
    private JLabel jlFails;
    private JLabel jlTries;
    private JLabel jlRounds;
    
    private GameLogic gl;
    private String figureGoal;
    private String fFigure;
    private String sFigure;
    private String tFigure;
    
    //------------------------------------------------------------------------------------------------
    
    //Constructor:
    public ViewGame() 
    {
        initComponents();   
        View.setInGame(true); //Already in game view
    }
    
    //------------------------------------------------------------------------------------------------
    
    private void initComponents()
    {
        //Variable initialization:-------------------------------------------
        
        gl = new GameLogic();
        figures = gl.getFigures();
        
        figureGoal = figures.get(0).substring(3);
        leftPanel = new ViewBackground(figureGoal);

        Collections.shuffle(figures);

        fFigure = figures.get(0).substring(3);
        sFigure = figures.get(1).substring(3);
        tFigure = figures.get(2).substring(3);

        fPanel = new ViewBackground(fFigure);
        sPanel = new ViewBackground(sFigure);
        tPanel = new ViewBackground(tFigure);
        
        vBackground.setName("/Images/ViewGame.png");
        
        
        jlNickname = new JLabel("Player: " + nickname);
        jlNickname.setFont(font);
        jlFails = new JLabel("Fails: " + GameLogic.getFails());
        jlFails.setFont(font);
        jlTries = new JLabel("Tries: " + GameLogic.getTries());
        jlTries.setFont(font);
        jlRounds = new JLabel("Round: " + GameLogic.getRounds());
        jlRounds.setFont(font);
        //--------------------------------------------------------------------
        
        
        // Components coordinates:-------------------------------------------
        leftPanel.setBounds(70,265,180,180);
        fPanel.setBounds(350,265,180,180);
        sPanel.setBounds(620,265,180,180);
        tPanel.setBounds(900,265,180,180);
        
        jlNickname.setBounds(30,20,230,33);
        jlFails.setBounds(340,20,230,33);
        jlTries.setBounds(565,20,230,33);
        jlRounds.setBounds(805,20,230,33);
        //--------------------------------------------------------------------
        
        
        // Add components to the main panel:----------------------------------
        add(leftPanel);
        add(fPanel);
        add(sPanel);
        add(tPanel);
        
        add(jlNickname);
        add(jlFails);
        add(jlTries);
        add(jlRounds);
        //--------------------------------------------------------------------
        
        
        // Configuation of the order of the components (at the bottom, on top, etc)
        getContentPane().setComponentZOrder(leftPanel,0);
        getContentPane().setComponentZOrder(fPanel,0);
        getContentPane().setComponentZOrder(sPanel,0);
        getContentPane().setComponentZOrder(tPanel,0);
        
        getContentPane().setComponentZOrder(jlNickname,0);
        getContentPane().setComponentZOrder(jlFails,0);
        getContentPane().setComponentZOrder(jlTries,0);
        getContentPane().setComponentZOrder(jlRounds,0);
        //--------------------------------------------------------------------
        
        // Action Listeners:--------------------------------------------------
        fPanel.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseClicked(MouseEvent e) 
            {                
                compareFigure(fFigure);
            }
        });
        
        sPanel.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseClicked(MouseEvent e) 
            {
                compareFigure(sFigure);
            }
        });
        
        tPanel.addMouseListener(new MouseAdapter() 
        {
            @Override
            public void mouseClicked(MouseEvent e) 
            {
                compareFigure(tFigure);
            }
        });
        //--------------------------------------------------------------------                        
        
        getContentPane().revalidate();          
    }
    
    //------------------------------------------------------------------------------------------------    
    
    private void round()
    {
        GameLogic.setTries(GameLogic.getTries()+1);
        jlTries.setText("Tries: "+GameLogic.getTries());
        
        GameLogic.setRound(GameLogic.getRounds()+1);
        jlRounds.setText("Round: "+GameLogic.getRounds());
        
        figures = gl.getFigures();
        
        figureGoal = figures.get(0).substring(3);
        leftPanel.setName(figureGoal);

        Collections.shuffle(figures);

        fFigure = figures.get(0).substring(3);
        sFigure = figures.get(1).substring(3);
        tFigure = figures.get(2).substring(3);

        fPanel.setName(fFigure);
        sPanel.setName(sFigure);
        tPanel.setName(tFigure);
        
        leftPanel.repaint();
        fPanel.repaint();
        sPanel.repaint();
        tPanel.repaint();
        
        getContentPane().revalidate();    
    }
    
    //------------------------------------------------------------------------------------------------
    
    private void fail()
    {
        GameLogic.setFails(GameLogic.getFails()+1);
        GameLogic.setTries(GameLogic.getTries()+1);
        
        jlFails.setText("Fails: "+GameLogic.getFails());
        jlTries.setText("Tries: "+GameLogic.getTries());
    }
    
    //------------------------------------------------------------------------------------------------
    
    private void compareFigure(String figureSelected)
    {
        if(figureSelected.equals(figureGoal))
        {
            round();
        }
        else
        {
            fail();
        }
    }
    
    //------------------------------------------------------------------------------------------------
}
//------------------------------------------------------------------------------------------------------
