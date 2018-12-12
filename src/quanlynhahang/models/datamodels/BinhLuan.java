package quanlynhahang.models.datamodels;

import java.sql.Date;

public class BinhLuan {
    private int idBinhLuan;
    private int idBaiViet;
    private int idMonAn;
    private String loai;
    private Date thoiGian;
    private String noiDung;
    private String email;
    private String avatar;

    public BinhLuan() {
    }

    public BinhLuan(int idBinhLuan, int idBaiViet, int idMonAn, String loai, Date thoiGian, String noiDung, String email) {
        this.idBinhLuan = idBinhLuan;
        this.idBaiViet = idBaiViet;
        this.idMonAn = idMonAn;
        this.loai = loai;
        this.thoiGian = thoiGian;
        this.noiDung = noiDung;
        this.email = email;
    }

    public BinhLuan(int idBinhLuan, int idBaiViet, int idMonAn, String loai, Date thoiGian, String noiDung, String email, String avatar) {
        this.idBinhLuan = idBinhLuan;
        this.idBaiViet = idBaiViet;
        this.idMonAn = idMonAn;
        this.loai = loai;
        this.thoiGian = thoiGian;
        this.noiDung = noiDung;
        this.email = email;
        this.avatar = avatar;
    }

    public int getIdBinhLuan() {
        return idBinhLuan;
    }

    public void setIdBinhLuan(int idBinhLuan) {
        this.idBinhLuan = idBinhLuan;
    }

    public int getIdBaiViet() {
        return idBaiViet;
    }

    public void setIdBaiViet(int idBaiViet) {
        this.idBaiViet = idBaiViet;
    }

    public int getIdMonAn() {
        return idMonAn;
    }

    public void setIdMonAn(int idMonAn) {
        this.idMonAn = idMonAn;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
