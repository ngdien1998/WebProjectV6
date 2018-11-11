package quanlynhahang.models.businessmodels;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
    protected Connection connection;
    private final String connectionString = "jdbc:sqlserver://localhost:1433;database=QuanLyNhaHang_2;username=sa;password=123456789";

    public void openConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        connection = DriverManager.getConnection(connectionString);
    }

    public void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}
