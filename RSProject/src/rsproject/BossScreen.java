
package rsproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class BossScreen extends JPanel implements ActionListener{
    
    JButton add;
    JTextField id;
    
    BossScreen()
    {
        add = new JButton("ADD");
        id = new JTextField(20);
        add(new JLabel("Add new Job by id : "));
        
        add.addActionListener(this);
        add(id);
        add(add);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        myConnection con = new myConnection();
        if(con.addJob(id.getText()))
        {
            JOptionPane.showMessageDialog(this, "New Job Added !", "Success", JOptionPane.PLAIN_MESSAGE);
        }
        else
        {
            JOptionPane.showMessageDialog(this, "There is some mistake", "Failed", JOptionPane.ERROR_MESSAGE);

        }
        
    }
}
