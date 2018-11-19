package quanlynhahang.models.businessmodels;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
    protected Connection connection;
    private final String connectionString = "jdbc:sqlserver://localhost;database=QuanLyNhaHang_2;username=sa;password=123456789";

    protected void openConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        connection = DriverManager.getConnection(connectionString);
    }

    protected void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}