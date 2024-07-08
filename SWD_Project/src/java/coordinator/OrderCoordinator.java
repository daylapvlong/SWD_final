/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coordinator;

import impl.OrderServiceImpl;
import impl.UserServiceImpl;
import service.OrderService;
import service.UserService;

/**
 *
 * @author Legion
 */
public class OrderCoordinator {
    private OrderService orderService;
    private UserService userService;

    public OrderCoordinator() {
        orderService = new OrderServiceImpl();
        userService = new UserServiceImpl();
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
