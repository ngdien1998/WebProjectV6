package quanlynhahang.models.businessmodels;

import quanlynhahang.models.datamodels.BaiViet;
import quanlynhahang.models.viewmodels.ChiTietBaiViet;
import quanlynhahang.models.viewmodels.UserDbConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class BaiVietService extends ConnectDatabase implements Businesses<BaiViet> {
    public BaiVietService(UserDbConnect user) {
        super(user);
    }

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
            baiViet.setHinh(res.getString(6));
            baiViet.setEmail(res.getString(7));
            baiViet.setIdLoaiBaiViet(res.getInt(8));
            baiViets.add(baiViet);
        }
        closeConnection();
        return baiViets;
    }

    @Override
    public int add(BaiViet baiViet) throws SQLException, ClassNotFoundException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        openConnection();
        String sql = "EXEC ThemBaiViet ?,?,?,?,?,?,?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setString(1, baiViet.getTenBaiViet());
        statement.setString(2, baiViet.getMoTa());
        statement.setString(3, baiViet.getNoiDung());
        statement.setString(4, sdf.format(baiViet.getNgayViet()));
        statement.setString(5, baiViet.getHinh());
        statement.setString(6, baiViet.getEmail());
        statement.setInt(7, baiViet.getIdLoaiBaiViet());
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
        statement.setString(5, baiViet.getHinh());
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
        statement.setInt(1, (int) keys[0]);
        ResultSet res = statement.executeQuery();
        BaiViet baiViet = null;
        if (res.next()) {
            baiViet = new BaiViet();
            baiViet.setIdBaiViet(res.getInt(1));
            baiViet.setTenBaiViet(res.getString(2));
            baiViet.setMoTa(res.getString(3));
            baiViet.setNoiDung(res.getString(4));
            baiViet.setNgayViet(res.getDate(5));
            baiViet.setHinh(res.getString(6));
            baiViet.setEmail(res.getString(7));
            baiViet.setIdLoaiBaiViet(res.getInt(8));
        }
        closeConnection();
        return baiViet;
    }

    public ArrayList<BaiViet> layBaiVietTheoDanhMuc(int loaiBaiViet) throws SQLException, ClassNotFoundException {
        openConnection();
        ArrayList<BaiViet> baiViets = new ArrayList<>();
        String sql = "SELECT * FROM LayBaiVietTheoLoai(?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, loaiBaiViet);
        ResultSet res = statement.executeQuery();
        while (res.next()) {
            BaiViet baiViet = new BaiViet();
            baiViet.setIdBaiViet(res.getInt(1));
            baiViet.setTenBaiViet(res.getString(2));
            baiViet.setMoTa(res.getString(3));
            baiViet.setNoiDung(res.getString(4));
            baiViet.setNgayViet(res.getDate(5));
            baiViet.setHinh(res.getString(6));
            baiViet.setEmail(res.getString(7));
            baiViet.setIdLoaiBaiViet(res.getInt(8));
            baiViets.add(baiViet);
        }
        closeConnection();
        return baiViets;
    }

    public ChiTietBaiViet layChiTietBaiViet(int idBaiViet) throws SQLException, ClassNotFoundException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        openConnection();
        ChiTietBaiViet baiViet = null;
        String sql = "SELECT * FROM LayChiTietBaiViet(?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idBaiViet);
        ResultSet res = statement.executeQuery();
        if (res.next()) {
            baiViet = new ChiTietBaiViet();
            baiViet.setIdBaiViet(res.getInt(1));
            baiViet.setTenBaiViet(res.getString(2));
            baiViet.setThoiGianViet(sdf.format(res.getDate(3)));
            baiViet.setNguoiViet(res.getString(4));
            baiViet.setMoTa(res.getString(5));
            baiViet.setNoiDung(res.getString(6));
            baiViet.setIdLoaiBaiViet(res.getInt(7));
            baiViet.setLoaiBaiViet(res.getString(8));
        }
        closeConnection();
        return baiViet;
    }
}
