package quanlynhahang.models.datamodels;

import java.sql.Date;

public class ThongKeDatBanChiTiet {
    private String email;
    private String thoiGian;
    private Date ngay;
    private int soLuongNguoi;
    private String ghiChu;
    private String hoTen;
    private String sdt;

    public ThongKeDatBanChiTiet() {
    }

    public ThongKeDatBanChiTiet(String email, String thoiGian, Date ngay, int soLuongNguoi, String ghiChu, String hoTen, String sdt) {
        this.email = email;
        this.thoiGian = thoiGian;
        this.ngay = ngay;
        this.soLuongNguoi = soLuongNguoi;
        this.ghiChu = ghiChu;
        this.hoTen = hoTen;
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public int getSoLuongNguoi() {
        return soLuongNguoi;
    }

    public void setSoLuongNguoi(int soLuongNguoi) {
        this.soLuongNguoi = soLuongNguoi;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
}
