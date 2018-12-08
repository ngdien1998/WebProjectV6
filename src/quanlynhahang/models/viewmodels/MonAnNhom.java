package quanlynhahang.models.viewmodels;

public class MonAnNhom {
    private int idMonAn;
    private String tenMonAn;
    private int gia;
    private int soLuong;
    private String emailNguoiDat;
    private String tenNguoiDat;

    public MonAnNhom() {
    }

    public MonAnNhom(int idMonAn, String tenMonAn, int gia, int soLuong, String emailNguoiDat, String tenNguoiDat) {
        this.idMonAn = idMonAn;
        this.tenMonAn = tenMonAn;
        this.gia = gia;
        this.soLuong = soLuong;
        this.emailNguoiDat = emailNguoiDat;
        this.tenNguoiDat = tenNguoiDat;
    }

    public int getIdMonAn() {
        return idMonAn;
    }

    public void setIdMonAn(int idMonAn) {
        this.idMonAn = idMonAn;
    }

    public String getTenMonAn() {
        return tenMonAn;
    }

    public void setTenMonAn(String tenMonAn) {
        this.tenMonAn = tenMonAn;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getEmailNguoiDat() {
        return emailNguoiDat;
    }

    public void setEmailNguoiDat(String emailNguoiDat) {
        this.emailNguoiDat = emailNguoiDat;
    }

    public String getTenNguoiDat() {
        return tenNguoiDat;
    }

    public void setTenNguoiDat(String tenNguoiDat) {
        this.tenNguoiDat = tenNguoiDat;
    }

    public int tinhTienMon() {
        return gia * soLuong;
    }
}
