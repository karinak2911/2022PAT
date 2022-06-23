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
    private User user; 
   

    public Order(int orderID, String studentName, double price,String paymentMeothod ,User user ) {
        this.orderID = orderID;
        this.studentName = studentName;
        this.price = price;
        this.user = user;
        this.paymentMeothod = paymentMeothod;
    }
    
    
    

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getStudentName() {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPaymentMeothod() {
        return paymentMeothod;
    }

    public void setPaymentMeothod(String paymentMeothod) {
        this.paymentMeothod = paymentMeothod;
    }
    
    
    
    
}
