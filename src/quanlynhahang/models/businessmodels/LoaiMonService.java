package quanlynhahang.models.businessmodels;

import quanlynhahang.models.datamodels.LoaiMon;
import quanlynhahang.models.viewmodels.UserDbConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoaiMonService extends ConnectDatabase implements Businesses<LoaiMon>{
    public LoaiMonService(UserDbConnect user) {
        super(user);
    }

    @Override
    public ArrayList<LoaiMon> getData() throws SQLException, ClassNotFoundException {
        ArrayList<LoaiMon> loaiMons = new ArrayList<>();
        openConnection();

        String sql = "SELECT * FROM LayTatCaLoaiMonA";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        ResultSet res = statement.executeQuery();

        while(res.next()){
            LoaiMon loaiMon = new LoaiMon();
            loaiMon.setIdLoaiMon(res.getInt(1));
            loaiMon.setTenLoaiMon(res.getString(2));
            loaiMon.setMoTa(res.getString(3));

            loaiMons.add(loaiMon);
        }

        closeConnection();
        return loaiMons;
    }

    @Override
    public int add(LoaiMon loaiMon) throws SQLException, ClassNotFoundException {
        if(loaiMon == null){
            return 0;
        }
        openConnection();
        String sql = "EXEC ThemLoaiMon ?,?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setString(1,loaiMon.getTenLoaiMon());
        statement.setString(2,loaiMon.getMoTa());

        int rowAffected = statement.executeUpdate();
        closeConnection();
        return rowAffected;
    }

    @Override
    public int delete(Object... keys) throws SQLException, ClassNotFoundException {
        openConnection();

        String sql = "EXEC XoaLoaiMon ?";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setInt(1, (int)keys[0]);
        int rowAffected = statement.executeUpdate();
        closeConnection();
        return rowAffected;
    }


    @Override
    public int modify(LoaiMon loaiMon) throws SQLException, ClassNotFoundException {
        openConnection();
        String sql = "EXEC SuaLoaiMon ?,?,?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setInt(1,loaiMon.getIdLoaiMon());
        statement.setString(2,loaiMon.getTenLoaiMon());
        statement.setString(3,loaiMon.getMoTa());

        int rowAffected = statement.executeUpdate();
        closeConnection();
        return rowAffected;
    }

    @Override
    public LoaiMon get(Object... keys) throws SQLException, ClassNotFoundException {
        if(keys.length <= 0) {
            return null;
        }
        openConnection();

        String sql = "SELECT * FROM LayMotLoaiMon (?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setString(1, keys[0].toString());

        ResultSet res = statement.executeQuery();
        LoaiMon loaiMon = null;
        if(res.next()){
            loaiMon = new LoaiMon();
            loaiMon.setIdLoaiMon(res.getInt(1));
            loaiMon.setTenLoaiMon(res.getString(2));
            loaiMon.setMoTa(res.getString(3));
        }

        closeConnection();
        return loaiMon;
    }
}
