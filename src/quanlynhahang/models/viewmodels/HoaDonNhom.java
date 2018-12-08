package quanlynhahang.models.viewmodels;

import java.util.ArrayList;
import java.util.Date;

public class HoaDonNhom {
    private int idHoaDonNhom;
    private String emailNguoiTao;
    private String tenNguoiTao;
    private Date thoiGianTao;
    private boolean hoanThanh;
    private ArrayList<MonAnNhom> monAnNhoms;

    public HoaDonNhom() {
        monAnNhoms = new ArrayList<>();
    }

    public HoaDonNhom(int idHoaDonNhom, String emailNguoiTao, String tenNguoiTao, Date thoiGianTao, boolean hoanThanh) {
        this.idHoaDonNhom = idHoaDonNhom;
        this.emailNguoiTao = emailNguoiTao;
        this.tenNguoiTao = tenNguoiTao;
        this.thoiGianTao = thoiGianTao;
        this.hoanThanh = hoanThanh;
        monAnNhoms = new ArrayList<>();
    }

    public int getIdHoaDonNhom() {
        return idHoaDonNhom;
    }

    public void setIdHoaDonNhom(int idHoaDonNhom) {
        this.idHoaDonNhom = idHoaDonNhom;
    }

    public String getEmailNguoiTao() {
        return emailNguoiTao;
    }

    public void setEmailNguoiTao(String emailNguoiTao) {
        this.emailNguoiTao = emailNguoiTao;
    }

    public String getTenNguoiTao() {
        return tenNguoiTao;
    }

    public void setTenNguoiTao(String tenNguoiTao) {
        this.tenNguoiTao = tenNguoiTao;
    }

    public Date getThoiGianTao() {
        return thoiGianTao;
    }

    public void setThoiGianTao(Date thoiGianTao) {
        this.thoiGianTao = thoiGianTao;
    }

    public boolean isHoanThanh() {
        return hoanThanh;
    }

    public void setHoanThanh(boolean hoanThanh) {
        this.hoanThanh = hoanThanh;
    }

    public ArrayList<MonAnNhom> getMonAnNhoms() {
        return monAnNhoms;
    }

    public void setMonAnNhoms(ArrayList<MonAnNhom> monAnNhoms) {
        this.monAnNhoms = monAnNhoms;
    }

    public void themMonAn(MonAnNhom monAnNhom) {
        monAnNhoms.add(monAnNhom);
    }

    public void xoaMonAn(int index) {
        monAnNhoms.remove(index);
    }

    public MonAnNhom layMonAn(int index) {
        return monAnNhoms.get(index);
    }
}
