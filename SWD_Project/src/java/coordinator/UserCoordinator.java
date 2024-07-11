package coordinator;

import impl.UserServiceImpl;
import service.UserService;
import dal.DBContext;

import java.sql.Connection;

public class UserCoordinator {
    private UserService userService;

    public UserCoordinator(DBContext dbContext) {
        Connection connection = dbContext.getConnection();
        this.userService = new UserServiceImpl(connection);
    }

    public UserService getUserService() {
        return userService;
    }
}
