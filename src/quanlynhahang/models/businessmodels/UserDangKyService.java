package quanlynhahang.models.businessmodels;

import quanlynhahang.models.datamodels.NguoiDung;
import quanlynhahang.models.viewmodels.UserDbConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDangKyService extends ConnectDatabase implements Businesses{
    public UserDangKyService(UserDbConnect user) {
        super(user);
    }

    @Override
    public ArrayList getData() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public int add(Object o) throws SQLException, ClassNotFoundException {
        return 0;
    }

    public int add(NguoiDung nguoiDung) throws SQLException, ClassNotFoundException {
        if (nguoiDung == null) {
            return 0;
        }
        openConnection();

        String sql = "EXEC THEM_TAIKHOANDANGKY ?,?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setString(1, nguoiDung.getEmail());
        statement.setString(2, nguoiDung.getMatKhau());

        int rowAffected = statement.executeUpdate();
        closeConnection();
        return rowAffected;
    }

    @Override
    public int delete(Object... keys) throws SQLException, ClassNotFoundException {
        return 0;
    }

    @Override
    public int modify(Object o) throws SQLException, ClassNotFoundException {
        return 0;
    }

    @Override
    public Object get(Object... keys) throws SQLException, ClassNotFoundException {
        return null;
    }

    public int checkExist (String email) throws SQLException, ClassNotFoundException {
        openConnection();
        String sql = "SELECT dbo.CHECK_EMAIL_EXIST (?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setString(1, email);

        ResultSet res = statement.executeQuery();
        int exist = 0;
        if(res.next()){
            exist = res.getInt(1);
        }

        closeConnection();
        return exist;
    }
}
