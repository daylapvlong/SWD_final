



<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>User Orders</title>
        <!-- Bootstrap CSS link (adjust path as necessary) -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container">
            <h2>User Orders</h2>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Order ID</th>
                        <th>Payment ID</th>
                        <th>Order Date</th>
                        <th>Total Quantity</th>
                        <th>Status</th>
                        <th>Note</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="order" items="${orders}">
                        <tr>
                            <td>${order.orderID}</td>
                            <td>${order.paymentID}</td>
                            <td>${order.orderDate}</td>
                            <td>${order.totalQuantity}</td>
                            <td>${order.status}</td>
                            <td>${order.note}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
