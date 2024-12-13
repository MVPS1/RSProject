
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


public class Register extends JFrame implements ActionListener{
    
    private JTextField id;
    private JTextField first_name;
    private JTextField last_name;
    private JTextField mobile_number;
    private JTextField email;
    private JTextField username;
    private JPasswordField password;
    
    private JButton reg;
    private JButton cancel;
    
    Register()
    {
        super("Register");
        
        setSize(350, 300);
      
        setLayout(new FlowLayout());
        
        id = new JTextField(20);
        first_name = new JTextField(20);
        last_name = new JTextField(20);
        mobile_number = new JTextField(20);
        email = new JTextField(20);
        username = new JTextField(20);
        password = new JPasswordField(20);
       
   
        JLabel label = new JLabel("the id number must be taken from the boss");
        
        label.setFont(new Font(null, Font.BOLD, 16));
        label.setForeground(Color.red);
        
        add(label);
        
        
       
        
        add(new JLabel("id                          : "));
        add(id);
        add(new JLabel("First Name         : "));
        add(first_name);
        add(new JLabel("Last Name         : "));
        add(last_name);
        add(new JLabel("Mobile Number : "));
        add(mobile_number);
        add(new JLabel("Email                   : "));
        add(email);
        add(new JLabel("Username          : "));
        add(username);
        add(new JLabel("Password          : "));
        add(password);
        
        
         reg = new JButton("Register");
         cancel = new JButton("Cancel");
         
         reg.addActionListener(this);
         cancel.addActionListener(this);
         
         
         add(reg);
         add(cancel);
         setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == reg)
        {
            myConnection connect = new myConnection();
            ArrayList<String> s = new ArrayList<>();
            s.add(id.getText());
            s.add(first_name.getText());
            s.add(last_name.getText());
            s.add(mobile_number.getText());
            s.add(email.getText());
            s.add(username.getText());
            s.add(password.getText());
            
           if(!connect.register(s))
           {
               JOptionPane.showMessageDialog(this, "There is a mistake", "Error", JOptionPane.ERROR_MESSAGE);
           }
           else
           {
               JOptionPane.showMessageDialog(this, "Ask your maneger to activate your job","Registration Successful", JOptionPane.INFORMATION_MESSAGE);
               dispose();
           }
                    
        }else
        {
            dispose();
        }
        
    }
    
}
