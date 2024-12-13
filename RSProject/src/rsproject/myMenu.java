
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

public class myMenu extends JFrame implements ActionListener{
    
    Worker worker = new Worker();
    CasherScreen casher = new CasherScreen();
        
    myMenu(int num)
    {
        super("Abo Essam Restruent");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1400, 1000);
        
        JTabbedPane pane = new JTabbedPane();
       
        worker = new Worker();
        casher = new CasherScreen();
        
        
        pane.add("Worker", worker);
        
        if(num <  3)
            pane.add("Casher", casher);
        
        if(num < 2)
            pane.add("Manager", new ManagerScreen(false));
        
        if(num < 1)
        {
            pane.removeTabAt(2);
            pane.add("Manager", new ManagerScreen(true));
            pane.add("B!O!S!S", new BossScreen());
        }
            
        casher.getSubmit().addActionListener(this);
        
        add(pane);
        
        setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        casher.Submit();
        worker.addBill(Bill.getStr());
       
    }
    
}
