
package rsproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


class MyPanel extends JPanel {
    
    private ArrayList<JButton> buttons;
    private ArrayList<Order> orders;
    private JPanel sPanel;
    private JLabel label;
    
    
    MyPanel()
    {
        
        buttons = new ArrayList<>();
        orders = new ArrayList<>();
        sPanel = new JPanel();
        label = new JLabel();
        
        setSize(200 , 200);
        setLayout(new FlowLayout());
        sPanel.setLayout(new GridLayout(3, 2));
        sPanel.setPreferredSize(new Dimension(300 ,200));
        add(label);
        add(sPanel);
      
    }
    
    public void setPhoto(ImageIcon icon)
    {
        label.setIcon(icon); 
    }
    
    public void addOrder(Order order)
    {
        orders.add(order);
        JButton b = new JButton(order.getName());
        buttons.add(b);
        sPanel.add(b);
    }

    public ArrayList<JButton> getButtons(){
        
        return buttons;
    }
    
    public ArrayList<Order> getOrders(){
        
        return orders;
    }
}

public class CasherScreen extends JPanel implements ActionListener{
    
    private MyPanel[] ps; 
    private JPanel ordersPanel;
    private JPanel summaryPanel;
    private DefaultTableModel model;
    private JLabel totalText;
    private float total;
    private JButton undo;
    private JButton submit;
    private JTable table;
    private ArrayList<Order> orders;
    
    
    
    CasherScreen()
    {
        total = 0;
        orders = new ArrayList<>();
        
        ps = new MyPanel[6];
        for(int i = 0; i < 6; i++)
            ps[i] = new MyPanel();
        
        setBackground(Color.GRAY);
        ps[0].setBackground(Color.red);
        ps[1].setBackground(new Color(255, 204, 102));
        ps[2].setBackground(Color.red);
        ps[3].setBackground(new Color(255, 204, 102));
        ps[4].setBackground(Color.red);
        ps[5].setBackground(new Color(255, 204, 102));
     
        
        
        ps[0].setPhoto(new ImageIcon("PHOTOS/Mandy.png"));
        ps[1].setPhoto(new ImageIcon("PHOTOS/Bukhari.png"));
        ps[2].setPhoto(new ImageIcon("PHOTOS/Kabsah.png"));
        ps[3].setPhoto(new ImageIcon("PHOTOS/Pepsi.png"));
        ps[4].setPhoto(new ImageIcon("PHOTOS/7up.png"));
        ps[5].setPhoto(new ImageIcon("PHOTOS/Mirinda.png"));
        
        ps[0].addOrder(new Order("102", "1 Mandy Shiwaya", 42));
        ps[0].addOrder(new Order("112", "1 Mandy Fahm", 44));
        ps[0].addOrder(new Order("202", "1/2 Mandy Shiwaya", 22));
        ps[0].addOrder(new Order("212", "1/2 Mandy Fahm", 24));
        ps[0].addOrder(new Order("402", "1/4 Mandy Shiwaya", 14));
        ps[0].addOrder(new Order("412", "1/4 Mandy Fahm", 16));
        
        ps[1].addOrder(new Order("103", "1 Bukhari Shiwaya", 40));
        ps[1].addOrder(new Order("113", "1 Bukhari Fahm", 42));
        ps[1].addOrder(new Order("203", "1/2 Bukhari Shiwaya", 20));
        ps[1].addOrder(new Order("213", "1/2 Bukhari Fahm", 22));
        ps[1].addOrder(new Order("403", "1/4 Bukhari Shiwaya", 12));
        ps[1].addOrder(new Order("413", "1/4 Bukhari Fahm", 14));
        
        ps[2].addOrder(new Order("101", "1 Kabsah Shiwaya", 42));
        ps[2].addOrder(new Order("111", "1 Kabsah Fahm", 44));
        ps[2].addOrder(new Order("201", "1/2 Kabsah Shiwaya", 22));
        ps[2].addOrder(new Order("211", "1/2 Kabsah Fahm", 24));
        ps[2].addOrder(new Order("401", "1/4 Kabsah Shiwaya", 14));
        ps[2].addOrder(new Order("411", "1/4 Kabsah Fahm", 16));
        
        ps[3].addOrder(new Order("501", "Pepsi 330ml", 3));
        ps[3].addOrder(new Order("511", "Pepsi 1L", 5));
        ps[3].addOrder(new Order("521", "Pepsi 2.2L", 9));
        
        ps[4].addOrder(new Order("502", "7UP 330ml", 3));
        ps[4].addOrder(new Order("512", "7UP 1L", 5));
        ps[4].addOrder(new Order("522", "7UP 2.2L", 9));
        
        ps[5].addOrder(new Order("503", "Mirinda 330ml", 3));
        ps[5].addOrder(new Order("513", "Mirinda 1L", 5));
        ps[5].addOrder(new Order("523", "Mirinda 2.2L", 9));
        
        ordersPanel = new JPanel(new GridLayout(2,3));
        ordersPanel.setPreferredSize(new Dimension(1000, 900));
      
       
        for(int i = 0; i < 6; i++)
        {
            ordersPanel.add(ps[i]);
        }
        
        add(ordersPanel, BorderLayout.CENTER);

        
        for(int i = 0; i < 6; i++)
        {
            for(JButton b : ps[i].getButtons())
            {
                b.addActionListener(this);
            }
        }
        
        summaryPanel = new JPanel();
        summaryPanel.setPreferredSize(new Dimension(320, 900));
        

        table = new JTable() {
            
            public boolean isCellEditable(int row,int column)
            {
                return false;
            }
        };
        
        model = (DefaultTableModel) table.getModel();
        JScrollPane pane = new JScrollPane(table);
        model.addColumn("ID");
        model.addColumn("ORDER");
        model.addColumn("PRICE");
        
        
        table.setPreferredScrollableViewportSize(new Dimension(300, 200));
        
        
        undo = new JButton("REMOVE");
        submit = new JButton("SUBMIT");
        
        undo.addActionListener(this);
        totalText = new JLabel("0 $");
        totalText.setFont(new Font("", Font.BOLD, 22));
        
        
        summaryPanel.add(pane);
        summaryPanel.add(submit);
        summaryPanel.add(undo);
        summaryPanel.add(new JLabel("TOTAL : "));
        summaryPanel.add(totalText);
        add(summaryPanel);
        
    }

