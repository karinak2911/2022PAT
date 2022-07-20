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
import objects.MenuItem;

/**
 *
 * @author Karinak
 */
public class StaticsManager implements TableModel{
    
    MenuItem[] menuArr = new MenuItem[200]; 
    int size = 0;
    
    
    public StaticsManager() throws SQLException{ 
        
        String query = "SELECT menuitemtbl.`itemName`, typetbl.`typeName`, menuitemtbl.`itemPrice`, SUM(ordereditemtbl.quantity) AS times_sold\n" +
" FROM ordereditemtbl, typetbl, menuitemtbl\n" +
"WHERE typetbl.`typeId` = menuitemtbl.`typeID` AND ordereditemtbl.`menuItemID` = menuitemtbl.`itemID`\n" +
"GROUP BY menuitemtbl.`itemID`"
                + ";"; 
        System.out.println(query);
        ResultSet rs = SystemManager.db.query(query); 
         while(rs.next()){ 
            String menuItemName = rs.getString(1); 
             String typeName = rs.getString(2); 
             double price = rs.getDouble(3); 
             int timesSold = rs.getInt(4); 
             
             menuArr[size] = new MenuItem(menuItemName, typeName, price, timesSold); 
             size++; 
         }
        
    }
    
    
    public void orderArray(boolean asc){ 
        if(asc){ 
            for (int currentIndex = size - 1; currentIndex >= 0; currentIndex--) {
            boolean sorted = true;
            for (int i = 0; i < currentIndex; i++) {
                if (menuArr[i].getTimesSold() > (menuArr[i + 1]).getTimesSold()) {
                    MenuItem temp = menuArr[i];
                    menuArr[i] = menuArr[i + 1];
                    menuArr[i + 1] = temp;
                    sorted = false;
                }

            }
            // outside inner for loop!!!
            if (sorted) {
                break;
            }
        }
    }
        else { 
             for (int currentIndex = size - 1; currentIndex >= 0; currentIndex--) {
            boolean sorted = true;
            for (int i = 0; i < currentIndex; i++) {
                if (menuArr[i].getTimesSold() < (menuArr[i + 1]).getTimesSold()) {
                    MenuItem temp = menuArr[i];
                    menuArr[i] = menuArr[i + 1];
                    menuArr[i + 1] = temp;
                    sorted = false;
                }

            }
            // outside inner for loop!!!
            if (sorted) {
                break;
            }
        }
        }
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
            case 0 -> name = "Name";
            case 1 -> name = "Type";
            case 2 -> name = "Price";
            case 3 -> name = "Times Sold";
            
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
            case 0 -> out = menuArr[rowIndex].getItemName();
            case 1 -> out = menuArr[rowIndex].getItemType();
            case 2 -> out = menuArr[rowIndex].getPrice();
            case 3 -> out = menuArr[rowIndex].getTimesSold();
            
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
