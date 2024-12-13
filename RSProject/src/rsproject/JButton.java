
package rsproject;

import java.awt.Color;


public class JButton extends javax.swing.JButton{
    
    JButton(String title)
    {
        super(title);
        
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
        setFocusable(false);
        setToolTipText(title);
        
    }
    
}
