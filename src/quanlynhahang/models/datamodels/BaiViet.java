package quanlynhahang.models.datamodels;

import java.util.Date;

public class BaiViet  {
    private int idBaiViet;
    private String tenBaiViet;
    private String moTa;
    private String noiDung;
    private Date ngayViet;
    private String hinh;
    private String email;
    private int idLoaiBaiViet;

    public BaiViet() {
    }

    public BaiViet(int idBaiViet, String tenBaiViet, String moTa, String noiDung, Date ngayViet, String email, int idLoaiBaiViet) {
        this.idBaiViet = idBaiViet;
        this.tenBaiViet = tenBaiViet;
        this.moTa = moTa;
        this.noiDung = noiDung;
        this.ngayViet = ngayViet;
        this.email = email;
        this.idLoaiBaiViet = idLoaiBaiViet;
    }

    public int getIdBaiViet() {
        return idBaiViet;
    }

    public void setIdBaiViet(int idBaiViet) {
        this.idBaiViet = idBaiViet;
    }

    public String getTenBaiViet() {
        return tenBaiViet;
    }

    public void setTenBaiViet(String tenBaiViet) {
        this.tenBaiViet = tenBaiViet;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public Date getNgayViet() {
        return ngayViet;
    }

    public void setNgayViet(Date ngayViet) {
        this.ngayViet = ngayViet;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdLoaiBaiViet() {
        return idLoaiBaiViet;
    }

    public void setIdLoaiBaiViet(int idLoaiBaiViet) {
        this.idLoaiBaiViet = idLoaiBaiViet;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }
}
