package quanlynhahang.models.businessmodels;

import quanlynhahang.models.datamodels.BinhLuan;
import quanlynhahang.models.viewmodels.UserDbConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BinhLuanService extends ConnectDatabase implements Businesses<BinhLuan> {
    public BinhLuanService(UserDbConnect user) {
        super(user);
    }

    @Override
    public ArrayList<BinhLuan> getData() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public int add(BinhLuan binhLuan) throws SQLException, ClassNotFoundException {
        return 0;
    }

    @Override
    public int delete(Object... keys) throws SQLException, ClassNotFoundException {
        return 0;
    }

    @Override
    public int modify(BinhLuan binhLuan) throws SQLException, ClassNotFoundException {
        return 0;
    }

    @Override
    public BinhLuan get(Object... keys) throws SQLException, ClassNotFoundException {
        return null;
    }

    public ArrayList<BinhLuan> getData(String loai, int idDanhMucLienQuan) throws SQLException, ClassNotFoundException {
        if (loai == null || loai.trim().isEmpty()) {
            return null;
        }
        openConnection();
        String sql = "EXEC LayBinhLuan ?,?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setString(1, loai);
        statement.setInt(2, idDanhMucLienQuan);
        ArrayList<BinhLuan> binhLuans = new ArrayList<>();
        ResultSet res = statement.executeQuery();
        while (res.next()) {
            BinhLuan binhLuan = new BinhLuan();
            binhLuan.setIdBinhLuan(res.getInt(1));
            binhLuan.setIdDanhMucLienQuan(res.getInt(2));
            binhLuan.setLoai(res.getString(3));
            binhLuan.setThoiGian(res.getDate(4));
            binhLuan.setNoiDung(res.getString(5));
            binhLuan.setEmail(res.getString(6));
            binhLuans.add(binhLuan);
        }
        closeConnection();
        return binhLuans;
    }
}
