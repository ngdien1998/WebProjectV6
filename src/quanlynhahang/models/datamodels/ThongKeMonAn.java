package quanlynhahang.models.datamodels;

import java.sql.Date;

public class ThongKeMonAn {
    private String tenMonAn;
    private int soLuong;
    private int donGia;
    private Date thoiGian;

    public ThongKeMonAn() {
    }

    public ThongKeMonAn(String tenMonAn, int soLuong, int donGia, Date thoiGian) {
        this.tenMonAn = tenMonAn;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thoiGian = thoiGian;
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
