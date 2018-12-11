package quanlynhahang.models.businessmodels;

import quanlynhahang.models.datamodels.BaiViet;
import quanlynhahang.models.datamodels.MonAn;
import quanlynhahang.models.datamodels.ThucDon;
import quanlynhahang.models.viewmodels.UserDbConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserTrangChuService extends ConnectDatabase {
    public UserTrangChuService(UserDbConnect user) {
        super(user);
    }

    public ArrayList<MonAn> getBonMonAnMoiNhat() throws SQLException, ClassNotFoundException {
        ArrayList<MonAn> monAns = new ArrayList<>();
        openConnection();

        String sql = "SELECT * FROM LAY_12_MONAN_MOINHAT";
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

    public ArrayList<ThucDon> getBonThucDonMoiNhat() throws SQLException, ClassNotFoundException {
        ArrayList<ThucDon> thucDons = new ArrayList<>();
        openConnection();

        String sql = "SELECT * FROM LAY_THUCDON_MOINHAT";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        ResultSet res = statement.executeQuery();

        while (res.next()) {
            ThucDon thucDon = new ThucDon();
            thucDon.setIdThucDon(res.getInt(1));
            thucDon.setTenThucDon(res.getString(2));
            thucDon.setMoTa(res.getString(3));
            thucDon.setGia(res.getInt(4));
            thucDon.setPhanTramKhuyenMai(res.getInt(5));
            thucDon.setThu(res.getInt(6));
            thucDon.setHinhThucDon(res.getString(7));

            thucDons.add(thucDon);
        }

        closeConnection();
        return thucDons;
    }

    public ArrayList<BaiViet> getBonBaiVietMoiNhat() throws SQLException, ClassNotFoundException {
        ArrayList<BaiViet> baiViets = new ArrayList<>();
        openConnection();

        String sql = "SELECT * FROM LAY_4_BAIVIET_MOINHAT";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
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

}
