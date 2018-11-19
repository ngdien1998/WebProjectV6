package quanlynhahang.models.datamodels;

import java.sql.Date;

public class BinhLuan {
    private int idBinhLuan;
    private int idDanhMucLienQuan;
    private String loai;
    private Date thoiGian;
    private String noiDung;
    private String email;

    public BinhLuan() {
    }

    public BinhLuan(int idBinhLuan, int idDanhMucLienQuan, String loai, Date thoiGian, String noiDung, String email) {
        this.idBinhLuan = idBinhLuan;
        this.idDanhMucLienQuan = idDanhMucLienQuan;
        this.loai = loai;
        this.thoiGian = thoiGian;
        this.noiDung = noiDung;
        this.email = email;
    }

    public int getIdBinhLuan() {
        return idBinhLuan;
    }

    public void setIdBinhLuan(int idBinhLuan) {
        this.idBinhLuan = idBinhLuan;
    }

    public int getIdDanhMucLienQuan() {
        return idDanhMucLienQuan;
    }

    public void setIdDanhMucLienQuan(int idDanhMucLienQuan) {
        this.idDanhMucLienQuan = idDanhMucLienQuan;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public Date getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(Date thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
