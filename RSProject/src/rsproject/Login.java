
package rsproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class Login extends JFrame implements ActionListener{
    
    
    private JTextField username;
    private JPasswordField password;
    
    private JButton login;
    private JButton cancel;
    
    Login()
    {
        super("Login");
        
        setSize(350, 300);
        setLayout(new FlowLayout());
        
        username = new JTextField("MVP",20);
        password = new JPasswordField("osama123123",20);
        
        login = new JButton("Login");
        cancel = new JButton("Cancel");
         
        login.addActionListener(this);
        cancel.addActionListener(this);
        
        add(new JLabel("Username          : "));
        add(username);
        add(new JLabel("Password          : "));
        add(password);
        
         add(login);
         add(cancel);
         setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == login)
        {
            
            myConnection connection = new myConnection();
            
            
            int windowNumber = connection.login(username.getText(), password.getText());
            
            if(windowNumber == -1)
                JOptionPane.showMessageDialog(this, "Username or password not correct", "Invalid Login", JOptionPane.ERROR_MESSAGE);
            else
            {
                new myMenu(windowNumber);
                dispose();
            }
                
            
        }
        else
        {
            
            dispose();
        }
        
        
    }
    
}
