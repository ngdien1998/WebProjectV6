package quanlynhahang.models.datamodels;
import java.sql.Array;
import java.sql.Date;
import java.util.ArrayList;

public class DatBan {
    private String email;
    private String ban;
    private Date thoiGian;
    private int soLuong;
    private int giaTien;
    private String ghiChu;

    public DatBan(){
    }
    public DatBan(String email,String ban, Date thoiGian, int soLuong, int giaTien,String ghiChu){
        this.email=email;
        this.ban=ban;
        this.thoiGian=thoiGian;
        this.soLuong=soLuong;
        this.giaTien=giaTien;
        this.ghiChu=ghiChu;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getBan() {
        return ban;
    }
    public void setBan(String ban) {
        this.ban = ban;
    }
    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getGia() {
        return giaTien;
    }

    public void setGia(int gia) {
        this.giaTien = gia;
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
}


