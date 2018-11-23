package quanlynhahang.models.businessmodels;

import quanlynhahang.models.datamodels.DatBan;
import quanlynhahang.models.viewmodels.UserDbConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatBanService extends ConnectDatabase implements Businesses<DatBan> {
    public DatBanService(UserDbConnect user) {
        super(user);
    }

    @Override
    public ArrayList<DatBan> getData() throws SQLException, ClassNotFoundException {
        ArrayList<DatBan> datBans = new ArrayList<>();
        openConnection();

        String sql = "EXEC LayDatBan";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        ResultSet res = statement.executeQuery();
        while (res.next()) {
            DatBan datBan = new DatBan();
            datBan.setEmail(res.getString(1));
            datBan.setBan(res.getString(2));
            datBan.setThoiGian(res.getDate(3));
            datBan.setSoLuong(res.getInt(4));
            datBan.setGia(res.getInt(5));
            datBan.setGhiChu(res.getString(6));

            datBans.add(datBan);
        }
        closeConnection();
        return datBans;
    }

    @Override
    public int delete(Object... keys) throws SQLException, ClassNotFoundException {
        openConnection();
        String sql = "EXEC XoaDatBan ?";

        PreparedStatement statement = null;
        statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setInt(1, (int) keys[0]);

        int rowAffected = statement.executeUpdate();
        closeConnection();
        return rowAffected;
    }

    @Override
    public int add(DatBan datBan) throws SQLException, ClassNotFoundException{
        return 0;
    }

    @Override
    public int modify(DatBan datBan) throws SQLException, ClassNotFoundException{
        return 0;
    }

    @Override
    public DatBan get(Object... keys) throws SQLException, ClassNotFoundException{
        openConnection();
        String sql = "EXEC LayMotDatBan ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setInt(1, (int) keys[0]);

        DatBan datBan = null;
        ResultSet res = statement.executeQuery();
        if (res.next()) {
            datBan = new DatBan();
            datBan.setEmail(res.getString(1));
            datBan.setBan(res.getString(2));
            datBan.setThoiGian(res.getDate(3));
            datBan.setSoLuong(res.getInt(4));
            datBan.setGia(res.getInt(5));
            datBan.setGhiChu(res.getString(6));
        }
        closeConnection();
        return datBan;
    }
}
