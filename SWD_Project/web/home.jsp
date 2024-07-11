<%-- 
    Document   : home
    Created on : Jul 11, 2024, 10:10:36 PM
    Author     : admin's
--%>

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
                        <h3>${item.BookName}</h3>
                        <c:if test="${item.Description == ''}">
                            <p style="margin-top: 0px;">No description</p>
                        </c:if>
                        <p style="margin-top: 0px;"> ${item.Description}</p>
                        <p style="margin-top: 0px;"> ${item.Author}</p>
                        <p style="margin-top: 0px;"> ${item.Publisher}</p>
                        <p style="margin-top: 0px;">Quantity Left: ${item.StockQuantity}</p>

                    </div>
                    <div class="price-addtocart">
                        <p class="text">${item.price}.000 ₫</p>
                        <form action="addtocart" method="post">
                            <input name="productID" hidden value="${item.BookID}"></input>
                            <input type="submit" name="add" value="Add to cart"
                                   class="btn btn-addtocart">
                        </form>
                    </div>
                </div>
            </c:forEach>
        </div>
    </body>
</html>
