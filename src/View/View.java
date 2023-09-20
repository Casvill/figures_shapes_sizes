package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
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
    
    private final JButton jbQuit;
    
    public View() 
    {
        // Configurar el fondo (puedes personalizar la lógica de fondo aquí)
        setContentPane(new JPanel() 
        {
            @Override
            protected void paintComponent(Graphics g) 
            {
                super.paintComponent(g);
                // Dibuja el fondo aquí
                g.setColor(Color.BLACK);
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        });
        
        
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
        setSize(800, 600); // Tamaño predeterminado
    }
    
    //------------------------------------------------------------------------------------------------
    
    private void cerrarVentana(){
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
        java.awt.EventQueue.invokeLater(() -> {
            new View().setVisible(true);
        });
    }
    
}
