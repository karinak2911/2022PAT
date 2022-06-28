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
import objects.Order;
import objects.OrderedItem;

/**
 *
 * @author Karinak
 */
public class OrdersManager implements TableModel{
    
    Order[] ordersArr = new Order[200]; 
    int size = 0; 
    private int waiterID; 

    public OrdersManager() throws SQLException {
          String query = "SELECT orderstbl.`OrderID`, \n" +
"CONCAT(studentstbl.`firstName` , \" \", studentstbl.surname) AS full_name, \n" +
" SUM(menuitemtbl.`itemPrice` * ordereditemtbl.quantity) AS order_total, \n" +
"orderstbl.`PaymentMethod`, \n" +
"orderstbl.`UserID`, \n" +
"orderstbl.collected\n" +
" FROM orderstbl,studentstbl,ordereditemtbl, menuitemtbl\n" +
"WHERE orderstbl.`OrderID` = ordereditemtbl.`orderID` AND orderstbl.`StudentID` = studentstbl.`StudentID`  AND ordereditemtbl.`menuItemID` = menuitemtbl.`itemID`\n" +
"GROUP BY orderstbl.`OrderID`;"; 
         ResultSet rs = SystemManager.db.query(query); 
         while(rs.next()){ 
             int orderId = rs.getInt(1); 
             String studentFullName = rs.getString(2); 
             double price = rs.getDouble(3);
             String paymentMethod = rs.getString(4); 
             int userID = rs.getInt(5); 
             int collectedTinyInt = rs.getInt(6); 
             boolean collected = false;
             if(collectedTinyInt == 1)
                 collected = true; 
             
             ordersArr[size] = new Order(orderId, studentFullName, price, paymentMethod, userID, collected); 
             size++; 
         }
        
        
    }
    
    public OrdersManager(int waiterID) throws SQLException{ 
        String query = "SELECT orderstbl.`OrderID`, \n" +
"CONCAT(studentstbl.`firstName` , \" \", studentstbl.surname) AS full_name, \n" +
" SUM(menuitemtbl.`itemPrice` * ordereditemtbl.quantity) AS order_total, \n" +
"orderstbl.`PaymentMethod`, \n" +
"orderstbl.`UserID`, \n" +
"orderstbl.collected\n" +
" FROM orderstbl,studentstbl,ordereditemtbl, menuitemtbl\n" +
"WHERE orderstbl.`OrderID` = ordereditemtbl.`orderID` AND orderstbl.`StudentID` = studentstbl.`StudentID`  AND ordereditemtbl.`menuItemID` = menuitemtbl.`itemID` AND orderstbl.`UserID` =  " + waiterID + "\n" + 
"GROUP BY orderstbl.`OrderID`;"; 
        
        ResultSet rs = SystemManager.db.query(query); 
         while(rs.next()){ 
             int orderId = rs.getInt(1); 
             String studentFullName = rs.getString(2); 
             double price = rs.getDouble(3);
             String paymentMethod = rs.getString(4); 
             int userID = rs.getInt(5); 
             int collectedTinyInt = rs.getInt(6); 
             boolean collected = false;
             if(collectedTinyInt == 1)
                 collected = true; 
             
             ordersArr[size] = new Order(orderId, studentFullName, price, paymentMethod, userID, collected); 
             size++; 
        
    }
    } 
    
  
    public void addOrder(int studentID, String paymentMethod, int userID, int collected) throws SQLException{ 
        String query = "INSERT INTO cutos.orderstbl (`StudentID`, `PaymentMethod`, `UserID`, `Collected`) \n" +
"	VALUES (" + studentID + ", '" + paymentMethod + "', " + userID + ", " + collected + ");"; 
            System.out.println(query);
             SystemManager.db.update(query);
            
    }
    

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
            case 0 -> name = "order id"; 
            case 1 -> name = "Student full name"; 
            case 2 -> name =  "Total price"; 
            case 3 -> name = "Payment method"; 
            case 4 -> name = "user ID"; 
            case 5 -> name = "collected"; 
                    
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
                case 2 -> temp = Class.forName("java.lang.Double");
                case 3 -> temp = Class.forName("java.lang.String");
                case 4 -> temp = Class.forName("java.lang.Integer");
                case 5 -> temp = Class.forName("java.lang.Boolean");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MenuManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
//            if(columnIndex == 5)
//                return true; 
//            else 
//                return false; 
       return true; 
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        System.out.println(rowIndex);
        Object out = new Object(); 
         switch(columnIndex){
              case 0 -> out = ordersArr[rowIndex].getOrderID();
            case 1 ->  out = ordersArr[rowIndex].getStudentFullname();
            case 2 -> out = ordersArr[rowIndex].getPrice();
            case 3 -> out = ordersArr[rowIndex].getPaymentMeothod();
             case 4 -> out = ordersArr[rowIndex].getUserID();
              case 5 -> out = ordersArr[rowIndex].isCollected();
 
                  }
         return out; 
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Order o = ordersArr[rowIndex];
         String query = "UPDATE orderstbl SET `Collected` = 1 WHERE `OrderID` = " + o.getOrderID() + ";";
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
    
    
    public String print(){ 
        return ordersArr[1].getStudentFullname(); 
    }
    
    
    public String[] getOrderedItemsForOrder(int rowIndex) throws SQLException{ 
        Order o = ordersArr[rowIndex]; 
        String[] out = new String[200]; 
        int strSize = 0; 
        String query = "SELECT CONCAT(menuitemtbl.`itemName`, \" \", typetbl.`typeName`) AS menu_item, \n" +
"ordereditemtbl.quantity \n" +
" FROM ordereditemtbl,orderstbl,menuitemtbl, typetbl \n" +
"WHERE menuitemtbl.`typeID` = typetbl.`typeId` AND ordereditemtbl.`orderID` = orderstbl.`OrderID` AND ordereditemtbl.`menuItemID` = menuitemtbl.`itemID` AND orderstbl.`OrderID` = " + o.getOrderID() + ";"; 
        
        ResultSet rs = SystemManager.db.query(query); 
         while(rs.next()){ 
             String menu_item = rs.getString(1); 
             int quantity = rs.getInt(2); 
             
             
             out[strSize] = menu_item + "\t\t" + quantity + "\n";  
             strSize++; 
         }
        
        return out; 
        
    }
    
 
}
