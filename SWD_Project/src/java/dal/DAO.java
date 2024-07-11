/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Book;
import model.Comment;
import model.User;

/**
 *
 * @author Admin
 */
public class DAO extends DBContext {

    public List<Book> getAllBook() {
        List<Book> listB = new ArrayList<>();

        String sql = "SELECT b.BookId, b.BookName, b.Author, b.Publisher, \n"
                + "b.Description, b.Price, b.StockQuantity, b.CommentId, b.CategoryId, b.Status, u.Name \n"
                + "FROM Book b \n"
                + "LEFT JOIN Comment c ON b.CommentId = c.CommentId \n"
                + "LEFT JOIN [User] u ON c.UserId = u.UserId";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int bookId = rs.getInt("BookId");
                String bookName = rs.getString("BookName");
                String author = rs.getString("Author");
                String publisher = rs.getString("Publisher");
                String description = rs.getString("Description");
                double price = rs.getDouble("Price");
                int stockQuantity = rs.getInt("StockQuantity");
                int commentId = rs.getInt("CommentId");
                int categoryId = rs.getInt("CategoryId");
                int status = rs.getInt("Status");
                String userName = rs.getString("Name");

                User user = new User();
                user.setName(userName);

                Book book = new Book(bookId, bookName, author, publisher, description, price, stockQuantity, commentId, categoryId, status);
                book.setUser(user);

                listB.add(book);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listB;
    }

    public Book getBookById(int bookId) {
        String sql = "SELECT b.BookId, b.BookName, b.Author, b.Publisher, "
                + "b.Description, b.Price, b.StockQuantity, b.CommentId, b.CategoryId, b.Status, u.Name "
                + "FROM Book b "
                + "LEFT JOIN Comment c ON b.CommentId = c.CommentId "
                + "LEFT JOIN [User] u ON c.UserId = u.UserId "
                + "WHERE b.BookId = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, bookId);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("BookId");
                String bookName = rs.getString("BookName");
                String author = rs.getString("Author");
                String publisher = rs.getString("Publisher");
                String description = rs.getString("Description");
                double price = rs.getDouble("Price");
                int stockQuantity = rs.getInt("StockQuantity");
                int commentId = rs.getInt("CommentId");
                int categoryId = rs.getInt("CategoryId");
                int status = rs.getInt("Status");
                String userName = rs.getString("Name");

                User user = new User();
                user.setName(userName);

                Book book = new Book(id, bookName, author, publisher, description, price, stockQuantity, commentId, categoryId, status);
                book.setUser(user);

                return book;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateBookStatus(int bookId, int status) {
        String sql = "UPDATE Book SET Status = ? WHERE BookId = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, status);
            st.setInt(2, bookId);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteBookById(int bookId) {
    String sql = "DELETE FROM Book WHERE BookId = ?";
    try {
        PreparedStatement st = connection.prepareStatement(sql);
        st.setInt(1, bookId);
        st.executeUpdate();
    } catch (SQLException e) {
        System.out.println(e);
    }
}

//    public static void main(String[] args) {
//        DAO bookDAO = new DAO();
//        List<Book> books = bookDAO.getAllBook();
//        for (Book book : books) {
//            System.out.println("Book Name: " + book.getBookName() + ", Owned by: " + book.getUser().getName());
//        }
//    }
    public static void main(String[] args) {
        DAO bookDAO = new DAO();
        Book book = bookDAO.getBookById(1); // Thay thế 1 bằng ID bạn muốn kiểm tra
        if (book != null) {
            System.out.println("Book ID: " + book.getBookId());
            System.out.println("Book Name: " + book.getBookName());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Publisher: " + book.getPublisher());
            System.out.println("Description: " + book.getDescription());
            System.out.println("Price: " + book.getPrice());
            System.out.println("Stock Quantity: " + book.getStockQuantity());
            System.out.println("Comment ID: " + book.getCommentId());
            System.out.println("Category ID: " + book.getCategoryId());
            System.out.println("Status: " + book.getStatus());
            System.out.println("User Name: " + book.getUser().getName());
        } else {
            System.out.println("Book not found.");
        }
    }
}
