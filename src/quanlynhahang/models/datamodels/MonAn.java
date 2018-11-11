package quanlynhahang.models.datamodels;

import java.sql.Date;

public class MonAn {
    private int idMonAn;
    private String tenMonAn;
    private String donViTinh;
    private String moTa;
    private double gia;
    private int khuyenMai;
    private Date ngayThem;
    private int idLoaiMon;
    private int idThucDon;

    public MonAn() {
    }

    public MonAn(int idMonAn, String tenMonAn, String donViTinh, String moTa, double gia, int khuyenMai, Date ngayThem, int idLoaiMon, int idThucDon) {
        this.idMonAn = idMonAn;
        this.tenMonAn = tenMonAn;
        this.donViTinh = donViTinh;
        this.moTa = moTa;
        this.gia = gia;
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

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
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
