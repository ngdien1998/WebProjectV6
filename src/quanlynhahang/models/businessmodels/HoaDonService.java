package quanlynhahang.models.businessmodels;

import quanlynhahang.models.datamodels.DatBan;
import quanlynhahang.models.datamodels.HoaDon;
import quanlynhahang.models.viewmodels.UserDbConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HoaDonService extends ConnectDatabase implements  Businesses<HoaDon> {

    public HoaDonService(UserDbConnect user) {
        super(user);
    }

    @Override
    public ArrayList<HoaDon> getData() throws SQLException, ClassNotFoundException {
        ArrayList<HoaDon> hoaDons=new ArrayList<>();
        openConnection();

        String sql="Select * from LayHoaDon";
        PreparedStatement statement=connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        ResultSet res=statement.executeQuery();
        while (res.next())
        {
            HoaDon hoaDon=new HoaDon();
            hoaDon.setIdHoaDon(res.getInt(1));
            hoaDon.setEmail(res.getString(2));
            hoaDon.setThoiGian(res.getDate(3));
            hoaDon.setGhiChu(res.getString(4));
            hoaDons.add(hoaDon);
        }
        closeConnection();
        return hoaDons;
    }

    @Override
    public int add(HoaDon hoaDon) throws SQLException, ClassNotFoundException {
//        if(hoaDon==null)
//            return 0;
//        openConnection();
//        String sql="exec ThemHoaDon ?,?,?";
//        PreparedStatement statement=connection.prepareStatement(sql) ;
//        statement.setEscapeProcessing(true);
//        statement.setQueryTimeout(90);
//        statement.setInt(1,hoaDon.getIdMonAn());
//        statement.setInt(2,hoaDon.getSoLuong());
//        statement.setInt(3,hoaDon.getDonGia());
//        int rowAffected=statement.executeUpdate();
//        closeConnection();
//        return rowAffected;
        return 0;
    }

    @Override
    public int delete(Object... keys) throws SQLException, ClassNotFoundException {

        return 0;
    }

    @Override
    public int modify(HoaDon hoaDon) throws SQLException, ClassNotFoundException {
        return 0;
    }

    @Override
    public HoaDon get(Object... keys) throws SQLException, ClassNotFoundException {
        return null;
    }


    public ArrayList<HoaDon> getHoaDon(String id) throws SQLException, ClassNotFoundException {
        ArrayList<HoaDon> hoaDons=new ArrayList<>();
        openConnection();
        String sql="exec LayMotHoaDon ?";
        PreparedStatement statement=connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setString(1,id);

        ResultSet res=statement.executeQuery();
        while(res.next()){
            HoaDon hoaDon=new HoaDon();
            hoaDon.setEmail(res.getString(1));
            hoaDon.setThoiGian(res.getDate(2));
            hoaDon.setGhiChu(res.getString(3));
            hoaDon.setTenMon(res.getString(4));
            hoaDon.setSoLuong(res.getInt(5));
            hoaDon.setDonGia(res.getInt(6));
            hoaDons.add(hoaDon);
        }
        closeConnection();
        return hoaDons;
    }
}
