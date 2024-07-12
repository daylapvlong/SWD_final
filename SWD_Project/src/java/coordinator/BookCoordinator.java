/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coordinator;

import impl.BookServiceImpl;
import service.BookService;

/**
 *
 * @author admin's
 */
public class BookCoordinator {
    private BookService bookService;
    
    public BookCoordinator() {
        bookService = new BookServiceImpl();
    }
    
    public BookService getBookService() {
        return bookService;
    }

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }
}
