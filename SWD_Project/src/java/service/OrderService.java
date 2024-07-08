/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entity.Order;
import java.util.List;

/**
 *
 * @author Legion
 */
public interface OrderService {
    List<Order> getOrderHistoryByUserId(int userID);
    boolean updateStatus(int orderID, String newStatus);
    List<Order> getOrders();
}
