/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Legion
 */
import java.util.Date;

public class Order {
    private int orderID;
    private int paymentID;
    private int userID;
    private Date orderDate;
    private int totalQuantity;
    private String status;
    private String note;

    public Order() {
    }

    public Order(int orderID, int paymentID, int userID, Date orderDate, int totalQuantity, String status, String note) {
        this.orderID = orderID;
        this.paymentID = paymentID;
        this.userID = userID;
        this.orderDate = orderDate;
        this.totalQuantity = totalQuantity;
        this.status = status;
        this.note = note;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", paymentID=" + paymentID +
                ", userID=" + userID +
                ", orderDate=" + orderDate +
                ", totalPrice=" + totalQuantity +
                ", status='" + status + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}

