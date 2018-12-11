package quanlynhahang.models.businessmodels;

import quanlynhahang.models.datamodels.MonAn;
import quanlynhahang.models.viewmodels.UserDbConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserTatCaMonAnService extends ConnectDatabase{
    public UserTatCaMonAnService(UserDbConnect user) {
        super(user);
    }

    public ArrayList<MonAn> getData() throws SQLException, ClassNotFoundException {
        ArrayList<MonAn> monAns = new ArrayList<>();
        openConnection();

        String sql = "SELECT  * FROM LayTatCaMonAnA";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        ResultSet res = statement.executeQuery();
        while (res.next()) {
            MonAn monAn = new MonAn();
            monAn.setIdMonAn(res.getInt(1));
            monAn.setTenMonAn(res.getString(2));
            monAn.setDonViTinh(res.getString(3));
            monAn.setMoTa(res.getString(4));
            monAn.setMoTaChiTiet(res.getString(5));
            monAn.setGia(res.getInt(6));
            monAn.setHinhMonAn(res.getString(7));
            monAn.setKhuyenMai(res.getInt(8));
            monAn.setNgayThem(res.getDate(9));
            monAn.setIdLoaiMon(res.getInt(10));

            monAns.add(monAn);
        }
        closeConnection();
        return monAns;
    }

    public ArrayList<MonAn> LayBaMonAnMoiNhat() throws SQLException, ClassNotFoundException {
        ArrayList<MonAn> monAns = new ArrayList<>();
        openConnection();

        String sql = "SELECT  * FROM LAY_BA_MONAN_MOINHATG";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        ResultSet res = statement.executeQuery();
        while (res.next()) {
            MonAn monAn = new MonAn();
            monAn.setIdMonAn(res.getInt(1));
            monAn.setTenMonAn(res.getString(2));
            monAn.setDonViTinh(res.getString(3));
            monAn.setMoTa(res.getString(4));
            monAn.setMoTaChiTiet(res.getString(5));
            monAn.setGia(res.getInt(6));
            monAn.setHinhMonAn(res.getString(7));
            monAn.setKhuyenMai(res.getInt(8));
            monAn.setNgayThem(res.getDate(9));
            monAn.setIdLoaiMon(res.getInt(10));

            monAns.add(monAn);
        }
        closeConnection();
        return monAns;
    }

    public ArrayList<MonAn> LayMonAnTheoLoaiMon(String idLoaiMon) throws SQLException, ClassNotFoundException {
        ArrayList<MonAn> monAns = new ArrayList<>();
        openConnection();

        String sql = "EXEC LayMonAnTheoLoaiMon ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setInt(1, Integer.parseInt(idLoaiMon));

        ResultSet res = statement.executeQuery();
        while (res.next()) {
            MonAn monAn = new MonAn();
            monAn.setIdMonAn(res.getInt(1));
            monAn.setTenMonAn(res.getString(2));
            monAn.setDonViTinh(res.getString(3));
            monAn.setMoTa(res.getString(4));
            monAn.setMoTaChiTiet(res.getString(5));
            monAn.setGia(res.getInt(6));
            monAn.setHinhMonAn(res.getString(7));
            monAn.setKhuyenMai(res.getInt(8));
            monAn.setNgayThem(res.getDate(9));
            monAn.setIdLoaiMon(res.getInt(10));

            monAns.add(monAn);
        }
        closeConnection();
        return monAns;
    }

    public ArrayList<MonAn> LayMonAnTheoGia(String gia_min, String gia_max) throws SQLException, ClassNotFoundException {
        ArrayList<MonAn> monAns = new ArrayList<>();
        openConnection();

        String sql = "EXEC LayMonAnTheoGia ?, ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setInt(1, Integer.parseInt(gia_min));
        statement.setInt(2, Integer.parseInt(gia_max));

        ResultSet res = statement.executeQuery();
        while (res.next()) {
            MonAn monAn = new MonAn();
            monAn.setIdMonAn(res.getInt(1));
            monAn.setTenMonAn(res.getString(2));
            monAn.setDonViTinh(res.getString(3));
            monAn.setMoTa(res.getString(4));
            monAn.setMoTaChiTiet(res.getString(5));
            monAn.setGia(res.getInt(6));
            monAn.setHinhMonAn(res.getString(7));
            monAn.setKhuyenMai(res.getInt(8));
            monAn.setNgayThem(res.getDate(9));
            monAn.setIdLoaiMon(res.getInt(10));

            monAns.add(monAn);
        }
        closeConnection();
        return monAns;
    }
}
