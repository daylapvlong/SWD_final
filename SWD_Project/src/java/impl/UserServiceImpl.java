package impl;

import model.User;
import service.UserService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    private Connection connection;

    public UserServiceImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public User getUserById(int userId) {
        String sql = "SELECT * FROM [User] WHERE UserId = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, userId);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new User(
                    rs.getInt("UserId"),
                    rs.getString("UserName"),
                    rs.getString("Password"),
                    rs.getString("Name"),
                    rs.getString("Phone"),
                    rs.getString("Email"),
                    rs.getString("Address"),
                    rs.getString("Role")
                );
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}
