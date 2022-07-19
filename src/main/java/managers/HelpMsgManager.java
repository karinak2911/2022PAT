/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managers;

import java.sql.ResultSet;
import java.sql.SQLException;
import objects.HelpMsg;

/**
 *
 * @author Karinak
 */
public class HelpMsgManager {
   private HelpMsg [] helpmessages = new HelpMsg[200];
    private int size; 

    public HelpMsgManager() throws SQLException {
    
     String query = "SELECT * FROM helptbl;"; 
      ResultSet rs = SystemManager.db.query(query);

        while (rs.next()){ 
            int ID = rs.getInt(1);
            String message = rs.getString(2);
            
            helpmessages[size] = new HelpMsg(ID, message); 
            size++; 
        }
    }
    
    public String getMessage(int id){ 
        String out = ""; 
        for(int i = 0; i < size ; i++ ){ 
            if(helpmessages[i].getId() == id)
                out += helpmessages[i].getMessage(); 
        }
        return out;
    }
    
    
   
}
