package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


/**
 *
 * @author Daniel Casvill
 */

//----------------------------------------------------------------------------------------------------

public class ViewLogin extends javax.swing.JFrame 
{ 
    //Variable declaration:
    private JLabel jlNickname;
    private JTextField jtfNickname;
    private JButton jbGo;
    private JButton jbQuit;
    
    //------------------------------------------------------------------------------------------------
    
    //Constructor:
    public ViewLogin() 
    {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    //------------------------------------------------------------------------------------------------
    
    private void initComponents() 
    {
        this.setUndecorated(true);
        
        jlNickname = new JLabel("Nickname: ");
        jtfNickname = new JTextField(20);
        jbGo = new JButton("Go!");
        jbQuit = new JButton("Quit Game");
        
        
        
        // Configura el ActionListener para el botón "Go!"
        jbGo.addActionListener((ActionEvent evt) -> {
            // Aquí puedes agregar la lógica para el botón "Go!" si es necesario
            String nickname = jtfNickname.getText();
            System.out.println(nickname);
            // Realiza alguna acción con el nombre de usuario
        });

        // Configura el ActionListener para el botón "Quit Game"
        jbQuit.addActionListener((ActionEvent evt) -> {
            // Aquí puedes agregar la lógica para salir del juego si es necesario
            cerrarVentana();
        });

        
        // Configura el diseño de la ventana
        setLayout(new java.awt.GridLayout(3, 2));
        add(jlNickname);
        add(jtfNickname);
        add(jbGo);
        add(jbQuit);

        pack(); // Ajusta el tamaño de la ventana automáticamente
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ViewLogin().setVisible(true);
            }
        });
    }
    
    //------------------------------------------------------------------------------------------------
    
}

//------------------------------------------------------------------------------------------------------


