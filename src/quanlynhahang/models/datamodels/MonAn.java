package quanlynhahang.models.datamodels;

import java.sql.Array;
import java.sql.Date;
import java.util.ArrayList;

public class MonAn {
    private int idMonAn;
    private String tenMonAn;
    private String donViTinh;
    private String moTa;
    private String moTaChiTiet;
    private int gia;
    private String hinhMonAn;
    private int khuyenMai;
    private Date ngayThem;
    private int idLoaiMon;
    private int idThucDon;

    public MonAn() {
    }

    public MonAn(int idMonAn, String tenMonAn, String donViTinh, String moTa, int gia, String hinhMonAn, int khuyenMai, Date ngayThem, int idLoaiMon) {
        this.idMonAn = idMonAn;
        this.tenMonAn = tenMonAn;
        this.donViTinh = donViTinh;
        this.moTa = moTa;
        this.gia = gia;
        this.hinhMonAn = hinhMonAn;
        this.khuyenMai = khuyenMai;
        this.ngayThem = ngayThem;
        this.idLoaiMon = idLoaiMon;
    }

    public MonAn(int idMonAn, String tenMonAn, String donViTinh, String moTa, int gia, String hinhMonAn, int khuyenMai, Date ngayThem, int idLoaiMon, int idThucDon) {
        this.idMonAn = idMonAn;
        this.tenMonAn = tenMonAn;
        this.donViTinh = donViTinh;
        this.moTa = moTa;
        this.gia = gia;
        this.hinhMonAn = hinhMonAn;
        this.khuyenMai = khuyenMai;
        this.ngayThem = ngayThem;
        this.idLoaiMon = idLoaiMon;
        this.idThucDon = idThucDon;
    }

    public MonAn(int idMonAn, String tenMonAn, int gia, String hinhMonAn) {
        this.idMonAn = idMonAn;
        this.tenMonAn = tenMonAn;
        this.gia = gia;
        this.hinhMonAn = hinhMonAn;
    }

    public MonAn(int idMonAn, String tenMonAn, String donViTinh, String moTa, String moTaChiTiet, int gia, String hinhMonAn, int khuyenMai, Date ngayThem, int idLoaiMon, int idThucDon) {
        this.idMonAn = idMonAn;
        this.tenMonAn = tenMonAn;
        this.donViTinh = donViTinh;
        this.moTa = moTa;
        this.moTaChiTiet = moTaChiTiet;
        this.gia = gia;
        this.hinhMonAn = hinhMonAn;
        this.khuyenMai = khuyenMai;
        this.ngayThem = ngayThem;
        this.idLoaiMon = idLoaiMon;
        this.idThucDon = idThucDon;
    }

    public int getIdMonAn() {
        return idMonAn;
    }

    public void setIdMonAn(int idMonAn) {
        this.idMonAn = idMonAn;
    }

    public String getTenMonAn() {
        return tenMonAn;
    }

    public void setTenMonAn(String tenMonAn) {
        this.tenMonAn = tenMonAn;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getMoTaChiTiet() {
        return moTaChiTiet;
    }

    public void setMoTaChiTiet(String moTaChiTiet) {
        this.moTaChiTiet = moTaChiTiet;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public String getHinhMonAn() {
        return hinhMonAn;
    }

    public void setHinhMonAn(String hinhMonAn) {
        this.hinhMonAn = hinhMonAn;
    }

    public int getKhuyenMai() {
        return khuyenMai;
    }

    public void setKhuyenMai(int khuyenMai) {
        this.khuyenMai = khuyenMai;
    }

    public Date getNgayThem() {
        return ngayThem;
    }

    public void setNgayThem(Date ngayThem) {
        this.ngayThem = ngayThem;
    }

    public int getIdLoaiMon() {
        return idLoaiMon;
    }

    public void setIdLoaiMon(int idLoaiMon) {
        this.idLoaiMon = idLoaiMon;
    }

    public int getIdThucDon() {
        return idThucDon;
    }

    public void setIdThucDon(int idThucDon) {
        this.idThucDon = idThucDon;
    }
}
