package impl;

import dal.DBContext;
import model.Book;
import model.User;
import service.BookService;
import service.UserService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BookService {
    private Connection connection;

    public BookServiceImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> listB = new ArrayList<>();

        String sql = "SELECT b.BookId, b.BookName, b.Author, b.Publisher, " +
                "b.Description, b.Price, b.StockQuantity, b.CommentId, b.CategoryId, b.Status, u.Name " +
                "FROM Book b " +
                "LEFT JOIN Comment c ON b.CommentId = c.CommentId " +
                "LEFT JOIN [User] u ON c.UserId = u.UserId";
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

    @Override
    public Book getBookById(int bookId) {
        String sql = "SELECT b.BookId, b.BookName, b.Author, b.Publisher, " +
                "b.Description, b.Price, b.StockQuantity, b.CommentId, b.CategoryId, b.Status, u.Name " +
                "FROM Book b " +
                "LEFT JOIN Comment c ON b.CommentId = c.CommentId " +
                "LEFT JOIN [User] u ON c.UserId = u.UserId " +
                "WHERE b.BookId = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, bookId);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                int bookId1 = rs.getInt("BookId");
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

                Book book = new Book(bookId1, bookName, author, publisher, description, price, stockQuantity, commentId, categoryId, status);
                book.setUser(user);

                return book;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public void updateBookStatus(int bookId, int status) {
        String sql = "UPDATE Book SET Status = ? WHERE BookId = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, status);
            st.setInt(2, bookId);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
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
    
    public static void main(String[] args) {
        DBContext dbContext = new DBContext();
        BookServiceImpl bookService = new BookServiceImpl(dbContext.getConnection());

        // Test updating book status
        int testBookId = 1; // Replace with an actual book ID
        int newStatus = 2; // 1: Pending, 2: Approved, 3: Rejected

        System.out.println("Updating book status...");
        bookService.updateBookStatus(testBookId, newStatus);

        // Fetch the book to verify the update
        Book updatedBook = bookService.getBookById(testBookId);
        if (updatedBook != null) {
            System.out.println("Book ID: " + updatedBook.getBookId());
            System.out.println("Book Status: " + updatedBook.getStatus());
        } else {
            System.out.println("Book not found.");
        }
    }
}
