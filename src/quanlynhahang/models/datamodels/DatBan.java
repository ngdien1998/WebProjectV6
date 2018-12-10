package quanlynhahang.models.datamodels;
import java.sql.Array;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class DatBan {
    private String email;
    private String thoiGian;
    private Date ngay;
    private int soLuong;
    private String ghiChu;
    private  String hoTen;
    private  String soDT;

    public DatBan(){
    }



    public DatBan(String email, String thoiGian, Date ngay, int soLuong, String ghiChu, String hoTen, String soDT) {
        this.email = email;
        this.thoiGian = thoiGian;
        this.ngay=ngay;
        this.soLuong = soLuong;
        this.ghiChu = ghiChu;
        this.hoTen=hoTen;
        this.soDT=soDT;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }
    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public void setHoTen(String hoTen){ this.hoTen=hoTen;}

    public String getHoTen() {
        return hoTen;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }
}


