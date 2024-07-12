/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entity.Book;
import java.util.List;

/**
 *
 * @author admin's
 */
public interface CookieService {
    List<Book> CookieToProduct(String cart);
    String addToCart(String cart, String bookId);
}
