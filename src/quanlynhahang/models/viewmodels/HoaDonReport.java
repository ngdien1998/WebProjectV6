package quanlynhahang.models.viewmodels;

import java.util.ArrayList;
import java.util.Date;

public class HoaDonReport {
    private int maHoaDon;
    private String email;
    private Date thoiGian;

    private ArrayList<MonAnVM> monAns;

    public HoaDonReport() {
        monAns = new ArrayList<>();
    }

    public HoaDonReport(int maHoaDon, String email, Date thoiGian) {
        this.maHoaDon = maHoaDon;
        this.email = email;
        this.thoiGian = thoiGian;
        monAns = new ArrayList<>();
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(Date thoiGian) {
        this.thoiGian = thoiGian;
    }

    public ArrayList<MonAnVM> getMonAns() {
        return monAns;
    }

    public void setMonAns(ArrayList<MonAnVM> monAns) {
        this.monAns = monAns;
    }

    public void add(MonAnVM monAn) {
        monAns.add(monAn);
    }
}
