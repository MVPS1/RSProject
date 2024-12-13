
package rsproject;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;

public class ManagerScreen extends JPanel implements ActionListener{
    
    JButton submit;
    JTextField search;
    Vector<Vector<String>> vec;
    DefaultTableModel model;
    myConnection connection;
    boolean isBoss;
    
    ManagerScreen(boolean isBoss)
    {
        this.isBoss = isBoss;
        connection = new myConnection();  
        setLayout(new FlowLayout());
        add(new JLabel("Manager Screen"));
        
        submit = new JButton("Submit");
        submit.addActionListener(this);
        
        search = new JTextField(20);
        search.addActionListener(this);
        
        
        JTable table = new JTable() {
            
            public boolean isCellEditable(int row,int column)
            {
                if(column == 6)
                    return true;
                
                return false;
            }
        };
        
        model = (DefaultTableModel) table.getModel();
        JScrollPane pane = new JScrollPane(table);
        
        
        String[] strs = {"Active", "Not Active"};
        
        JComboBox comboBox = new JComboBox(strs);
        
        vec = connection.getEmployees(isBoss, "");
        
        model.setColumnIdentifiers(vec.get(0));
        
        for(int i = 1; i < vec.size(); i++)
        { 
          model.addRow(vec.get(i)); 
        }
        
        TableColumn col = table.getColumnModel().getColumn(6);
        col.setCellEditor(new DefaultCellEditor(comboBox));
        
        
        table.setPreferredScrollableViewportSize(new Dimension(1100, 300));
        
        add(new JLabel("Search By Id : "));
        add(search);
        add(pane);
        add(submit); 
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == submit)
        {
           for(int i = 0; i < model.getRowCount(); i++)
           { 
               vec.get(i+1).set(6, model.getValueAt(i, 6).toString());  
           }

           if(connection.setEmployeesStatus(vec))
           {
               JOptionPane.showMessageDialog(this, "Employees information changed", "Update Successful", JOptionPane.INFORMATION_MESSAGE);
           }
           else
           { 
              JOptionPane.showMessageDialog(this, "There is some mistake", "Update Failed", JOptionPane.ERROR_MESSAGE);
           }
        }
        else if(e.getSource() == search)
        {
            vec = connection.getEmployees(isBoss, search.getText());

            while(model.getRowCount() > 0)
                model.removeRow(0);
                
               
            for(int i = 1; i < vec.size(); i++)
            { 
              model.addRow(vec.get(i));
            }
        }
        
  
    }

   
}
