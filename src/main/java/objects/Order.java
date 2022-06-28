/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objects;

/**
 *
 * @author Karinak
 */
public class Order {
    private int orderID; 
    private String studentFullName; 
    private double totalPrice; 
    private String paymentMeothod; 
    private int waiterID; 
    private boolean collected; 
   

    public Order(int orderID, String studentName, double price,String paymentMeothod ,int userID, boolean collected ) {
        this.orderID = orderID;
        this.studentFullName = studentName;
        this.totalPrice = price;
        this.waiterID = userID;
        this.paymentMeothod = paymentMeothod;
        this.collected = collected; 
    }
    
    
    

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getStudentFullname() {
        return studentFullName;
    }

    public void setStudentName(String studentName) {
        this.studentFullName = studentName;
    }


    public double getPrice() {
        return totalPrice;
    }

    public void setPrice(double price) {
        this.totalPrice = price;
    }

    public int getUserID() {
        return waiterID;
    }

    public void setUser(int userId) {
        this.waiterID = userId;
    }

    public String getPaymentMeothod() {
        return paymentMeothod;
    }

    public void setPaymentMeothod(String paymentMeothod) {
        this.paymentMeothod = paymentMeothod;
    }

    public boolean isCollected() {
        return collected;
    }

    public void setCollected(boolean collected) {
        this.collected = collected;
    }
    
    
    
    
    
    
}
