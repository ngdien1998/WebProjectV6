package quanlynhahang.models.businessmodels;

import quanlynhahang.models.datamodels.LoaiMon;
import quanlynhahang.models.datamodels.MonAn;
import quanlynhahang.models.datamodels.ThucDon;
import quanlynhahang.models.viewmodels.UserDbConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MonAnService extends ConnectDatabase implements Businesses<MonAn> {
    public MonAnService(UserDbConnect user) {
        super(user);
    }

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

        String sql = "SELECT * FROM LayTatCaMonAnA";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        ResultSet res = statement.executeQuery();
        while (res.next()) {
            MonAn monAn = new MonAn();
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

            monAns.add(monAn);
        }
        closeConnection();
        return monAns;
    }

    public ArrayList<MonAn> getMonAnMoiNhat() throws SQLException, ClassNotFoundException {
        ArrayList<MonAn> monAns = new ArrayList<>();
        openConnection();

        String sql = "SELECT * FROM LayTatCaMonAnMoiNhat";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        ResultSet res = statement.executeQuery();
        while (res.next()) {
            MonAn monAn = new MonAn();
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

            monAns.add(monAn);
        }
        closeConnection();
        return monAns;
    }


    public ArrayList<MonAn> getMonAnTheoKhuyenMai() throws SQLException, ClassNotFoundException {
        ArrayList<MonAn> monAns = new ArrayList<>();
        openConnection();

        String sql = "SELECT * FROM LayTatCaMonAnTheoKhuyenMaiGiamDan";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        ResultSet res = statement.executeQuery();
        while (res.next()) {
            MonAn monAn = new MonAn();
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
        String sql = "EXEC ThemMonAn ?,?,?,?,?,?,?,?,?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setString(1, monAn.getTenMonAn());
        statement.setString(2, monAn.getDonViTinh());
        statement.setString(3, monAn.getMoTa());
        statement.setString(4, monAn.getMoTaChiTiet());
        statement.setInt(5, monAn.getGia());
        statement.setString(6, monAn.getHinhMonAn());
        statement.setInt(7, monAn.getKhuyenMai());
        statement.setDate(8, monAn.getNgayThem());
        statement.setInt(9, monAn.getIdLoaiMon());

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
        String sql = "EXEC SuaMonAn ?,?,?,?,?,?,?,?,?,?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setInt(1,monAn.getIdMonAn());
        statement.setString(2, monAn.getTenMonAn());
        statement.setString(3, monAn.getDonViTinh());
        statement.setString(4, monAn.getMoTa());
        statement.setString(5, monAn.getMoTaChiTiet());
        statement.setInt(6, monAn.getGia());
        statement.setString(7, monAn.getHinhMonAn());
        statement.setInt(8, monAn.getKhuyenMai());
        statement.setDate(9, monAn.getNgayThem());
        statement.setInt(10, monAn.getIdLoaiMon());

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

    public ArrayList<ThucDon> layToanBoThucDon() throws SQLException, ClassNotFoundException {
        ThucDonService thucDonService = new ThucDonService(getDbAccessValue());
        ArrayList<ThucDon> listThucDon = null;
        listThucDon = thucDonService.getData();
        return listThucDon;
    }

    public ArrayList<LoaiMon> layToanBoLoaiMon() throws SQLException, ClassNotFoundException {
        LoaiMonService loaiMonService = new LoaiMonService(getDbAccessValue());
        ArrayList<LoaiMon> listLoaiMon = null;
        listLoaiMon = loaiMonService.getData();
        return listLoaiMon;
    }

    public ArrayList<MonAn> layMonAnTheoThucDon(int idMonAn) throws SQLException, ClassNotFoundException {
        openConnection();
        ArrayList<MonAn> monAns = new ArrayList<>();
        String sql = "SELECT * FROM LayMonAnNhomTheoThucDon(?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idMonAn);
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
}

