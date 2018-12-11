package quanlynhahang.models.businessmodels;

import quanlynhahang.models.datamodels.*;
import quanlynhahang.models.viewmodels.UserDbConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ThongKeService extends ConnectDatabase {
    public ThongKeService(UserDbConnect user) {
        super(user);
    }

    public ArrayList<ThongKeMonAn> top10MonAnBanChay () throws SQLException, ClassNotFoundException {
        ArrayList<ThongKeMonAn> thongKeMonAns = new ArrayList<>();
        openConnection();

        String sql = "SELECT * FROM ThongKe10MonAnBanChayNhatThangTruoc";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        ResultSet res = statement.executeQuery();

        while(res.next()){
            ThongKeMonAn thongKeMonAn = new ThongKeMonAn();
            thongKeMonAn.setTenMonAn(res.getString(1));
            thongKeMonAn.setSoLuong(res.getInt(2));

            thongKeMonAns.add(thongKeMonAn);
        }

        closeConnection();
        return thongKeMonAns;
    }

    public ArrayList<ThongKeThucDon> thongKeSuDungThucDon () throws SQLException, ClassNotFoundException {
        ArrayList<ThongKeThucDon> thongKeThucDons = new ArrayList<>();
        openConnection();

        String sql = "SELECT * FROM ThongKeSoLanSuDungThucDon";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        ResultSet res = statement.executeQuery();

        while(res.next()){
            ThongKeThucDon thongKeThucDon = new ThongKeThucDon();
            thongKeThucDon.setTenThucDon(res.getString(1));
            thongKeThucDon.setSoLanSuDung(res.getInt(2));

            thongKeThucDons.add(thongKeThucDon);
        }

        closeConnection();
        return thongKeThucDons;
    }

    public ArrayList<ThongKeTongThu> thongKeTongThuTungNgayTrongThang () throws SQLException, ClassNotFoundException {
        ArrayList<ThongKeTongThu> thongKeTongThus = new ArrayList<>();
        openConnection();

        String sql = "SELECT * FROM ThongKeTongThuTungNgay";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        ResultSet res = statement.executeQuery();

        while(res.next()){
            ThongKeTongThu thongKeTongThu = new ThongKeTongThu();
            thongKeTongThu.setTongTien(res.getInt(1));
            thongKeTongThu.setThoiGian(res.getInt(2));

            thongKeTongThus.add(thongKeTongThu);
        }

        closeConnection();
        return thongKeTongThus;
    }

    public ArrayList<ThongKeTongThu> thongKeTongThuTungThang() throws SQLException, ClassNotFoundException {
        ArrayList<ThongKeTongThu> thongKeTongThus = new ArrayList<>();
        openConnection();

        String sql = "SELECT * FROM ThongKeTongThuTungThang";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        ResultSet res = statement.executeQuery();

        while(res.next()){
            ThongKeTongThu thongKeTongThu = new ThongKeTongThu();
            thongKeTongThu.setTongTien(res.getInt(1));
            thongKeTongThu.setThoiGian(res.getInt(2));

            thongKeTongThus.add(thongKeTongThu);
        }

        closeConnection();
        return thongKeTongThus;
    }

    public ArrayList<ThongKeDatBanChiTiet> thongKeDatBanChiTiet() throws SQLException, ClassNotFoundException {
        ArrayList<ThongKeDatBanChiTiet> thongKeDatBans = new ArrayList<>();
        openConnection();

        String sql = "SELECT * FROM ThongKeDatBanChiTiet";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        ResultSet res = statement.executeQuery();

        while(res.next()){
            ThongKeDatBanChiTiet thongKeDatBan = new ThongKeDatBanChiTiet();
            thongKeDatBan.setEmail(res.getString(1));
            thongKeDatBan.setThoiGian(res.getString(2));
            thongKeDatBan.setNgay(res.getDate(3));
            thongKeDatBan.setSoLuongNguoi(res.getInt(4));
            thongKeDatBan.setGhiChu(res.getString(5));
            thongKeDatBan.setHoTen(res.getString(6));
            thongKeDatBan.setSdt(res.getString(7));

            thongKeDatBans.add(thongKeDatBan);
        }

        closeConnection();
        return thongKeDatBans;
    }

    public ArrayList<ThongKeDatBanBieuDo> thongKeDatBanBieuDo() throws SQLException, ClassNotFoundException {
        ArrayList<ThongKeDatBanBieuDo> thongKeDatBans = new ArrayList<>();
        openConnection();

        String sql = "SELECT * FROM ThongKeDatBanBieuDo";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        ResultSet res = statement.executeQuery();

        while(res.next()){
            ThongKeDatBanBieuDo thongKeDatBan = new ThongKeDatBanBieuDo();
            thongKeDatBan.setSoLuong(res.getInt(1));
            thongKeDatBan.setNgay(res.getInt(2));

            thongKeDatBans.add(thongKeDatBan);
        }

        closeConnection();
        return thongKeDatBans;
    }

    public ArrayList<ThongKeBinhLuanBieuDo> thongKeBinhLuanBieuDo() throws SQLException, ClassNotFoundException {
        ArrayList<ThongKeBinhLuanBieuDo> thongKeBinhLuanBieuDos = new ArrayList<>();
        openConnection();

        String sql = "SELECT * FROM ThongKeBinhLuanBieuDo";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        ResultSet res = statement.executeQuery();

        while(res.next()){
            ThongKeBinhLuanBieuDo thongKeBinhLuanBieuDo = new ThongKeBinhLuanBieuDo();
            thongKeBinhLuanBieuDo.setSoLuong(res.getInt(1));
            thongKeBinhLuanBieuDo.setNgay(res.getInt(2));

            thongKeBinhLuanBieuDos.add(thongKeBinhLuanBieuDo);
        }

        closeConnection();
        return thongKeBinhLuanBieuDos;
    }
}
