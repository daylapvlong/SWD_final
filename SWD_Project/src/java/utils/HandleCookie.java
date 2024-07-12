/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import entity.Book;
import impl.BookServiceImpl;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.List;
import service.CookieService;

/**
 *
 * @author ASUS PC
 */
public class HandleCookie implements CookieService{    
    @Override
    public List<Book> CookieToProduct(String cookie) {
        try {
            String[] listProductString = cookie.split("/");
            List<Book> listBook = new ArrayList<>();
            BookServiceImpl bookService = new BookServiceImpl();
            for (String productString : listProductString) {
                String[] item = productString.split(":");
                if (item.length >= 2) {
                    String bookId = item[0];
                    int quantity = Integer.parseInt(item[1]);

                    // Make sure bookId can be parsed to integer
                    int parsedBookId = Integer.parseInt(bookId);

                    // Fetch book from service
                    Book book = bookService.getBookById(parsedBookId);
                    if (book != null) {
                        book.setStockQuantity(quantity);
                        listBook.add(book);
                    } else {
                        System.out.println("Book with ID " + parsedBookId + " not found.");
                        // Handle the case where book is not found, if necessary
                    }
                } else {
                    System.out.println("Invalid format for productString: " + productString);
                    // Handle the case where the format is invalid, if necessary
                }
            }
            return listBook;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

//    public static List<OrderDetail> CookieToOrderDetail(String cookie, int orderID) {
//        String[] listProductString = cookie.split("/");
//        List<OrderDetail> OrderDetails = new ArrayList<>();
//        for (String productString : listProductString) {
//            String[] item = productString.split(":");
//            try {
//                int productID = Integer.parseInt(item[0]);
//                int quantity = Integer.parseInt(item[1]);
//                OrderDetail orderDetail = new OrderDetail();
//                orderDetail.setOrderID(orderID);
//                orderDetail.setProductID(productID);
//                orderDetail.setQuantity(quantity);
//                OrderDetails.add(orderDetail);
//
//            } catch (Exception e) {
//                return null;
//            }
//        }
//        return OrderDetails;
//    }
}
