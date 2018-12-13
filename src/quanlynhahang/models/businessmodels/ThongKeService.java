package quanlynhahang.models.businessmodels;

import quanlynhahang.models.datamodels.*;
import quanlynhahang.models.viewmodels.HoaDonReport;
import quanlynhahang.models.viewmodels.MonAnVM;
import quanlynhahang.models.viewmodels.UserDbConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ThongKeService extends ConnectDatabase {
    public ThongKeService(UserDbConnect user) {
        super(user);
    }

    public ArrayList<ThongKeMonAn> top10MonAnBanChay () throws SQLException, ClassNotFoundException {
        ArrayList<ThongKeMonAn> thongKeMonAns = new ArrayList<>();
        openConnection();

        String sql = "EXEC ThongKe10MonAnBanChayNhatThangTruoc";
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

        String sql = "EXEC ThongKeTongThuTungNgayTrongThangTruoc";
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

    public ArrayList<ThongKeTongThu> thongKeTongThuTungNgayTrongThangNay() throws SQLException, ClassNotFoundException {
        ArrayList<ThongKeTongThu> thongKeTongThus = new ArrayList<>();
        openConnection();

        String sql = "EXEC ThongKeTongThuTungNgayTrongThangNay";
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

    public ArrayList<ThongKeTongThuChiTiet> thongKeTongThuChiTietTungThang(int thang) throws SQLException, ClassNotFoundException {
        ArrayList<ThongKeTongThuChiTiet> thongKeTongThus = new ArrayList<>();
        openConnection();

        String sql = "EXEC [ThongKeChiTietTongThu] ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setEscapeProcessing(true);
        statement.setQueryTimeout(90);
        statement.setInt(1, thang);
        ResultSet res = statement.executeQuery();

        while(res.next()){
            ThongKeTongThuChiTiet thongKeTongThuChiTiet = new ThongKeTongThuChiTiet();
            thongKeTongThuChiTiet.setIdHoaDon(res.getInt(1));
            thongKeTongThuChiTiet.setEmail(res.getString(2));
            thongKeTongThuChiTiet.setTenMonAn(res.getString(3));
            thongKeTongThuChiTiet.setSoLuong(res.getInt(4));
            thongKeTongThuChiTiet.setDonGia(res.getInt(5));
            thongKeTongThuChiTiet.setThoiGian(res.getDate(6));

            thongKeTongThus.add(thongKeTongThuChiTiet);
        }

        closeConnection();
        return thongKeTongThus;
    }

    public ArrayList<ThongKeDatBanChiTiet> thongKeDatBanChiTiet() throws SQLException, ClassNotFoundException {
        ArrayList<ThongKeDatBanChiTiet> thongKeDatBans = new ArrayList<>();
        openConnection();

        String sql = "EXEC ThongKeDatBanChiTiet";
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

    public ArrayList<HoaDonReport> reportHoaDonToExcel(int thang) throws SQLException, ClassNotFoundException, ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        ArrayList<HoaDonReport> hoaDons = new ArrayList<>();
        openConnection();
        String sql = "EXEC ThongKeChiTietTongThu ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, thang);
        ResultSet res = statement.executeQuery();
        while (res.next()) {
            int idHoaDon = res.getInt(1);
            String email = res.getString(2);
            Date thoiGian = sdf.parse(res.getString(6));
            MonAnVM monAn = new MonAnVM();
            monAn.setTenMonAn(res.getString(3));
            monAn.setSoLuong(res.getInt(4));
            monAn.setGia(res.getInt(5));
            add(hoaDons, idHoaDon, email, thoiGian, monAn);

        }
        closeConnection();
        return hoaDons;
    }

    private void add(ArrayList<HoaDonReport> hoaDons, int idHoaDon, String email, Date thoiGian, MonAnVM monAn) {
        boolean found = false;
        for (HoaDonReport hoaDon : hoaDons) {
            if (hoaDon.getMaHoaDon() == idHoaDon) {
                hoaDon.add(monAn);
                found = true;
            }
        }
        if (!found) {
            HoaDonReport hoaDon = new HoaDonReport();
            hoaDon.setMaHoaDon(idHoaDon);
            hoaDon.setEmail(email);
            hoaDon.setThoiGian(thoiGian);
            hoaDon.add(monAn);
            hoaDons.add(hoaDon);
        }
    }

    public ArrayList<DatBan> reportDatBanToExcel(int thang) throws SQLException, ClassNotFoundException {
        ArrayList<DatBan> datBans = new ArrayList<>();
        openConnection();
        String sql = "select * from DatBan where MONTH(Ngay) = ? order by Ngay";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, thang);
        ResultSet res = statement.executeQuery();
        while (res.next()) {
            DatBan datBan = new DatBan();
            datBan.setEmail(res.getString(1));
            datBan.setThoiGian(res.getString(2));
            datBan.setNgay(res.getDate(3));
            datBan.setSoLuong(res.getInt(4));
            datBan.setGhiChu(res.getString(5));
            datBan.setHoTen(res.getString(6));
            datBan.setSoDT(res.getString(7));
            datBans.add(datBan);
        }
        closeConnection();
        return datBans;
    }
}