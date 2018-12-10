package quanlynhahang.models.businessmodels;

import quanlynhahang.models.datamodels.LoaiBaiViet;
import quanlynhahang.models.viewmodels.UserDbConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoaiBaiVietService extends ConnectDatabase implements Businesses<LoaiBaiViet> {
    public LoaiBaiVietService(UserDbConnect user) {
        super(user);
    }

    @Override
    public ArrayList<LoaiBaiViet> getData() throws SQLException, ClassNotFoundException {
        ArrayList<LoaiBaiViet> loaiBaiViets=new ArrayList<>();
        openConnection();

        String sql = "exec LayLoaiBaiViet";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);

        ResultSet res = statement.executeQuery();
        while (res.next()) {
            LoaiBaiViet loaiBaiViet = new LoaiBaiViet();
            loaiBaiViet.setIdLoaiBaiViet(res.getInt(1));
            loaiBaiViet.setTenLoaiBaiViet(res.getString(2));
            loaiBaiViet.setMoTa(res.getString(3));

            loaiBaiViets.add(loaiBaiViet);
        }

        closeConnection();
        return loaiBaiViets;
    }

    @Override
    public int add(LoaiBaiViet loaiBaiViet) throws SQLException, ClassNotFoundException {
        if(loaiBaiViet==null)
            return 0;
        openConnection();
        String sql = "EXEC ThemLoaiBaiViet ?,?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setString(1, loaiBaiViet.getTenLoaiBaiViet());
        statement.setString(2, loaiBaiViet.getMoTa());

        int rowAffected = statement.executeUpdate();
        closeConnection();
        return rowAffected;
    }

    @Override
    public int delete(Object... keys) throws SQLException, ClassNotFoundException {
        openConnection();
        String sql = "EXEC XoaLoaiBaiViet ?";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setInt(1, (int) keys[0]);
        int rowAffected = statement.executeUpdate();
        closeConnection();
        return rowAffected;
    }

    @Override
    public int modify(LoaiBaiViet loaiBaiViet) throws SQLException, ClassNotFoundException {
        openConnection();
        String sql = "EXEC SuaLoaiBaiViet ?,?,?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setInt(1, loaiBaiViet.getIdLoaiBaiViet());
        statement.setString(2, loaiBaiViet.getTenLoaiBaiViet());
        statement.setString(3, loaiBaiViet.getMoTa());

        int rowAffected = statement.executeUpdate();
        closeConnection();
        return rowAffected;
    }

    @Override
    public LoaiBaiViet get(Object... keys) throws SQLException, ClassNotFoundException {
        if(keys.length<=0)
            return null;
        openConnection();
        String sql = "exec Lay1LoaiBaiViet ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setInt(1, (int) keys[0]);
        ResultSet res = statement.executeQuery();
        LoaiBaiViet loaiBaiViet = null;
        if (res.next()) {
            loaiBaiViet = new LoaiBaiViet();
            loaiBaiViet.setIdLoaiBaiViet(res.getInt(1));
            loaiBaiViet.setTenLoaiBaiViet(res.getString(2));
            loaiBaiViet.setMoTa(res.getString(3));
        }
        closeConnection();
        return loaiBaiViet;
    }
}
