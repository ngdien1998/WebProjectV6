package quanlynhahang.models.datamodels;

import java.sql.Date;

public class ThongKeTongThuChiTiet {
    private int idHoaDon;
    private String email;
    private String tenMonAn;
    private int soLuong;
    private int donGia;
    private Date thoiGian;

    public ThongKeTongThuChiTiet() {
    }

    public ThongKeTongThuChiTiet(int idHoaDon, String email, String tenMonAn, int soLuong, int donGia, Date thoiGian) {
        this.idHoaDon = idHoaDon;
        this.email = email;
        this.tenMonAn = tenMonAn;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thoiGian = thoiGian;
    }

    public int getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTenMonAn() {
        return tenMonAn;
    }

    public void setTenMonAn(String tenMonAn) {
        this.tenMonAn = tenMonAn;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public Date getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(Date thoiGian) {
        this.thoiGian = thoiGian;
    }
}
