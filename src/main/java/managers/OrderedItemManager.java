/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managers;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import objects.OrderedItem;

/**
 *
 * @author Karinak
 */
public class OrderedItemManager implements TableModel{

    OrderedItem[] orderedItemArr = new OrderedItem[200]; 
    private int size = 0; 

    public OrderedItemManager() {
 
    }
    
    public void addOrderedItem(int menuId, String menuName, String menuType,double price, int quantity){
         orderedItemArr[size] = new OrderedItem(quantity, menuId, menuName, menuType, price); 
         size++; 
    }
    
    public void deleteOrderedItem(int menuId){ 
        for(int i = 0; i < size; i++){ 
            if(orderedItemArr[i].getMenuItemID() == menuId)
                this.shiftLeft(i);
        }
    }
    
    
     private void shiftLeft(int index) {
        for (int i = index; i < size; i++) {
            orderedItemArr[i] = orderedItemArr[i + 1];
        }
        size--;
    }
    
    
    public double getTotalPriceOfOrder() {
        double total = 0;
        for (int i = 0; i < size; i++) {
            total += orderedItemArr[i].getTotalPriceOfOrderedItem();
        }
        return total;
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
            case 0 -> name = "ID";
            case 1 -> name = "Name";
            case 2 -> name = "Type";
            case 3 -> name = "Price";
            case 4 -> name = "Quantity";
            case 5 -> name = "Total";
            
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
                case 3 -> temp = Class.forName("java.lang.Double");
                case 4 -> temp = Class.forName("java.lang.Integer");
                case 5 -> temp = Class.forName("java.lang.Double");
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
            case 0 -> out = orderedItemArr[rowIndex].getMenuItemID();
            case 1 -> out = orderedItemArr[rowIndex].getItemName();
            case 2 -> out = orderedItemArr[rowIndex].getItemType();
            case 3 -> out = orderedItemArr[rowIndex].getPrice();
              case 4 -> out = orderedItemArr[rowIndex].getQuantity();
                case 5 -> out = orderedItemArr[rowIndex].getTotalPriceOfOrderedItem();
            
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
    
