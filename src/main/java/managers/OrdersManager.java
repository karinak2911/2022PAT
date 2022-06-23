/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managers;

import java.sql.ResultSet;
import java.sql.SQLException;
import objects.Order;

/**
 *
 * @author Karinak
 */
public class OrdersManager {
    
    Order[] ordersARR = new Order[200]; 
    int size = 0; 

    public OrdersManager() throws SQLException {
          String query = "SELECT * FROM orderstbl;"; 
         ResultSet rs = SystemManager.db.query(query); 
         while(rs.next()){ 
             int orderId = rs.
         }
        
        
    }
    
    
    
}
