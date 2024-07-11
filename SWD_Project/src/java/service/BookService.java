package service;

import model.Book;
import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    Book getBookById(int bookId);
    void updateBookStatus(int bookId, int status);
    void deleteBookById(int bookId);
}
