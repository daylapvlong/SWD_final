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
        <style>
            body,
            h1,
            h2,
            h3,
            h4,
            h5,
            h6,
            p {
                font-family: Roboto, Arial, sans-serif;
            }

            .w3-bar-block .w3-bar-item {
                padding: 20px
            }

            .row-product {
                display: flex;
                flex-wrap: wrap;
                justify-content: space-evenly;
                height: 700px;
            }

            .session-product {
                border: 1px;
                box-shadow: 0px 0px 2px 0px #533939;
                background: white;
                padding: 10px;
                border-radius: 10px;
                width: 265px;
                height: 660px;
            }

            .price-addtocart {
                position: relative;
                bottom: -5px;
            }

            .price-addtocart .text {
                font-family: Roboto, Arial, sans-serif;
                color: #ff5b6a;
                font-weight: 700;
                font-size: 25px;
                line-height: 100%;
                margin-bottom: 5px;
            }

            .btn-addtocart {
                background: #ff5b6a;
                border-color: #ff5b6a;
                margin-top: 10px;
                width: 100%;
                color: white;
            }
        </style>
        <!-- Bootstrap CSS link (adjust path as necessary) -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.24/css/dataTables.bootstrap4.min.css">
    </head>
    <body>
        <!-- Header -->
        <%@include file="header.jsp"%> 
        <!-- end header -->

        <div class="w3-container">
            <header class="w3-center w3-padding-32 flex align-items-center">
                <h1>Welcome to Our Book Store</h1>
                <p>Find the best books at amazing prices</p>
            </header>

            <!-- !PAGE CONTENT! -->
            <div class="w3-main w3-content w3-padding" style="max-width:1200px;margin-top:100px">

                <!-- First Photo Grid-->
                <div class="w3-row-padding w3-padding-16 w3-center row-product" id="food">
                    <!-- <div class="product w3-center" id="food"></div> -->
                    <c:forEach items="${listBooks}" var="item" varStatus="loop">
                        <c:if test="${loop.index < 4}">
                            <div class="w3-quarter session-product">
                                <img class="img" src="public/img/harry.jpg" alt="Sandwich" style="width:100%">
                                <div>
                                    <h3>${item.bookName}</h3>
                                    <c:if test="${item.description == ''}">
                                        <p>No description</p>
                                    </c:if>
                                    <p style="margin-top: 0px;"> ${item.description}</p>
                                    <p>${item.author}</p>
                                    <p>${item.publisher}</p>
                                    <p>Quantity Left: ${item.stockQuantity}</p>
                                </div>
                                <div class="price-addtocart">
                                    <p class="text">${item.price}.000 ₫</p>
                                    <form action="addtocart" method="post">
                                        <input name="bookId" type="hidden" value="${item.bookId}" />
                                        <input type="submit" name="add" value="Add to cart" class="btn btn-addtocart">
                                    </form>
                                </div>
                            </div>
                        </c:if>
                    </c:forEach>
                </div>

                <!-- Second Photo Grid-->
                <div class="w3-row-padding w3-padding-16 w3-center row-product" id="food">
                    <!-- <div class="product w3-center" id="food"></div> -->
                    <c:forEach items="${listBooks}" var="item" varStatus="loop">
                        <c:if test="${loop.index >= 4 && loop.index < 9}">
                            <div class="w3-quarter session-product">
                                <img class="img" src="public/img/harry.jpg" alt="Sandwich" style="width:100%">
                                <div>
                                    <h3>${item.bookName}</h3>
                                    <c:if test="${item.description == ''}">
                                        <p>No description</p>
                                    </c:if>
                                    <p style="margin-top: 0px;"> ${item.description}</p>
                                    <p>${item.author}</p>
                                    <p>${item.publisher}</p>
                                    <p>Quantity Left: ${item.stockQuantity}</p>
                                </div>
                                <div class="price-addtocart">
                                    <p class="text">${item.price}.000 ₫</p>
                                    <form action="addtocart" method="post">
                                        <input name="bookId" type="hidden" value="${item.bookId}" />
                                        <input type="submit" name="add" value="Add to cart" class="btn btn-addtocart">
                                    </form>
                                </div>
                            </div>
                        </c:if>
                    </c:forEach>
                </div>

                <!-- End page content -->
            </div>
        </div>
    </body>
</html>
