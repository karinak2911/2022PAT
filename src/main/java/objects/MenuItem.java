/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objects;

/**
 *
 * @author Karinak
 */
public class MenuItem {
    private int menuItemID; 
    private String itemName; 
    private String itemType; 
    private double price; 

    public MenuItem() {
    }

    public MenuItem(int menuItemID, String itemName, String itemType, double price) {
        this.menuItemID = menuItemID;
        this.itemName = itemName;
        this.itemType = itemType;
        this.price = price;
    }

    public MenuItem(String itemName, String itemType, double price) {
        this.itemName = itemName;
        this.itemType = itemType;
        this.price = price;
    }
    
    

    public int getMenuItemID() {
        return menuItemID;
    }

    public void setMenuItemID(int menuItemID) {
        this.menuItemID = menuItemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
    
}
