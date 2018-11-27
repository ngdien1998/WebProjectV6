package quanlynhahang.models.businessmodels;

import quanlynhahang.models.datamodels.MonAn;
import quanlynhahang.models.datamodels.ThucDon;
import quanlynhahang.models.viewmodels.UserDbConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserTrangChuService extends  ConnectDatabase{
    public UserTrangChuService(UserDbConnect user) {
        super(user);
    }

    public ArrayList<MonAn> getBonMonAnMoiNhat () throws SQLException, ClassNotFoundException {
        ArrayList<MonAn> monAns = new ArrayList<>();
        openConnection();

        String sql = "SELECT * FROM LAY_4_MONAN_MOINHAT";
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
            monAn.setGia(res.getInt(5));
            monAn.setHinhMonAn(res.getString(6));
            monAn.setKhuyenMai(res.getInt(7));
            monAn.setNgayThem(res.getDate(8));
            monAn.setIdLoaiMon(res.getInt(9));

            monAns.add(monAn);
        }
        closeConnection();
        return monAns;
    }

    public ArrayList<ThucDon> getBonThucDonMoiNhat () throws SQLException, ClassNotFoundException {
        ArrayList<ThucDon> thucDons = new ArrayList<>();
        openConnection();

        String sql = "SELECT * FROM LAY_THUCDON_MOINHAT";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        ResultSet res = statement.executeQuery();

        while(res.next()){
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
}
