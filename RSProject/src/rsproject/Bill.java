
package rsproject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Bill {
    
    private static int callNum = 0;
    private static LocalDateTime now = LocalDateTime.now();
    private static String str = "";
    
    private static String getRandom()
    {
            now = LocalDateTime.now();
            int year = now.getYear();
            int day = now.getDayOfYear();
            int hour = now.getHour() + 1;
            int minute = now.getMinute() + 1;
            int second = now.getSecond() + 1;
            int nano = now.getNano();

            int num = year * day * hour * minute * second + nano;
            num = Math.abs(num);
            
            return "" + num;
    }
    
    private static String getCallingNumber()
    {
        now = LocalDateTime.now();
         if(callNum >= 99)
             callNum = 0;
         
         int call =(now.getMinute() * 100) + (++callNum);
         
         return "" + call;
    }
    
    private static String getCurrentDate()
    {
          now = LocalDateTime.now();
          DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
          
          return df.format(now);
    }
    
    public static boolean printOut(ArrayList<Order> orders, float total) 
    {
        myConnection con = new myConnection();
        
        String random = getRandom();
        String callNumber = getCallingNumber();
        String currentDate = getCurrentDate();
        
        if(!con.insertBill(random, callNumber, currentDate, total, orders))
        {
            JOptionPane.showMessageDialog(null, "There is some mistake", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        str = "";
        String line = new String(new char[20]).replace("\0", "-");
        
        line = "\n\n" + line + "\n\n";
    
        File folder = new File("Bills");
        folder.mkdir();
        
        try{
            
            File file = new File(folder+"\\" + random + ".txt");
            
            file.createNewFile();
            FileWriter writer = new FileWriter(file); 
            
            str = str + random + "\nCalling Number : #" + callNumber + line;
            
            str = str + String.format("%s.\t%-20s%10s", "ID", "ORDER", "PRICE");
            str = str + line;
            
            for(Order o : orders)
            {
                String format = String.format("%s.\t%-20s%10.2f\n", o.getId(),o.getName(), o.getPrice());
                
                str = str + format;
                
            }
            
            str = str +"\n\nAT : "+ currentDate + "\n\nTOTAL : " + total + " SAR";
            writer.write(str);
            
               
            writer.close();
            JOptionPane.showMessageDialog(null, str, "YOUR BILL", JOptionPane.PLAIN_MESSAGE);
            return true;
            
        }catch(Exception ex)
        {
             JOptionPane.showMessageDialog(null, "There is some mistake", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
    }
    
    public static String getStr()
    {
        return str;
    }
}
