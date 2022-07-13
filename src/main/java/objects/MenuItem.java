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
    private int timesSold; 

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

    public MenuItem(String itemName, String itemType, double price, int timesSold) {
        this.itemName = itemName;
        this.itemType = itemType;
        this.price = price;
        this.timesSold = timesSold;
    }

    public void setTimesSold(int timesSold) {
        this.timesSold = timesSold;
    }

    public int getTimesSold() {
        return timesSold;
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
    
    
    private static boolean hasLettersOrSpaceOnly(String idNumber){
        for(char c: idNumber.toCharArray()){
            if(!Character.isAlphabetic(c) && !Character.isSpaceChar(c))
            {
                return false;
            }
        }
        return true;
    }
    
     private static boolean hasNumbersOnly(String price){
        for(char c: price.toCharArray()){
            if(!Character.isDigit(c))
            {
                return false;
            }
        }
        return true;
    }
    
    
    public static boolean isValidMenuitemName(String name){ 
        return hasLettersOrSpaceOnly(name); 
    }

    
}
