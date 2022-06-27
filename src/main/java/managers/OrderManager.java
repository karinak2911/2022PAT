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
import objects.OrderedItem;

/**
 *
 * @author Karinak
 */
public class OrderManager implements TableModel{
    
    OrderedItem[] orderedItemArr = new OrderedItem[200]; 
    int size = 0; 

    
    public OrderManager(int id) throws SQLException{ 
        String query = "SELECT menuitemtbl.`itemName`, typetbl.`typeName`, menuitemtbl.`itemPrice`, ordereditemtbl.quantity \n" +
" FROM ordereditemtbl,orderstbl,menuitemtbl, typetbl \n" +
"WHERE menuitemtbl.`typeID` = typetbl.`typeId` AND ordereditemtbl.`orderID` = orderstbl.`OrderID` AND ordereditemtbl.`menuItemID` = menuitemtbl.`itemID` AND orderstbl.`OrderID` = " + id +
";"; 
        
        ResultSet rs = SystemManager.db.query(query); 
         while(rs.next()){ 
             String name = rs.getString(1); 
             String type = rs.getString(2); 
             double price = rs.getDouble(3); 
             int quantity = rs.getInt(4); 
             
             orderedItemArr[size] = new OrderedItem(quantity, name, type, price); 
             size++; 
             
         }
       
    }

    public OrderManager() {
    }
    
    

    @Override
    public int getRowCount() {
        return size; 
    }

    @Override
    public int getColumnCount() {
        return 4; 
    }

    @Override
    public String getColumnName(int columnIndex) {
         String name ="";
        switch(columnIndex){
            case 0 -> name = "MenuItemName"; 
            case 1 -> name = "MenuItmeType"; 
            case 2 -> name =  "MenuItmePrice"; 
            case 3 -> name = "Quantity"; 
                    
                    } 
        return name; 
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class<?> temp =getClass();
        try {
            switch(columnIndex){
                case 0 -> temp = Class.forName("java.lang.String");
                case 1 -> temp = Class.forName("java.lang.String");
                case 2 -> temp = Class.forName("java.lang.Double");
                case 3 -> temp = Class.forName("java.lang.Integer");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MenuManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp;

    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
       return false; 
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object out = new Object();
        switch(columnIndex){
            case 0 -> out = orderedItemArr[rowIndex].getItemName();
            case 1 -> out = orderedItemArr[rowIndex].getItemType();
            case 2 -> out = orderedItemArr[rowIndex].getPrice();
            case 3 -> out = orderedItemArr[rowIndex].getQuantity();
            
        }
        
        return out;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        
    }
    
}
