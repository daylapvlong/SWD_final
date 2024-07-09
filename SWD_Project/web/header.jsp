
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
                            <a class="btn btn-outline-success my-2 my-sm-0 mr-2" href="login">Log out</a>
                            <a class="btn btn-outline-success my-2 my-sm-0" href="history-order">Profile</a>
                        </c:if>
                            
                    </form>
                </div>
            </div>
        </nav>
    </body>
</html>