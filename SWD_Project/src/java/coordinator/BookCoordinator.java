package coordinator;

import impl.BookServiceImpl;
import service.BookService;
import dal.DBContext;

import java.sql.Connection;

public class BookCoordinator {
    private BookService bookService;

    public BookCoordinator(DBContext dbContext) {
        Connection connection = dbContext.getConnection();
        this.bookService = new BookServiceImpl(connection);
    }

    public BookService getBookService() {
        return bookService;
    }
}
