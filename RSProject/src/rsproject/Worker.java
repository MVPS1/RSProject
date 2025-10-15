
package rsproject;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextArea;


public class Worker extends JPanel implements ActionListener{
    
    ArrayList<JPanel> panels;
    ArrayList<JButton> buttons;
    
    Worker()
    {
       panels = new ArrayList<>();
       buttons = new ArrayList<>();
       
        setLayout(new FlowLayout(5));
        
    }
    
    public void addBill(String str)
    {
        
        panels.add(new JPanel());
        buttons.add(new JButton("X"));
        buttons.get(buttons.size()-1).addActionListener(this);
        
        
        
        JTextArea label = new JTextArea();
        label.setEditable(false);
        label.setFont(new Font(null, Font.BOLD, 16)); 
        label.setText(str);
        
        panels.get(panels.size()-1).add(label);
        panels.get(panels.size()-1).add(buttons.get(buttons.size()-1));
        panels.get(panels.size()-1).setBackground(Color.gray);
        
        add(panels.get(panels.size()-1));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i =0 ; i < buttons.size(); i++)
        {
            if(e.getSource() == buttons.get(i))
            {
                remove(panels.get(i));
                this.repaint();
                this.validate();
                break;
            }
        }
        
    }
    
}
