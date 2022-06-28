/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objects;

/**
 *
 * @author Karinak
 */
public class OrderedItem extends MenuItem {
    private int quantity; 

    public OrderedItem(int quantity, int menuItemID, String itemName, String itemType, double price) {
        super(menuItemID, itemName, itemType, price);
        this.quantity = quantity;
    }

    public OrderedItem(int quantity, String itemName, String itemType, double price) {
        super(itemName, itemType, price);
        this.quantity = quantity;
    }
    
    

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public double getTotalPriceOfOrderedItem() {
        return this.quantity * this.getPrice();
    }
    
    
}
