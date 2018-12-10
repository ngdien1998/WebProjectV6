package quanlynhahang.models.datamodels;

import java.sql.Date;

public class BinhLuan {
    private int idBinhLuan;
    private int idMonAn;
    private int idBaiViet;
    private Date thoiGian;
    private String noiDung;
    private String email;

    public BinhLuan() {
    }

    public BinhLuan(int idBinhLuan, int idMonAn, int idBaiViet, Date thoiGian, String noiDung, String email) {
        this.idBinhLuan = idBinhLuan;
        this.idMonAn = idMonAn;
        this.idBaiViet = idBaiViet;
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

    public int getIdMonAn() {
        return idMonAn;
    }

    public void setIdMonAn(int idMonAn) {
        this.idMonAn = idMonAn;
    }

    public int getIdBaiViet() {
        return idBaiViet;
    }

    public void setIdBaiViet(int idBaiViet) {
        this.idBaiViet = idBaiViet;
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
