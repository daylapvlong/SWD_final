/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package impl;

import dal.DBContext;
import entity.User;
import service.UserService;
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
public class UserServiceImpl extends DBContext implements UserService{
    
    Connection connection;

    public UserServiceImpl() {
        try {
            this.connection = getConnection();
        } catch (Exception e) {
        }
    }
    
    @Override
    public User authenticate(String username, String password) {
        String query = "SELECT * FROM [User] WHERE UserName = ? AND Password = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                User user = new User();
                user.setUserID(rs.getInt("UserId"));
                user.setUsername(rs.getString("UserName"));
                user.setPassword(rs.getString("Password"));
                user.setName(rs.getString("Name"));
                user.setPhone(rs.getString("Phone"));
                user.setEmail(rs.getString("Email"));
                user.setAddress(rs.getString("Address"));
                user.setRole(rs.getString("Role"));
                return user;
            }
        } catch (SQLException e) {
            System.out.println("authenticate: " + e.getMessage());
        }
        return null;
    }
}
