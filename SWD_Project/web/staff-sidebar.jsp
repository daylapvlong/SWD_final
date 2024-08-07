
<!-- Custom CSS -->
<style>
    /* Sidebar style */
    .sidebar {
        position: fixed;
        top: 0;
        left: 0;
        height: 100%;
        width: 11%;
        background-color: #343a40;
        padding-top: 56px;
        z-index: 1;
        transition: width 0.3s;
    }

    .sidebar ul {
        list-style-type: none;
        padding: 0;
        margin: 0;
    }

    .sidebar li {
        padding: 10px;
        text-align: center;
        border-bottom: 1px solid rgba(255, 255, 255, 0.1);
    }

    .sidebar a {
        color: #f8f9fa;
        text-decoration: none;
    }

    .sidebar a:hover {
        color: #007bff;
    }

    /* Main content style */
    .main-content {
        padding-left: 11%;
    }
</style>
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>

<!-- Sidebar -->
<nav class="sidebar">
    <ul>
        <li><a href="staff-dashboard.jsp"><i class='bx bxs-bar-chart-alt-2 mr-2' ></i>Dashboard</a></li>
        <li><a href="staff-order"><i class="fas fa-shopping-cart mr-2"></i>Orders</a></li>
        <li><a href="login"><i class='bx bxs-log-out mr-2' ></i>LogOUT</a></li>
    </ul>
</nav>
