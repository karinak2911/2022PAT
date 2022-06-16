/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managers;

import java.sql.ResultSet;
import java.sql.SQLException;
import objects.MenuItem;
import utils.DB;

/**
 *
 * @author Karinak
 */
public class MenuManager {
    MenuItem[] menuArr = new MenuItem[200]; 
    int size = 0; 
    
    public MenuManager() throws ClassNotFoundException, SQLException{
       
        String query = "SELECT menuitemtbl.`itemID`, menuitemtbl.`itemName`, typetbl.`typeName`, menuitemtbl.`itemPrice` FROM menuitemtbl,typetbl\n" +
"WHERE menuitemtbl.`typeID` = typetbl.`typeId` ;";
        
        ResultSet rs = SystemManager.db.query(query);
        
        while(rs.next()){
            int ID = rs.getInt(1); 
            String name = rs.getString(2); 
            String type = rs.getString(3); 
            double price = rs.getDouble(4); 
            
            
            menuArr[size] = new MenuItem(ID, name, type, price);
            size++;
        }
    
    }
       public Object[][] getMenuForTable() {

        Object[][] out = new Object[size][3];

        for (int row = 0; row < size; row++) {

            out[row][0] = menuArr[row].getItemName();
            out[row][1] = menuArr[row].getItemType();
            out[row][2] = new Double(menuArr[row].getPrice());
        }
        return out;
    }

    public void add(String name, String type, double price) throws SQLException{
        ResultSet rs = SystemManager.db.query("SELECT `typeId` FROM typetbl WHERE `typeName` = '" + type + "';");
        int typeID = 0; 
        rs.next();
         typeID = rs.getInt(1);
        
        String query = " INSERT INTO cutos.menuitemtbl ( `itemName`, `typeID`, `itemPrice`) VALUES ( ' " + name + "' , '"  + typeID + "'," + price + ");";  
        
       SystemManager.db.update(query);
        menuArr[size] = new MenuItem(name, type, price);
        size++; 
        

        
    }
    
    public void remove(String name, String type) throws SQLException{ 
        ResultSet rs =  SystemManager.db.query("SELECT `typeId` FROM typetbl WHERE `typeName` = '" + type + "';");
        int typeID = 0; 
        rs.next(); 
        typeID = rs.getInt(1); 
        
        String query = "DELETE FROM cutos.menuitemtbl WHERE `itemName` = '" + name + "' AND `typeID` = " + typeID;
        SystemManager.db.update(query);
          for (int i = 0; i < size; i++) {
            if (menuArr[i].getItemName().equalsIgnoreCase(name) && menuArr[i].getItemType().equalsIgnoreCase(type)) {
                this.shiftLeft(i);
            }
    }
    
          

    
    
}
          
    private void shiftLeft(int index) {
        for (int i = index; i < size; i++) {
            menuArr[i] = menuArr[i + 1];
        }
        size--;
    }