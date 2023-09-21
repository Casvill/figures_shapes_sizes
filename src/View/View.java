package View;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
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
    private ViewBackground vBackground;
    
    private final JButton jbQuit;
    
    public View() 
    {
        vBackground = new ViewBackground("/Images/ViewLogging.png");
        
        
        jbQuit = new JButton("Quit Game");
        
        // Configura el ActionListener para el botón "Quit Game"
        jbQuit.addActionListener((ActionEvent evt) -> {
            // Aquí puedes agregar la lógica para salir del juego si es necesario
            cerrarVentana();
        });
        
        
        JPanel panelBotones = new JPanel();
        panelBotones.add(jbQuit);
        getContentPane().add(panelBotones, BorderLayout.SOUTH);

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

    
}