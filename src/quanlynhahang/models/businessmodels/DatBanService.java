package quanlynhahang.models.businessmodels;

import quanlynhahang.models.datamodels.DatBan;
import quanlynhahang.models.viewmodels.UserDbConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class DatBanService extends ConnectDatabase implements Businesses<DatBan> {
    public DatBanService(UserDbConnect user) {
        super(user);
    }

    @Override
    public ArrayList<DatBan> getData() throws SQLException, ClassNotFoundException {
        ArrayList<DatBan> datBans = new ArrayList<>();
        openConnection();

        String sql = "select * from dbo.LayDatBan";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        ResultSet res = statement.executeQuery();
        while (res.next()) {
            DatBan datBan = new DatBan();
            datBan.setEmail(res.getString(1));
            datBan.setThoiGian(res.getString(2));
            datBan.setNgay(res.getDate(3));
            datBan.setSoLuong(res.getInt(4));
            datBan.setGhiChu(res.getString(5));
            datBan.setHoTen(res.getString(6));
            datBan.setSoDT(res.getString(7));
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
        if(datBan==null)
            return 0;
        openConnection();
        String sql="exec ThemDatBan ?,?,?,?,?,?,?";
        PreparedStatement statement=connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setString(1, datBan.getEmail());
        statement.setString(2,datBan.getThoiGian());
        statement.setDate(3,datBan.getNgay());
        statement.setInt(4,datBan.getSoLuong());
        statement.setString(5,datBan.getGhiChu());
        statement.setString(6,datBan.getHoTen());
        statement.setString(7,datBan.getSoDT());

        int rowAffected = statement.executeUpdate();
        closeConnection();
        return rowAffected;

    }

    @Override
    public int modify(DatBan datBan) throws ClassNotFoundException{
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
            datBan.setThoiGian(res.getString(2));
            datBan.setNgay(res.getDate(3));
            datBan.setSoLuong(res.getInt(4));
            datBan.setGhiChu(res.getString(5));
            datBan.setHoTen(res.getString(6));
            datBan.setSoDT(res.getString(7));
        }
        closeConnection();
        return datBan;
    }
}
