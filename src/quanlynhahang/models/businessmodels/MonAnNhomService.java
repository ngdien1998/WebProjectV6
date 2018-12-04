package quanlynhahang.models.businessmodels;

import quanlynhahang.models.viewmodels.HoaDonNhom;
import quanlynhahang.models.viewmodels.MonAnNhom;
import quanlynhahang.models.viewmodels.UserDbConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MonAnNhomService extends ConnectDatabase {
    public MonAnNhomService(UserDbConnect user) {
        super(user);
    }

    public HoaDonNhom layHoaDon(int id) throws SQLException, ClassNotFoundException {
        openConnection();
        HoaDonNhom hoaDon = new HoaDonNhom();

        String sql = "SELECT * FROM dbo.LayHoaDonNhom(?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet res = statement.executeQuery();
        if (res.next()) {
            hoaDon.setIdHoaDonNhom(res.getInt(1));
            hoaDon.setEmailNguoiTao(res.getString(2));
            hoaDon.setTenNguoiTao(res.getString(3));
            hoaDon.setThoiGianTao(res.getDate(4));
            hoaDon.setHoanThanh(res.getBoolean(5));

            MonAnNhom monAn = new MonAnNhom();
            monAn.setIdMonAn(res.getInt(6));
            monAn.setTenMonAn(res.getString(7));
            monAn.setGia(res.getInt(8));
            monAn.setSoLuong(res.getInt(9));
            monAn.setEmailNguoiDat(res.getString(10));
            monAn.setTenNguoiDat(res.getString(11));
            hoaDon.themMonAn(monAn);
        }

        while (res.next()) {
            MonAnNhom monAn = new MonAnNhom();
            monAn.setIdMonAn(res.getInt(6));
            monAn.setTenMonAn(res.getString(7));
            monAn.setGia(res.getInt(8));
            monAn.setSoLuong(res.getInt(9));
            monAn.setEmailNguoiDat(res.getString(10));
            monAn.setTenNguoiDat(res.getString(11));
            hoaDon.themMonAn(monAn);
        }

        closeConnection();
        return hoaDon;
    }

    public HoaDonNhom taoHoaDon(HoaDonNhom hoaDonNhom) throws SQLException, ClassNotFoundException {
        openConnection();
        String sql = "EXEC ThemHoaDonNhom ?,?,?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, hoaDonNhom.getEmailNguoiTao());
        statement.setDate(2, hoaDonNhom.getThoiGianTao());
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
}
