package quanlynhahang.models.businessmodels;

import quanlynhahang.models.datamodels.MonAn;
import quanlynhahang.models.viewmodels.UserDbConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserChiTietMonAnService extends ConnectDatabase{
    public UserChiTietMonAnService(UserDbConnect user) {
        super(user);
    }

    public MonAn get(Object... keys) throws SQLException, ClassNotFoundException {
        if(keys.length <= 0) {
            return null;
        }
        openConnection();

        String sql = "SELECT * FROM LayMotMonAn (?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setString(1, keys[0].toString());

        ResultSet res = statement.executeQuery();
        MonAn monAn = null;
        if(res.next()){
            monAn = new MonAn();
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
        }

        closeConnection();
        return monAn;
    }
}
