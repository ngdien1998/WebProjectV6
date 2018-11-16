package quanlynhahang.models.businessmodels;

import quanlynhahang.models.datamodels.LoaiMon;
import quanlynhahang.models.datamodels.MonAn;
import quanlynhahang.models.datamodels.ThucDon;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MonAnService extends ConnectDatabase implements Businesses<MonAn> {
    // Lấy các món ăn trong thực đơn để hiển thị trong trang xem chi tiết thực đơn
    public ArrayList<Integer> getIDMonAn(int idThucDon) throws SQLException, ClassNotFoundException {
//        ArrayList<MonAn> monAns = new ArrayList<>();
        openConnection();
        String sql = "EXEC LayTatCaIDMonAnTrongThucDon ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setInt(1,idThucDon);

        ResultSet res = statement.executeQuery();
        ArrayList<Integer> listIDMonAn = new ArrayList<>();
        while (res.next()){
            int ID;
            ID = res.getInt(1);
            listIDMonAn.add(ID);
        }
        closeConnection();
        return listIDMonAn;
    }
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
            monAn.setIdMonAn(res.getInt(1));
            monAn.setTenMonAn(res.getString(2));
            monAn.setDonViTinh(res.getString(3));
            monAn.setMoTa(res.getString(4));
            monAn.setGia(res.getInt(5));
            monAn.setKhuyenMai(res.getInt(6));
            monAn.setNgayThem(res.getDate(7));
            monAn.setIdLoaiMon(res.getInt(8));

            monAns.add(monAn);
        }
        closeConnection();
        return monAns;
    }

//    @Override
    public int add(MonAn monAn) throws SQLException, ClassNotFoundException {
        if (monAn == null) {
            return 0;
        }
        openConnection();
        String sql = "EXEC ThemMonAn ?,?,?,?,?,?,?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setString(1, monAn.getTenMonAn());
        statement.setString(2, monAn.getDonViTinh());
        statement.setString(3, monAn.getMoTa());
        statement.setInt(4, monAn.getGia());
        statement.setInt(5, monAn.getKhuyenMai());
        statement.setDate(6, monAn.getNgayThem());
        statement.setInt(7, monAn.getIdLoaiMon());

        int rowAffected = statement.executeUpdate();
        closeConnection();
        return rowAffected;
    }


    @Override
    public int delete(Object... keys) throws SQLException, ClassNotFoundException {
        openConnection();
        String sql = "EXEC XoaMonAn ?";

        PreparedStatement statement = null;
        statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setInt(1, (int) keys[0]);

        int rowAffected = statement.executeUpdate();
        closeConnection();
        return rowAffected;
    }

    @Override
    public int modify(MonAn monAn) throws SQLException, ClassNotFoundException {
        openConnection();
        String sql = "EXEC SuaMonAn ?,?,?,?,?,?,?,?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setInt(1,monAn.getIdMonAn());
        statement.setString(2, monAn.getTenMonAn());
        statement.setString(3, monAn.getDonViTinh());
        statement.setString(4, monAn.getMoTa());
        statement.setInt(5, monAn.getGia());
        statement.setInt(6, monAn.getKhuyenMai());
        statement.setDate(7, monAn.getNgayThem());
        statement.setInt(8, monAn.getIdLoaiMon());

        int rowAffected = statement.executeUpdate();
        closeConnection();
        return rowAffected;
    }

    @Override
    public MonAn get(Object... keys) throws SQLException, ClassNotFoundException {
        if(keys.length <= 0) {
            return null;
        }
        openConnection();

        String sql = "EXEC LayMotMonAn ?";
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
            monAn.setGia(res.getInt(5));
            monAn.setKhuyenMai(res.getInt(6));
            monAn.setNgayThem(res.getDate(7));
            monAn.setIdLoaiMon(res.getInt(8));
        }

        closeConnection();
        return monAn;
    }

    public ArrayList<ThucDon> layToanBoThucDon() throws SQLException, ClassNotFoundException {
        ThucDonService thucDonService = new ThucDonService();
        ArrayList<ThucDon> listThucDon = null;
        listThucDon = thucDonService.getData();
        return listThucDon;
    }

    public ArrayList<LoaiMon> layToanBoLoaiMon() throws SQLException, ClassNotFoundException {
        LoaiMonService loaiMonService = new LoaiMonService();
        ArrayList<LoaiMon> listLoaiMon = null;
        listLoaiMon = loaiMonService.getData();
        return listLoaiMon;
    }
}

