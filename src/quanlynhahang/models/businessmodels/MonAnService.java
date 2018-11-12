package quanlynhahang.models.businessmodels;

import quanlynhahang.models.datamodels.MonAn;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MonAnService extends ConnectDatabase implements Businesses<MonAn> {

    @Override
    public ArrayList<MonAn> getData() throws SQLException, ClassNotFoundException {
        ArrayList<MonAn> monAns = new ArrayList<>();
        openConnection();

        String sql = "EXEC LayMonAn";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        ResultSet res = statement.executeQuery();
        while (res.next()) {
            MonAn monAn = new MonAn();
            monAn.setIdLoaiMon(res.getInt(1));
            monAn.setTenMonAn(res.getString(2));
            monAn.setDonViTinh(res.getString(3));
            monAn.setMoTa(res.getString(4));
            monAn.setGia(res.getDouble(5));
            monAn.setKhuyenMai(res.getInt(6));
            monAn.setNgayThem(res.getDate(7));
            monAn.setIdLoaiMon(res.getInt(8));
            monAn.setIdThucDon(res.getInt(9));

            monAns.add(monAn);
        }
        closeConnection();
        return monAns;
    }

    @Override
    public int add(MonAn monAn) throws SQLException, ClassNotFoundException {
        return 0;
    }

    @Override
    public int delete(Object... keys) {
        return 0;
    }

    @Override
    public int modify(MonAn monAn) throws SQLException, ClassNotFoundException {
        return 0;
    }

    @Override
    public MonAn get(Object... keys) throws SQLException, ClassNotFoundException {
        return null;
    }
}
