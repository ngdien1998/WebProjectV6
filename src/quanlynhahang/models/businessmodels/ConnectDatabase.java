package quanlynhahang.models.businessmodels;

import quanlynhahang.models.viewmodels.UserDbConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class ConnectDatabase {
    protected Connection connection;
    private String username;
    private String password;
    private String hostName;
    private String port;

    public ConnectDatabase(UserDbConnect user) {
        //hostName = "192.168.43.184";
        hostName = "localhost";
        port = "1433";
        if (user == null) {
            username = "guest";
            password = "guest";
        } else if (!user.isAdmin()) {
            username = "user";
            password = "user";
        } else {
            username = "admin";
            password = "admin";
        }
    }

    protected void openConnection() throws SQLException, ClassNotFoundException {
        String baseConnectionString = "jdbc:sqlserver://{hostname}:{port};database=QuanLyNhaHang_2;username={username};password={password}";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String conn = baseConnectionString.replace("{username}", username)
                                          .replace("{password}", password)
                                          .replace("{hostname}", hostName)
                                          .replace("{port}", port);
        connection = DriverManager.getConnection(conn);
    }

    protected void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    UserDbConnect getDbAccessValue() {
        if (username.equals("guest")) {
            return null;
        }
        return new UserDbConnect(username, password, hostName, port, !username.equals("user"));
    }
}