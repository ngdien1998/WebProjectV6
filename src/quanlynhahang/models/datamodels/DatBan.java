package quanlynhahang.models.datamodels;
import java.sql.Array;
import java.sql.Date;
import java.util.ArrayList;

public class DatBan {
    private String email;
    private Date thoiGian;
    private int soLuong;
    private String ghiChu;

    public DatBan(){
    }

    public DatBan(String email, Date thoiGian, int soLuong, String ghiChu) {
        this.email = email;
        this.thoiGian = thoiGian;
        this.soLuong = soLuong;
        this.ghiChu = ghiChu;
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


