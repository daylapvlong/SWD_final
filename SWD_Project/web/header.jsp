
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            /* Custom styles can be added here */
            .banner {
                background-image: url('https://www.shutterstock.com/image-photo/open-book-on-table-education-260nw-1813887353.jpg'); /* Light gray background for banner */
                padding: 80px 0; /* Adjust padding as needed */
                text-align: center;
                background-repeat: no-repeat;
                background-size: cover;
                height: 400px
            }
        </style>
    </head>
    <body>
        <!-- Navigation Bar -->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container">
                <a class="navbar-brand" href="home">BookStore</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="home">Home <span class="sr-only">(current)</span></a>
                        </li>
                        
                    </ul>
                    <!-- You can add login/logout button or user-specific options here -->
                    <form class="form-inline my-2 my-lg-0">
                        <c:if test="${sessionScope.user eq null}">
                            <a class="btn btn-outline-success my-2 my-sm-0" href="login">Login</a>
                        </c:if>
                            <c:if test="${sessionScope.user ne null}">
                            <a class="mr-3" href="cart">
                                <svg width="30px" height="30px" viewBox="0 0 96 96" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">
                                    <g id="cart" clip-path="url(#clip-cart)">
                                    <g id="pills" transform="translate(0 -116)">
                                        <g id="Group_154" data-name="Group 154">
                                        <path id="Path_188" data-name="Path 188" d="M92,132H84.619a8.361,8.361,0,0,0-7.956,5.47L63.712,174.53A8.364,8.364,0,0,1,55.755,180H21.321a8.4,8.4,0,0,1-7.773-4.994l-8.925-21C2.387,148.746,6.445,143,12.4,143H57" fill="none" stroke="#58595b" stroke-linecap="round" stroke-linejoin="round" stroke-width="4"/>
                                        <circle id="Ellipse_335" data-name="Ellipse 335" cx="4.5" cy="4.5" r="4.5" transform="translate(20 187)" fill="none" stroke="#58595b" stroke-linecap="round" stroke-linejoin="round" stroke-width="4"/>
                                        <circle id="Ellipse_336" data-name="Ellipse 336" cx="4.5" cy="4.5" r="4.5" transform="translate(49 187)" fill="none" stroke="#58595b" stroke-linecap="round" stroke-linejoin="round" stroke-width="4"/>
                                        </g>
                                    </g>
                                    </g>
                                </svg>
                                <span class='badge badge-warning' id='lblCartCount' style="border-radius: 60rem;">${countProduct}</span>
                            </a>
                            <a class="btn btn-outline-success my-2 my-sm-0 mr-3" href="history-order">Profile</a>
                            <a class="btn btn-outline-success my-2 my-sm-0 mr-2" href="logout">Log out</a>
                        </c:if>
                            
                    </form>
                </div>
            </div>
        </nav>
    </body>
</html>
