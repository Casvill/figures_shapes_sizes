package view;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import View.View;


/**
 *
 * @author Daniel Casvill
 */

//----------------------------------------------------------------------------------------------------

public class ViewLoggin extends View
{ 
    //Variable declaration:
    private JLabel jlNickname;
    private JTextField jtfNickname;
    private JButton jbGo;
    
    //------------------------------------------------------------------------------------------------
    
    //Constructor:
    public ViewLoggin() 
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
        
        
        
        // Configura el ActionListener para el botón "Go!"
        jbGo.addActionListener((ActionEvent evt) -> {
            // Aquí puedes agregar la lógica para el botón "Go!" si es necesario
            String nickname = jtfNickname.getText();
            System.out.println(nickname);
            // Realiza alguna acción con el nombre de usuario
        });



        
        // Configura el diseño de la ventana
        setLayout(new java.awt.GridLayout(3, 2));
        add(jlNickname);
        add(jtfNickname);
        add(jbGo);

        //pack(); // Ajusta el tamaño de la ventana automáticamente
    }
    
    
    //------------------------------------------------------------------------------------------------
    
    public static void main(String args[]) {
        // Crea una instancia de ViewLogin y hazla visible
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ViewLoggin().setVisible(true);
            }
        });
    }
    
    //------------------------------------------------------------------------------------------------
    
}

//------------------------------------------------------------------------------------------------------


