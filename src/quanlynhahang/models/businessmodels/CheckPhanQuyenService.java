package quanlynhahang.models.businessmodels;

import quanlynhahang.models.viewmodels.UserDbConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckPhanQuyenService extends ConnectDbService {
    public CheckPhanQuyenService(UserDbConnect user) {
        super(user);
    }

    public boolean checkPhanQuyen(String email, int idQuyen) throws SQLException, ClassNotFoundException {
        openConnection();
        String sql = "SELECT dbo.KiemTraPhanQuyen(?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setString(1, email);
        statement.setInt(2, idQuyen);
        ResultSet res = statement.executeQuery();
        boolean allow = false;
        if (res.next()) {
            allow = res.getBoolean(1);
        }
        closeConnection();
        return allow;
    }
}
