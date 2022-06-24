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
    private String studentName; 
    private double price; 
    private String paymentMeothod; 
    private int userID; 
    private boolean collected; 
   

    public Order(int orderID, String studentName, double price,String paymentMeothod ,int userID, boolean collected ) {
        this.orderID = orderID;
        this.studentName = studentName;
        this.price = price;
        this.userID = userID;
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
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getUserID() {
        return userID;
    }

    public void setUser(int userId) {
        this.userID = userId;
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
