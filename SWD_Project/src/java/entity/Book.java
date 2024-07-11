/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 *
 * @author admin's
 */
public class Book {
    private int BookId;
    private int CommentId;
    private int CategoryId;
    private String BookName;
    private String Author;
    private String Publisher;
    private float Price;
    private String Description;
    private int StockQuantity;

    public Book() {
    }
    
    public Book(int BookId, int CommentId, int CategoryId, String BookName, String Author, String Publisher, float Price, String Description, int StockQuantity) {
        this.BookId = BookId;
        this.CommentId = CommentId;
        this.CategoryId = CategoryId;
        this.BookName = BookName;
        this.Author = Author;
        this.Publisher = Publisher;
        this.Price = Price;
        this.Description = Description;
        this.StockQuantity = StockQuantity;
    }

    public int getBookId() {
        return BookId;
    }

    public void setBookId(int BookId) {
        this.BookId = BookId;
    }

    public int getCommentId() {
        return CommentId;
    }

    public void setCommentId(int CommentId) {
        this.CommentId = CommentId;
    }

    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int CategoryId) {
        this.CategoryId = CategoryId;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        this.BookName = bookName;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String Publisher) {
        this.Publisher = Publisher;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float Price) {
        this.Price = Price;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public int getStockQuantity() {
        return StockQuantity;
    }

    public void setStockQuantity(int StockQuantity) {
        this.StockQuantity = StockQuantity;
    }

    
}