    public JButton getSubmit()
    {
        return submit;
    }
    
    public void Submit()
    {
           if(Bill.printOut(orders, total))
           {
               while(model.getRowCount() > 0)
                   model.removeRow(model.getRowCount()-1);
               
               orders = new ArrayList<>();
               total = 0;
               totalText.setText("0 $");
           }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
         if(e.getSource() == undo)
        {
            if(table.getSelectedRow() > -1)
            {
                
                total = total - Float.parseFloat(""+model.getValueAt(table.getSelectedRow(), 2));
                orders.remove(table.getSelectedRow());
                model.removeRow(table.getSelectedRow());
          
                totalText.setText(String.format("%3.2f $", total));
            }
            else if(model.getRowCount() > 0)
            {
                total = total - Float.parseFloat(""+model.getValueAt(model.getRowCount()-1, 2));
                orders.remove(model.getRowCount()-1);
                model.removeRow(model.getRowCount()-1);
                
                totalText.setText(String.format("%3.2f $", total));
            }
            
        }
        else{
            
            for(int i = 0; i < 6; i++)
            {
                int z = 0;
                for(JButton b : ps[i].getButtons())
                {

                    if(e.getSource() == b)
                    {
                        Vector<String> vec = new Vector<>();
                        
                        String id = ps[i].getOrders().get(z).getId();
                        String name = ps[i].getOrders().get(z).getName();
                        float price = ps[i].getOrders().get(z).getPrice();
                        
                        vec.add(id);
                        vec.add(name);
                        vec.add("" +price);
                        
                        
                        orders.add(new Order(id, name, price));
                        model.addRow(vec);
                        
                        total = total + ps[i].getOrders().get(z).getPrice();
                        
                        totalText.setText(String.format("%3.2f $", total));
                        
                        break;
                    }
                    z++;
                }
            }
        }
    }
}
