/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package impl;

import dal.DBContext;
import entity.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import service.BookService;

/**
 *
 * @author admin's
 */
public class BookServiceImpl extends DBContext implements BookService{
    Connection connection;

    public BookServiceImpl() {
        try {
            this.connection = getConnection();
        } catch (Exception e) {
        }
    }
    
    @Override
    public List<Book> getAllBook() {
        List<Book> list = new ArrayList<>();
        String query = "SELECT * FROM Book";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setBookId(rs.getInt("BookId"));
                book.setCommentId(rs.getInt("CommentId"));
                book.setCategoryId(rs.getInt("CategoryId"));
                book.setBookName(rs.getString("setBookName"));
                book.setAuthor(rs.getString("Author"));
                book.setPublisher(rs.getString("Publisher"));
                book.setPrice(rs.getFloat("Price"));
                book.setDescription(rs.getString("Description"));
                book.setStockQuantity(rs.getInt("StockQuantity"));
                list.add(book);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }
    
    public static void main(String[] args) {
        BookServiceImpl bookService = new BookServiceImpl();
        List<Book> books = bookService.getAllBook();
        
        if (books != null) {
            for (Book book : books) {
                System.out.println("Book ID: " + book.getBookId());
                System.out.println("Comment ID: " + book.getCommentId());
                System.out.println("Category ID: " + book.getCategoryId());
                System.out.println("Book Name: " + book.getBookName());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Publisher: " + book.getPublisher());
                System.out.println("Price: " + book.getPrice());
                System.out.println("Description: " + book.getDescription());
                System.out.println("Stock Quantity: " + book.getStockQuantity());
                System.out.println("---------------------------");
            }
        } else {
            System.out.println("No books found or an error occurred.");
        }
    }
}

