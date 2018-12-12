package quanlynhahang.models.businessmodels;

import quanlynhahang.models.viewmodels.HoaDonNhom;
import quanlynhahang.models.viewmodels.MonAnNhom;
import quanlynhahang.models.viewmodels.UserDbConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MonAnNhomService extends ConnectDatabase {
    public MonAnNhomService(UserDbConnect user) {
        super(user);
    }

    public HoaDonNhom layHoaDon(int id) throws SQLException, ClassNotFoundException {
        openConnection();
        HoaDonNhom hoaDon = new HoaDonNhom();

        String sql = "SELECT * FROM dbo.LayHoaDonNhom(?)";
        PreparedStatement statement1 = connection.prepareStatement(sql);
        statement1.setInt(1, id);

        ResultSet res = statement1.executeQuery();
        if (!res.next()) {
            return null;
        }

        hoaDon.setIdHoaDonNhom(res.getInt(1));
        hoaDon.setEmailNguoiTao(res.getString(2));
        hoaDon.setTenNguoiTao(res.getString(3));
        hoaDon.setThoiGianTao(res.getDate(4));
        hoaDon.setHoanThanh(res.getBoolean(5));

        sql = "SELECT * FROM dbo.LayMonAnTrongHoaDonNhom(?) ORDER BY ThoiGianDat DESC";
        PreparedStatement statement2 = connection.prepareStatement(sql);
        statement2.setInt(1, id);

        ResultSet res2 = statement2.executeQuery();
        while (res2.next()) {
            MonAnNhom monAn = new MonAnNhom();
            monAn.setIdMonAn(res2.getInt(1));
            monAn.setTenMonAn(res2.getString(2));
            monAn.setGia(res2.getInt(3));
            monAn.setSoLuong(res2.getInt(4));
            monAn.setEmailNguoiDat(res2.getString(5));
            monAn.setTenNguoiDat(res2.getString(6));
            hoaDon.themMonAn(monAn);
        }

        closeConnection();
        return hoaDon;
    }

    public HoaDonNhom taoHoaDon(HoaDonNhom hoaDonNhom) throws SQLException, ClassNotFoundException {
        openConnection();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        String sql = "EXEC ThemHoaDonNhom ?,?,?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, hoaDonNhom.getEmailNguoiTao());
        statement.setString(2, sdf.format(hoaDonNhom.getThoiGianTao()));
        statement.setBoolean(3, hoaDonNhom.isHoanThanh());

        ResultSet res = statement.executeQuery();
        if (res.next()) {
            hoaDonNhom.setIdHoaDonNhom(res.getInt(1));
        }
        closeConnection();
        return hoaDonNhom;
    }

    public int xoaHoaDon(int idHoaDon) throws SQLException, ClassNotFoundException {
        openConnection();
        String sql = "EXEC XoaHoaDonNhom ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idHoaDon);
        int rowsAffected = statement.executeUpdate();
        closeConnection();
        return rowsAffected;
    }

    public int congSoLuongMonAn(int idHoaDon, int idMonAn, String emailNguoiDat) throws SQLException, ClassNotFoundException {
        openConnection();
        String sql = "EXEC CongSoLuongMonAnNhom ?,?,?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idHoaDon);
        statement.setInt(2, idMonAn);
        statement.setString(3, emailNguoiDat);
        int rowsAffected = statement.executeUpdate();
        closeConnection();
        return rowsAffected;
    }

    public int truSoLuongMonAn(int idHoaDon, int idMonAn, String emailNguoiDat) throws SQLException, ClassNotFoundException {
        openConnection();
        String sql = "EXEC TruSoLuongMonAnNhom ?,?,?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idHoaDon);
        statement.setInt(2, idMonAn);
        statement.setString(3, emailNguoiDat);
        int rowsAffected = statement.executeUpdate();
        closeConnection();
        return rowsAffected;
    }

    public int xoaMonAnTronHoaDon(int idHoaDon, int idMonAn, String emailNguoiDat) throws SQLException, ClassNotFoundException {
        openConnection();
        String sql = "EXEC XoaMonAnTrongHoaDon ?,?,?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idHoaDon);
        statement.setInt(2, idMonAn);
        statement.setString(3, emailNguoiDat);
        int rowsAffected = statement.executeUpdate();
        closeConnection();
        return rowsAffected;
    }

    public int themMonAn(int idMonAn, int idGioHang, String email) throws SQLException, ClassNotFoundException {
        openConnection();

        String sql = "SELECT Gia + (Gia * PhanTramKhuyenMai) FROM MonAn WHERE IdMonAn = ?";
        PreparedStatement st = connection.prepareStatement(sql);
        st.setInt(1, idMonAn);
        ResultSet set = st.executeQuery();
        if (!set.next()) {
            return 0;
        }
        int gia = set.getInt(1);
        Date now = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        sql = "EXEC ThemMonAnNhom ?,?,?,?,?,?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idGioHang);
        statement.setInt(2, idMonAn);
        statement.setString(3, email);
        statement.setInt(4, gia);
        statement.setInt(5, 1);
        statement.setString(6, sdf.format(now));

        int rowsAffected = statement.executeUpdate();
        closeConnection();
        return rowsAffected;
    }

    public String hoanThanhDonHang(int idHoaDon) throws SQLException, ClassNotFoundException {
        openConnection();
        String sql = "EXEC HoanThanhDonHang ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idHoaDon);
        statement.executeUpdate();

        sql = "SELECT * FROM dbo.LayMonAnTrongHoaDonNhom(?)";
        PreparedStatement statement2 = connection.prepareStatement(sql);
        statement2.setInt(1, idHoaDon);
        double tongTien = 0;
        int soLuong = 0;
        ResultSet res2 = statement2.executeQuery();
        while (res2.next()) {
            tongTien += res2.getInt(3) * res2.getInt(4);
            soLuong++;
        }
        closeConnection();
        return soLuong + "-" + tongTien;
    }
}