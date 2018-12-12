package quanlynhahang.models.datamodels;
import java.util.ArrayList;
import java.util.Date;
public class HoaDon {
    private int idHoaDon;
    private String email;
    private Date thoiGian;
    private String ghiChu;
    private String tenMon;
    private int soLuong;
    private int donGia;
    private String donVi;

    public HoaDon() {

    }

    public HoaDon(int idHoaDon, String email, Date thoiGian, String ghiChu, String tenMon, int soLuong, int donGia, String donVi) {
        this.idHoaDon = idHoaDon;
        this.email = email;
        this.thoiGian = thoiGian;
        this.ghiChu = ghiChu;
        this.tenMon = tenMon;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.donVi=donVi;
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

    public Date getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(Date thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
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

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }
}
