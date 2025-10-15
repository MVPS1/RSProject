
package rsproject;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import javax.swing.JFrame;
import javax.swing.JLabel;

//2025. Updated
class MainMenu extends JFrame implements ActionListener{
    
    JButton reg;
    JButton log;
    //2025.
    MainMenu()
    {
        super("Abo Essam Restaurant");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 100);
        setResizable(false);
        
        add(new JLabel("Welcome to Abo Essam Restaurant"));
        
        reg = new JButton("Register");
        log = new JButton("Login");
        
        reg.addActionListener(this);
        log.addActionListener(this);
        
        add(reg);
        add(log);
        
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == reg)
        {
            new Register();
        }else
        {
            new Login();
        }
    }
    
}

class FailMenu extends JFrame{
    
    FailMenu()
    {
        super("Connection Failed");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        JLabel label = new JLabel("Sorry, Our servers now is down");
        label.setFont(new Font(null, Font.BOLD, 24));
        label.setForeground(Color.red);
        add(label);
        
        pack();
        setVisible(true);
        
        
    }
}

public class RSProject {

    
    public static void main(String[] args) throws Exception{
        
   
        myConnection con = new myConnection();
        //LocalDateTime now = LocalDateTime.now();
        
        if(con.getConnectionState())
            new MainMenu();
        else
            new FailMenu();
        
       
      
    }
    
}
