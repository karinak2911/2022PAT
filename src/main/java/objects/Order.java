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
    private int studentID; 
    private double price; 
    private User user; 
    private String paymentMeothod; 

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
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
