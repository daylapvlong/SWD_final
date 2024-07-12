/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import entity.Book;
import java.util.List;

/**
 *
 * @author admin's
 */
public interface BookService {
    List<Book> getAllBook();
    Book getBookById(int bookId);
    void updateBookStatus(int bookId, int status);
    void deleteBookById(int bookId);
}
