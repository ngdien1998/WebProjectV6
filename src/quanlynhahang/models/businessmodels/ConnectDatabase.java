package quanlynhahang.models.businessmodels;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class ConnectDatabase {
    protected Connection connection;
    protected String username;
    protected String password;
    private final String baseConnectionString = "jdbc:sqlserver://localhost;database=QuanLyNhaHang_2;username={username};password={password}";

    public ConnectDatabase(Boolean isAdmin) {
        if (isAdmin == null) {
            username = "guest";
            password = "guest";
        } else if (isAdmin) {
            username = "user";
            password = "user";
        } else {
            username = "admin";
            password = "admin";
        }
    }

    protected void openConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String conn = baseConnectionString.replace("{username}", username).replace("{password}", password);
        connection = DriverManager.getConnection(conn);
    }

    protected void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    protected Boolean getDbAccessValue() {
        Boolean isAdmin = null;
        if (username.equals("admin")) {
            isAdmin = true;
        } else if (username.equals("user")) {
            isAdmin = false;
        }
        return isAdmin;
    }
}