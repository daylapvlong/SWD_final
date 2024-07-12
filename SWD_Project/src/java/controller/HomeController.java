/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import coordinator.BookCoordinator;
import coordinator.CartCoordinator;
import entity.Book;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import utils.HandleCookie;

/**
 *
 * @author admin's
 */
@WebServlet(name = "HomeController", urlPatterns = {"/home"})
public class HomeController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // count product
        Cookie[] cookies = request.getCookies();
        CartCoordinator cartCoordinator = new CartCoordinator();

        int countProduct = 0;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("cart")) {
                if (cookie.getValue() != "") {
                    countProduct = cartCoordinator.getCookieService().CookieToProduct(cookie.getValue()).size();
                }
            }
        }
        request.setAttribute("countProduct", countProduct);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BookCoordinator bookCoordinator = new BookCoordinator();
        CartCoordinator cartCoordinator = new CartCoordinator();
        List<Book> listBooks = bookCoordinator.getBookService().getAllBook();
        
        List<Book> listBookCart = new ArrayList<>();
        Cookie[] cookies = request.getCookies();
        String cart = "";
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("cart")) {
                cart = cookie.getValue();
                break;
            }
        }
        
        if (!cart.equals("")) {
            // get list product from cookie
            listBookCart = cartCoordinator.getCookieService().CookieToProduct(cart);
            request.setAttribute("data", listBookCart);

            // get number of product
            int countProduct = listBookCart.size();
            request.setAttribute("countProduct", countProduct);
        }
        
        request.setAttribute("listBooks", listBooks);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
