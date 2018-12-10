package quanlynhahang.models.businessmodels;

import quanlynhahang.models.datamodels.MonAn;
import quanlynhahang.models.viewmodels.UserDbConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserChiTietThucDonService extends ConnectDatabase{
    public UserChiTietThucDonService(UserDbConnect user) {
        super(user);
    }

    public ArrayList<MonAn> getAllMonAnCuaThucDon(int IDThucDon) throws SQLException, ClassNotFoundException {
        ArrayList<MonAn> monAns = new ArrayList<>();
        openConnection();

        String sql = "EXEC LayMonAnTheoThucDon ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setInt(1,IDThucDon);

        ResultSet res = statement.executeQuery();
        while (res.next()) {
            MonAn monAn = new MonAn();
            monAn.setIdMonAn(res.getInt(1));
            monAn.setTenMonAn(res.getString(2));
            monAn.setGia(res.getInt(3));
            monAn.setHinhMonAn(res.getString(4));
            monAn.setKhuyenMai(res.getInt(5));

            monAns.add(monAn);
        }
        closeConnection();
        return monAns;
    }
}
