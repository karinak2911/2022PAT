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
import utils.DB;

/**
 *
 * @author Karinak
 */
//a list of method headers that i need to implement 
public class MenuManager implements TableModel {

    MenuItem[] menuArr = new MenuItem[200];
    int size = 0;

    public MenuManager(String typeGiven) throws SQLException {
        String query = "SELECT menuitemtbl.`itemID`, menuitemtbl.`itemName`, typetbl.`typeName`, menuitemtbl.`itemPrice` FROM menuitemtbl,typetbl\n"
                + "WHERE menuitemtbl.`typeID` = typetbl.`typeId` AND typetbl.`typeName` = '" + typeGiven + "' ;";

        ResultSet rs = SystemManager.db.query(query);

        while (rs.next()) {
            int ID = rs.getInt(1);
            String name = rs.getString(2);
            String type = rs.getString(3);
            double price = rs.getDouble(4);

            menuArr[size] = new MenuItem(ID, name, type, price);
            size++;
        }
    }

    public MenuManager() throws ClassNotFoundException, SQLException {

        String query = "SELECT menuitemtbl.`itemID`, menuitemtbl.`itemName`, typetbl.`typeName`, menuitemtbl.`itemPrice` FROM menuitemtbl,typetbl\n"
                + "WHERE menuitemtbl.`typeID` = typetbl.`typeId` ;";

        ResultSet rs = SystemManager.db.query(query);

        while (rs.next()) {
            int ID = rs.getInt(1);
            String name = rs.getString(2);
            String type = rs.getString(3);
            double price = rs.getDouble(4);

            menuArr[size] = new MenuItem(ID, name, type, price);
            size++;
        }

    }

    public void add(String name, String type, double price) throws SQLException {
        String query2 = "SELECT `typeId` FROM typetbl WHERE `typeName` = '" + type + "';";
        ResultSet rs = SystemManager.db.query(query2);
    
        int typeID = 0;
        rs.next();
        typeID = rs.getInt(1);

        String query = " INSERT INTO menuitemtbl ( `itemName`, `typeID`, `itemPrice`) VALUES ( ' " + name + "' , '" + typeID + "'," + price + ");";

        SystemManager.db.update(query);
        menuArr[size] = new MenuItem(name, type, price);
        size++;

    }

    public void remove(int row) throws SQLException {
        String query = "DELETE FROM menuitemtbl WHERE `itemID` = " + menuArr[row].getMenuItemID();
        SystemManager.db.update(query);
        this.shiftLeft(row);

    }

    private void shiftLeft(int index) {
        for (int i = index; i < size; i++) {
            menuArr[i] = menuArr[i + 1];
        }
        size--;
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
        String name = "";
        switch (columnIndex) {
            case 0 ->
                name = "ID";
            case 1 ->
                name = "Name";
            case 2 ->
                name = "Type";
            case 3 ->
                name = "Price";

        }

        return name;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class<?> temp = getClass();
        try {
            switch (columnIndex) {
                case 0 ->
                    temp = Class.forName("java.lang.Integer");
                case 1 ->
                    temp = Class.forName("java.lang.String");
                case 2 ->
                    temp = Class.forName("java.lang.String");
                case 3 ->
                    temp = Class.forName("java.lang.Double");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MenuManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return false;
        } else {
            return true;
        }

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object out = new Object();
        switch (columnIndex) {
            case 0 ->
                out = menuArr[rowIndex].getMenuItemID();
            case 1 ->
                out = menuArr[rowIndex].getItemName();
            case 2 ->
                out = menuArr[rowIndex].getItemType();
            case 3 ->
                out = menuArr[rowIndex].getPrice();

        }

        return out;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        String query = "UPDATE menuitemtbl SET ";
        MenuItem m = menuArr[rowIndex];
        switch (columnIndex) {
            case 1:
                menuArr[rowIndex].setItemName((String) aValue);
                query += "`itemName` = '" + ((String) aValue) + "' WHERE `itemID` = " + m.getMenuItemID() + ";";

                break;

            case 2:
                menuArr[rowIndex].setItemType((String) aValue);
                query += "`typeID`= (SELECT `typeID` FROM typetbl WHERE `typeName` = '" + ((String) aValue) + "') WHERE `itemID` = " + m.getMenuItemID() + ";";

                break;
            case 3:
                menuArr[rowIndex].setPrice(((Double) aValue).doubleValue());
                query += "`itemPrice` = " + (((Double) aValue).doubleValue()) + " WHERE `typeID` = " + m.getMenuItemID() + ";";

                break;
            //redo

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
}
