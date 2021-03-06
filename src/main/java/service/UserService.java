package service;

import dao.UserDao;
import model.User;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class UserService {

    public UserService() {
    }

    public User getUserById(long id) throws SQLException {

        return getUserDAO().getUserById(id);

    }

    public List<User> getAllClient() {
        UserDao userDao = new UserDao(getMysqlConnection());
        return userDao.getAllUser();
    }

    public boolean addUser(User user) throws Exception {
        UserDao userDao = new UserDao(getMysqlConnection());
        if (userDao.getAllUser().contains(user) || user.getName().length() == 0
                || user.getAge() == 0) {
            return false;
        }
        try {
            userDao.addUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void updateUser(User user) throws SQLException {
        new UserDao(getMysqlConnection()).updateUserDao(user);
    }
    public void deleteUser(User user) throws SQLException {
        new UserDao(getMysqlConnection()).deleteUserDao(user);
    }

    private static Connection getMysqlConnection() {
        try {
            DriverManager.registerDriver((Driver) Class
                    .forName("com.mysql.jdbc.Driver").newInstance());

            StringBuilder url = new StringBuilder();

            url.
                    append("jdbc:mysql://").        //db type
                    append("localhost:").           //host name
                    append("3306/").                //port
                    append("db_example?").          //db name
                    append("user=root&").          //login
                    append("password=root").       //password
                    append("&serverTimezone=UTC");

            System.out.println("URL: " + url + "\n");

            Connection connection = DriverManager.getConnection(url.toString());
            return connection;
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }
    }

    private static UserDao getUserDAO() {
        return new UserDao(getMysqlConnection());
    }
}

