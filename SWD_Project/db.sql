CREATE DATABASE Bookstore;

USE Bookstore;

CREATE TABLE [User] (
    UserId INT PRIMARY KEY IDENTITY(1,1),
    UserName NVARCHAR(255) NOT NULL,
    Password NVARCHAR(255) NOT NULL,
    Name NVARCHAR(255),
    Phone NVARCHAR(20),
    Email NVARCHAR(255),
    Address NVARCHAR(MAX),
    Role NVARCHAR(50)
);

CREATE TABLE Category (
    CategoryId INT PRIMARY KEY IDENTITY(1,1),
    CategoryName NVARCHAR(255) NOT NULL
);

CREATE TABLE Comment (
    CommentId INT PRIMARY KEY IDENTITY(1,1),
    Comment NVARCHAR(MAX) NOT NULL,
    UserId INT,
    FOREIGN KEY (UserId) REFERENCES [User](UserId)
);

CREATE TABLE Book (
    BookId INT PRIMARY KEY IDENTITY(1,1),
    BookName NVARCHAR(255) NOT NULL,
    Author NVARCHAR(255),
    Publisher NVARCHAR(255),
    Description NVARCHAR(MAX),
    Price DECIMAL(10, 2),
    StockQuantity INT,
    CommentId INT,
    CategoryId INT,
    FOREIGN KEY (CommentId) REFERENCES Comment(CommentId),
    FOREIGN KEY (CategoryId) REFERENCES Category(CategoryId)
);

CREATE TABLE Payment (
    PaymentId INT PRIMARY KEY IDENTITY(1,1),
    Date DATE NOT NULL,
    Status NVARCHAR(50),
    Method NVARCHAR(50),
    Total DECIMAL(10, 2),
    Detail NVARCHAR(MAX)
);

CREATE TABLE [Order] (
    OrderId INT PRIMARY KEY IDENTITY(1,1),
    UserId INT,
    OrderDate DATE NOT NULL,
    TotalQuantity INT,
    Status NVARCHAR(50),
    Note NVARCHAR(MAX),
    PaymentId INT,
    FOREIGN KEY (UserId) REFERENCES [User](UserId),
    FOREIGN KEY (PaymentId) REFERENCES Payment(PaymentId)
);

CREATE TABLE OrderDetail (
    OrderDetailId INT PRIMARY KEY IDENTITY(1,1),
    Quantity INT NOT NULL,
    UnitPrice DECIMAL(10, 2) NOT NULL,
    Subtotal DECIMAL(10, 2) NOT NULL,
    OrderId INT,
    BookId INT,
    FOREIGN KEY (OrderId) REFERENCES [Order](OrderId),
    FOREIGN KEY (BookId) REFERENCES Book(BookId)
);
