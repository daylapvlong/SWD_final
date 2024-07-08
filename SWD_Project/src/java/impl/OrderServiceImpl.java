/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package impl;

import dal.DBContext;
import entity.Order;
import service.OrderService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Legion
 */
public class OrderServiceImpl extends DBContext implements OrderService{
    
    Connection connection;

    public OrderServiceImpl() {
        try {
            this.connection = getConnection();
        } catch (Exception e) {
        }
    }
    
    

    @Override
    public List<Order> getOrderHistoryByUserId(int userID) {
        List<Order> orderHistory = new ArrayList<>();
        String query = "SELECT * FROM [Order] WHERE userID = ?";

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, userID);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Order order = new Order();
                order.setOrderID(rs.getInt("orderID"));
                order.setPaymentID(rs.getInt("paymentID"));
                order.setUserID(rs.getInt("userID"));
                order.setOrderDate(rs.getDate("orderDate"));
                order.setTotalQuantity(rs.getInt("totalQuantity"));
                order.setStatus(rs.getString("status"));
                order.setNote(rs.getString("Note"));
                orderHistory.add(order);
            }

        } catch (SQLException e) {
            System.out.println("getOrderHistoryByUserId: " + e.getMessage());
        }

        return orderHistory;
    }

    @Override
    public boolean updateStatus(int orderID, String newStatus) {
        String query = "UPDATE [Order] SET status = ? WHERE orderID = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, newStatus);
            ps.setInt(2, orderID);
            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.out.println("updateStatus: " + e.getMessage());
        }
        return false;
    }

    @Override
    public List<Order> getOrders() {
        List<Order> orderHistory = new ArrayList<>();
        String query = "SELECT * FROM [Order]";

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Order order = new Order();
                order.setOrderID(rs.getInt("orderID"));
                order.setPaymentID(rs.getInt("paymentID"));
                order.setUserID(rs.getInt("userID"));
                order.setOrderDate(rs.getDate("orderDate"));
                order.setTotalQuantity(rs.getInt("totalQuantity"));
                order.setStatus(rs.getString("status"));
                order.setNote(rs.getString("Note"));
                orderHistory.add(order);
            }

        } catch (SQLException e) {
            System.out.println("getOrders: " + e.getMessage());
        }

        return orderHistory;
    }
    
}
