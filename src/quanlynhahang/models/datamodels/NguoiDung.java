package quanlynhahang.models.datamodels;

import java.sql.Date;

public class NguoiDung {
    private String email;
    private String hoDem;
    private String ten;
    private String matKhau;
    private Date ngaySinh;
    private boolean nu;
    private String avatar;
    private String dienThoai;
    private String diaChi;
    private boolean quanTriVien;
    private boolean kichHoat;
    private boolean choPhep;

    public NguoiDung() {
    }

    public NguoiDung(String email, String hoDem, String ten, String matKhau, Date ngaySinh, boolean nu, String avatar, String dienThoai, String diaChi, boolean quanTriVien, boolean kichHoat, boolean choPhep) {
        this.email = email;
        this.hoDem = hoDem;
        this.ten = ten;
        this.matKhau = matKhau;
        this.ngaySinh = ngaySinh;
        this.nu = nu;
        this.avatar = avatar;
        this.dienThoai = dienThoai;
        this.diaChi = diaChi;
        this.quanTriVien = quanTriVien;
        this.kichHoat = kichHoat;
        this.choPhep = choPhep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHoDem() {
        return hoDem;
    }

    public void setHoDem(String hoDem) {
        this.hoDem = hoDem;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public boolean isNu() {
        return nu;
    }

    public void setNu(boolean nu) {
        this.nu = nu;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public boolean isQuanTriVien() {
        return quanTriVien;
    }

    public void setQuanTriVien(boolean quanTriVien) {
        this.quanTriVien = quanTriVien;
    }

    public boolean isKichHoat() {
        return kichHoat;
    }

    public void setKichHoat(boolean kichHoat) {
        this.kichHoat = kichHoat;
    }

    public boolean isChoPhep() {
        return choPhep;
    }

    public void setChoPhep(boolean choPhep) {
        this.choPhep = choPhep;
    }
}
