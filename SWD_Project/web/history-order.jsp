



<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>User Orders</title>
        <!-- Bootstrap CSS link (adjust path as necessary) -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
         <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.24/css/dataTables.bootstrap4.min.css">
    </head>
    <body>
        
        <%@ include file="user-sidebar.jsp" %>
        
        <div class="main-content container text-center" style="margin-top: 10%">
            <h2>User Orders</h2>
            <table id="table" class="table table-striped">
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
        
         <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.min.js"></script>
        <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.24/js/dataTables.bootstrap4.min.js"></script>
        <script>
            $(document).ready(function () {
                $('#table').DataTable({
                    "pageLength": 20, // chinh so luong 1 page 
                    "lengthChange": false
                });
            });
        </script>
    </body>
</html>
