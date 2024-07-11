/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;


import model.Book;
import coordinator.BookCoordinator;
import coordinator.UserCoordinator;
import dal.DBContext;
import jakarta.servlet.RequestDispatcher;
import java.sql.Connection;
import service.BookService;
/**
 *
 * @author Admin
 */
@WebServlet(name = "Request", urlPatterns = {"/request"})
public class Request extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Request</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Request at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
    private DAO bookDAO;
    private static final long serialVersionUID = 1L;
    private BookCoordinator bookCoordinator;
    private UserCoordinator userCoordinator;
    
    
    public void init() {
        DBContext dbContext = new DBContext();
        this.bookCoordinator = new BookCoordinator(dbContext);
        this.userCoordinator = new UserCoordinator(dbContext);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equals("updateStatus")) {
            int bookId = Integer.parseInt(request.getParameter("bookId"));
            int status = Integer.parseInt(request.getParameter("status"));
            bookCoordinator.getBookService().updateBookStatus(bookId, status);
            response.sendRedirect("request");
        } else {
            doGet(request, response);
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch(action) {
                case "edit":
                    int bookId = Integer.parseInt(request.getParameter("bookId"));
                    Book book = bookCoordinator.getBookService().getBookById(bookId);
                    request.setAttribute("book", book);
                    break;
                case "delete":
                    int deleteBookId = Integer.parseInt(request.getParameter("bookId"));
                    bookCoordinator.getBookService().deleteBookById(deleteBookId);
                    break;
            }
        }
        
        List<Book> bookList = bookCoordinator.getBookService().getAllBooks();
        request.setAttribute("bookList", bookList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("request.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

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
