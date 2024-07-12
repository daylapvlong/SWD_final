/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author admin's
 */
@WebServlet(name = "AddToCartServlet", urlPatterns = {"/addtocart"})
public class AddToCartServlet extends HttpServlet {

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
        User user = ((User)request.getSession().getAttribute("user"));
        if(user != null) {
            String bookId = request.getParameter("bookId");
        Cookie[] cookies = request.getCookies();
        String cart = "";
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("cart")) {
                cart = cookie.getValue();
                cookie.setMaxAge(0);
                response.addCookie(cookie);
                break;
            }
        }
        if (cart.isEmpty()) {
            cart = bookId + ":" + 1;
        } else {
            String[] books = cart.split("/");
            boolean isExist = false;
            for (int i = 0; i < books.length; i++) {
                String[] product = books[i].split(":");
                if (product[0].equals(bookId)) {
                    int quantity = Integer.parseInt(product[1]) + 1;
                    books[i] = bookId + ":" + quantity;
                    isExist = true;
                    break;
                }
            }
            cart = books[0];
            for (int i = 1; i < books.length; i++) {
                cart += "/" + books[i];
            }
            if (!isExist) {
                cart += "/" + bookId + ":" + 1;
            }
        }
        Cookie cookie = new Cookie("cart", cart);
        cookie.setMaxAge(60 * 60 * 24);
        response.addCookie(cookie);
        response.sendRedirect("home");
        } else {
            response.sendRedirect("login");
        }
        
        }
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
        processRequest(request, response);
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
