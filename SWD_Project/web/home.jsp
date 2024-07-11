<%-- 
    Document   : home
    Created on : Jul 11, 2024, 10:10:36 PM
    Author     : admin's
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Home</title>
        <!-- Bootstrap CSS link (adjust path as necessary) -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.24/css/dataTables.bootstrap4.min.css">
    </head>
    <body>
        <!-- Header -->
        <%@include file="header.jsp"%> 
        <!-- end header -->

        <!-- First Photo Grid -->
        <div class="w3-row-padding w3-padding-16 w3-center row-product">
            <c:forEach items="${books}" var="item" varStatus="loop">
                <div class="w3-quarter session-product">
                    <div>
                        <h3>${item.bookName}</h3>
                        <c:if test="${item.description == ''}">
                            <p style="margin-top: 0px;">No description</p>
                        </c:if>
                        <p style="margin-top: 0px;">${item.description}</p>
                        <p style="margin-top: 0px;">${item.author}</p>
                        <p style="margin-top: 0px;">${item.publisher}</p>
                        <p style="margin-top: 0px;">Quantity Left: ${item.stockQuantity}</p>
                    </div>
                    <div class="price-addtocart">
                        <p class="text">${item.price}.000 ₫</p>
                        <form action="addtocart" method="post">
                            <input name="productID" hidden value="${item.bookID}"></input>
                            <input type="submit" name="add" value="Add to cart" class="btn btn-addtocart">
                        </form>
                    </div>
                </div>
            </c:forEach>
            
            <c:if test="${empty books}">
                <p>No books available</p>
            </c:if>
        </div>
    </body>
</html>
