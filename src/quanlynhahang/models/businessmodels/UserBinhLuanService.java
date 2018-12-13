package quanlynhahang.models.businessmodels;

import quanlynhahang.models.viewmodels.UserDbConnect;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserBinhLuanService  extends  ConnectDatabase {
    public UserBinhLuanService(UserDbConnect user) {
        super(user);
    }

    public int addBinhLuanMonAn(String idMonAn, String noiDung, String email) throws SQLException, ClassNotFoundException {
        openConnection();
        String sql = "EXEC ThemBinhLuanMonAn ?,?,?,?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, Integer.parseInt(idMonAn));
        statement.setDate(2, Date.valueOf(java.time.LocalDate.now()));
        statement.setString(3, noiDung);
        statement.setString(4, email);

        int rowAffected = statement.executeUpdate();
        closeConnection();
        return rowAffected;
    }

    public int addBinhLuanBaiViet(String idBaiViet, String noiDung, String email) throws SQLException, ClassNotFoundException {
        openConnection();
        String sql = "EXEC ThemBinhLuanBaiViet ?,?,?,?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, Integer.parseInt(idBaiViet));
        statement.setDate(2, Date.valueOf(java.time.LocalDate.now()));
        statement.setString(3, noiDung);
        statement.setString(4, email);

        int rowAffected = statement.executeUpdate();
        closeConnection();
        return rowAffected;
    }
}
