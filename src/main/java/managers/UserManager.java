/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import objects.User;

/**
 *
 * @author Karinak
 */
public class UserManager implements TableModel {
    
    User [] userArr = new User[200]; 
    int size = 0; 
    

    public UserManager() throws SQLException {
        
        String query = "SELECT * FROM usertbl"; 
        
          ResultSet rs = SystemManager.db.query(query);
          
          while(rs.next()){ 
              int userID = rs.getInt(1);
              String firstName = rs.getString(2); 
              String lastName = rs.getString(3);
              String type = rs.getString(4); 
              String email = rs.getString(5); 
              String password = rs.getString(6); 
              
              userArr[size] = new User(userID, firstName, lastName, type, email, password); 
              size++; 
              
          }
    }
    
    public int getUserID(String email, String password){ 
        int out = 0; 
        for(int i = 0; i < size; i++){ 
            if(email.equalsIgnoreCase(userArr[i].getEmail()) && password.equalsIgnoreCase(userArr[i].getPassword()))
                out = userArr[i].getUserID(); 
        }
        return out; 
        
        
    }
    
    public void addUser(String firstName, String lastname, String type, String email, String password) throws SQLException{ 
         
        String query = " INSERT INTO cutos.usertbl ( `firstName`, `surname`, `workerType`, `emailAdress`, `password`) VALUES ( '" + firstName + "' , '"  + lastname + "' , '"  + type + "' , '"  + email + "' , '"  + password + "');";  
        System.out.println(query);
       SystemManager.db.update(query);
        
       userArr[size] = new User(firstName, lastname, type, email, password); 
       size++; 
    }
    
    public void deleteUser(int row) throws SQLException{ 
         String query = "DELETE FROM cutos.usertbl WHERE `userID` = " + userArr[row].getUserID();
        SystemManager.db.update(query);
                this.shiftLeft(row);
              
    }
    
          

    
    

          
    private void shiftLeft(int index) {
        for (int i = index; i < size; i++) {
            userArr[i] = userArr[i + 1];
        }
        size--;
    }
    
    
    
//    public Object[][] getUsersForTable(){ 
//        Object[][] out = new Object[size][6];
//          for (int row = 0; row < size; row++) {
//
//            out[row][0] = userArr[row].getUserID(); 
//            out[row][1] = userArr[row].getType(); 
//            out[row][2] = userArr[row].getFirstName(); 
//            out[row][3] = userArr[row].getLastName(); 
//             out[row][4] = userArr[row].getEmail(); 
//              out[row][5] = userArr[row].getPassword(); 
//        }
//        return out;
//    }

    @Override
    public int getRowCount() {
        return size; 
    }

    @Override
    public int getColumnCount() {
      return 6; 
    }

    @Override
    public String getColumnName(int columnIndex) {
        String name ="";
        switch(columnIndex){
            case 0 -> name = "user id"; 
            case 1 -> name = "Type"; 
            case 2 -> name =  "Fisrt name"; 
            case 3 -> name = "Last name"; 
            case 4 -> name = "Emai adress"; 
            case 5 -> name = "Password"; 
                    
                    } 
        return name; 
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
         Class<?> temp =getClass();
        try {
            switch(columnIndex){
                case 0 -> temp = Class.forName("java.lang.Integer");
                case 1 -> temp = Class.forName("java.lang.String");
                case 2 -> temp = Class.forName("java.lang.String");
                case 3 -> temp = Class.forName("java.lang.String");
                case 4 -> temp = Class.forName("java.lang.String");
                case 5 -> temp = Class.forName("java.lang.String");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MenuManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(columnIndex == 0)
            return false; 
        else 
            return true; 
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         Object out = new Object(); 
         switch(columnIndex){
              case 0 -> out = userArr[rowIndex].getUserID();
            case 1 -> out = userArr[rowIndex].getType();
            case 2 -> out = userArr[rowIndex].getFirstName();
            case 3 -> out = userArr[rowIndex].getLastName();
             case 4 -> out = userArr[rowIndex].getEmail();
              case 5 -> out = userArr[rowIndex].getPassword();
                  }
         return out; 
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        User currentUser = userArr[rowIndex];
        String query = "UPDATE usertbl SET "; 
       switch(columnIndex){
            case 1: 
                userArr[rowIndex].setType((String)aValue);
                query += "`workerType` = '" + (String)aValue + "' WHERE `userID` = " + currentUser.getUserID()+ ";"; 
                break; 
            case 2: 
                userArr[rowIndex].setFirstName((String)aValue);
                query += "`firstName` = '" + (String)aValue + "' WHERE `userID` = " + currentUser.getUserID()+ ";"; ; 
                 break; 
            case 3: 
                userArr[rowIndex].setLastName((String)aValue);
                 query += "`surname` = '" + (String)aValue + "' WHERE `userID` = " + currentUser.getUserID()+ ";"; ; 
                  break; 
            case 4: 
                userArr[rowIndex].setEmail((String)aValue);
                query += "`emailAdress` = '" + (String)aValue + "' WHERE `userID` = " + currentUser.getUserID()+ ";"; ; 
                 break; 
             case 5: 
                 userArr[rowIndex].setPassword((String)aValue);
                 query += "`password` = '" + (String)aValue + "' WHERE `userID` = " + currentUser.getUserID()+ ";"; ; 
                  break; 
        }
       try {
                   SystemManager.db.update(query); 
                           } catch (SQLException ex) {
                   Logger.getLogger(StudentManager.class.getName()).log(Level.SEVERE, null, ex);
               }
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
       
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
      
    }
 
    
    public boolean isUserValid(String name, String password, String type){ 
        boolean valid = false; 
        for(int i = 0; i < size; i++){ 
            if(userArr[i].getEmail().equalsIgnoreCase(name) && userArr[i].getPassword().equals(password) && userArr[i].getType().equalsIgnoreCase(type))
                valid = true; 
        }
        return valid; 
    }
}
