
package rsproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

public class myConnection {
    
    private final String url = "jdbc:mysql://localhost:3306/rsproject";
    private final String username = "root";
    private final String password = "";
    private boolean connectionState = false;
    
    private Connection con;
    private Statement statement;
    
    
    myConnection()
    {
            try
            {
               con = DriverManager.getConnection(url, username, password);
               statement = con.createStatement();
               
               System.out.println("Welcome");
               connectionState = true;
               
            }catch(SQLException ex)
            {
                connectionState = false;
                System.err.println("Connection Failed");
                System.err.println(ex);
            }
           
    }
    
    public boolean getConnectionState()
    {
        return connectionState;
    }
    
    public boolean register(ArrayList<String> s)
    {
        for(String str : s)
        {
            if(str.equals(""))
                return false;
        }
        
        if(checkId(s.get(0)))
        {
            try{
                String power;
                
                switch(s.get(0).charAt(0))
                {
                    case '1' : power = "Manager";
                    break;
                    case '2' : power = "Casher";
                    break;
                    case '3' : power = "Worker";
                    break;
                    
                    default: power = "Worker";
                }
                
                statement.executeUpdate("UPDATE employee "
        
                + "SET first_name = '" +s.get(1) + "', "
                + "last_name ='" +s.get(2) + "', "
                + "mobile_number ='" +s.get(3) + "', "
                + "email ='" +s.get(4) + "', "
                + "username ='" +s.get(5) + "', "
                + "pass ='" +s.get(6) + "', "
                + "power ='" + power + "', "
                + "state ='" +"Not Active" + "' "
                + "WHERE id = " + s.get(0)
                );
                
                return true;
            }catch(SQLException ex)
            {
                System.err.println(ex);
                return false;
            }
            
        }
        
       return false;
    }
    
    public int login(String username, String password)
    {
        try{
            
            ResultSet set = statement.executeQuery("SELECT id from employee where"
                    
                    + " username = '" +username+ "' AND "
                    + "pass = '"+password+"' AND state = 'Active'" );
            
            if(set.next())
            {
                String id = "" + set.getObject(1);
                
                if(id.equals("10"))
                    return 0;
                
                    int w = id.charAt(0) - '0';
                    
                    return w;
            }
            else
            {
                return -1;
            }
            
        }catch(SQLException ex)
        {
        
        }
        
        return 1;
    }
    
    public Vector<Vector<String>> getEmployees(boolean boss, String id)
    {
        
        Vector<Vector<String>> vec = new Vector<Vector<String>>();
        
        String prime = boss ? "99" : "199";
        
        if(id.equals(""))
            id = "id";
        
        try{
            
            ResultSet set = statement.executeQuery("SELECT id, first_name, last_name, mobile_number, email, power, state "
            + " FROM employee WHERE id > "+prime+" and id = "+id+" and username is not NULL");
                
            ResultSetMetaData meta = set.getMetaData();
            
            vec.add(new Vector<String>());
            
            for(int i = 1; i <= meta.getColumnCount(); i++)
            {
                
                vec.get(0).add(meta.getColumnName(i));
            }
            
            for(int i = 1; set.next();i++)
            {
                vec.add(new Vector<String>());
                vec.get(i).add((String) ("" + set.getObject(1)));
                vec.get(i).add((String) set.getObject(2));
                vec.get(i).add((String) set.getObject(3));
                vec.get(i).add((String) set.getObject(4));
                vec.get(i).add((String) set.getObject(5));
                vec.get(i).add((String) set.getObject(6));
                vec.get(i).add((String) set.getObject(7));
            }
            
           
            
        }catch(SQLException ex)
        {
            System.err.println(ex);
        }
        
        return vec;
    }
    
    public boolean insertBill(String id, String cN, String date, float total, ArrayList<Order> orders)
    {
        
        try{
            statement.executeUpdate(String.format("INSERT INTO BILL VALUES(%s,'%s','%s',%.2f)", id, cN, date, total));
            
            for(Order o : orders)
            {
                statement.executeUpdate(String.format("INSERT INTO orders VALUES(%s,%s)", id, o.getId()));
            }
            
            return true;
        }catch(SQLException ex)
        {
            System.err.println(ex);
            return false;
        }
        
       
    }
    
    public boolean setEmployeesStatus(Vector<Vector<String>> vec)
    {
        try{
            
            for(int i = 1; i < vec.size(); i++)
            statement.executeUpdate("UPDATE employee SET state = '" + vec.get(i).get(6)
            + "' WHERE id = " + vec.get(i).get(0)
            );
            
            return true;
        }catch(SQLException ex)
        {
            System.err.println(ex);
            return false;
        }
        
        
    }
    
    public boolean addJob(String id)
    {
        try{
            
            statement.executeUpdate(String.format("INSERT INTO employee(id) VALUES('%s')", id));
            
            return true;
        }catch(SQLException ex)
        {
            return false;
        }
    }
        
    private boolean checkId(String str)
    {
        try{
            ResultSet set = statement.executeQuery("SELECT * from employee where id = " + str);
            
            if(set.next() && set.getObject(6) == null) 
                return true;
            else
                return false;
            
           
        }catch(SQLException ex)
        {
            return false;
        }

    }
    
}
