package quanlynhahang.models.businessmodels;

import quanlynhahang.models.datamodels.ThucDon;
import quanlynhahang.models.viewmodels.UserDbConnect;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ThucDonService  extends ConnectDatabase implements Businesses<ThucDon> {
    public ThucDonService(UserDbConnect user) {
        super(user);
    }

    @Override
    public ArrayList<ThucDon> getData() throws SQLException, ClassNotFoundException {
        ArrayList<ThucDon> thucDons = new ArrayList<>();
        openConnection();

        String sql = "SELECT * FROM LayTatCaThucDon";
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

    @Override
    public int add(ThucDon thucDon) throws SQLException, ClassNotFoundException {
        if(thucDon == null){
            return 0;
        }
        openConnection();
        String sql = "EXEC ThemThucDon ?,?,?,?,?,?,?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setString(1, thucDon.getTenThucDon());
        statement.setString(2, thucDon.getMoTa());
        statement.setInt(3,thucDon.getGia());
        statement.setInt(4,thucDon.getPhanTramKhuyenMai());
        statement.setInt(5,thucDon.getThu());
        statement.setString(6, thucDon.getHinhThucDon());
        statement.setInt(7, 0);

        int rowAffected = statement.executeUpdate();
        closeConnection();
        return rowAffected;
    }

    @Override
    public int delete(Object... keys) throws SQLException, ClassNotFoundException {
        openConnection();

        String sql = "EXEC XoaThucDon ?";
        // Thực đơn có chứa món ăn thì sao, Không cho xóa
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setInt(1, (int)keys[0]);
        int rowAffected = statement.executeUpdate();
        closeConnection();
        return rowAffected;
    }

    @Override
    public int modify(ThucDon thucDon) throws SQLException, ClassNotFoundException {
        openConnection();
        String sql = "EXEC SuaThucDon ?,?,?,?,?,?,?,?";
        // Xóa thì Set lan truyền

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setInt(1,thucDon.getIdThucDon());
        statement.setString(2, thucDon.getTenThucDon());
        statement.setString(3, thucDon.getMoTa());
        statement.setInt(4,thucDon.getGia());
        statement.setInt(5,thucDon.getPhanTramKhuyenMai());
        statement.setInt(6,thucDon.getThu());
        statement.setString(7, thucDon.getHinhThucDon());
        statement.setInt(8,0);

        int rowAffected = statement.executeUpdate();
        closeConnection();
        return rowAffected;
    }

    @Override
    public ThucDon get(Object... keys) throws SQLException, ClassNotFoundException {
        if(keys.length <= 0) {
            return null;
        }
        openConnection();

        String sql = "SELECT * FROM LayMotThucDon (?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setString(1, keys[0].toString());

        ResultSet res = statement.executeQuery();
        ThucDon thucDon = null;
        if(res.next()){
            thucDon = new ThucDon();
            thucDon.setIdThucDon(res.getInt(1));
            thucDon.setTenThucDon(res.getString(2));
            thucDon.setMoTa(res.getString(3));
            thucDon.setGia(res.getInt(4));
            thucDon.setPhanTramKhuyenMai(res.getInt(5));
            thucDon.setThu(res.getInt(6));
            thucDon.setHinhThucDon(res.getString(7));
            thucDon.setMucDanhGia(Integer.parseInt(res.getString(8)));
        }

        closeConnection();
        return thucDon;
    }

    public ThucDon getThucDon(String idThucDon) throws SQLException{

        String sql = "SELECT * FROM LayMotThucDon (?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setInt(1, Integer.parseInt(idThucDon));

        ResultSet res = statement.executeQuery();
        ThucDon thucDon = null;
        if(res.next()){
            thucDon = new ThucDon();
            thucDon.setIdThucDon(res.getInt(1));
            thucDon.setTenThucDon(res.getString(2));
            thucDon.setMoTa(res.getString(3));
            thucDon.setGia(res.getInt(4));
            thucDon.setPhanTramKhuyenMai(res.getInt(5));
            thucDon.setThu(res.getInt(6));
            thucDon.setHinhThucDon(res.getString(7));
            thucDon.setMucDanhGia(Integer.parseInt(res.getString(8)));
        }

        closeConnection();
        return thucDon;
    }
}
