package View;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Daniel Casvill
 */
public class View extends JFrame 
{
    private int initialX;
    private int initialY;
    private ViewBackground vBackground;
    
    private final JButton jbQuit;
    
    public View() 
    {
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        vBackground = new ViewBackground("/Images/ViewLogging.png");
        jbQuit = new JButton("Quit Game");
        
        
        jbQuit.addActionListener((ActionEvent evt) -> {
            cerrarVentana();
        });
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                initialX = e.getX();
                initialY = e.getY();
            }
        });
        addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                int newX = getLocation().x + e.getX() - initialX;
                int newY = getLocation().y + e.getY() - initialY;
                setLocation(newX, newY);
            }
        });
        
        
        
        
        JPanel panel = new JPanel();
        panel.setBounds(975,20,100,33);
        panel.add(jbQuit);
        getContentPane().add(panel);
        //JPanel panelBotones = new JPanel();
        //panelBotones.add(jbQuit);
        //getContentPane().add(panelBotones, BorderLayout.SOUTH);

            
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1123, 693); // Tamaño predeterminado
        add(vBackground);
    }
    
    //------------------------------------------------------------------------------------------------
    
    public void cerrarVentana(){
        int respuesta;

        respuesta = JOptionPane.showConfirmDialog(
                    null,"¿Realmente dese abandonar el juego?", "Advertencia",
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.WARNING_MESSAGE);
        if(respuesta == JOptionPane.YES_OPTION)
        {
            System.exit(0);
        }
    }
    
    //------------------------------------------------------------------------------------------------
    public static void main(String args[]) {
        // Crea una instancia de ViewLogin y hazla visible
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new View().setVisible(true);
            }
        });
    }
    
}