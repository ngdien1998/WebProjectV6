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

        String sql = "SELECT * FROM  LayDatBan";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        ResultSet res = statement.executeQuery();
        while (res.next()) {
            DatBan datBan = new DatBan();
            datBan.setEmail(res.getString(1));
            datBan.setThoiGian(res.getDate(2));
            datBan.setSoLuong(res.getInt(3));
            datBan.setGhiChu(res.getString(4));

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
        statement.setString(1, keys[0].toString());

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
        String sql = "SELECT * FROM LayMotDatBan (?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setString(1, keys[0].toString());

        DatBan datBan = null;
        ResultSet res = statement.executeQuery();
        if (res.next()) {
            datBan = new DatBan();
            datBan.setEmail(res.getString(1));
            datBan.setThoiGian(res.getDate(2));
            datBan.setSoLuong(res.getInt(3));
            datBan.setGhiChu(res.getString(4));
        }
        closeConnection();
        return datBan;
    }
}
