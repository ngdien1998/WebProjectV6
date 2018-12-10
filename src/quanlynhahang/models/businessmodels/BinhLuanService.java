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

    public ArrayList<BinhLuan> getBinhLuanMonAn(int idMonAn) throws SQLException, ClassNotFoundException {
        openConnection();
        String sql = "EXEC LayBinhLuanMonAn ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setInt(1, idMonAn);
        ArrayList<BinhLuan> binhLuans = new ArrayList<>();
        ResultSet res = statement.executeQuery();
        while (res.next()) {
            BinhLuan binhLuan = new BinhLuan();
            binhLuan.setIdBinhLuan(res.getInt(1));
            binhLuan.setIdMonAn(res.getInt(2));
            binhLuan.setIdBaiViet(res.getInt(3));
            binhLuan.setThoiGian(res.getDate(4));
            binhLuan.setNoiDung(res.getString(5));
            binhLuan.setEmail(res.getString(6));
            binhLuans.add(binhLuan);
        }
        closeConnection();
        return binhLuans;
    }

    public ArrayList<BinhLuan> getBinhLuanBaiViet(int idMonAn) throws SQLException, ClassNotFoundException {
        openConnection();
        String sql = "EXEC LayBinhLuanBaiViet ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setInt(1, idMonAn);
        ArrayList<BinhLuan> binhLuans = new ArrayList<>();
        ResultSet res = statement.executeQuery();
        while (res.next()) {
            BinhLuan binhLuan = new BinhLuan();
            binhLuan.setIdBinhLuan(res.getInt(1));
            binhLuan.setIdMonAn(res.getInt(2));
            binhLuan.setIdBaiViet(res.getInt(3));
            binhLuan.setThoiGian(res.getDate(4));
            binhLuan.setNoiDung(res.getString(5));
            binhLuan.setEmail(res.getString(6));
            binhLuans.add(binhLuan);
        }
        closeConnection();
        return binhLuans;
    }

    public int deleteBinhLuanMonAn(int idMonAn) throws SQLException, ClassNotFoundException {
        openConnection();
        String sql = "EXEC XoaBinhLuanMonAn ?";

        PreparedStatement statement = null;
        statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setInt(1, idMonAn);

        int rowAffected = statement.executeUpdate();
        closeConnection();
        return rowAffected;
    }
}
