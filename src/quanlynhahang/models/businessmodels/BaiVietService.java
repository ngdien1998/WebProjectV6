package quanlynhahang.models.businessmodels;

import quanlynhahang.models.datamodels.BaiViet;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BaiVietService extends ConnectDatabase implements Businesses<BaiViet> {

    @Override
    public ArrayList<BaiViet> getData() throws SQLException, ClassNotFoundException {
        openConnection();
        ArrayList<BaiViet> baiViets = new ArrayList<>();
        String sql = "EXEC LayBaiViet";
        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(sql);
        while (res.next()) {
            BaiViet baiViet = new BaiViet();
            baiViet.setIdBaiViet(res.getInt(1));
            baiViet.setTenBaiViet(res.getString(2));
            baiViet.setMoTa(res.getString(3));
            baiViet.setNoiDung(res.getString(4));
            baiViet.setNgayViet(res.getDate(5));
            baiViet.setEmail(res.getString(6));
            baiViet.setIdLoaiBaiViet(res.getInt(7));
            baiViets.add(baiViet);
        }
        closeConnection();
        return baiViets;
    }

    @Override
    public int add(BaiViet baiViet) throws SQLException, ClassNotFoundException {
        openConnection();
        String sql = "EXEC ThemBaiViet ?,?,?,?,?,?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setString(1, baiViet.getTenBaiViet());
        statement.setString(2, baiViet.getMoTa());
        statement.setString(3, baiViet.getNoiDung());
        statement.setDate(4, baiViet.getNgayViet());
        statement.setString(5, baiViet.getEmail());
        statement.setInt(6, baiViet.getIdLoaiBaiViet());
        int rowAffected = statement.executeUpdate();
        closeConnection();
        return rowAffected;
    }

    @Override
    public int delete(Object... keys) throws SQLException, ClassNotFoundException {
        if (keys.length <= 0) {
            return 0;
        }
        openConnection();
        String sql = "EXEC XoaBaiViet ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setInt(1, (int) keys[0]);
        int rowAffected = statement.executeUpdate();
        closeConnection();
        return rowAffected;
    }

    @Override
    public int modify(BaiViet baiViet) throws SQLException, ClassNotFoundException {
        if (baiViet == null) {
            return 0;
        }
        openConnection();
        String sql = "EXEC SuaBaiViet ?,?,?,?,?,?,?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setInt(1, baiViet.getIdBaiViet());
        statement.setString(2, baiViet.getTenBaiViet());
        statement.setString(3, baiViet.getMoTa());
        statement.setString(4, baiViet.getNoiDung());
        statement.setDate(5, baiViet.getNgayViet());
        statement.setString(6, baiViet.getEmail());
        statement.setInt(7, baiViet.getIdLoaiBaiViet());
        int rowAffected = statement.executeUpdate();
        closeConnection();
        return rowAffected;
    }

    @Override
    public BaiViet get(Object... keys) throws SQLException, ClassNotFoundException {
        if (keys.length <= 0) {
            return null;
        }
        openConnection();
        String sql = "EXEC LayMotBaiViet ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, (int)keys[0]);
        ResultSet res = statement.executeQuery();
        BaiViet baiViet = null;
        if (res.next()) {
            baiViet = new BaiViet();
            baiViet.setIdBaiViet(res.getInt(1));
            baiViet.setTenBaiViet(res.getString(2));
            baiViet.setMoTa(res.getString(3));
            baiViet.setNoiDung(res.getString(4));
            baiViet.setNgayViet(res.getDate(5));
            baiViet.setEmail(res.getString(6));
            baiViet.setIdLoaiBaiViet(res.getInt(7));
        }
        closeConnection();
        return baiViet;
    }
}
